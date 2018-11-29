package br.edu.fbv.projetolibdowload.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.edu.fbv.projetolibdowload.R;
import br.edu.fbv.projetolibdowload.model.Contato;


public class AdapterContato extends RecyclerView.Adapter<AdapterContato.ViewHolder> {

    private List<Contato> contatos;
    public AdapterContato(List<Contato> contatos) {

        this.contatos = contatos;
    }

    @Override
    public AdapterContato.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listacontatos = LayoutInflater.from(parent.getContext()).inflate(R.layout.contatoslistados, parent, false);

        return new ViewHolder(listacontatos);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contato contato = contatos.get(position);

        holder.nomecontao.setText(contato.getNome());
        holder.email.setText(contato.getEmail());
        //holder.baixarvideo.setText(contato.getUrldowload());
    }

    @Override
    public int getItemCount() {
        return contatos.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView nomecontao,email;
        ImageView imageProfile;


        public ViewHolder(View itemView) {
            super(itemView);

            nomecontao = itemView.findViewById(R.id.nomecontato);
            imageProfile = itemView.findViewById(R.id.imageProfile);
            email = itemView.findViewById(R.id.email);
        }
    }

}
