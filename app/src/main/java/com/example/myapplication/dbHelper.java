package com.example.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper{
    public static String DATABASE_NAME = "sweet.db";
    public static final String TABLE_NAME = "Sweet_Table";
    public static final String COL_1 = "name";
    public static final String COL_2 = "phoneno";
    public static final String COL_3 = "sweetc"; // Missing semicolon
    public static final String COL_4 = "sweetno";
    public dbHelper(startactivity start)
    {
        super(start,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(name TEXT, phoneno TEXT, sweetc TEXT, sweetno TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name, String phoneno, String sweetc, String sweetno) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put(COL_1, name);
        contentvalues.put(COL_2, phoneno);
        contentvalues.put(COL_3, sweetc);
        contentvalues.put(COL_4, sweetno);
        long result=db.insert(TABLE_NAME,null,contentvalues);
        if(result==-1)
            return false;
        else
            return true;
    }


    public boolean updateData(String name, String phoneno, String sweetc, String sweetno) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, name);
        contentValues.put(COL_2, phoneno);
        contentValues.put(COL_3, sweetc);
        contentValues.put(COL_4, sweetno);
        db.update(TABLE_NAME, contentValues, "PHONE NUMBER=?", new String[]{phoneno});
        return true;
    }

    public Integer deleteData(String phoneno) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "PHONE NUMBER=?", new String[]{phoneno});
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return cursor;
    }
}
