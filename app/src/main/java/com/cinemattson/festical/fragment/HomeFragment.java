package com.cinemattson.festical.fragment;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.cinemattson.festical.R;
import com.cinemattson.festical.adapter.HomePagerAdapter;
import com.cinemattson.festical.fragment.api.BaseFragment;
import com.cinemattson.festical.interfaces.home.HomeView;
import com.cinemattson.festical.presenter.HomePresenterImpl;

import java.util.List;


public class HomeFragment extends BaseFragment implements HomeView {
    private static final String TAG = HomeFragment.class.getSimpleName();
    private View mViewHome;
    private PagerSlidingTabStrip mPagerSlidingTabStrip;
    private ViewPager mViewPager;
    private HomePresenterImpl mHomePresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewHome = inflater.inflate(R.layout.fragment_default, container, false);

        loadViewComponents();
        initPresenter();
        loadSectionsTabs();

        return mViewHome;
    }

    @Override
    public void onDestroy() {
        mHomePresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void loadViewComponents() {
        mPagerSlidingTabStrip = (PagerSlidingTabStrip) mViewHome.findViewById(R.id.fragment_home_pager_sliding_tab);
        mViewPager = (ViewPager) mViewHome.findViewById(R.id.fragment_home_view_pager);
    }

    @Override
    public void initPresenter() {
        mHomePresenter = new HomePresenterImpl(this);
    }

    @Override
    public void loadSectionsTabs() {
        mHomePresenter.loadSectionsTabs();
    }

    @Override
    public void loadViewPager(List<String> listTitleTabs) {
        mViewPager.setAdapter(new HomePagerAdapter(listTitleTabs, getChildFragmentManager()));
    }

    @Override
    public void setColorTabs(int color) {
        mPagerSlidingTabStrip.setTextColor(color);
    }

    @Override
    public void setDividerColorTabs(int color) {
        mPagerSlidingTabStrip.setDividerColor(mViewHome.getResources().getColor(R.color.primary));
    }

    @Override
    public void setIndicatorColorTabs(int color) {
        mPagerSlidingTabStrip.setDividerColor(color);
    }

    @Override
    public void loadTabs() {
        mPagerSlidingTabStrip.setViewPager(mViewPager);
    }
}