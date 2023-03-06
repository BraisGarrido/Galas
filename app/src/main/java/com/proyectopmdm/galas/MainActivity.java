package com.proyectopmdm.galas;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.proyectopmdm.galas.db.DbHelper;

public class MainActivity extends AppCompatActivity {
    Button gala_nueva, gala_listar, gala_actual, juego_preguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper dbHelper=new DbHelper(this);
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        if (db!=null){
            db.execSQL("INSERT INTO galas (year, film, director) VALUES ('2000', 'American beauty', 'Sam Mendes')");
            db.execSQL("INSERT INTO galas (year, film, director) VALUES ('2001', 'Gladiator', 'Steven Soderbergh')");
            db.execSQL("INSERT INTO galas (year, film, director) VALUES ('2002', 'A beautiful mind', 'Ron Howard')");
            db.execSQL("INSERT INTO galas (year, film, director) VALUES ('2003', 'Chicago', 'Roman Polanski')");
            db.execSQL("INSERT INTO galas (year, film, director) VALUES ('2004', 'El señor de los anillos: El retorno del rey', 'PeterJackson')");
            db.execSQL("INSERT INTO galas (year, film, director) VALUES ('2005', 'Million dollar baby', 'Clim Eastwood')");
            db.execSQL("INSERT INTO galas (year, film, director) VALUES ('2006', 'Crash', 'Ang Lee')");
            db.execSQL("INSERT INTO galas (year, film, director) VALUES ('2007', 'The departed', 'Martin Scorsese')");
        }

        gala_nueva=findViewById(R.id.nueva_gala);
        gala_listar=findViewById(R.id.listar_gala);
        gala_actual=findViewById(R.id.actual_gala);
        juego_preguntas=findViewById(R.id.juego_preguntas);

        gala_nueva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, InsertarActivity.class);
                startActivity(intent);
            }
        });

        gala_listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this, ListarActivity.class);
                startActivity(intent1);
            }
        });

        gala_actual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(MainActivity.this, NominadosActivity.class);
                startActivity(intent2);
            }
        });

        juego_preguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(MainActivity.this, ComPreguntasActivity.class);
                startActivity(intent3);
            }
        });
    }
}