package com.example.samrat.relax;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class MovieLoader extends AsyncTaskLoader<List<MovieList>> {

    private String mUrl;
    public MovieLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }
	
    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<MovieList> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<MovieList> movieLists = QueryUtils.fetchmoviedata(mUrl);
        return movieLists;
    }
}
