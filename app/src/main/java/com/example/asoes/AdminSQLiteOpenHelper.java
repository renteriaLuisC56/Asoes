package com.example.asoes;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table asesoria(Id_Asesoria int primary key,Docente text, Horario text, Link text,Asignatura text,Recurso text)");
        BaseDeDatos.execSQL("create table personas(Id_persona INTEGER PRIMARY KEY AUTOINCREMENT,Nombres text, ApePat text, ApeMat text,FechaN text,CorreoE text)");
        BaseDeDatos.execSQL("create table usuariosAlumnos(Usuario primary key, Contraseña text)");
        BaseDeDatos.execSQL("create table usuariosProfesores(Usuario primary key, Contraseña text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase BaseDeDatos, int i, int i1) {
        BaseDeDatos.execSQL("DROP TABLE IF EXISTS asesoria");
        BaseDeDatos.execSQL("DROP TABLE IF EXISTS personas");
        BaseDeDatos.execSQL("DROP TABLE IF EXISTS usuariosAlumnos");
        BaseDeDatos.execSQL("DROP TABLE IF EXISTS usuariosProfesores");
        onCreate(BaseDeDatos);

    }

    public long personasIdNuevo(String nom, String apepat, String apemat) {
        //--------< add_Note() >--------
        //*add a recordset to the tbl_Notes Table
        //< getDB >
        SQLiteDatabase db = this.getWritableDatabase();
        //</ getDB >

        //< set_Values >
        //SimpleDateFormat fmtDate = new SimpleDateFormat("YYYYMMdd");
        //String sDate_Note = fmtDate.format(dtNoteDay);
        //String sDate_Now = fmtDate.format(new Date());

        ContentValues values = new ContentValues();
        values.put("Nombres", nom);
        values.put("ApePat", apepat);
        values.put("ApeMat", apemat);
        //values.put("dtEdit", sDate_Now);
        //</ set_Values >

        //< add >
        long newID = db.insert("personas", null, values);
        //</ add >

        //< out >
        if (newID == -1)
        {
            //*SQLite Error on Insert: -1
            return -1;
        }
        else
        {
            //*return value is new ID
            return newID;
        }
        //</ out >
        //--------</ add_Note() >--------
    }

}