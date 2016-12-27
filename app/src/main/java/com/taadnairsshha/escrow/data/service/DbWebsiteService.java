package com.taadnairsshha.escrow.data.service;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.taadnairsshha.escrow.data.EscrowContract;
import com.taadnairsshha.escrow.enums.WebsiteType;
import com.taadnairsshha.escrow.models.Website;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adarsh on 12/26/16.
 */

public class DbWebsiteService {
    private static Website getWebsiteFromCursor(Cursor cursor) {
        /*
         * TODO: Add a get boolean to db utils.
         */
        return Website.create(cursor.getString(cursor.getColumnIndex(EscrowContract.Website.COLUMN_NAME)),
                WebsiteType.valueOf(cursor.getString(cursor.getColumnIndex(EscrowContract.Website.COLUMN_WEBSITE_TYPE))),
                (cursor.getInt(cursor.getColumnIndex(EscrowContract.Website.COLUMN_HAS_WALLET)) == 1));
    }

    public static List<Website> getWebsites(SQLiteDatabase db) {
        Cursor cursor = db.query(EscrowContract.Website.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);

        List<Website> websites = new ArrayList<Website>();
        while(cursor.moveToNext()) {
            websites.add(getWebsiteFromCursor(cursor));
        }

        return websites;
    }


    public static long insertWebsite(Website website, SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(EscrowContract.Website.COLUMN_NAME, website.getName());
        contentValues.put(EscrowContract.Website.COLUMN_WEBSITE_TYPE, website.getWebsiteType().name());
        contentValues.put(EscrowContract.Website.COLUMN_HAS_WALLET, website.hasWallet());

        long rowId = db.insert(EscrowContract.Website.TABLE_NAME, null, contentValues);
        if(rowId == -1) {
            throw new RuntimeException("Could not insert website: " + website.getName());
        }

        return rowId;
    }
}
