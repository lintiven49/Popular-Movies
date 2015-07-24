package com.ivanlin.popularmovies;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

public class MovieApplication {
    private static final OkHttpClient CLIENT = new OkHttpClient();
    private static final Gson GSON = new Gson();
    public static OkHttpClient getClient() {
        return CLIENT;
    }
    public static Gson getGson() {
        return GSON;
    }
}
