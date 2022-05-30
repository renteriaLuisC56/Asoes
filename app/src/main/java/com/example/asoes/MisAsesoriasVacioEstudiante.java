package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MisAsesoriasVacioEstudiante extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_asesorias_vacio_estudiante);

        btn= (Button)findViewById(R.id.button24);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IrInicioEstudiante();
            }
        });



    }

    void IrInicioEstudiante(){

        Intent a = new Intent(this,pantallaPrincipal.class);
        startActivity(a);
        finish();
    }
}