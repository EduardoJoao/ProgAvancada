/*package br.edu.fbv.projetolibdowload.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class AdapterList extends RecyclerView.Adapter<AdapterFilmes.MyViewHolder> {

    private List<Results> results = new ArrayList<>();
    private Context context;

    public AdapterFilmes(List<Results> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_filme, parent, false);
        return new AdapterFilmes.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Results result  = results.get( position );

        holder.title.setText( result.getTitle() );

        String urlImagem = result.getBackdrop_path();
        //Picasso.get().load("https://image.tmdb.org/t/p/w500" + url).into(holder.capa);
        String urlDownload = result.getURL();
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView capa;,
        Button urlDownload;

        public MyViewHolder(View itemView){
            super(itemView);

            title = itemView.findViewById(R.id.textTitulo);
            capa = itemView.findViewById(R.id.imageCapa);
            urlDownload = itemView.findViewById(R.id.botaoDownload);

        }

    }
}
*/