package com.example.asoes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table asesoria(Id_Asesoria int primary key,Docente text, Horario text, Link text,Asignatura text,Recurso text)");
        BaseDeDatos.execSQL("create table personas(Id_persona int primary key autoincrement,Nombres text, ApePat text, ApeMat text,CorreoE text)");
        BaseDeDatos.execSQL("create table usuariosAlumnos(Id_usuarioAlumno int primary key autoincrement,Usuario text, Contraseña text)");
        BaseDeDatos.execSQL("create table usuariosProfesores(Id_usuarioAlumno int primary key autoincrement,Usuario text, Contraseña text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase BaseDeDatos, int i, int i1) {
        BaseDeDatos.execSQL("DROP TABLE IF EXISTS asesoria");
        onCreate(BaseDeDatos);

    }
}