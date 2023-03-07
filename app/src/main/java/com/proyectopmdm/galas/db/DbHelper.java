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
        db.execSQL("CREATE TABLE "+TABLE_GALAS+"(id INTEGER PRIMARY KEY AUTOINCREMENT, year TEXT NOT NULL, film TEXT, director TEXT)");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2000', 'American beauty', 'Sam Mendes')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2001', 'Gladiator', 'Steven Soderbergh')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2002', 'A beautiful mind', 'Ron Howard')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2003', 'Chicago', 'Roman Polanski')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2004', 'El señor de los anillos: El retorno del rey', 'PeterJackson')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2005', 'Million dollar baby', 'Clim Eastwood')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2006', 'Crash', 'Ang Lee')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2007', 'The departed', 'Martin Scorsese')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2008', 'No country for old men', 'Joel Coen & Ethan Coen')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2009', 'Slumdog millionaire', 'Dany Boyle')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2010', 'The hurt locker', 'Kathryn Bigelow')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2011', 'El discurso del rey', 'Tom Hooper')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2012', 'The artist', 'Michel Hazanavicius')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2013', 'Argo', 'Ang Lee')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2014', '12 años de esclavitud', 'Alfonso Cuarón')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2015', 'Birdman', 'Alejandro González Iñárritu')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2016', 'Spotlight', 'Alejandro González Iñárritu')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2017', 'Moonlight', 'Damien Chazelle')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2018', 'La forma del agua', 'Guillermo del Toro')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2019', 'Green Book', 'Alfonso Cuarón')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2020', 'Parásitos', 'Bong Joon-ho')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2021', 'Nomadland', 'Chloé Zhao')");
        db.execSQL("INSERT INTO "+TABLE_GALAS+" (year, film, director) VALUES ('2022', 'CODA', 'Jane Campion')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

