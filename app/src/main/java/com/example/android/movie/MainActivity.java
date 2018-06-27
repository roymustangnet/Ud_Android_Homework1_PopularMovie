package com.example.android.movie;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.movie.utils.NetworkUtils;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MovieAdapter mAdapter;
    private ProgressBar mLoadingIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_movie_list);
        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new MovieAdapter();
        mRecyclerView.setAdapter(mAdapter);
        loadMoviesData();
    }

    private void loadMoviesData(){
        new FetchMoviesTask().execute("");
    }

    public class FetchMoviesTask extends AsyncTask<String, Void, String[]> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoadingIndicator.setVisibility(View.VISIBLE);
        }

        @Override
        protected String[] doInBackground(String... params) {

            /* If there's no zip code, there's nothing to look up. */
            if (params.length == 0) {
                return null;
            }
            try {
                URL url =  NetworkUtils.buildGatAllMoviesUrl(0, NetworkUtils.SortBy.POPULARITY_ASC);
                String json = NetworkUtils.getResponseFromHttpUrl(url);
                Log.v("json", json);
            } catch (Exception e){
                e.printStackTrace();
            }


//            String location = params[0];
//            URL weatherRequestUrl = NetworkUtils.buildGatAllMoviesUrl(location);

//            try {
//                String jsonWeatherResponse = NetworkUtils
//                        .getResponseFromHttpUrl(weatherRequestUrl);
//
//                String[] simpleJsonWeatherData = OpenWeatherJsonUtils
//                        .getSimpleWeatherStringsFromJson(MainActivity.this, jsonWeatherResponse);
//
//                return simpleJsonWeatherData;
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }
            return null;
        }

        @Override
        protected void onPostExecute(String[] weatherData) {
            mLoadingIndicator.setVisibility(View.INVISIBLE);
//            if (weatherData != null) {
//                showWeatherDataView();
//                // COMPLETED (45) Instead of iterating through every string, use mForecastAdapter.setWeatherData and pass in the weather data
//                mForecastAdapter.setWeatherData(weatherData);
//            } else {
//                showErrorMessage();
//            }
        }
    }



}
