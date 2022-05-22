package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class registro extends AppCompatActivity {

    RadioButton rbProfesor,rbAlumno;
    Button btnSig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        rbProfesor = (RadioButton) findViewById(R.id.radioButton);
        rbAlumno = (RadioButton) findViewById(R.id.radioButton2);
        btnSig = (Button)findViewById(R.id.button3);
        btnSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(rbProfesor.isChecked()){
                    OpenRegistroProfe();
                }else if(rbAlumno.isChecked()){
                    RegNormalFin();
                }else{
                    //Seleccione algo.
                }


            }
        });

    }

    public void OpenRegistroProfe() {

        Intent a = new Intent(this, Registro3Profesores.class);
        startActivity(a);

    }
    public void RegNormalFin() {

        Intent a = new Intent(this, registroCompleto.class);
        startActivity(a);

    }
}