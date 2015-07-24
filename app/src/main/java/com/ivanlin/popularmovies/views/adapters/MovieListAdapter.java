package com.ivanlin.popularmovies.views.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class MovieListAdapter extends ArrayAdapter<String> {
    public MovieListAdapter(Context context, List<String> objects) {
        super(context, 0, objects);
    }
}
