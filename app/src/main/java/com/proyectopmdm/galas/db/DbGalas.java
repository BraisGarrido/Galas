package com.proyectopmdm.galas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;

import com.proyectopmdm.galas.entidades.Galas;

import java.util.ArrayList;

public class DbGalas extends DbHelper {
    Context context;

    public DbGalas(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertaGala(String year, String pelicula, String director) {
        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("year", year);
            values.put("film", pelicula);
            values.put("director", director);

            id = db.insert(TABLE_GALAS, null, values);
        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }

    public ArrayList<Galas> mostrarGalas(){
        DbHelper dbHelper=new DbHelper(context);
        SQLiteDatabase db=dbHelper.getWritableDatabase();

        ArrayList<Galas> listaGalas=new ArrayList<>();
        Galas gala=null;
        Cursor cursorGalas=null;

        cursorGalas=db.rawQuery("SELECT * FROM "+TABLE_GALAS, null);

        if(cursorGalas.moveToFirst()){
            do{
                gala=new Galas();
                gala.setId(cursorGalas.getInt(0));
                gala.setYear(cursorGalas.getString(1));
                gala.setFilm(cursorGalas.getString(2));
                gala.setDirector(cursorGalas.getString(3));
                listaGalas.add(gala);
            } while (cursorGalas.moveToNext());
        }

        cursorGalas.close();

        return listaGalas;
    }
}
