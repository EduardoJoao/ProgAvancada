package br.edu.fbv.projetolibdowload.Activitys;

import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.edu.fbv.libdowload.libdowload;
import br.edu.fbv.projetolibdowload.Config.ConfiguracaoFirebase;
import br.edu.fbv.projetolibdowload.R;
import br.edu.fbv.projetolibdowload.adapter.AdapterContato;
import br.edu.fbv.projetolibdowload.model.Contato;

public class ListaContato extends AppCompatActivity {

    private RecyclerView list;
    private AdapterContato contatoAdapter;
    private ValueEventListener valueList;
    private List<Contato> listContato = new ArrayList<>();
    private DatabaseReference referenciaBancoContato = ConfiguracaoFirebase.getFirebaseDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contato);

        list = findViewById(R.id.list);

        contatoAdapter = new AdapterContato(listContato);

        RecyclerView.LayoutManager layoutRecycle = new LinearLayoutManager(getApplicationContext());
        list.setLayoutManager(layoutRecycle);
        list.setHasFixedSize(true);
        list.setAdapter(contatoAdapter);

    }
    public void contato(){

        referenciaBancoContato = referenciaBancoContato.child("contato");

        valueList = referenciaBancoContato.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                listContato.clear();
                for(DataSnapshot dados: dataSnapshot.getChildren()){

                    Contato contato = dados.getValue(Contato.class);
                    //contato.setId( dados.getKey());
                    listContato.add(contato);
                }
                contatoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        contato();
    }

    @Override
    protected void onStop() {
        super.onStop();
        referenciaBancoContato.removeEventListener(valueList);
    }
}
