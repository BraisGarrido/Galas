package com.proyectopmdm.galas.adaptadores;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.proyectopmdm.galas.R;
import com.proyectopmdm.galas.entidades.Galas;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ListaGalasAdapter extends RecyclerView.Adapter<ListaGalasAdapter.GalaViewHolder> {
    ArrayList<Galas> listaGalas;
    ArrayList<Galas> listaOriginal;

    public ListaGalasAdapter(ArrayList<Galas> listaGalas){
        this.listaGalas=listaGalas;
        listaOriginal=new ArrayList<>();
        listaOriginal.addAll(listaGalas);
    }

    @NonNull
    @Override
    public ListaGalasAdapter.GalaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.plantilla_recycler, null, false);
        return new GalaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaGalasAdapter.GalaViewHolder galaViewHolder, int i) {
        galaViewHolder.viewYear.setText(listaGalas.get(i).getYear());
        galaViewHolder.viewFilm.setText(listaGalas.get(i).getFilm());
        galaViewHolder.viewDirector.setText(listaGalas.get(i).getDirector());
    }

    public void filtrado(String txtBuscar){
        int longitud=txtBuscar.length();

        if(longitud == 0){
            listaGalas.clear();
            listaGalas.addAll(listaOriginal);
        }
        else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Galas> collecion=listaGalas.stream().filter(i -> i.getYear().toLowerCase().contains(txtBuscar.toLowerCase()))
                        .collect(Collectors.toList());
                listaGalas.clear();
                listaGalas.addAll(collecion);
            }else{
                for(Galas g:listaOriginal){
                    if(g.getYear().toLowerCase().contains(txtBuscar.toLowerCase())){
                        listaGalas.add(g);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listaGalas.size();
    }

    public class GalaViewHolder extends RecyclerView.ViewHolder{
        TextView viewYear, viewFilm, viewDirector;

        public GalaViewHolder(@NonNull View itemView) {
            super(itemView);
            viewYear=itemView.findViewById(R.id.textYear);
            viewFilm=itemView.findViewById(R.id.textPelicula);
            viewDirector=itemView.findViewById(R.id.textDirector);
        }
    }
}
