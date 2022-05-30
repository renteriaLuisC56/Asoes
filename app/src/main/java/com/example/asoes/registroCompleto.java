package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.asoes.ui.CurrentUserInfo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

public class registroCompleto extends AppCompatActivity {

    Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_completo);
        entrar = (Button) findViewById(R.id.button5);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDatosGeneralesUsuario();
                entrar();
            }
        });
    }

    void entrar() {
        Intent a = new Intent(this, pantallaPrincipal.class);
        startActivity(a);
    }

    void getDatosGeneralesUsuario() {
        try {
            CONEXION conex1 = new CONEXION();
            Statement stm1 = conex1.conexion().createStatement();
            ResultSet rs1 = stm1.executeQuery("SELECT ASOESUsuarios.idPersona, Nombre,ApellidoPaterno,ApellidoMaterno,CorreoElectronico,FechaNacimiento,Usuario,esDocente,Contraseña FROM ASOESPersonas , ASOESUsuarios where ASOESPersonas.idPersona = ASOESUsuarios.idPersona AND idUsuario = '" + CurrentUserInfo.idUser + "' ");
            if (rs1.next()) {
                CurrentUserInfo.idPersona = rs1.getString(1);
                CurrentUserInfo.Nombre = rs1.getString(2);
                CurrentUserInfo.ApellidoPaterno = rs1.getString(3);
                CurrentUserInfo.ApellidoMaterno = rs1.getString(4);
                CurrentUserInfo.CorreoElectronico = rs1.getString(5);
                CurrentUserInfo.FechaNacimiento = rs1.getString(6);
                CurrentUserInfo.Usuario = rs1.getString(7);
                CurrentUserInfo.esDocente = rs1.getString(8);
                CurrentUserInfo.Contraseña = rs1.getString(9);

            }

        } catch (Exception e) {

        }


        try{
            CONEXION conex1 = new CONEXION();
            Statement stm1 = conex1.conexion().createStatement();
            ResultSet rs1 = stm1.executeQuery("SELECT idAlumno FROM ASOESAlumnos order by idAlumno desc");
            if(rs1.next()) {
                CurrentUserInfo.idEstudiante = rs1.getString(1);
            }

        }catch (Exception e ){


        }



    }
}