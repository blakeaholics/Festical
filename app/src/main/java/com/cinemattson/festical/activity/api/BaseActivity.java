/*
 * Copyright (C) 2014 Antonio Leiva Gordillo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cinemattson.festical.activity.api;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import com.cinemattson.festical.R;
import com.cinemattson.festical.constants.DrawerMenu;
import com.cinemattson.festical.fragment.AboutFragment;
import com.cinemattson.festical.fragment.HomeFragment;
import com.cinemattson.festical.fragment.NavigationDrawerFragment;
import com.cinemattson.festical.fragment.SettingsFragment;

public abstract class BaseActivity extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {
    protected Toolbar mToolBar;
    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResourceIdentifier());

        loadViewComponents();
        loadInfoToolbar();
        loadInfoDrawerMenu();
    }

    private void loadViewComponents() {
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.screen_default_navigation_drawer);
        mToolBar = (Toolbar) findViewById(R.id.screen_default_toolbar);
    }


    private void loadInfoToolbar() {
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle(getTitleToolBar());
    }


    private void loadInfoDrawerMenu() {
        mNavigationDrawerFragment.setUp(
                R.id.screen_default_navigation_drawer,
                (DrawerLayout) findViewById(R.id.screen_default_drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        switch (position) {
            case DrawerMenu.USER:
                fragmentTransaction(new HomeFragment()); //User
                break;
            case DrawerMenu.HOME:
                fragmentTransaction(new HomeFragment()); //Home
                break;
            case DrawerMenu.ABOUT:
                fragmentTransaction(new AboutFragment()); //About
                break;
            case DrawerMenu.SETTINGS:
                fragmentTransaction(new SettingsFragment()); //About
                break;
        }
    }

    private void fragmentTransaction(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.screen_default_container, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

    protected abstract int setLayoutResourceIdentifier();

    protected abstract int getTitleToolBar();
}
