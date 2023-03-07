package com.proyectopmdm.galas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.proyectopmdm.galas.adaptadores.ListaGalasAdapter;
import com.proyectopmdm.galas.db.DbGalas;
import com.proyectopmdm.galas.entidades.Galas;

import java.util.ArrayList;

public class ListarActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    SearchView txtBuscar;
    RecyclerView listaGalas;
    ArrayList<Galas> listaArrayGalas;
    ListaGalasAdapter adapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        txtBuscar=findViewById(R.id.txtbuscar);
        txtBuscar.setQueryHint("Escribe un año");
        listaGalas=findViewById(R.id.recyclerView);

        // Se establece que se muestre el botón de "volver atrás" en la barra de acción (action bar)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaGalas.setLayoutManager(new LinearLayoutManager(this));

        //Instanciamos la arraylist para llenar el recyclerview
        DbGalas dbGalas=new DbGalas(ListarActivity.this);
        listaArrayGalas=new ArrayList<>();

        adapter=new ListaGalasAdapter(dbGalas.mostrarGalas());
        listaGalas.setAdapter(adapter);

        txtBuscar.setOnQueryTextListener(this);
    }

    //Añadimos el filtrado para darle funcionalidad al buscador
    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.filtrado(s);
        return false;
    }

    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_listar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.listar_añadir:
                intent=new Intent(ListarActivity.this, InsertarActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}