package com.ivanlin.popularmovies.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.ivanlin.popularmovies.R;
import com.ivanlin.popularmovies.models.Movie;
import com.ivanlin.popularmovies.network.PopularMoviesApi;
import com.ivanlin.popularmovies.views.adapters.MovieListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieListFragment extends BaseFragment {
    @Bind(R.id.gv_movie_list) GridView gvMovieList;
    private List<Movie> data;
    private MovieListAdapter mMovieListAdapter;

    public MovieListFragment() {
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View resultView = inflater.inflate(R.layout.fragment_movie_list, container, false);
        ButterKnife.bind(this, resultView);
        data = new ArrayList<Movie>(0);
        mMovieListAdapter = new MovieListAdapter(getActivity(), data);
        gvMovieList.setAdapter(mMovieListAdapter);
        new LoadMoviesTasks().execute();
        return resultView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private class LoadMoviesTasks extends AsyncTask<Void, Void, List<Movie>> {
        @Override
        protected List<Movie> doInBackground(Void... params) {
            return PopularMoviesApi.getInstance().discoverMovies();
        }

        @Override
        protected void onPostExecute(List<Movie> movies) {
            data.clear();
            data.addAll(movies);
            mMovieListAdapter.notifyDataSetChanged();
        }
    }
}
