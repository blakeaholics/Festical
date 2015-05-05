package com.cinemattson.festical.interfaces.home;

import com.cinemattson.festical.events.LoadColorsTabsDisk;
import com.cinemattson.festical.events.LoadTitleTabsDisk;
import com.squareup.otto.Subscribe;

/**
 * Created by Halyson on 20/01/15.
 */
public interface HomePresenter {
    void loadSectionsTabs();

    @Subscribe
    void onLoadTitleTabsDiskSuccess(LoadTitleTabsDisk loadTitleTabsDisk);

    @Subscribe
    void onLoadColorTabsDiskSuccess(LoadColorsTabsDisk loadColorsTabsDisk);

    void onDestroy();
}
