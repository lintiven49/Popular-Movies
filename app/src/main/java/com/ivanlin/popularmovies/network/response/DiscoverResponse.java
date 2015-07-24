package com.ivanlin.popularmovies.network.response;

import com.google.gson.annotations.SerializedName;
import com.ivanlin.popularmovies.models.Movie;

import java.util.List;

public class DiscoverResponse {
    private int page;
    @SerializedName("results")
    private List<Movie> movies;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
