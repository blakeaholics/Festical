package com.cinemattson.festical.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cinemattson.festical.fragment.ExploreFragment;
import com.cinemattson.festical.fragment.DefaultFragment;
import com.cinemattson.festical.fragment.FollowingFragment;
import com.cinemattson.festical.fragment.OverviewFragment;

import java.util.List;

/**
 * Created by cinemattson on 18/12/14.
 */
public class HomePagerAdapter extends FragmentPagerAdapter {
    private List<String> mListTitleTabs;

    public HomePagerAdapter(List<String> listTitleTabs, FragmentManager childFragmentManager) {
        super(childFragmentManager);
        this.mListTitleTabs = listTitleTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mListTitleTabs == null || mListTitleTabs.isEmpty()) {
            return "";
        }
        return mListTitleTabs.get(position);
    }

    @Override
    public int getCount() {
        if (mListTitleTabs == null || mListTitleTabs.isEmpty()) {
            return 0;
        }
        return mListTitleTabs.size();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return OverviewFragment.newInstance();
            case 1:
                return FollowingFragment.newInstance();
            case 2:
                return ExploreFragment.newInstance();
            default:
                return DefaultFragment.newInstance();
        }
    }
}
