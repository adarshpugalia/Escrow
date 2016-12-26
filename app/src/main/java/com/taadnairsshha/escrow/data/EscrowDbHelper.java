package com.taadnairsshha.escrow.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adarsh on 12/26/16.
 */
/*
 * This class provides the db herlper for accessing database.
 */
public class EscrowDbHelper extends SQLiteOpenHelper {
    /* Increase the db version whenever db schema is changed. */
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Escrow.db";

    public EscrowDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase db) {
        /* creating table for website */
        db.execSQL(EscrowContract.Website.SQL_CREATE_TABLE);
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /* Migration code goes here. */
    }


    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
