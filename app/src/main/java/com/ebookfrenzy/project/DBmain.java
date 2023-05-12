package com.ebookfrenzy.project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBmain extends SQLiteOpenHelper {
    public static final String DB="appointment";
    public static final int VER=1;
    public DBmain(@Nullable Context context) {
        super(context, DB, null, VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE history (" +
                "id INTEGER PRIMARY KEY, " +
                "sub1 TEXT, " +
                "sub2 TEXT, " +
                "sub3 TEXT, " +
                "sub4 TEXT, " +
                "sub5 TEXT, " +
                "sub6 TEXT, " +
                "sub7 TEXT, " +
                "sub8 TEXT, " +
                "sub9 TEXT, " +
                "sub10 TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop="drop table if exists history";
        db.execSQL(drop);
        onCreate(db);
    }
}

