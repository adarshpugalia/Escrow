package com.taadnairsshha.escrow.Utils;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;

/**
 * Created by adarsh on 12/27/16.
 */

public class ViewUtils {
    public static String getEditTextString(Activity activity, int id) {
        return ((EditText) activity.findViewById(id)).getText().toString();
    }
}
