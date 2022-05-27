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
import android.widget.TextView;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.Statement;

public class Consulta extends AppCompatActivity {


    TextView tVDatos;
    Button button;

    AdminSQLiteOpenHelper admin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        tVDatos =(TextView)findViewById(R.id.tvD);
        button=(Button) findViewById(R.id.button11);

        //Acción del botón
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

consultarLista();

            }
        });

    }


    public void consultarLista() {
        try{
            CONEXION conex = new CONEXION();
            Statement stm = conex.conexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM ASOESPERSONAS");

            if(rs.next()){
                tVDatos.setText("Asesoría: "+rs.getString(2)+"\n"+"Instructor: "+rs.getString(3)+"\n"+"Horario: "+rs.getString(4)+"\n"+"Enlace de sesión: "+rs.getString(5)+"\n"+"Recursos didácticos: "+rs.getString(6));
                tVDatos.setText("------------------------------------------------------------");
         //       tVDatos.setText(rs.getString(3));
         //       tVDatos.setText(rs.getString(4));
         //       tVDatos.setText(rs.getString(5));
         //       tVDatos.setText(rs.getString(6));
            }


        }catch (Exception e){
            Toast.makeText(this, "Error viejo", Toast.LENGTH_SHORT).show();
        }
    }
}