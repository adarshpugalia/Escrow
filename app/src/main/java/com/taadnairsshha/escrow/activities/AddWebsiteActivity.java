package com.taadnairsshha.escrow.activities;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.taadnairsshha.escrow.R;
import com.taadnairsshha.escrow.Utils.ViewUtils;
import com.taadnairsshha.escrow.data.EscrowDbHelper;
import com.taadnairsshha.escrow.data.service.DbWebsiteService;
import com.taadnairsshha.escrow.enums.WebsiteType;
import com.taadnairsshha.escrow.models.Website;

import java.util.ArrayList;
import java.util.List;


public class AddWebsiteActivity extends AppCompatActivity {
    private Spinner spinnerWebsiteType;

    private void populateWebsiteTypeSpinner() {
        spinnerWebsiteType = (Spinner) findViewById(R.id.act_add_website_sp_type);
        ViewUtils.populateSpinner(this, spinnerWebsiteType, WebsiteType.getWebsiteTypeNames());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_website);

        populateWebsiteTypeSpinner();
    }

    public void addWebsite(View view) {
        /* TODO: Change ids to use short names for view type. */
        String name = ViewUtils.getEditTextString(this, R.id.activity_add_website_edittext_name);
        // add website type
        boolean hasWallet = ((CheckBox) findViewById(R.id.activity_add_website_checkbox_wallet)).isChecked();

        if(name == "") {
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
            return;
        }

        Website website = Website.create(name, WebsiteType.WALLET, hasWallet);
        EscrowDbHelper escrowDbHelper = new EscrowDbHelper(getApplicationContext());
        SQLiteDatabase db = escrowDbHelper.getWritableDatabase();
        DbWebsiteService.insertWebsite(website, db);
    }
}
