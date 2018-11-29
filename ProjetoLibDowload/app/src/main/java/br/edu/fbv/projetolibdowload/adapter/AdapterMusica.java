package br.edu.fbv.projetolibdowload.adapter;

import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

import br.edu.fbv.libdowload.libdowload;

import br.edu.fbv.model.Musica;
import br.edu.fbv.projetolibdowload.R;


public class AdapterMusica extends RecyclerView.Adapter<AdapterMusica.ViewHolder> {

    private List<Musica> musicas;


    public AdapterMusica(List<Musica> musicaslist) {

        this.musicas = musicaslist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View listamusica = LayoutInflater.from(parent.getContext()).inflate(R.layout.musicaslistadas, parent, false);

        return new ViewHolder(listamusica);


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String urlmusica = "https://libprogavancada.herokuapp.com/";


       // final String urlmusica = "https://libprogavancada.herokuapp.com/";


        final Musica musicass =musicas.get(position);


        Picasso.get().load(urlmusica+""+musicass.getUrlimagem()).into(holder.imagemmusica);



        holder.nomemusica.setText(musicass.getNome().toString());
        holder.baixarvideo.setText(musicass.getUrlmusica().toString());


        //final File root_sd = Environment.getExternalStoragePublicDirectory(Environment.getExternalStorageState()) ;



        final File root_sd = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        final String caminho = root_sd.toString();
        holder.urldowload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String parteurl = musicass.getUrlmusica();

                String nomepassado ="/"+musicass.getNome().toString();

                String finalurl=urlmusica+""+parteurl;
                libdowload libdowload = new libdowload();




                libdowload.dowloadMusica(finalurl, nomepassado,caminho);
                Log.i("testex", caminho);
                Log.i("testex", musicass.getNome());
                Log.i("teste", finalurl.toString());

            }
        });


    }

    @Override
    public int getItemCount() {
        return musicas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomemusica;
        Button urldowload;
        TextView baixarvideo;

        ImageView imagemmusica;

        public ViewHolder(View itemView) {
            super(itemView);

            nomemusica = itemView.findViewById(R.id.nomemusica);
            urldowload = itemView.findViewById(R.id.buttondowloadmusica);
            baixarvideo = itemView.findViewById(R.id.baixarmusica);
            imagemmusica = itemView.findViewById(R.id.imagemusica);
        }
    }
}
