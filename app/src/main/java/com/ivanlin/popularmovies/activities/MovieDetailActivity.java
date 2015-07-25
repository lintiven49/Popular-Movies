package com.ivanlin.popularmovies.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.ivanlin.popularmovies.R;
import com.ivanlin.popularmovies.fragments.MovieDetailFragment;

public class MovieDetailActivity extends BaseActivity {
    private static final String EXTRA_ID = "id";

    public static Intent getDetailIntent(Context context, long id) {
        return new Intent(context, MovieDetailActivity.class)
                .putExtra(EXTRA_ID, id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        long id = getIntent().getLongExtra(EXTRA_ID, 0);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, MovieDetailFragment.newInstance(id))
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_movie_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}
