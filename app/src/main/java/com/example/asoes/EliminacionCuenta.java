package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.asoes.ui.CurrentUserInfo;

import java.sql.ResultSet;
import java.sql.Statement;

public class EliminacionCuenta extends AppCompatActivity {


    Button eliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminacion_cuenta);
    eliminar=(Button)findViewById(R.id.button20);
    eliminar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(CurrentUserInfo.typeUser.equalsIgnoreCase("Docente")) {

                ElimiarCuentaDocente();
            }else{
                ElimiarCuentaEstudiante();
            }

            irInicio();
            finish();
        }
    });

    }


 Boolean ElimiarCuentaDocente(){

        try {

                CONEXION conex1 = new CONEXION();
                Statement stm1 = conex1.conexion().createStatement();
                try {
                    stm1.executeQuery("DELETE FROM ASOESDocentes where idUsuario = '" + CurrentUserInfo.idUser + "'");
                 }catch (Exception e){

                }


                try{
                stm1.executeQuery("DELETE FROM ASOESUsuarios where idUsuario = '"+CurrentUserInfo.idUser+"'");
                }catch (Exception e){

                }


                try{
                    stm1.executeQuery("DELETE FROM ASOESPersonas where idPersona = '"+CurrentUserInfo.idPersona+"'");
                }catch (Exception e){

                }




        }catch(Exception e){


        }

        return true;
 }


    Boolean ElimiarCuentaEstudiante(){

        try {

            CONEXION conex1 = new CONEXION();
            Statement stm1 = conex1.conexion().createStatement();
            try {
                stm1.executeQuery("DELETE FROM ASOESUsuarios where idUsuario = '" + CurrentUserInfo.idUser + "'");
            }catch (Exception e){

            }
            try {
            stm1.executeQuery("DELETE FROM ASOESPersonas where idPersona = '"+CurrentUserInfo.idPersona+"'");

        }catch (Exception e){

        }

        }catch(Exception e){


        }

        return true;
    }

 void irInicio(){

        Intent a = new Intent(this,Login.class);
        startActivity(a);
 }

}