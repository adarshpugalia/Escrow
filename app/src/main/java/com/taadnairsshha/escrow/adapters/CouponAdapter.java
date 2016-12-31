package com.taadnairsshha.escrow.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.taadnairsshha.escrow.R;

/**
 * Created by adarsh on 12/31/16.
 */

public class CouponAdapter extends RecyclerView.Adapter<CouponAdapter.CouponViewHolder> {
    private int NUMBER_OF_ITEMS = 20;

    public CouponAdapter() {

    }

    @Override
    public CouponViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_item_coupon, viewGroup, false);
        CouponViewHolder viewHolder = new CouponViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CouponViewHolder viewHolder, int position) {
        // do nothing.
    }

    @Override
    public int getItemCount() {
        return NUMBER_OF_ITEMS;
    }


    public class CouponViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCoupon;

        public CouponViewHolder(View view) {
            super(view);
            textViewCoupon = (TextView) view.findViewById(R.id.textView);
        }
    }
}
