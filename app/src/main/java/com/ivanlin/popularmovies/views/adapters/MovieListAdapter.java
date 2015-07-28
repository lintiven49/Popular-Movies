package com.ivanlin.popularmovies.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.ivanlin.popularmovies.R;
import com.ivanlin.popularmovies.activities.MovieDetailActivity;
import com.ivanlin.popularmovies.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieListAdapter extends ArrayAdapter<Movie> {
    private Context mContext;

    public MovieListAdapter(Context context, List<Movie> objects) {
        super(context, 0, objects);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Movie movie = getItem(position);
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_movie_list, parent, false);
            ViewHolder holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        Picasso.with(mContext).load(movie.getDefaultPoster())
                .placeholder(R.drawable.poster)
                .into(holder.imgvMoviePoster);
        holder.imgvMoviePoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(MovieDetailActivity.getDetailIntent(mContext, movie.getId()));
            }
        });
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.imgv_poster) ImageView imgvMoviePoster;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
