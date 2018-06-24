package com.example.android.movie;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder> {
    @NonNull
    @Override
    public MovieAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder {
        public final ImageView mMovieImage;

        public MovieAdapterViewHolder(View itemView) {
            super(itemView);
            mMovieImage = (ImageView) itemView.findViewById(R.id.image_movie_list_item);
        }

    }
}
