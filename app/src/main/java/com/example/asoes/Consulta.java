package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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



            }
        });

    }










    private void consultarLista() {
        admin = new AdminSQLiteOpenHelper(this, "Asoes", null, 2);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();


        Cursor cursor = BaseDeDatos.rawQuery
                ("select Id_Asesoria, Docente, Horario, Link, Asignatura, Recurso from asesoria", null);

        //   if(cursor.moveToFirst()){

        tVDatos.setText(cursor.getInt(0) +"\n" + cursor.getString(1) +"\n" + cursor.getString(2) +"\n"+ cursor.getString(3) +"\n"+ cursor.getString(4) +"\n"+ cursor.getString(5));


        BaseDeDatos.close();

        //   }
    }
}