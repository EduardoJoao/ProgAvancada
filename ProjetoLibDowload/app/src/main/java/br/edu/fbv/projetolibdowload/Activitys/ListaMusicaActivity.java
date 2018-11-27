package br.edu.fbv.projetolibdowload.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import br.edu.fbv.libdowload.libdowload;

import br.edu.fbv.model.Musica;
import br.edu.fbv.projetolibdowload.R;
import br.edu.fbv.projetolibdowload.adapter.AdapterMusica;


//testeggg
public class ListaMusicaActivity extends AppCompatActivity {
private String hahah ="";
    List<Musica> musicaslist = new ArrayList<Musica>();
    libdowload libdowload = new libdowload();
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_musica);

        recyclerView = findViewById(R.id.recycleMusica);

        try {
          musicaslist =   libdowload.dowloadjson();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        AdapterMusica adapterMusica = new AdapterMusica(musicaslist);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterMusica);
    }
}
