package com.cinemattson.festical.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cinemattson.festical.R;

/**
 * Created by Blake on 04/05/2015.
 */
public class ImageItemAdapter extends BaseAdapter {
    private final TypedArray iconValues;
    private Context context;
    private final String[] genreValues;

    public ImageItemAdapter(Context context, String[] genreValues) {
        this.context = context;
        this.genreValues = genreValues;
        this.iconValues = context.getApplicationContext().getResources().obtainTypedArray(R.array.genre_icon);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.item_grid, null);

            // set value into textview
            TextView textView = (TextView) gridView
                    .findViewById(R.id.grid_item_label);
            textView.setText(genreValues[position]);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.grid_item_image);

            String mobile = genreValues[position];
            imageView.setImageResource(iconValues.getResourceId(position, -1));

/*            if (mobile.equals("comedy")) {
                imageView.setImageResource(R.drawable.ic_about);
            } else if (mobile.equals("horror")) {
                imageView.setImageResource(R.drawable.ic_account);
            } else if (mobile.equals("action")) {
                imageView.setImageResource(R.drawable.ic_user);
            } else {
                imageView.setImageResource(R.mipmap.ic_launcher);
            }*/

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return genreValues.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
