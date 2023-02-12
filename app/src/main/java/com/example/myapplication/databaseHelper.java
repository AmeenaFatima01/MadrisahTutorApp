package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
