package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.Statement;

public class registro2 extends AppCompatActivity {

    String idUser;
    Button btnSiguiente;
    EditText txtNombre,txtApePat,txtApeMat,FechaNac,txtRegCorreo2;
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
                        Registrar();
                        OpenRegistroUser();
                        finish();
                    }
            }
        });

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApePat = (EditText) findViewById(R.id.txtApellidoPat);
        txtApeMat = (EditText) findViewById(R.id.txtApellidoMat);
        FechaNac = (EditText) findViewById(R.id.FechaNacimiento);
        txtRegCorreo2 = (EditText) findViewById(R.id.txtRegCorreo2);


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
        } else if(TextUtils.isEmpty(txtRegCorreo2.getText().toString())){
        Toast.makeText(this, "Llena el campo de 'Correo Electronico' por favor", Toast.LENGTH_SHORT).show();
        return false;
    }


        return true;
    }
//SQLSERVER
    void Consulta(){

        try{
            CONEXION conex = new CONEXION();
            Statement stm = conex.conexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM ASOESPERSONAS");

            if(rs.next()){
                txtNombre.setText(rs.getString(2));
                txtApePat.setText(rs.getString(3));
                txtApeMat.setText(rs.getString(4));
                txtRegCorreo2.setText(rs.getString(5));
                FechaNac.setText(rs.getString(6));
            }


        }catch (Exception e){
            Toast.makeText(this, "Error viejo", Toast.LENGTH_SHORT).show();
        }
    }

    void Registrar(){
        try{
            CONEXION conex = new CONEXION();
            Statement stm = conex.conexion().createStatement();
            ResultSet rs = stm.executeQuery("Insert into ASOESPersonas values ('"+txtNombre.getText().toString()+"','"+txtApePat.getText().toString()+"','"+txtApeMat.getText().toString()+"','"+txtRegCorreo2.getText().toString()+"','"+FechaNac.getText().toString()+"')");

        }catch (Exception e){

        }

    }



}