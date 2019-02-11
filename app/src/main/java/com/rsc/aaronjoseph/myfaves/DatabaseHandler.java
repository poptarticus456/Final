package com.rsc.aaronjoseph.myfaves;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "myfaves.db";

    public static final String TABLE_MYFAVES = "myfaves";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CATEGORIES = "category";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DETAILS = "details";
    public static final String COLUMN_URL = "url";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Create tables
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

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MYFAVES);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    //Insert values to the table favs
    public void addMyFaves(MyFaves myfaves){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_CATEGORIES, myfaves.get_category());
        values.put(COLUMN_TITLE, myfaves.get_title());
        values.put(COLUMN_DETAILS, myfaves.get_details());
        values.put(COLUMN_URL, myfaves.get_url());

        db.insert(TABLE_MYFAVES, null, values);
        db.close();
    }


    public void addMyFave(MyFaves myfaves) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_CATEGORIES, myfaves.get_category());
        values.put(COLUMN_TITLE, myfaves.get_title());
        values.put(COLUMN_DETAILS, myfaves.get_details());
        values.put(COLUMN_URL, myfaves.get_url());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_MYFAVES, null, values);
        db.close();
    }

    /**
     *Getting All fav
     **/

    public List<MyFaves> getAllFaves() {
        List<MyFaves> myfavesList = new ArrayList<MyFaves>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MYFAVES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                MyFaves myFaves = new MyFaves();
                myFaves.set_id(Integer.parseInt(cursor.getString(0)));
                myFaves.set_category(cursor.getString(1));
                myFaves.set_title(cursor.getString(2));
                myFaves.set_details(cursor.getString(3));
                myFaves.set_url(cursor.getString(4));

                // Adding fav to list
                myfavesList.add(myFaves);
            } while (cursor.moveToNext());
        }

        // return fav list
        return myfavesList;
    }

    public List<MyFaves> GetTitle(String categories) {
        List<MyFaves> myfavesList = new ArrayList<MyFaves>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MYFAVES + " WHERE " + COLUMN_CATEGORIES + " = '" + categories + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                MyFaves myFaves = new MyFaves();
                myFaves.set_id(Integer.parseInt(cursor.getString(0)));
                myFaves.set_category(cursor.getString(1));
                myFaves.set_title(cursor.getString(2));
                myFaves.set_details(cursor.getString(3));
                myFaves.set_url(cursor.getString(4));

                // Adding fav to list
                myfavesList.add(myFaves);
            } while (cursor.moveToNext());
        }

        // return fav list
        return myfavesList;
    }

    public List<MyFaves> getUrl(String title) {
        List<MyFaves> myfavesList = new ArrayList<MyFaves>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MYFAVES + " WHERE " + COLUMN_TITLE + " = '" + title + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                MyFaves myFaves = new MyFaves();
                myFaves.set_id(Integer.parseInt(cursor.getString(0)));
                myFaves.set_category(cursor.getString(1));
                myFaves.set_title(cursor.getString(2));
                myFaves.set_details(cursor.getString(3));
                myFaves.set_url(cursor.getString(4));

                // Adding fav to list
                myfavesList.add(myFaves);
            } while (cursor.moveToNext());
        }

        // return fav list
        return myfavesList;
    }

    // this is goint in record_TextView in the Main activity.
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT  * FROM " + TABLE_MYFAVES;

        //Cursor points to a location in your results
        Cursor recordSet = db.rawQuery(query, null);
        //Move to the first row in your results
        recordSet.moveToFirst();

        //Position after the last row means the end of the results
        while (!recordSet.isAfterLast()) {
            // null could happen if we used our empty constructor
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

    // this is goint in record_TextView in the Main activity.
    public String databaseToStrings(int id){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT  * FROM " + TABLE_MYFAVES + " WHERE " + COLUMN_ID + " = '" + id + "'";

        //Cursor points to a location in your results
        Cursor recordSet = db.rawQuery(query, null);
        //Move to the first row in your results
        recordSet.moveToFirst();

        //Position after the last row means the end of the results
        while (!recordSet.isAfterLast()) {
            // null could happen if we used our empty constructor
            if (recordSet.getString(recordSet.getColumnIndex("title")) != null) {
                dbString += recordSet.getString(recordSet.getColumnIndex("title"));
                dbString += "\n";
            }
            recordSet.moveToNext();
        }
        db.close();
        return dbString;
    }

    // this is goint in record_TextView in the Main activity.
    public String databaseToStringss(int id){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT  * FROM " + TABLE_MYFAVES + " WHERE " + COLUMN_ID + " = '" + id + "'";

        //Cursor points to a location in your results
        Cursor recordSet = db.rawQuery(query, null);
        //Move to the first row in your results
        recordSet.moveToFirst();

        //Position after the last row means the end of the results
        while (!recordSet.isAfterLast()) {
            // null could happen if we used our empty constructor
            if (recordSet.getString(recordSet.getColumnIndex("details")) != null)  {
                dbString += recordSet.getString(recordSet.getColumnIndex("details"));
            }
            recordSet.moveToNext();
        }
        db.close();
        return dbString;
    }

    // this is goint in record_TextView in the Main activity.
    public String databaseToStringsss(int id){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT  * FROM " + TABLE_MYFAVES + " WHERE " + COLUMN_ID + " = '" + id + "'";

        //Cursor points to a location in your results
        Cursor recordSet = db.rawQuery(query, null);
        //Move to the first row in your results
        recordSet.moveToFirst();

        //Position after the last row means the end of the results
        while (!recordSet.isAfterLast()) {
            if (recordSet.getString(recordSet.getColumnIndex("url")) != null) {
                dbString += recordSet.getString(recordSet.getColumnIndex("url"));
            }
            recordSet.moveToNext();
        }
        db.close();
        return dbString;
    }



    /**
     *Updating single fav
     **/

    public int updateFave(MyFaves myfaves, int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, myfaves.get_title());
        values.put(COLUMN_DETAILS, myfaves.get_details());
        values.put(COLUMN_URL, myfaves.get_url());

        // updating row
        return db.update(TABLE_MYFAVES, values, COLUMN_ID + " = ?",
                new String[] { String.valueOf(id) });
    }

    /**
     *Deleting single fave
     **/

    // delete a row from the database
    public int deleteRow(String todoText){
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = COLUMN_TITLE + " = \"" + todoText + "\"";
        int deleteResult;
        try {
            deleteResult = db.delete(TABLE_MYFAVES, whereClause, null);
        }
        catch(Exception e) {
            Log.e("TODOLIST","delete problem");
            deleteResult = 0;
        }
        return deleteResult;
    }

}