package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity_Solicitud extends AppCompatActivity {

    private EditText txt_Materia;
    private EditText txt_Tema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_solicitud);

        txt_Materia = (EditText)findViewById(R.id.Materia);
        txt_Tema = (EditText)findViewById(R.id.Tema);
    }

    public void asesoriaE(View view) { //Sirve para cambiar a la pantalla de la asesoria especifica

        Intent intent = new Intent(this, MainActivity_AsesoriaE.class);
        startActivity(intent);
        finish();

    }

    public void asesoria(View view) { //Sirve para cambiar a la pantalla en la que se busca una asesoria
        String materia = txt_Materia.getText().toString();
        String tema = txt_Tema.getText().toString();

        if(materia.equals("") || tema.equals("")) { //Si los campos de materia y tema estan vacios no puede cambiar de pantalla

            Toast.makeText(this, "Debes Llenar Todos Los Campos", Toast.LENGTH_SHORT).show();
            txt_Materia.requestFocus();
            InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
            imm.showSoftInput(txt_Materia, InputMethodManager.SHOW_IMPLICIT);

        } else { //Si los campos estan llenos cambia buscar la asesoria con el tema solicitado

            Toast.makeText(this, "BUSCANDO ASESORIA", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity_Asesoria.class);
            intent.putExtra("dato", materia);
            startActivity(intent);
            finish();

        }
    }

    public void Regresar(View view) {

        Intent intent = new Intent(this, pantallaPrincipal.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {

    }
}