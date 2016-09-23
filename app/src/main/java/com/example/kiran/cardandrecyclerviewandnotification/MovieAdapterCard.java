package com.example.kiran.cardandrecyclerviewandnotification;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Kiran on 14-09-2016.
 */
public class MovieAdapterCard extends RecyclerView.Adapter<MovieAdapterCard.MyViewHolder> {

    private List<Movie> moviesList;
     private Context mContext;
    private int coverImageStatus;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.titleCard);
            genre = (TextView) view.findViewById(R.id.genreCard);
            year = (TextView) view.findViewById(R.id.yearCard);
            thumbnail= (ImageView) view.findViewById(R.id.thumbnail);
        }
    }


    public MovieAdapterCard(Context mContext,List<Movie> moviesList,int coverImageStatus ) {
        this.moviesList = moviesList;
        this.mContext=mContext;
        this.coverImageStatus=coverImageStatus;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
        holder.thumbnail.setImageResource(movie.getImageresourceId());
        // loading album cover using Glide library
       // Glide.with(mContext).load(movie.coverImages[position]).into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, " image  clicked at : "+(position+1), Toast.LENGTH_SHORT).show();
            }
        });
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, " Movie title  clicked at : "+(position+1), Toast.LENGTH_SHORT).show();
            }
        });
        holder.genre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, " Genere  clicked at : "+(position+1), Toast.LENGTH_SHORT).show();
            }
        });
        holder.year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, " Year  clicked at : "+(position+1), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public void changeMovieDatas(List<Movie> movieList){
        moviesList=movieList;
        notifyDataSetChanged();
    }
    public void updateDataAtLocation(Movie movie, int position){
        moviesList.set(position,movie);
        notifyDataSetChanged();
    }
}
