package com.example.android.movie.utils;

import android.net.Uri;
import android.util.Log;

import com.example.android.movie.BuildConfig;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {
    private static final String TAG = NetworkUtils.class.getSimpleName();

    private static final String POPULAR_MOVIES_URL =
            "http://api.themoviedb.org/3/movie/popular";

    // TODO(1): Check API Document to get query params
    private static final String API_KEY_PARAM = "api_key";
    private static final String PAGE_PARAM = "page";
    private static final String SORT_BY_PARAM = "sort_by";

    public static URL buildGatAllMoviesUrl(int page, String sortBy) {
        Uri builtUri = Uri.parse(POPULAR_MOVIES_URL).buildUpon()
                .appendQueryParameter(API_KEY_PARAM, BuildConfig.THE_MOVIE_DB_API_TOKEN)
                .appendQueryParameter(PAGE_PARAM, Integer.toString(page))
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.v(TAG, "Built URI " + url);
        return url;
    }

    // TODO(3): Get the movie information by movie id
    public static URL buildQueryMovieInfoUrl(int movieId){
        return null;
    }

    // TODO(4): Get the movie image by movie img
    public static URL buildQueryMovieInfoUrl(String img){
        return null;
    }




    public static String getResponseFromHttpUrl(URL url) {
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
            return null;
        }
    }

    // TODO(2): Add some sort by param value
    class SortBy {
        public static final String POPULARITY_ASC = "popularity.asc";
        public static final String POPULARITY_DEC = "popularity.des";
    }
}
