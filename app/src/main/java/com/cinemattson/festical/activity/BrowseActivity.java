package com.cinemattson.festical.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.cinemattson.festical.MaterialDesignApplication;
import com.cinemattson.festical.R;
import com.cinemattson.festical.adapter.RecyclerViewCardsAdapter;
import com.cinemattson.festical.fragment.api.BaseFragment;
import com.cinemattson.festical.model.FestivalInfo;
import com.melnykov.fab.FloatingActionButton;

import java.util.List;

/**
 * Created by cinemattson on 18/12/14.
 */
public class BrowseActivity extends ActionBarActivity {
    private static final String MOCK_URL = "http://lorempixel.com/800/400/nightlife/";
    private View mViewRecyclerCardsView;
    private RecyclerView mRecyclerView;
    private FloatingActionButton mFloatingActionButton;
    private List<FestivalInfo> listFestivals;
    private int position = 0;
    private MaterialDesignApplication application;

    public static BrowseActivity newInstance() {
        return new BrowseActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_browse);

        application = (MaterialDesignApplication) getApplication();

        Intent intent = getIntent();
        position = intent.getIntExtra("GENRE_NUMBER", 0);
        loadInfoView();
    }


    private void loadInfoView() {
        //mFloatingActionButton.attachToRecyclerView(mRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView = (RecyclerView) findViewById(R.id.fragment_recyler_view_content_browse);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);
        this.application = MaterialDesignApplication.getApplication();

        Spinner spinner = (Spinner) findViewById(R.id.spnGenres);
        spinner.setSelection(position);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_browse);
        toolbar.setTitle("Browse");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mRecyclerView.setAdapter(new RecyclerViewCardsAdapter(this, application.getListFestivals()));
    }
}

