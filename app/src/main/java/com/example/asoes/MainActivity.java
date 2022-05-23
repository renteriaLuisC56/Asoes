package com.example.asoes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etxt_Materia;
    private EditText etxt_Tema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxt_Materia = (EditText)findViewById(R.id.etxt_Materia);
        etxt_Tema = (EditText)findViewById(R.id.etxt_Tema);
    }

    public void asesoriaE(View view) { //Sirve para cambiar a la pantalla de la asesoria especifica

            Intent intent = new Intent(this, MainActivity2_AsesoriaE.class);
            startActivity(intent);
            finish();

    }

    public void asesoria(View view) { //Sirve para cambiar a la pantalla en la que se busca una asesoria
        String materia = etxt_Materia.getText().toString();
        String tema = etxt_Tema.getText().toString();

        if(materia.equals("") || tema.equals("")) { //Si los campos de materia y tema estan vacios no puede cambiar de pantalla

            Toast.makeText(this, "Debes Llenar Todos Los Campos", Toast.LENGTH_SHORT).show();
            etxt_Materia.requestFocus();
            InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
            imm.showSoftInput(etxt_Materia, InputMethodManager.SHOW_IMPLICIT);

        } else { //Si los campos estan llenos cambia buscar la asesoria con el tema solicitado

            Toast.makeText(this, "BUSCANDO ASESORIA", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity3_asesoria.class);
            startActivity(intent);
            finish();

        }
    }

    @Override
    public void onBackPressed() {

    }
}