package com.example.submissiondicodingwithretrofit.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.submissiondicodingwithretrofit.R;
import com.example.submissiondicodingwithretrofit.model.Movie;

import java.util.List;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.ViewHolder> {
    private List<Movie> movies ;
    private Context context;

    public TvAdapter(List<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public TvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.app_item,parent,false);
        return new TvAdapter.ViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull TvAdapter.ViewHolder holder, int position) {
        holder.textTitle.setText(movies.get(position).getTitle_tv());
        Log.d("titleTv", movies.get(position).getTitle_tv());
        Glide.with(context)
                .load(movies.get(position).getPoster_path())
                .apply(new RequestOptions().override(300,400))
                .into(holder.poster);
        float vote = movies.get(position).getVote_average();
        holder.textVote.setText(String.valueOf(vote));
        Log.d("asset",vote + movies.get(position).getTitle());
        if (vote <= 2){
            holder.star1.setVisibility(View.VISIBLE);
            holder.star2.setVisibility(View.GONE);
            holder.star3.setVisibility(View.GONE);
            holder.star4.setVisibility(View.GONE);
            holder.star5.setVisibility(View.GONE);
        }else if (vote <= 4 && vote > 2){
            holder.star1.setVisibility(View.VISIBLE);
            holder.star2.setVisibility(View.VISIBLE);
            holder.star3.setVisibility(View.GONE);
            holder.star4.setVisibility(View.GONE);
            holder.star5.setVisibility(View.GONE);
        }else if (vote <= 6 && vote > 4){
            holder.star1.setVisibility(View.VISIBLE);
            holder.star2.setVisibility(View.VISIBLE);
            holder.star3.setVisibility(View.VISIBLE);
            holder.star4.setVisibility(View.GONE);
            holder.star5.setVisibility(View.GONE);
        }else if (vote <=8 && vote > 6){
            holder.star1.setVisibility(View.VISIBLE);
            holder.star2.setVisibility(View.VISIBLE);
            holder.star3.setVisibility(View.VISIBLE);
            holder.star4.setVisibility(View.VISIBLE);
            holder.star5.setVisibility(View.GONE);
        }else if (vote > 8){
            holder.star1.setVisibility(View.VISIBLE);
            holder.star2.setVisibility(View.VISIBLE);
            holder.star3.setVisibility(View.VISIBLE);
            holder.star4.setVisibility(View.VISIBLE);
            holder.star5.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle,textVote;
        private ImageView poster,star1,star2,star3,star4,star5;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textVote = itemView.findViewById(R.id.textVote);
            textTitle = itemView.findViewById(R.id.textTitle);
            poster = itemView.findViewById(R.id.posterImage);
            star1 = itemView.findViewById(R.id.star1);
            star2 = itemView.findViewById(R.id.star2);
            star3 = itemView.findViewById(R.id.star3);
            star4 = itemView.findViewById(R.id.star4);
            star5 = itemView.findViewById(R.id.star5);
        }
    }
}
