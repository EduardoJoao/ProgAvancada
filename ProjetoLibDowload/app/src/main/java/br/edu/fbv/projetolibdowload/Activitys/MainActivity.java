package br.edu.fbv.projetolibdowload.Activitys;

import android.Manifest;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import br.edu.fbv.libdowload.libdowload;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import br.edu.fbv.libdowload.libdowload;
import br.edu.fbv.projetolibdowload.Dowload.Download_img;
import br.edu.fbv.projetolibdowload.R;

public class MainActivity extends AppCompatActivity {

    libdowload libdowload = new libdowload();
    Button botaovideo ;
    Button botaoMusica;
    Button baixarimg;
    Button btncadastro;
    Button arquivosListados;

    Button listvideos;

    private  String[] permissoesApp = new String []{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE

    };

    final File destination = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS );
    final String url = ("https://firebasestorage.googleapis.com/v0/b/teste-b3d5f.appspot.com/o/Prestadores-de-servi%C3%A7o.jpg?alt=media&token=d11c7ee2-2003-4715-b57e-9b446497a98b");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {


            Log.i("teste", libdowload.dowloadjson().toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //Validar Permissoes Do App

        Permissao.validarPermissoes(permissoesApp , this , 1);



        botaovideo = findViewById(R.id.botaovideo);

        botaovideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReproducaoVideoActivity.class);
                startActivity(intent);
            }
        });

        botaoMusica = findViewById(R.id.botaoMusica);

        botaoMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReproducaoMusicaActivity.class);
                startActivity(intent);
            }
        });

        baixarimg = findViewById(R.id.baixarimg);

        baixarimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Download_img dow = new Download_img(url,destination);
                Thread t1 = new Thread(dow);
                t1.start();
            }
        });

        btncadastro = findViewById(R.id.btnCadastro);
        btncadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CadastroContato.class));
            }
        });

        arquivosListados = findViewById(R.id.btnarquivoslistados);
        arquivosListados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ArquivosActivity.class);
                startActivity(intent);
            }
        });

        listvideos = findViewById(R.id.listvideosjson);
        listvideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaMusicaActivity.class);
                startActivity(intent);
            }
        });
    }
}
