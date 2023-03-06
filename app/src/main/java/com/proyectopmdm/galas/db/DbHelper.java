package com.proyectopmdm.galas.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="galas.db";
    private static final int DB_VERSION=1;
    public static final String TABLE_GALAS="galas";

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_GALAS+"("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "year TEXT NOT NULL,"+
                "film TEXT,"+
                "director TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
