package com.ivanlin.popularmovies.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ivanlin.popularmovies.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieDetailFragment extends BaseFragment {
    private static final String ARG_ID = "id";
    @Bind(R.id.tv_title) TextView tvTitle;
    @Bind(R.id.imgv_poster) ImageView imgvPoster;
    @Bind(R.id.tv_year) TextView tvYear;
    @Bind(R.id.tv_duration) TextView tvDuration;
    @Bind(R.id.tv_rate) TextView tvRate;
    @Bind(R.id.btn_favourite) Button btnFavourite;
    @Bind(R.id.tv_desc) TextView tvDesc;

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
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
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
}
