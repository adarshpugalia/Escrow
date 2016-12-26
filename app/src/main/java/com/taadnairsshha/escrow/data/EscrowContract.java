package com.taadnairsshha.escrow.data;

import android.provider.BaseColumns;

/**
 * Created by adarsh on 12/26/16.
 */

public final class EscrowContract {
    private EscrowContract() {};

    /* Table schema for Website. */
    public static class Website implements BaseColumns {
        /* Table Name */
        public static final String TABLE_NAME = "website";

        /* Columns */
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_WEBSITE_TYPE = "website_type";
        public static final String COLUMN_HAS_WALLET = "has_wallet";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME + " VARCHAR(100) NOT NULL," +
                        COLUMN_WEBSITE_TYPE + " ENUM('wallet', 'travel', 'cabs', 'movies', 'food') NOT NULL," +
                        COLUMN_HAS_WALLET + " BOOLEAN NOT NULL DEFAULT 0)";

    }
}
