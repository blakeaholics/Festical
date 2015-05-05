package com.cinemattson.festical.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cinemattson.festical.R;

/**
 * Created by Blake on 05/05/2015.
 */
public class AboutFragment extends Fragment {
    public static DefaultFragment newInstance() {
        return new DefaultFragment();
    }

    private View mViewFragmentDefault;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewFragmentDefault = inflater.inflate(R.layout.fragment_about, container, false);
        mViewFragmentDefault.findViewById(R.id.imgBTC).setClickable(true);

        mViewFragmentDefault.findViewById(R.id.imgBTC).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        String url = getString(R.string.pref_BTC_uri);
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                });

        return mViewFragmentDefault;
    }



}