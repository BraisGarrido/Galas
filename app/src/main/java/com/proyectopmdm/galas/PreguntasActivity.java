package com.proyectopmdm.galas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class PreguntasActivity extends AppCompatActivity {
    RadioButton respuesta1, respuesta2, respuesta3;
    Button siguiente, salir;
    TextView num_pregunta, enunciado;
    int nota=0, npregunta=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        //Se le asigna a cada objeto el id de lo que va a usar
        respuesta1 = (RadioButton)findViewById(R.id.respuesta1);
        respuesta2 = (RadioButton)findViewById(R.id.respuesta2);
        respuesta3 = (RadioButton)findViewById(R.id.respuesta3);

        num_pregunta = (TextView)findViewById(R.id.num_pregunta);
        enunciado = (TextView)findViewById(R.id.enunciado);

        siguiente = (Button)findViewById(R.id.siguiente);
        salir = (Button)findViewById(R.id.salir);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguiente(view);
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PreguntasActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void siguiente (View v){
        //if por si no se marca ninguna opcion
        if(!respuesta1.isChecked() && !respuesta2.isChecked() && !respuesta3.isChecked()){
            Toast.makeText(this, "Elija una opción", Toast.LENGTH_SHORT).show();
        }else if(npregunta == 1){
            //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota
            if(respuesta2.isChecked()){
                nota = nota + 2;
            }
            //Se le suma 1 al contador de la pregunta
            npregunta = npregunta + 1;
            //Se setean los textos para la siguiente pregunta
            num_pregunta.setText("Pregunta 2");
            enunciado.setText("Esta es la pregunta 2, su respuesta correcta es la opcion 1");
            respuesta1.setText("Opcion 1 p2");
            respuesta2.setText("Opcion 2 p2");
            respuesta3.setText("Opcion 3 p2");
            //Se limpian los Radio buttons para la siguiente pregunta
            respuesta1.setChecked(false);
            respuesta2.setChecked(false);
            respuesta3.setChecked(false);
        }else if(npregunta == 2) {
            //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota
            if (respuesta1.isChecked()) {
                nota = nota + 2;
            }
            //Se le suma 1 al contador de la pregunta
            npregunta = npregunta + 1;
            //Se setean los textos para la siguiente pregunta
            num_pregunta.setText("Pregunta 3");
            enunciado.setText("Esta es la pregunta 3, su respuesta correcta es la opcion 3");
            respuesta1.setText("Opcion 1 p3");
            respuesta2.setText("Opcion 2 p3");
            respuesta3.setText("Opcion 3 p3");
            //Se limpian los Radio buttons para la siguiente pregunta
            respuesta1.setChecked(false);
            respuesta2.setChecked(false);
            respuesta3.setChecked(false);
        }else if(npregunta == 3) {
            //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota
            if (respuesta3.isChecked()) {
                nota = nota + 2;
            }
            //Se le suma 1 al contador de la pregunta
            npregunta = npregunta + 1;
            //Se setean los textos para la siguiente pregunta
            num_pregunta.setText("Pregunta 4");
            enunciado.setText("Esta es la pregunta 4, su respuesta correcta es la opcion 1");
            respuesta1.setText("Opcion 1 p4");
            respuesta2.setText("Opcion 2 p4");
            respuesta3.setText("Opcion 3 p4");
            //Se limpian los Radio buttons para la siguiente pregunta
            respuesta1.setChecked(false);
            respuesta2.setChecked(false);
            respuesta3.setChecked(false);
        }else if(npregunta == 4) {
            //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota
            if (respuesta1.isChecked()) {
                nota = nota + 2;
            }
            //Se le suma 1 al contador de la pregunta
            npregunta = npregunta + 1;
            //Se setean los textos para la siguiente pregunta
            num_pregunta.setText("Pregunta 5");
            enunciado.setText("Esta es la pregunta 5, su respuesta correcta es la opcion 2");
            respuesta1.setText("Opcion 1 p5");
            respuesta2.setText("Opcion 2 p5");
            respuesta3.setText("Opcion 3 p5");
            //Se limpian los Radio buttons para la siguiente pregunta
            respuesta1.setChecked(false);
            respuesta2.setChecked(false);
            respuesta3.setChecked(false);
        }else if(npregunta == 5) {
            //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota
            if (respuesta2.isChecked()) {
                nota = nota + 2;
            }
            //Se setean los textos para el resultado de la nota
            num_pregunta.setText("Nota obtenida: "+nota);
            //IF para verificar si se ha aprobado o reprobado
            if(nota >= 6){
                enunciado.setText("Estado: Aprobado");
            }else{
                enunciado.setText("Estado: Reprobado");
            }
            //Se ocultan las opciones que no se van a usar para ver la nota y resultado
            respuesta1.setVisibility(View.GONE);
            respuesta2.setVisibility(View.GONE);
            respuesta3.setVisibility(View.GONE);
            siguiente.setVisibility(View.GONE);
        }
    }
}