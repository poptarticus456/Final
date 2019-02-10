package com.rsc.aaronjoseph.myfaves;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MyFavesDB.db";
    public static final String TABLE_MYFAVES = "myfaves";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CATEGORIES = "category";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DETAILS = "details";
    public static final String COLUMN_URL = "url";




    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_MYFAVES + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CATEGORIES + " TEXT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_DETAILS + " TEXT, " +
                COLUMN_URL + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MYFAVES);
        onCreate(db);
    }


    public void addMyFave(MyFaves myfaves) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_CATEGORIES, myfaves.get_category());
        values.put(COLUMN_TITLE, myfaves.get_title());
        values.put(COLUMN_DETAILS, myfaves.get_details());
        values.put(COLUMN_URL, myfaves.get_title());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_MYFAVES, null, values);
        db.close();
    }

    public int deleteRow(String myfaves) {
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = COLUMN_TITLE + " = \"" + myfaves + "\"";
        int deleteResult;
        try {
            deleteResult = db.delete(TABLE_MYFAVES, whereClause, null);
        } catch (Exception e) {
            Log.e("MYFAVES", "delete problem");
            deleteResult = 0;
        }
        return deleteResult;
    }

    public String databaseToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_MYFAVES + " WHERE 1";

        Cursor recordSet = db.rawQuery(query, null);
        recordSet.moveToFirst();

        while (!recordSet.isAfterLast()) {
            if (recordSet.getString(recordSet.getColumnIndex("category")) != null) {
                dbString += recordSet.getString(recordSet.getColumnIndex("category"));
                dbString += recordSet.getString(recordSet.getColumnIndex("title"));
                dbString += "\n";
            }
            recordSet.moveToNext();
        }
        db.close();
        return dbString;
    }




}
