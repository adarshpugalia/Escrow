package com.taadnairsshha.escrow;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.taadnairsshha.escrow.Utils.CommonUtils;
import com.taadnairsshha.escrow.activities.AddAcountActivity;
import com.taadnairsshha.escrow.activities.AddCouponActivity;
import com.taadnairsshha.escrow.activities.AddWebsiteActivity;
import com.taadnairsshha.escrow.activities.CouponsActivity;
import com.taadnairsshha.escrow.data.EscrowDbHelper;
import com.taadnairsshha.escrow.data.service.DbWebsiteService;
import com.taadnairsshha.escrow.models.Website;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.activity_main_textview_test);

        EscrowDbHelper escrowDbHelper = new EscrowDbHelper(getApplicationContext());
        SQLiteDatabase db = escrowDbHelper.getWritableDatabase();

        List<Website> websiteList = DbWebsiteService.getWebsites(db);
        for(Website website: websiteList) {
            textView.append(website.getName() + "\n\n");
        }

        textView.append(String.valueOf(websiteList.size()));
    }

    public void goToAddWebsite(View view) {
        CommonUtils.startActivity(this, AddWebsiteActivity.class);
    }

    public void goToAddAccount(View view) {
        CommonUtils.startActivity(this, AddAcountActivity.class);
    }

    public void goToAddCoupon(View view) {
        CommonUtils.startActivity(this, AddCouponActivity.class);
    }

    public void goToCoupons(View view) {
        CommonUtils.startActivity(this, CouponsActivity.class);
    }
}
