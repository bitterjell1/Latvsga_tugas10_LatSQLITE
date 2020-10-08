package com.fitriasari.mahasiswa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    static final String DB_NAME = "students_db";
    public static final int DATABASE_VERSION = 1;
    static final String TABLE_STUDENTS = "students";
    static final String KEY_ID = "id";
    static final String KEY_NAME = "nama";

    private static final String CREATE_TABLE_STUDENTS = "CREATE TABLE " + TABLE_STUDENTS + " (" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context,DB_NAME,null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "  + TABLE_STUDENTS);
        onCreate(db);
    }

}
