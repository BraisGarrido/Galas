package com.proyectopmdm.galas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class NominadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nominados);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_nominados, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nominados_añadir:
                Intent intent = new Intent(NominadosActivity.this, InsertarActivity.class);
                startActivity(intent);
                return true;
            case R.id.nominados_listar:
                Intent intent1 = new Intent(NominadosActivity.this, ListarActivity.class);
                startActivity(intent1);
                return true;
            case R.id.nominados_juego:
                Intent intent2=new Intent(NominadosActivity.this, ComPreguntasActivity.class);
                startActivity(intent2);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}