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

    // Constructor que recibe el contexto de la aplicación
    public DbGalas(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    // Método para insertar una gala en la tabla "galas"
    public long insertaGala(String year, String pelicula, String director) {
        long id = 0;

        try {
            // Se obtiene una instancia de la base de datos en modo escritura
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            // Se crean los valores a insertar
            ContentValues values = new ContentValues();
            values.put("year", year);
            values.put("film", pelicula);
            values.put("director", director);

            // Se inserta la fila en la tabla "galas" y se obtiene el ID generado
            id = db.insert(TABLE_GALAS, null, values);
        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }

    // Método para mostrar todas las galas almacenadas en la tabla "galas"
    public ArrayList<Galas> mostrarGalas(){
        // Se obtiene una instancia de la base de datos en modo escritura
        DbHelper dbHelper=new DbHelper(context);
        SQLiteDatabase db=dbHelper.getWritableDatabase();

        // Se crea una lista de galas vacía y un objeto gala para ir agregando las galas recuperadas
        ArrayList<Galas> listaGalas=new ArrayList<>();
        Galas gala=null;
        Cursor cursorGalas=null;

        // Se ejecuta la consulta para recuperar todas las galas de la tabla "galas"
        cursorGalas=db.rawQuery("SELECT * FROM "+TABLE_GALAS, null);

        // Se recorre el cursor con todas las galas y se agrega cada una a la lista de galas
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

        // Se cierra el cursor y se retorna la lista de galas
        cursorGalas.close();

        return listaGalas;
    }
}
