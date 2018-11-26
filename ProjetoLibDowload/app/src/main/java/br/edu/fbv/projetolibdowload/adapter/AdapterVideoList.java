package br.edu.fbv.projetolibdowload.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import br.edu.fbv.projetolibdowload.R;
import br.edu.fbv.projetolibdowload.model.Video;

public class AdapterVideoList extends RecyclerView.Adapter<AdapterVideoList.ViewHolder> {

    private List<Video> videos;
    public AdapterVideoList(List<Video> videos) {

        this.videos = videos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listavideos = LayoutInflater.from(parent.getContext()).inflate(R.layout.videoslistados, parent, false);

        return new ViewHolder(listavideos);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Video video = videos.get(position);

        holder.nomevideo.setText(video.getNome());
        holder.baixarvideo.setText(video.getUrldowload());

    }

    @Override
    public int getItemCount() {
      return videos.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView nomevideo;
        Button urldowload;
        TextView baixarvideo;

        public ViewHolder(View itemView) {
            super(itemView);

            nomevideo = itemView.findViewById(R.id.nomevideo);
            urldowload = itemView.findViewById(R.id.buttondowload);
            baixarvideo = itemView.findViewById(R.id.baixarvideo);
        }
    }

}
