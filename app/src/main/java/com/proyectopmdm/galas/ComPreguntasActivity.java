package com.proyectopmdm.galas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ComPreguntasActivity extends AppCompatActivity {
    Button comenzar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_preguntas);

        comenzar=findViewById(R.id.comenzar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ComPreguntasActivity.this, PreguntasActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_juego, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.juego_ver:
                intent=new Intent(ComPreguntasActivity.this, ListarActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}