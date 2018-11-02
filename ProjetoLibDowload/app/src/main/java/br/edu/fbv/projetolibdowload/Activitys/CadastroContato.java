package br.edu.fbv.projetolibdowload.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.fbv.projetolibdowload.R;
import br.edu.fbv.projetolibdowload.model.Contato;

public class CadastroContato extends AppCompatActivity {

    private Button lista, cadatrar;

    private EditText nome, telefone, email;

    private Contato contato;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_contato);

        lista= findViewById(R.id.btnLista);
        nome = findViewById(R.id.nome);
        telefone = findViewById(R.id.telefone);
        email = findViewById(R.id.email);
        cadatrar = findViewById(R.id.cadastrar);



        cadatrar.setOnClickListener(new View.OnClickListener() {
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
                            contato.setTelefone(vEmail);
                            contato.salvar();

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

        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(CadastroContato.this, ListaContato.class));
            }
        });


    }
}
