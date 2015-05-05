package com.cinemattson.festical.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.cinemattson.festical.R;
import com.cinemattson.festical.activity.api.BaseActivity;
import com.cinemattson.festical.constants.FragmentNames;
import com.cinemattson.festical.fragment.HomeFragment;


public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.screen_default_container, new HomeFragment(), FragmentNames.FRAGMENT_HOME_).commit();
            Toolbar toolbar = (Toolbar) findViewById(R.id.screen_default_toolbar);
            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    protected int setLayoutResourceIdentifier() {
        return R.layout.screen_default;
    }

    @Override
    protected int getTitleToolBar() {
        return R.string.app_name;
    }

}
