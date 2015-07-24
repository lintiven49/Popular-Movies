package com.ivanlin.popularmovies.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.ivanlin.popularmovies.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovieListActivityFragment extends Fragment {
    @Bind(R.id.gv_movie_list) GridView gvMovieList;

    public MovieListActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View resultView = inflater.inflate(R.layout.fragment_movie_list, container, false);
        GridView gv = (GridView) resultView.findViewById(R.id.gv_movie_list);
        gv.setAdapter(new ArrayAdapter<String>(null, 0));
        ButterKnife.bind(this, resultView);
        return resultView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
