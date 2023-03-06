package com.proyectopmdm.galas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ComPreguntasActivity extends AppCompatActivity {
    Button comenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_preguntas);

        comenzar=findViewById(R.id.comenzar);
        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ComPreguntasActivity.this, PreguntasActivity.class);
                startActivity(intent);
            }
        });
    }
}