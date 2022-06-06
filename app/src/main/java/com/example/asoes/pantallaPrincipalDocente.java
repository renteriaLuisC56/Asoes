package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asoes.ui.CurrentUserInfo;

import java.sql.ResultSet;
import java.sql.Statement;

public class pantallaPrincipalDocente extends AppCompatActivity {

    ImageView profile, help, busqueda, questioMark, imgAlusiva1,imgAlusiva2;
    Button btnRecomen1,btnRecomen2,verMisAsesorias,btnMenu1,btnMenu2;
    TextView nomInicio;


    TextView e0,e1,e2,e3,e4,e5,e6,e7,e8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal_docente);
        //
        e0=(TextView)findViewById(R.id.lblM1);//TITULO
        e1=(TextView)findViewById(R.id.lblM2);//ASIGNATURA
        e2=(TextView)findViewById(R.id.lblM3);// FECHA
        e3=(TextView)findViewById(R.id.lblM4); // HORA


        e4=(TextView)findViewById(R.id.lblN1);
        e5=(TextView)findViewById(R.id.lblN2);
        e6=(TextView)findViewById(R.id.lblN3);
        e7=(TextView)findViewById(R.id.lblN4);

        //

        questioMark = (ImageView)findViewById(R.id.greyQuestion);
        imgAlusiva1 = (ImageView)findViewById(R.id.imgMain1);
        imgAlusiva2 = (ImageView)findViewById(R.id.imgMain2);
        //


        //

        busqueda = (ImageView) findViewById(R.id.imageView33);
        help =(ImageView)findViewById(R.id.imageView32);
        profile = (ImageView)findViewById(R.id.imageView30);
        btnRecomen1 = (Button)findViewById(R.id.tbnVer1);
        btnRecomen2 = (Button)findViewById(R.id.btnVer2);

        verMisAsesorias = (Button)findViewById(R.id.button25);
        nomInicio = (TextView) findViewById(R.id.textView43);

        nomInicio.setText(CurrentUserInfo.Nombre+" "+CurrentUserInfo.ApellidoPaterno+" "+CurrentUserInfo.ApellidoMaterno);

        BuscarAsesoriasCurrentDocente();


        verMisAsesorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarAsesorias();

            }
        });


        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ayuda();
            }
        });

        btnRecomen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenAsesoriaRecomend();
            }
        });
        btnRecomen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenAsesoriaRecomend();
            }
        });
//        btnRecomen3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                OpenAsesoriaRecomend();
//            }
//        });

        busqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Solicitud();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenUserMenu();
            }
        });
    }

    public void Solicitud() { //Sirve para cambiar a la pantalla de la asesoria especifica

        Intent intent = new Intent(this, MainActivity_Solicitud.class);
        startActivity(intent);
        finish();

    }

    void verificarAsesorias(){
        try{

            CONEXION conex1 = new CONEXION();
            Statement stm1 = conex1.conexion().createStatement();
            ResultSet rs1 = stm1.executeQuery("SELECT * FROM ASOESAsesorias where idDocente = '"+ CurrentUserInfo.idDocente +"'");

            if (rs1.next()){
                //Existen asesorias
                Intent a = new Intent(this, MisAsesorias.class);
                startActivity(a);
                finish();

            }else{
                //No existen asesorias
                Intent a = new Intent(this, MisAsesoriasVacio.class);
                startActivity(a);
                finish();
            }
        }catch (Exception e){


        }


    }
    public void OpenUserMenu() {
        Intent a = new Intent(this, UserMain.class);
        startActivity(a);

    }

    public void OpenAsesoriaRecomend(){
        Intent a = new Intent(this,AsesoriaMain.class);
        startActivity(a);
        finish();
    }
    public void ayuda(){
        Intent a = new Intent(this,Soprte.class);
        startActivity(a);
        finish();
    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    void BuscarAsesoriasCurrentDocente(){

        try{
            questioMark.setVisibility(View.INVISIBLE);
            CONEXION conex1 = new CONEXION();
            Statement stm1 = conex1.conexion().createStatement();
            ResultSet rs1 = stm1.executeQuery("SELECT idAsesoria,Titulo,Fecha,CONVERT(VARCHAR(5),Hora,108)  as Hora,Link,Nombre FROM ASOESAsesorias Ase ,ASOESAsignaturas Asi where idDocente = '"+CurrentUserInfo.idDocente+"' and Asi.idAsignatura = Ase.idAsignatura");

            if (rs1.next()){

                String a = rs1.getString(2);
                String b = rs1.getString(6);
                String c = rs1.getString(3);
                String d = rs1.getString(4);


                imgAlusiva1.setVisibility(View.VISIBLE);
                btnRecomen1.setVisibility(View.VISIBLE);

                e0.setText(a);
                e1.setText(b);
                e2.setText(c);
                e3.setText(d);

                e0.setVisibility(View.VISIBLE);
                e1.setVisibility(View.VISIBLE);
                e2.setVisibility(View.VISIBLE);
                e3.setVisibility(View.VISIBLE);


            }else{
                questioMark.setVisibility(View.VISIBLE);
                e0.setVisibility(View.INVISIBLE);
                e1.setVisibility(View.INVISIBLE);
                e2.setVisibility(View.INVISIBLE);
                e3.setVisibility(View.INVISIBLE);
                btnRecomen1.setVisibility(View.INVISIBLE);
                imgAlusiva1.setVisibility(View.INVISIBLE);
            }
        }catch (Exception e){


        }

    }

}