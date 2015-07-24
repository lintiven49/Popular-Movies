package com.ivanlin.popularmovies.network;

import android.util.Log;

import com.ivanlin.popularmovies.models.Movie;
import com.ivanlin.popularmovies.network.response.DiscoverResponse;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static com.ivanlin.popularmovies.MovieApplication.getClient;
import static com.ivanlin.popularmovies.MovieApplication.getGson;

public class PopularMoviesApi {
    private static final String ID_PLACEHOLDER = "{id}";
    private static final String TAG = "PopularMoviesApi";
    private static final String VERSION = "3";
    private static final String BASE_URL = "http://api.themoviedb.org/" + VERSION + "/";
    private static final String API_KEY = "api_key=883ecd231e9553afc7a7896259cbfe43";
    private static final String DISCOVER_URL = BASE_URL + "discover/movie?" + API_KEY;
    private static final String GET_MOVIE_URL = BASE_URL + "movie/" + ID_PLACEHOLDER + "?" + API_KEY;
    public static final String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/";

    public List<Movie> discoverMovies() {
        OkHttpClient client = getClient();
        Request request = new Request.Builder().url(DISCOVER_URL)
                .get().build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                DiscoverResponse resp = getGson().fromJson(responseBody, DiscoverResponse.class);
                return resp.getMovies();
            }
        } catch (IOException e) {
            Log.e(TAG, "discoverMovies error", e);

            return Collections.emptyList();
        }
        return Collections.emptyList();
    }

    public Movie getMovie(long id) {
        OkHttpClient client = getClient();
        Request request = new Request.Builder()
                .url(GET_MOVIE_URL.replace(ID_PLACEHOLDER, String.valueOf(id)))
                .get().build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                return getGson().fromJson(responseBody, Movie.class);
            }
        } catch (IOException e) {
            Log.e(TAG, "discoverMovies error", e);
            return null;
        }
        return null;
    }
}
