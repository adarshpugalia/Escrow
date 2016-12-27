package com.taadnairsshha.escrow;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.taadnairsshha.escrow.Utils.CommonUtils;
import com.taadnairsshha.escrow.activities.AddWebsiteActivity;
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
        CommonUtils.startActivity(this, AddWebsiteActivity.class);
    }
}
