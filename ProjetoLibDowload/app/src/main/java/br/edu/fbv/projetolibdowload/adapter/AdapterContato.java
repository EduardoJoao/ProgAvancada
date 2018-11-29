package br.edu.fbv.projetolibdowload.adapter;

import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.List;

import br.edu.fbv.projetolibdowload.Config.ConfiguracaoFirebase;
import br.edu.fbv.projetolibdowload.R;
import br.edu.fbv.projetolibdowload.model.Contato;

import static android.provider.MediaStore.Images.Media.getBitmap;


public class AdapterContato extends RecyclerView.Adapter<AdapterContato.ViewHolder> {

    private List<Contato> contatos;
    public AdapterContato(List<Contato> contatoss) {

        this.contatos = contatoss;
    }

    @Override
    public AdapterContato.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listacontatos = LayoutInflater.from(parent.getContext()).inflate(R.layout.contatoslistados, parent, false);

        return new ViewHolder(listacontatos);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contato contato2 = contatos.get(position);
        String teste = contato2.getUrl();

        Picasso.get().load(teste).into(holder.imageProfile);

        holder.nomecontao.setText(contato2.getNome());
        holder.email.setText(contato2.getEmail());

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
