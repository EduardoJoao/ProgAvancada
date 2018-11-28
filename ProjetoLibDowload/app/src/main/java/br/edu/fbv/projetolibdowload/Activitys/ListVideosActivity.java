package br.edu.fbv.projetolibdowload.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import java.io.IOException;
import java.util.concurrent.ExecutionException;

import br.edu.fbv.projetolibdowload.R;

import br.edu.fbv.libdowload.libdowload;




public class ListVideosActivity extends AppCompatActivity {


libdowload libdowload = new libdowload();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String url = "https://libprogavancada.herokuapp.com/musica/";

        try {
            Log.i("teste",libdowload.dowloadjson().toString());


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_videos);
    }
}
