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

    //Adaptamos los datos de una lista de galas a una vista de recycler.
    public ListaGalasAdapter(ArrayList<Galas> listaGalas){
        this.listaGalas=listaGalas;
        listaOriginal=new ArrayList<>();
        listaOriginal.addAll(listaGalas);
    }

    //Inflamos una vista para el elemento de la lista a partir de una
    // plantilla definida en el archivo plantilla_recycler.xml y se crea
    // un nuevo GalaViewHolder a partir de la vista inflada.
    @NonNull
    @Override
    public ListaGalasAdapter.GalaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.plantilla_recycler, null, false);
        return new GalaViewHolder(view);
    }

    //Establecemos los valores de texto de la vista GalaViewHolder para
    // el elemento de la lista correspondiente en la lista listaGalas.
    @Override
    public void onBindViewHolder(@NonNull ListaGalasAdapter.GalaViewHolder galaViewHolder, int i) {
        galaViewHolder.viewYear.setText(listaGalas.get(i).getYear());
        galaViewHolder.viewFilm.setText(listaGalas.get(i).getFilm());
        galaViewHolder.viewDirector.setText(listaGalas.get(i).getDirector());
    }

    //Aplicamos un filtro de búsqueda a la lista listaGalas
    //Cuando se llama a este método, se verifica la longitud del texto
    //de búsqueda txtBuscar.
    //Si la longitud es 0, la lista listaGalas se restaura a su estado original
    //a partir de listaOriginal. De lo contrario, se recorre listaOriginal
    //y se agrega cada elemento que contenga el texto de búsqueda a la lista
    //listaGalas. Para hacer esto, se utiliza un filtro lambda en la
    //versión de SDK 24 o superior y un bucle for en versiones anteriores.
    //Luego, se notifica al adaptador que la lista de datos ha cambiado.
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

    //Devolvemos la cantidad de elementos en la lista listaGalas
    @Override
    public int getItemCount() {
        return listaGalas.size();
    }

    public class GalaViewHolder extends RecyclerView.ViewHolder{
        TextView viewYear, viewFilm, viewDirector;

        //subclase de RecyclerView.ViewHolder y contiene referencias
        //a las vistas de texto viewYear, viewFilm y viewDirector
        //que se establecen en el constructor.
        public GalaViewHolder(@NonNull View itemView) {
            super(itemView);
            viewYear=itemView.findViewById(R.id.textYear);
            viewFilm=itemView.findViewById(R.id.textPelicula);
            viewDirector=itemView.findViewById(R.id.textDirector);
        }
    }
}
