package br.edu.fbv.projetolibdowload;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

import br.edu.fbv.projetolibdowload.Dowload.Download_img;

public class MainActivity extends AppCompatActivity {
    Button botaovideo ;
    Button botaoMusica;
    Button baixarimg;

    final File destination = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS );
    final String url = ("https://firebasestorage.googleapis.com/v0/b/teste-b3d5f.appspot.com/o/Prestadores-de-servi%C3%A7o.jpg?alt=media&token=d11c7ee2-2003-4715-b57e-9b446497a98b");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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


    }
}
