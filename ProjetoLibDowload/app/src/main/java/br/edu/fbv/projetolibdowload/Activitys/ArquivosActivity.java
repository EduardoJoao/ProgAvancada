package br.edu.fbv.projetolibdowload.Activitys;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.edu.fbv.projetolibdowload.R;
import br.edu.fbv.projetolibdowload.adapter.AdapterListArq;
import br.edu.fbv.projetolibdowload.model.Arquivo;

public class ArquivosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;



    private File file;

    private List<File> files = new ArrayList<>();

    TextView caminhoarq ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arquivos);




        String root_sd = Environment.getExternalStorageDirectory().toString();
        file =  new File(root_sd + "/imgdowload");



        files = Arrays.asList(file.listFiles());

        recyclerView = findViewById(R.id.recycleArq);

        AdapterListArq adapterListArq = new AdapterListArq(files);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterListArq);



    }
}
