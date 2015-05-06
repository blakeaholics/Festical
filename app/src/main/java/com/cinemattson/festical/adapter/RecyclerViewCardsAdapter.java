package com.cinemattson.festical.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cinemattson.festical.MaterialDesignApplication;
import com.cinemattson.festical.R;
import com.cinemattson.festical.activity.DetailsActivity;
import com.cinemattson.festical.model.FestivalInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Halyson on 19/12/14.
 */
public class RecyclerViewCardsAdapter extends RecyclerView.Adapter<RecyclerViewCardsAdapter.ViewHolder> {
    private final List<FestivalInfo> mListItemsCard;
    private Activity mActivity;

    public RecyclerViewCardsAdapter(Activity activity, List<FestivalInfo> listItemsCard) {
        this.mListItemsCard = listItemsCard;
        this.mActivity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mActivity, LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_recycler_view_comp, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final FestivalInfo itemCardView = mListItemsCard.get(position);
        MaterialDesignApplication application = (MaterialDesignApplication) mActivity.getApplication();

        TextView txtFestName = (TextView) holder.itemView.findViewById(R.id.txtFestName);

        txtFestName.setText(mListItemsCard.get(position)
                .getName());

        TextView txtRating = (TextView) holder.itemView.findViewById(R.id.txtStars);
        txtRating.setText("\u2605" + mListItemsCard.get(position).getRating());

        TextView txtSDate = (TextView) holder.itemView.findViewById(R.id.txtSubDate);
        txtSDate.setText(mListItemsCard.get(position).getSubDate());

        holder.itemView.setTag(itemCardView);
        Picasso.with(holder.imageView.getContext())
                .load(mListItemsCard.get(position)
                        .getUrlImage())
                .error(R.drawable.placeholder_card_view)
                .placeholder(R.drawable.placeholder_card_view)
                .into(holder.imageView);

        ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.material_com_card_view_image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, DetailsActivity.class);
                intent.putExtra("FEST_NUMBER", position);
                mActivity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListItemsCard.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        private Activity mActivity;

        public ViewHolder(Activity activity, View itemView) {
            super(itemView);
            mActivity = activity;
            imageView = (ImageView) itemView.findViewById(R.id.material_com_card_view_image);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mActivity, DetailsActivity.class);
                    MaterialDesignApplication application = (MaterialDesignApplication) mActivity.getApplication();
                    //intent.putExtra("FEST_NUMBER", application.getListFestivals().get(0));
                    mActivity.startActivity(intent);
                }
            });
        }

    }
}
