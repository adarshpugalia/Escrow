package com.taadnairsshha.escrow.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.taadnairsshha.escrow.R;
import com.taadnairsshha.escrow.Utils.ViewUtils;
import com.taadnairsshha.escrow.adapters.CouponAdapter;

public class CouponsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CouponAdapter couponAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        couponAdapter = new CouponAdapter();
        ViewUtils.bindRecyclerView(this, recyclerView, ViewUtils.LINEAR_LAYOUT_MANAGER, couponAdapter);
    }
}
