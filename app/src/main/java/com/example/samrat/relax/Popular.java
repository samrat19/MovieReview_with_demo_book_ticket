package com.example.samrat.relax;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Popular extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<MovieList>>{

    private static  final String movieUrl="https://api.themoviedb.org/3/movie/popular?api_key=e151ccdde6fbf9ea2d84c67dfb0a920c";
    private static final int EARTHQUAKE_LOADER_ID = 1;
    private MovieAdapter mAdapter;

    TextView home3,up3,top4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular);

        home3=(TextView)findViewById(R.id.now2);
        up3=(TextView)findViewById(R.id.up2);
        top4=(TextView)findViewById(R.id.top3);
        GridView listView = (GridView) findViewById(R.id.mvilst3);

        home3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        up3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j =new Intent(getApplicationContext(),UpComing.class);
                startActivity(j);
            }
        });

        top4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k =new Intent(getApplicationContext(),Top_Rated.class);
                startActivity(k);
            }
        });
        mAdapter = new MovieAdapter(this, new ArrayList<MovieList>());
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),Detail1.class);
                MovieList movieList = mAdapter.getItem(position);
                String name= movieList.getName();
                String plot = movieList.getPlot();
                String date=movieList.getDate();
                float rate= (float) movieList.getRating();
                String rating=Float.toString(rate);
                intent.putExtra("PLOT",plot);
                intent.putExtra("NAME",name);
                intent.putExtra("DATE",date);
                intent.putExtra("RATING",rating);
                startActivity(intent);
            }
        });

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, this);
        } else {
            // View loadingIndicator = findViewById(R.id.loading_indicator);
            //  loadingIndicator.setVisibility(View.GONE);
            // mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
    }


    @Override
    public Loader<List<MovieList>> onCreateLoader(int i, Bundle bundle) {
        return new MovieLoader(this, movieUrl);
    }

    @Override
    public void onLoadFinished(Loader<List<MovieList>> loader, List<MovieList> movieLists) {
        // View loadingIndicator = findViewById(R.id.loading_indicator);
        //  loadingIndicator.setVisibility(View.GONE);
        //  mEmptyStateTextView.setText(R.string.no_earthquakes);

        mAdapter.clear();
        if (movieLists != null && !movieLists.isEmpty()) {
            mAdapter.addAll(movieLists);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<MovieList>> loader) {
        // Loader reset, so we can clear out our existing data.
        mAdapter.clear();
    }
}
