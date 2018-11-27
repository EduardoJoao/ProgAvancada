package br.edu.fbv.projetolibdowload.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


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



        Musica musicass =musicas.get(position);



        holder.nomemusica.setText(musicass.getNome().toString());
        holder.baixarvideo.setText(musicass.getUrlmusica().toString());

    }

    @Override
    public int getItemCount() {
        return musicas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomemusica;
        Button urldowload;
        TextView baixarvideo;

        public ViewHolder(View itemView) {
            super(itemView);

            nomemusica = itemView.findViewById(R.id.nomemusica);
            urldowload = itemView.findViewById(R.id.buttondowloadmusica);
            baixarvideo = itemView.findViewById(R.id.baixarmusica);
        }
    }
}
