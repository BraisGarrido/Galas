package com.proyectopmdm.galas;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.proyectopmdm.galas.db.DbHelper;

public class MainActivity extends AppCompatActivity {
    Button gala_nueva, gala_listar, gala_actual, juego_preguntas;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper dbHelper=new DbHelper(this);
        SQLiteDatabase db=dbHelper.getWritableDatabase();


        gala_nueva=findViewById(R.id.nueva_gala);
        gala_listar=findViewById(R.id.listar_gala);
        gala_actual=findViewById(R.id.actual_gala);
        juego_preguntas=findViewById(R.id.juego_preguntas);

        gala_nueva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(MainActivity.this, InsertarActivity.class);
                startActivity(intent);
            }
        });

        gala_listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(MainActivity.this, ListarActivity.class);
                startActivity(intent);
            }
        });

        gala_actual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(MainActivity.this, NominadosActivity.class);
                startActivity(intent);
            }
        });

        juego_preguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(MainActivity.this, ComPreguntasActivity.class);
                startActivity(intent);
            }
        });
    }
}