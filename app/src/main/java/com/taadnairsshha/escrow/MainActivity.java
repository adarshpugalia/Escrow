package com.taadnairsshha.escrow;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.taadnairsshha.escrow.Utils.CommonUtils;
import com.taadnairsshha.escrow.activities.AddAcountActivity;
import com.taadnairsshha.escrow.activities.AddCouponActivity;
import com.taadnairsshha.escrow.activities.AddWebsiteActivity;
import com.taadnairsshha.escrow.data.EscrowDbHelper;
import com.taadnairsshha.escrow.data.service.DbWebsiteService;
import com.taadnairsshha.escrow.models.Website;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private String navOptionStrings[] = {"Coupons", "Accounts", "Websites"};
    private DrawerLayout drawerLayout;
    private ListView navDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Adding the navigation drawer to the activity. */
        addNavigationDrawer();

        /* setting the listeners on the navigation drawer. */
        setNavigationDrawerListeners();

        /* set the action bar. */
        setActionBar();
    }


    /* This method add the navigation bar to the activity. */
    private void addNavigationDrawer() {
        /* getting the views from layout. */
        drawerLayout = (DrawerLayout) findViewById(R.id.act_main_drawer_layout);
        navDrawerList = (ListView) findViewById(R.id.act_main_nav_drawer_layout);

        /* Setting the adapter for the list view. */
        navDrawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navOptionStrings));

        /* setting the on click listener. */
        navDrawerList.setOnItemClickListener(new NavigationDrawerClickListener());
    }


    /* This method sets up the navigation drawer listener. */
    private void setNavigationDrawerListeners() {
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle("Escrow");
            }

            public void onDrawerOpened(View view) {
                super.onDrawerOpened(view);
                getSupportActionBar().setTitle("Nav Drawer");
            }

        };

        /* setting the drawer toggle as the drawer listener. */
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

    }


    /* This method sets the action bar on the activity. */
    public void setActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        actionBarDrawerToggle.syncState();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }


    /* This class implements the onclick listener for the navigation bar items. */
    private class NavigationDrawerClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectNavigationDrawerItem(position);
        }
    }


    /* This method is called when an item in the navigation drawer is clicked. */
    private void selectNavigationDrawerItem(int position) {
        /* setting the selected item to checked. */
        navDrawerList.setItemChecked(position, true);

        /* setting the title for the activity. */
        setTitle(navOptionStrings[position]);

        /* closing the navigation drawer. */
        drawerLayout.closeDrawer(navDrawerList);
    }
}
