package com.taadnairsshha.escrow.Utils;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

/**
 * Created by adarsh on 12/27/16.
 */

public class ViewUtils {
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
}
