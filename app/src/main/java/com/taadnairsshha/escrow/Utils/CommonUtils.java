package com.taadnairsshha.escrow.Utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by adarsh on 12/27/16.
 */

public class CommonUtils {
    public static void startActivity(Context context, Class newActivityClass) {
        Intent intent = new Intent(context, newActivityClass);
        context.startActivity(intent);
    }
}
