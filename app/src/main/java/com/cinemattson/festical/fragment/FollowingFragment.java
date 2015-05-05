package com.cinemattson.festical.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class FollowingFragment extends BaseFragment {
    private static final String MOCK_URL = "http://lorempixel.com/800/400/nightlife/";
    private View mViewRecyclerCardsView;
    private RecyclerView mRecyclerView;
    private FloatingActionButton mFloatingActionButton;
    private MaterialDesignApplication activity;
    private List<FestivalInfo> listFestivals;

    public static FollowingFragment newInstance() {
        return new FollowingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewRecyclerCardsView = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        loadViewComponents();
        loadInfoView();

        return mViewRecyclerCardsView;
    }

    private void loadViewComponents() {
        mRecyclerView = (RecyclerView) mViewRecyclerCardsView.findViewById(R.id.fragment_recyler_view_content_main);
        mFloatingActionButton = (FloatingActionButton) mViewRecyclerCardsView.findViewById(R.id.fragment_recyler_view_float_action_button);
    }

    private void loadInfoView() {
        mFloatingActionButton.attachToRecyclerView(mRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);
        this.activity = MaterialDesignApplication.getApplication();
        mRecyclerView.setAdapter(new RecyclerViewCardsAdapter(getActivity(), activity.getListFestivals()));
    }
}

