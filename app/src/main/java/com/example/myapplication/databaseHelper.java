package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "std";
    public static final String COL_1 = "Date";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Ayat";
    public static final String COL_4 = "Sabaqi";
    public static final String COL_5 = "Manzil";
    public static final String COL_6 = "Salah";


    public databaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(Date TEXT,Name TEXT,Ayat TEXT,Sabaqi TEXT,Manzil TEXT,Salah TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean Insert(String Date, String Name, String Ayat, String Sabaqi, String Manzil, String Salah)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_1,Date);
        values.put(COL_2,Name);
        values.put(COL_3,Ayat);
        values.put(COL_4,Sabaqi);
        values.put(COL_5,Manzil);
        values.put(COL_6,Salah);
        long result=db.insert(TABLE_NAME,null,values);
        if(result==-1)
            return false;
        else
            return true;
    }
    public Cursor getData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        return res;
    }
}
