package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class registro2 extends AppCompatActivity {

    Button btnSiguiente;
    EditText txtNombre,txtApePat,txtApeMat,FechaNac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro2);

        //EVENT FOR BUTTON NEXT REGISTER ACTIVITY
        btnSiguiente = (Button) findViewById(R.id.btnSigReg2);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(camposLlenos()) {
                        OpenRegistroUser();
                    }
            }
        });

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApePat = (EditText) findViewById(R.id.txtApellidoPat);
        txtApeMat = (EditText) findViewById(R.id.txtApellidoMat);
        FechaNac = (EditText) findViewById(R.id.FechaNacimiento);


    }

    public void OpenRegistroUser() {

        Intent a = new Intent(this, registro.class);
        startActivity(a);
    }

    public boolean camposLlenos(){

        if(TextUtils.isEmpty(txtNombre.getText().toString())){
            Toast.makeText(this, "Llena el campo de 'Nombres' por favor", Toast.LENGTH_SHORT).show();
            return false;
        }else if(TextUtils.isEmpty(txtApePat.getText().toString())){
            Toast.makeText(this, "Llena el campo de 'Apellido Paterno' por favor", Toast.LENGTH_SHORT).show();
            return false;
        }else if(TextUtils.isEmpty(txtApeMat.getText().toString())){
            Toast.makeText(this, "Llena el campo de 'Apellido Materno' por favor", Toast.LENGTH_SHORT).show();
            return false;
        }else if(TextUtils.isEmpty(FechaNac.getText().toString())){
            Toast.makeText(this, "Llena el campo de 'Fecha de Nacimiento' por favor", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }


}