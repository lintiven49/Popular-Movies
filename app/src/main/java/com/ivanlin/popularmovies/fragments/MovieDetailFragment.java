package com.ivanlin.popularmovies.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ivanlin.popularmovies.R;
import com.ivanlin.popularmovies.models.Movie;
import com.ivanlin.popularmovies.network.PopularMoviesApi;
import com.squareup.picasso.Picasso;

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
        final long id = getArguments().getLong(ARG_ID);
        btnFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Favourite " + id, Toast.LENGTH_SHORT).show();
            }
        });
        new GetMovieTask().execute(id);
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

    private class GetMovieTask extends AsyncTask<Long, Void, Movie> {
        @Override
        protected Movie doInBackground(Long... params) {
            if (params.length > 0) {
                long id = params[0];
                return PopularMoviesApi.getInstance().getMovie(id);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Movie movie) {
            tvTitle.setText(movie.getTitle());
            Picasso.with(getActivity()).load(movie.getDefaultPoster()).placeholder(R.drawable.poster).into(imgvPoster);
            tvYear.setText(movie.getReleaseYear());
            tvDuration.setText(movie.getDuration() + " min");
            tvRate.setText(movie.getVoteAverage() + "/10");
            tvDesc.setText(movie.getOverview());
        }
    }
}
