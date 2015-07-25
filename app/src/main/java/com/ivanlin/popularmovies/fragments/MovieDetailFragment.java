package com.ivanlin.popularmovies.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ivanlin.popularmovies.R;

public class MovieDetailFragment extends BaseFragment {
    private static final String ARG_ID = "id";

    public MovieDetailFragment() {
    }

    public static MovieDetailFragment newInstance(long id) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(getActivity(), "!!!!!" + getArguments().getLong(ARG_ID), Toast.LENGTH_SHORT).show();
    }
}
