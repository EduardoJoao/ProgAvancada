package br.edu.fbv.projetolibdowload.Activitys;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import br.edu.fbv.projetolibdowload.R;

public class ReproducaoVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproducao_video);

        MediaController mediaController = new MediaController(this);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videoeclipse);

        VideoView videoview = (VideoView) findViewById(R.id.video_exec);

        videoview.setVideoURI(uri);
        videoview.setMediaController(mediaController);
        mediaController.setAnchorView(videoview);
    }

}
