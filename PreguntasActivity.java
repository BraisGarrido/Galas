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
    Button siguiente, salir, reiniciar;
    TextView num_pregunta, enunciado;
    int nota=0, npregunta=1;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);

        //Se le asigna a cada objeto el id de lo que va a usar
        respuesta1 = findViewById(R.id.respuesta1);
        respuesta2 = findViewById(R.id.respuesta2);
        respuesta3 = findViewById(R.id.respuesta3);

        num_pregunta = findViewById(R.id.num_pregunta);
        enunciado = findViewById(R.id.enunciado);

        siguiente = findViewById(R.id.siguiente);
        salir = findViewById(R.id.salir);
        reiniciar= findViewById(R.id.reiniciar);
        //Volvemos invisible este botón para mostrarlo al final
        reiniciar.setVisibility(View.GONE);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguiente(view);
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(PreguntasActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(PreguntasActivity.this, ComPreguntasActivity.class);
                startActivity(intent);
            }
        });
    }

    public void siguiente (View v){
        //if por si no se marca ninguna opcion
        if(!respuesta1.isChecked() && !respuesta2.isChecked() && !respuesta3.isChecked()){
            Toast.makeText(this, "Elije una opción", Toast.LENGTH_SHORT).show();
        }else if(npregunta == 1){
            //El enunciado de la primera pregunta se pone directamente en el activity_preguntas(Respuesta correcta: 2)
            //Se verifica la respuesta, si es correcta se agrega 1 punto a la nota
            if(respuesta2.isChecked()){
                nota = nota + 1;
            }
            //Se le suma 1 al contador de la pregunta
            npregunta = npregunta + 1;
            //Se reinician los textos para la siguiente pregunta(Respuesta correcta: 3)
            num_pregunta.setText("Pregunta 2");
            enunciado.setText("¿Cual es la película con más premios Oscar ganados?");
            respuesta1.setText("Titanic");
            respuesta2.setText("El señor de los anillos: El retorno del rey");
            respuesta3.setText("Ambas");
            //Se limpian los Radio buttons para la siguiente pregunta
            respuesta1.setChecked(false);
            respuesta2.setChecked(false);
            respuesta3.setChecked(false);
        }else if(npregunta == 2) {
            //Se verifica la respuesta, si es correcta se agrega 1 punto a la nota
            if (respuesta3.isChecked()) {
                nota = nota + 1;
            }
            //Se le suma 1 al contador de la pregunta
            npregunta = npregunta + 1;
            //Se reinician los textos para la siguiente pregunta(Respuesta correcta: 1)
            num_pregunta.setText("Pregunta 3");
            enunciado.setText("¿Cuando fue la primera gala de los premios Oscar?");
            respuesta1.setText("1929");
            respuesta2.setText("1931");
            respuesta3.setText("1927");
            //Se limpian los Radio buttons para la siguiente pregunta
            respuesta1.setChecked(false);
            respuesta2.setChecked(false);
            respuesta3.setChecked(false);
        }else if(npregunta == 3) {
            //Se verifica la respuesta, si es correcta se agrega 1 punto a la nota
            if (respuesta1.isChecked()) {
                nota = nota + 1;
            }
            //Se le suma 1 al contador de la pregunta
            npregunta = npregunta + 1;
            //Se reinician los textos para la siguiente pregunta(Respuesta correcta: 2)
            num_pregunta.setText("Pregunta 4");
            enunciado.setText("¿Cual fue la primera película de habla no inglesa en ganar el Oscar a mejor película?");
            respuesta1.setText("Roma");
            respuesta2.setText("Parásitos");
            respuesta3.setText("La gran belleza");
            //Se limpian los Radio buttons para la siguiente pregunta
            respuesta1.setChecked(false);
            respuesta2.setChecked(false);
            respuesta3.setChecked(false);
        }else if(npregunta == 4) {
            //Se verifica la respuesta, si es correcta se agrega punto a la nota
            if (respuesta2.isChecked()) {
                nota = nota + 1;
            }
            //Se le suma 1 al contador de la pregunta
            npregunta = npregunta + 1;
            //Se reinician los textos para la siguiente pregunta(Respuesta correcta:2)
            num_pregunta.setText("Pregunta 5");
            enunciado.setText("¿Cual fue la primera película española en ganar un Oscar?");
            respuesta1.setText("Los santos inocentes");
            respuesta2.setText("Volver a empezar");
            respuesta3.setText("Amanece, que no es poco");
            //Se limpian los Radio buttons para la siguiente pregunta
            respuesta1.setChecked(false);
            respuesta2.setChecked(false);
            respuesta3.setChecked(false);

            siguiente.setText("Finalizar");
        }else if(npregunta == 5) {
            //Se verifica la respuesta, si es correcta se agrega 1 punto a la nota
            if (respuesta2.isChecked()) {
                nota = nota + 1;
            }
            //Se reinician los textos para el resultado de la nota
            num_pregunta.setText("Preguntas acertadas: "+nota);
            //IF para verificar si se ha aprobado o reprobado
            if(nota >= 0 && nota <= 2)
                enunciado.setText("Un poco flojo, vuelve a intentarlo");
            else if(nota > 2 && nota <= 4){
                enunciado.setText("Increíble, eres muy bueno");
            }else{
                enunciado.setText("Eres todo un experto cinematográfico");
            }
            reiniciar.setVisibility(View.VISIBLE);
            //Se ocultan las opciones que no se van a usar para ver la nota y resultado
            respuesta1.setVisibility(View.GONE);
            respuesta2.setVisibility(View.GONE);
            respuesta3.setVisibility(View.GONE);
            siguiente.setVisibility(View.GONE);
        }
    }
}