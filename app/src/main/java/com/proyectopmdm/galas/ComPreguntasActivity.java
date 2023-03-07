package com.proyectopmdm.galas;

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

        // Se establece que se muestre el botón de "volver atrás" en la barra de acción (action bar)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Se establece el comportamiento para cuando se haga clic en el botón "comenzar"
        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(ComPreguntasActivity.this, PreguntasActivity.class);
                startActivity(intent);
            }
        });
    }

    // Se crea el menú de opciones para la actividad
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_juego, menu);
        return true;
    }

    // Se establece el comportamiento para cuando se seleccione una opción del menú de opciones
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