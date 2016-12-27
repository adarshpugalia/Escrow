package com.taadnairsshha.escrow.activities;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.taadnairsshha.escrow.R;
import com.taadnairsshha.escrow.Utils.ViewUtils;
import com.taadnairsshha.escrow.data.EscrowDbHelper;
import com.taadnairsshha.escrow.data.service.DbWebsiteService;
import com.taadnairsshha.escrow.enums.WebsiteType;
import com.taadnairsshha.escrow.models.Website;

public class AddWebsiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_website);
    }

    public void addWebsite(View view) {
        String name = ViewUtils.getEditTextString(this, R.id.activity_add_website_edittext_name);
        String type = ViewUtils.getEditTextString(this, R.id.activity_add_website_edittext_website_type);
        boolean hasWallet = ((CheckBox) findViewById(R.id.activity_add_website_checkbox_wallet)).isChecked();

        if(name == "") {
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
            return;
        }

        Website website = Website.create(name, WebsiteType.valueOf(type), hasWallet);
        EscrowDbHelper escrowDbHelper = new EscrowDbHelper(getApplicationContext());
        SQLiteDatabase db = escrowDbHelper.getWritableDatabase();
        DbWebsiteService.insertWebsite(website, db);
    }
}
