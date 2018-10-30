package br.edu.fbv.projetolibdowload;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ReproducaoMusicaActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproducao_musica);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.videoeclipse);

    }

    public void executarSom (View view) {
        if (mediaPlayer != null){
            mediaPlayer.start();
        }
    }

    public void pausarSom (View view) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public void pararSom (View view) {
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.videoeclipse);
        }
    }

}
