package com.example.pc_home.simpledatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "name_phone.db";
    private static final String TABLE_NAME = "NamePhone";
    private static final String COL_NAME = "col_name";
    private static final String COL_PHONE = "col_phone";



    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
       String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " ("
                + COL_NAME +" TEXT PRIMARY KEY, "
                +COL_PHONE+" NUMBER )";
        db.execSQL(TABLE_CREATE);


    }
    public  void INSERT(String name, String phone){
        //String Insert_Query = "INSERT INTO " + TABLE_NAME + "VALUES(" + name + "," + phone + " )";
       // Log.d("INSERT",db.toString());
       // db.execSQL(Insert_Query);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentval = new ContentValues();
        contentval.put(COL_NAME,name);
        contentval.put(COL_PHONE,phone);
        db.insert(TABLE_NAME,null,contentval);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public  void Delete(){
        SQLiteDatabase db = this.getWritableDatabase();
        String Delete_Query = "DELETE FROM " + TABLE_NAME;
        db.execSQL(Delete_Query);
    }
    public ArrayList<String> getAppCategoryDetail() {

        ArrayList<String> data= new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {
                data.add(cursor.getString(cursor.getColumnIndex(COL_NAME)));

              //  data.put(cursor.getString(cursor.getColumnIndex(COL_NAME)),cursor.getString(cursor.getColumnIndex(COL_PHONE)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return data;
    }
}
