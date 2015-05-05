package com.cinemattson.festical.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cinemattson.festical.R;

/**
 * Created by cinemattson on 18/12/14.
 */
public class OverviewFragment extends Fragment {
    public static OverviewFragment newInstance() {
        return new OverviewFragment();
    }

    private View mViewFragment2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewFragment2 = inflater.inflate(R.layout.fragment_overview, container, false);

        return mViewFragment2;
    }
}
