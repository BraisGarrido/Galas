package com.proyectopmdm.galas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.proyectopmdm.galas.db.DbGalas;

public class InsertarActivity extends AppCompatActivity {
    EditText editYear, editFilm, editDirector;
    Button guardar;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        editYear=findViewById(R.id.edit_year);
        editFilm=findViewById(R.id.edit_film);
        editDirector=findViewById(R.id.edit_director);
        guardar=findViewById(R.id.guardar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cogemos los textos de los campos y los insertamos en la base de datos
                DbGalas dbGalas=new DbGalas(InsertarActivity.this);
                long id=dbGalas.insertaGala(editYear.getText().toString(), editFilm.getText().toString(), editDirector.getText().toString());

                //Creamos dos toast para indicar si los campos han sido registrados con exito o han tenido un error
                if(id > 0){
                    Toast.makeText(InsertarActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                }
                else {
                    Toast.makeText(InsertarActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //Método para limpiar todos los campos después de meter un registro
    private void limpiar(){
        editYear.setText("");
        editFilm.setText("");
        editDirector.setText("");
    }

    //Creamos menu para ir al resto de opciones
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_insertar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.insertar_listar:
                intent=new Intent(InsertarActivity.this, ListarActivity.class);
                startActivity(intent);
                return true;
            case R.id. insertar_juego:
                intent=new Intent(InsertarActivity.this, InsertarActivity.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}