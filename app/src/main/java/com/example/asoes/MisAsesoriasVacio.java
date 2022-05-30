package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MisAsesoriasVacio extends AppCompatActivity {

    Button crear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_asesorias_vacio);

        crear = (Button)findViewById(R.id.button21);
        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                abrirCrear();
            }
        });
    }

    void abrirCrear(){
        Intent a = new Intent(this,CreacionAsesorias.class);
        startActivity(a);
        finish();
    }



}