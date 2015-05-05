package com.cinemattson.festical.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cinemattson.festical.MaterialDesignApplication;
import com.cinemattson.festical.R;
import com.cinemattson.festical.model.FestivalInfo;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.nineoldandroids.view.ViewHelper;

import java.io.InputStream;

/**
 * Created by Halyson on 20/01/15.
 */
public class DetailsActivity extends ActionBarActivity implements ObservableScrollViewCallbacks {
    private View mImageView;
    private View mToolbarView;
    private ObservableScrollView mScrollView;
    private int mParallaxImageHeight;
    private int position;
    private FestivalInfo festival;
    private MaterialDesignApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_details);

        Intent intent = getIntent();
        position = intent.getIntExtra("FEST_NUMBER", 0);
        application = (MaterialDesignApplication) getApplication();
        festival = application.getListFestivals().get(position);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle(festival.getName());
        //toolbar.set

        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mImageView = findViewById(R.id.image);

        new DownloadImageTask((ImageView) findViewById(R.id.image)).execute(festival.getUrlImage());
        mToolbarView = findViewById(R.id.toolbar);
        //mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(0, getResources().getColor(R.color.primary)));

        TextView txtBio = (TextView) findViewById(R.id.txtBio);
        txtBio.setText(festival.getBio());

        TextView txtFName = (TextView) findViewById(R.id.txtFName);
        txtFName.setText(festival.getName());

        TextView txtWebsite = (TextView) findViewById(R.id.txtWebsite);
        txtWebsite.setText(festival.getWebsite());

        TextView txtSDate = (TextView) findViewById(R.id.txtSDate);
        txtSDate.setText(festival.getSubDate());

        TextView txtRating = (TextView) findViewById(R.id.txtRating);
        txtRating.setText("\u2605" + festival.getRating());


        mScrollView = (ObservableScrollView) findViewById(R.id.scroll);
        mScrollView.setScrollViewCallbacks(this);

        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.drawer_menu_width);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        onScrollChanged(mScrollView.getCurrentScrollY(), false, false);
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        int baseColor = getResources().getColor(R.color.primary);
        float alpha = 1 - (float) Math.max(0, mParallaxImageHeight - scrollY) / mParallaxImageHeight;
        mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(alpha, baseColor));
        ViewHelper.setTranslationY(mImageView, scrollY / 2);
    }

    @Override
    public void onDownMotionEvent() {
    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}


