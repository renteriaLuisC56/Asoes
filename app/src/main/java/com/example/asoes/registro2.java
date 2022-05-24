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
                        //Registrar();
                        OpenRegistroUser();
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


    public void Registrar(){

        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"Asoes",null,2);
        SQLiteDatabase BaseDeDatos =admin.getWritableDatabase();

        String Nombres=txtNombre.getText().toString();
        String ApellidoPat=txtApePat.getText().toString();
        String ApellidoMat=txtApeMat.getText().toString();
        String FechaNacimiento=FechaNac.getText().toString();
        String Correo=txtRegCorreo2.getText().toString();


        if(camposLlenos()){
            ContentValues registro=new ContentValues();


            registro.put("Nombres",Nombres);
            registro.put("ApePat",ApellidoPat);
            registro.put("ApeMat",ApellidoMat);
            registro.put("FechaNac",FechaNacimiento);
            registro.put("CorreoE",Correo);

            BaseDeDatos.insert("personas",null,registro);

            try{
            Cursor mCursor = BaseDeDatos.rawQuery(
                    "SELECT * FROM personas WHERE CorreoE= '" + txtRegCorreo2.getText().toString()+ "'", null);

            if (mCursor.moveToFirst()) {
                idUser = mCursor.getString(0);
                Toast.makeText(this, "Hola", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
            BaseDeDatos.close();

           // Toast.makeText(this,"Registro existoso",Toast.LENGTH_SHORT).show();
        }else{
            //Toast.makeText(this,"Se deben llenar todos los campos",Toast.LENGTH_SHORT).show();
        }

       //getId();

    }

    void getId(){
        try {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Asoes", null, 2);
            SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
            Cursor mCursor = BaseDeDatos.rawQuery(
                    "SELECT Id_persona FROM personas WHERE CorreoE= '" + txtRegCorreo2.getText().toString()+ "'", null);

            if (mCursor.moveToFirst()) {
                idUser = mCursor.getString(0);
                Toast.makeText(this, "Hola", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }



}