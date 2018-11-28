package br.edu.fbv.projetolibdowload.Activitys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

import br.edu.fbv.projetolibdowload.Config.ConfiguracaoFirebase;
import br.edu.fbv.projetolibdowload.Helper.Base64;
import br.edu.fbv.projetolibdowload.R;
import br.edu.fbv.projetolibdowload.model.Contato;

public class CadastroContato extends AppCompatActivity {

    private Button lista, cadastrar, download;

    private EditText nome, telefone, email;

    private ImageView image;
    private ImageButton imageButtonCamera,imageButtonGaleria;
    private static final int SELECAO_CAMERA = 1;
    private static final int SELECAO_GALERIA = 200;
    private StorageReference reference;
    private Bitmap imagem = null;
    private String verificação;
    private Contato contato;
    private String id;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_contato);

        reference = ConfiguracaoFirebase.getFireBaseStorage();
        FirebaseApp.initializeApp(this);
        lista= findViewById(R.id.btnLista);
        nome = findViewById(R.id.nome);
        telefone = findViewById(R.id.telefone);
        email = findViewById(R.id.email);
        cadastrar = findViewById(R.id.cadastrar);
        // ====================================================== Cadastrando Contato ====================================
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String vNome = nome.getText().toString();
                String vTelofone = telefone.getText().toString();
                String vEmail = email.getText().toString();

                if(!vNome.isEmpty()){
                    if(!vTelofone.isEmpty()){
                        if(!vEmail.isEmpty()){

                            contato = new Contato();
                            contato.setNome(vNome);
                            contato.setTelefone(vTelofone);
                            contato.setEmail(vEmail);
                            verificação=vEmail;
                            id = Base64.encodeEmail(contato.getEmail());
                            contato.setId(id);
                            contato.salvar();
                            salvarImagem();

                        }else {
                            Toast.makeText(CadastroContato.this, "Informar um Email",Toast.LENGTH_LONG).show();

                        }

                    }else{
                        Toast.makeText(CadastroContato.this, "Informar um Telefone",Toast.LENGTH_LONG).show();

                    }
                }else{
                        Toast.makeText(CadastroContato.this, "Informar um Nome",Toast.LENGTH_LONG).show();
                }
            }
        });
        // ====================================================== Indo para a Activity Lista de Contatos====================================
        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(CadastroContato.this, ListaContato.class));
            }
        });

        // ====================================================== Cadastrando a Imagem Junto com os contato ====================================
        imageButtonCamera = findViewById(R.id.imageButtonCamera);
        imageButtonGaleria = findViewById(R.id.imageButtonGaleria);
        image = findViewById(R.id.image);

        imageButtonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(camera.resolveActivity(getPackageManager()) !=null ) {
                    startActivityForResult(camera, SELECAO_CAMERA);
                }
            }
        });

        imageButtonGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI );
                if(camera.resolveActivity(getPackageManager()) !=null ) {
                    startActivityForResult(camera, SELECAO_GALERIA);
                }
            }
        });


        download = findViewById(R.id.download);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadLib();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){


            try{

                switch (requestCode){
                    case SELECAO_CAMERA:
                        imagem = (Bitmap) data.getExtras().get("data");
                        break;

                    case SELECAO_GALERIA:
                        Uri localImagem = data.getData();
                        imagem = MediaStore.Images.Media.getBitmap(getContentResolver(),localImagem );
                        break;
                }

                if(imagem != null){
                    image.setImageBitmap(imagem);

                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            Toast.makeText(CadastroContato.this, "Erro ao carregar a imagem",Toast.LENGTH_LONG).show();
        }
    }

    public void salvarImagem(){


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        imagem.compress(Bitmap.CompressFormat.JPEG,70,baos);
        byte[] dadosimagem = baos.toByteArray();

        StorageReference teste = reference.child("contato").child(verificação).child(verificação+".jpeg");
        UploadTask upload = teste.putBytes(dadosimagem);
        upload.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(CadastroContato.this, "Erro ao fazer o upload da imagem",Toast.LENGTH_LONG).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(CadastroContato.this, "Sucesso ao fazer o upload  da imagem",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void downloadLib(){
      reference.child("contato").child(verificação).child(verificação +".jpeg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
          @Override
          public void onSuccess(Uri uri) {

              Log.i("teste", uri.toString());
          }
      }).addOnFailureListener(new OnFailureListener() {
          @Override
          public void onFailure(@NonNull Exception e) {
              Toast.makeText(CadastroContato.this, "Erro ao fazer o download da imagem",Toast.LENGTH_LONG).show();
          }
      });
    }

}
