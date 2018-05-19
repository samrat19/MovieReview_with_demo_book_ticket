package com.example.samrat.relax;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends ArrayAdapter<MovieList> {

    ImageView poster1;

    public MovieAdapter(Context context, List<MovieList> movieLists) {
        super(context, 0, movieLists);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.movielist, parent, false);
        }

        MovieList movieList = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.moviename);

        nameTextView.setText(movieList.getName());

        String poster="https://image.tmdb.org/t/p/w500"+movieList.getPoster();

        poster1=(ImageView) listItemView.findViewById(R.id.movieposter);

        loadimage(poster);


        return listItemView;
    }

    private void loadimage(String poster) {

        Picasso.with(getContext()).load(poster).placeholder(R.drawable.load)
                .error(R.drawable.load)
                .into(poster1, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
