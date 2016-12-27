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
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        COLUMN_NAME + " VARCHAR(100) NOT NULL," +
                        COLUMN_WEBSITE_TYPE + " VARCHAR(10) NOT NULL," +
                        COLUMN_HAS_WALLET + " BOOLEAN NOT NULL DEFAULT 0);";
    }


    public static class Account implements BaseColumns {
        /* Table Name */
        public static final String TABLE_NAME = "account";

        /* Columns */
        public static final String COLUMN_WEBSITE_ID = "website_id";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_WALLET_BALANCE = "wallet_balance";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_WEBSITE_ID + " INTEGER NOT NULL, " +
                        COLUMN_EMAIL + " VARCHAR(500), " +
                        COLUMN_PHONE + " VARCHAR(20), " +
                        COLUMN_PASSWORD + " VARCHAR(50), " +
                        COLUMN_WALLET_BALANCE + " REAL DEFAULT 0, " +
                        "FOREIGN KEY (" + COLUMN_WEBSITE_ID + ") REFERENCES " +
                        Website.TABLE_NAME + "(" + Website._ID + "));";
    }
}
