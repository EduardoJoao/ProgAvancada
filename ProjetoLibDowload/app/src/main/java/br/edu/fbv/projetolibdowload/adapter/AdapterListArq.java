package br.edu.fbv.projetolibdowload.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.File;
import java.util.List;

import br.edu.fbv.projetolibdowload.R;
import br.edu.fbv.projetolibdowload.model.Arquivo;

public class AdapterListArq extends RecyclerView.Adapter<AdapterListArq.ViewHolder> {
    private List<File> arquivos;
    public AdapterListArq(List<File> files) {

        this.arquivos = files;
    }

    /*
        private List<Arquivo> arquivos;

        public AdapterListArq(List<Arquivo> arquivos) {
            this.arquivos = arquivos;
        }
    */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //apenas cria a visual
        View listaqruivos = LayoutInflater.from(parent.getContext()).inflate(R.layout.arquivos_listados, parent, false);

        return new ViewHolder(listaqruivos);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //a exibição é no onbind

        //Arquivo arquivo = arquivos.get(position);

        File file = arquivos.get(position);

        holder.nomeArq.setText(file.getName());
        holder.caminho.setText(file.getPath());


       // holder.nomeArq.setText(arquivo.getNome());
        //holder.caminho.setText(arquivo.getCaminho());

    }

    @Override
    public int getItemCount() {
        return arquivos.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView nomeArq;
        TextView caminho;

    public ViewHolder(View itemView) {
        super(itemView);

        nomeArq = itemView.findViewById(R.id.nomeArq);
        caminho = itemView.findViewById(R.id.caminhoArquivo);
    }
}
}
