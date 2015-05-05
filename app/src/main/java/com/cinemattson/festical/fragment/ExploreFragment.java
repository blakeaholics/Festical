package com.cinemattson.festical.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.cinemattson.festical.R;
import com.cinemattson.festical.activity.BrowseActivity;
import com.cinemattson.festical.adapter.ImageItemAdapter;

/**
 * Created by cinemattson on 18/12/14.
 */
public class ExploreFragment extends Fragment {
    private GridView gridView;
    private Activity mActivity;
    private FragmentActivity myContext;

    public static ExploreFragment newInstance() {
        return new ExploreFragment();
    }

    private View mViewFragment3;

    @Override
    public void onAttach(Activity activity) {
        myContext = (FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewFragment3 = inflater.inflate(R.layout.fragment_explore, container, false);

        mActivity = (Activity) getActivity();

        gridView = (GridView) mViewFragment3.findViewById(R.id.gridView1);
        gridView.setAdapter(new ImageItemAdapter(mActivity, getResources().getStringArray(R.array.genre_title)));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(
                        mActivity,
                        ((TextView) v.findViewById(R.id.grid_item_label))
                                .getText(), Toast.LENGTH_SHORT).show();
                /*Intent intent = new Intent(mActivity, BrowseFragment.class);
                intent.putExtra("GENRE_NUMBER", position);
                mActivity.startActivity(intent);*/

                Bundle data = new Bundle();
                data.putInt("GENRE_NUMBER", position);

                /*Fragment fragment = new BrowseFragment();

                if (fragment != null) {
                    fragment.setArguments(data);
                    myContext.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.screen_default_container, fragment)
                            .addToBackStack(null)
                            .commit();
                }*/

                Intent intent = new Intent(mActivity, BrowseActivity.class);
                intent.putExtra("GENRE_NUMBER", position);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mActivity.startActivity(intent);

            }
        });

        return mViewFragment3;
    }
}
