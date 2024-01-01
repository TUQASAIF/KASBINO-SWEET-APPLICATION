package com.example.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper1 extends SQLiteOpenHelper {
    private static final String dbName="userDb";
    private static final int dbVersion=1;
    private static final String tbl="detail";
    private static final String id="ID";
    private static final String un="UserName";
    private static final String pass="Password";

    public dbHelper1(Context context)
    {
        super(context,dbName,null,dbVersion);
    }

    public void onCreate(SQLiteDatabase db)
    {
        String stg="create table " +tbl+ "("+id+ "Integer primary key autoincrement,"
                +un+ "text," +pass+ "text)";
        db.execSQL(stg);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(String.format("DROP TABLE IF EXISTSdetail%s", tbl));
        onCreate(db);
    }

    public void addUser(String username,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(un,username);
        cv.put(pass,password);
        db.insert(tbl,null,cv);
        db.close();
    }

    public boolean validateUser(String username, String password)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cc=db.query(tbl,new String[]{id},un +"=? AND " +pass+ "=?",
                new String[]{username,password},null,null,null);
        boolean exists=cc.getCount()>0;
        cc.close();
        db.close();
        return exists;

    }



}

