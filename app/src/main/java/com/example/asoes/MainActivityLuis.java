package com.example.asoes;


import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityLuis extends AppCompatActivity {

    private EditText txt_codigo,txt_Asesoria,txt_Docente,txt_Horario,txt_Link,txt_link2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_luis);

        txt_codigo=(EditText) findViewById(R.id.txt_Codigo);
        txt_Asesoria=(EditText) findViewById(R.id.txt_Asesoria);
        txt_Docente=(EditText) findViewById(R.id.txt_Docente);
        txt_Horario=(EditText) findViewById(R.id.txt_Horario);
        txt_Link=(EditText) findViewById(R.id.txt_Link);
        txt_link2=(EditText) findViewById(R.id.txt_link2);


    }


    public void Registrar(View view){
        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"Asoes",null,2);
        SQLiteDatabase BaseDeDatos =admin.getWritableDatabase();

        String codigo=txt_codigo.getText().toString();
        String asesoria=txt_Asesoria.getText().toString();
        String docente=txt_Docente.getText().toString();
        String horario=txt_Horario.getText().toString();
        String link=txt_Link.getText().toString();
        String rec=txt_link2.getText().toString();

        if(!codigo.isEmpty() && !asesoria.isEmpty() && !docente.isEmpty() && !horario.isEmpty() && !link.isEmpty() && !rec.isEmpty()){
            ContentValues registro=new ContentValues();

            registro.put("Id_Asesoria",codigo);
            registro.put("Asignatura",asesoria);
            registro.put("Docente",docente);
            registro.put("Horario",horario);
            registro.put("Link",link);
            registro.put("recurso",rec);

            BaseDeDatos.insert("asesoria",null,registro);

            BaseDeDatos.close();
            txt_codigo.setText("");
            txt_Asesoria.setText("");
            txt_Docente.setText("");
            txt_Horario.setText("");
            txt_Link.setText("");
            txt_link2.setText("");

            Toast.makeText(this,"Registro existoso",Toast.LENGTH_SHORT).show();


        }else{
            Toast.makeText(this,"Se deben llenar todos los campos",Toast.LENGTH_SHORT).show();
        }

    }



    public void Consultar(View view){
        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"Asoes",null,2);
        SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();

        String codigo=txt_codigo.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila = BaseDeDatos.rawQuery
                    ("select Id_Asesoria, Docente, Horario, Link, Asignatura,Recurso from asesoria where Id_Asesoria ="+codigo,null);

            if(fila.moveToFirst()){

                txt_codigo.setText(fila.getString(0));//Id_Asesoria
                txt_Docente.setText(fila.getString(1));
                txt_Horario.setText(fila.getString(2));
                txt_Link.setText(fila.getString(3));
                txt_Asesoria.setText(fila.getString(4));
                txt_link2.setText(fila.getString(5)); //recurso
                BaseDeDatos.close();

            }else{
                Toast.makeText(this,"Se debe introducir el codigo",Toast.LENGTH_SHORT).show();
            }
        }

    }


    public void bajas(View view) {

        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"Asoes",null,2);
        SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();

        String codigo=txt_codigo.getText().toString();

        if(!codigo.isEmpty()) {

            int cantidad=BaseDeDatos.delete("asesoria","Id_Asesoria="+codigo,null);
            BaseDeDatos.close();

            txt_codigo.setText("");
            txt_Asesoria.setText("");
            txt_Docente.setText("");
            txt_Horario.setText("");
            txt_Link.setText("");
            txt_link2.setText("");

            if(cantidad==1) {
                Toast.makeText(this,"Asesoria dada de baja exitosamente",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"No existe esa asesoria",Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this,"Se debe introducir el codigo",Toast.LENGTH_SHORT).show();
        }
    }



    public void modificar(View view){
        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"Asoes",null,2);
        SQLiteDatabase BaseDeDatos=admin.getWritableDatabase();

        String codigo=txt_codigo.getText().toString();
        String asesoria=txt_Asesoria.getText().toString();
        String docente=txt_Docente.getText().toString();
        String horario=txt_Horario.getText().toString();
        String link=txt_Link.getText().toString();
        String rec=txt_link2.getText().toString();


        if(!codigo.isEmpty() && !asesoria.isEmpty() && !docente.isEmpty() && !horario.isEmpty() && !link.isEmpty() && !rec.isEmpty()) {

            ContentValues registro=new ContentValues();

            registro.put("Id_Asesoria",codigo);
            registro.put("Asignatura",asesoria);
            registro.put("Docente",docente);
            registro.put("Horario",horario);
            registro.put("Link",link);
            registro.put("Recurso",rec);


            int cantidad=BaseDeDatos.update("asesoria", registro,"Id_Asesoria="+codigo,null);

            BaseDeDatos.close();

            if(cantidad==1){
                Toast.makeText(this,"Asesoria modificada correctamente",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"No existe esa asesoria",Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(this,"No existe esa asesoria",Toast.LENGTH_SHORT).show();
        }

    }
}