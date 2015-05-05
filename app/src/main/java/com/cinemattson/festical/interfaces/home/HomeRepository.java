package com.cinemattson.festical.interfaces.home;

/**
 * Created by Halyson on 20/01/15.
 */
public interface HomeRepository {
    void recoverTitleTabs();

    void recoverColorsTabs();

    int getColorTab();

    int getDividerColorTab();

    int getIndicatorColorTab();

    void onDestroy();


}
