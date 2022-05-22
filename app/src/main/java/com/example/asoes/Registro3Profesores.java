package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registro3Profesores extends AppCompatActivity {


    Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro3_profesores);
        btnSiguiente = (Button)findViewById(R.id.btnSigRegProf);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistroCompletado();
            }
        });

    }

    public void RegistroCompletado(){
        Intent a = new Intent(this, registroCompletoProfesor.class);
        startActivity(a);

    }
}