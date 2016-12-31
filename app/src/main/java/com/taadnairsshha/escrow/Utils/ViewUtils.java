package com.taadnairsshha.escrow.Utils;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

/**
 * Created by adarsh on 12/27/16.
 */

public class ViewUtils {
    public static final String LINEAR_LAYOUT_MANAGER = "linear_layout_manager";

    public static String getEditTextString(Activity activity, int id) {
        return ((EditText) activity.findViewById(id)).getText().toString();
    }

    /*
     * This method populates a spinner with choices.
     * @param context: the context where the spinner appears.
     * @param spinner: reference to the spinner to be populated.
     * @param items: the list of items to populate the spinner with.
     */
    public static void populateSpinner(Context context, Spinner spinner, List<String> items) {
        /* creating an array adapter from the list of items and a default spinner layout. */
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, items);

        /* specifying the layout to use when the list of choices appears. */
        stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        /* applying the adapter to the spinner. */
        spinner.setAdapter(stringArrayAdapter);
    }


    /*
     * This method binds the adapter and the layout manager to the recycler view in the given context.
     * @param context: the current context.
     * @param recyclerView: the recycler view to bind to.
     * @param layoutManager: the type of layout manager to set on the recycler view.
     * @param adapter: the adapter to bind to the recycler view.
     */
    public static void bindRecyclerView(Context context, RecyclerView recyclerView, String layoutManager, RecyclerView.Adapter adapter) {
        if(layoutManager == LINEAR_LAYOUT_MANAGER) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }

        /*
         * use this setting to improve performance if you know that changes
         * in content do not change the layout size of the RecyclerView
         */
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);
    }
}
