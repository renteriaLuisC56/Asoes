package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asoes.ui.CurrentUserInfo;

import java.sql.ResultSet;
import java.sql.Statement;

public class UserMain extends AppCompatActivity {

//textView65 69
    Button btn,btn1,cerrar,del;
    ImageView img;
    TextView Nombre,Apellidos,Correo,FechaNacimiento,Usuario,TipoUser;

    String apePat, ApeMat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);



        btn = (Button)findViewById(R.id.button13);
        btn1 = (Button)findViewById(R.id.button12);
        img = (ImageView)findViewById(R.id.imageView12);
        cerrar = (Button)findViewById(R.id.cerrar);
        del= (Button)findViewById(R.id.deleteAccount);
        del.setBackgroundColor(Color.RED);


        Nombre = (TextView)findViewById(R.id.tvNom);
        Correo = (TextView)findViewById(R.id.tvCorreo);
        FechaNacimiento = (TextView)findViewById(R.id.tvFN);
        Usuario = (TextView)findViewById(R.id.tvUser);
        TipoUser = (TextView)findViewById(R.id.tvAccount);


        CargarInfo();

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminacionCuenta();

            }
        });
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLogin();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    verificarAsesorias();
                   // abreAsesorias();

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiaPass();
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreSoporte();
            }
        });


        }
    void cambiaPass() {
        Intent a = new Intent(this,cambiarPassword.class);
        startActivity(a);

    }

    void abreAsesorias(){
        Intent a = new Intent(this,MisAsesorias.class);
        startActivity(a);
    }

    void abreSoporte(){
        Intent a = new Intent(this,Soprte.class);
        startActivity(a);
    }
    void goLogin(){
        Intent a = new Intent(this,Login.class);
        startActivity(a);
        finish();
    }

    void CargarInfo(){
                Nombre.setText(CurrentUserInfo.Nombre+" "+CurrentUserInfo.ApellidoPaterno+" "+CurrentUserInfo.ApellidoMaterno);
                Correo.setText(CurrentUserInfo.CorreoElectronico);
                FechaNacimiento.setText(CurrentUserInfo.FechaNacimiento);
                Usuario.setText(CurrentUserInfo.Usuario);
                TipoUser.setText(CurrentUserInfo.typeUser);
    }

    void eliminacionCuenta(){

        Intent a = new Intent(this,EliminacionCuenta.class);
        startActivity(a);

    }

    void verificarAsesorias(){
        if(CurrentUserInfo.esDocente.equalsIgnoreCase("1")) {
            try {
                CONEXION conex1 = new CONEXION();
                Statement stm1 = conex1.conexion().createStatement();
                ResultSet rs1 = stm1.executeQuery("SELECT * FROM ASOESAsesorias where idDocente = '" + CurrentUserInfo.idDocente + "'");

                if (rs1.next()) {
                    //Existen asesorias
                    Intent a = new Intent(this, MisAsesorias.class);
                    startActivity(a);
                    finish();

                } else {
                    //No existen asesorias
                    Intent a = new Intent(this, MisAsesoriasVacio.class);
                    startActivity(a);
                    finish();
                }
            } catch (Exception e) {


            }

        }else{
            try {
                CONEXION conex1 = new CONEXION();
                Statement stm1 = conex1.conexion().createStatement();
                ResultSet rs1 = stm1.executeQuery("SELECT * FROM ASOESAsesoriasInscritas where IdAlumno = '" + CurrentUserInfo.idEstudiante + "'");

                if (rs1.next()) {
                    //Existen asesorias
                    Intent a = new Intent(this, MisAsesorias.class);
                    startActivity(a);
                    finish();

                } else {
                    //No existen asesorias
                    Intent a = new Intent(this, MisAsesoriasVacioEstudiante.class);
                    startActivity(a);
                    finish();
                }
            } catch (Exception e) {

            String A = "A";
            }
        }



    }


}
