package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asoes.ui.CurrentUserInfo;

import java.sql.ResultSet;
import java.sql.Statement;

public class pantallaPrincipal extends AppCompatActivity {

    TextView nomInicio;
    ImageView profile, help, imgAlusiva1, questioMark;
    Button btnRecomen1, btnRecomen2, btnRecomen3, btnVerMisAs;
    private ImageView imageView;

    TextView a1,a2,a3,a4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);
        //

        a1 = (TextView) findViewById(R.id.lb1);
        a2 = (TextView) findViewById(R.id.lb2);
        a3 = (TextView) findViewById(R.id.lb3);
        a4 = (TextView) findViewById(R.id.lb4);

        imgAlusiva1 = (ImageView) findViewById(R.id.img1);
        questioMark = (ImageView) findViewById(R.id.questionErrorE);

        //
        imageView = (ImageView) findViewById(R.id.imageView10);
        help = (ImageView) findViewById(R.id.imageView9);
        profile = (ImageView) findViewById(R.id.imageView7);
        btnRecomen1 = (Button) findViewById(R.id.btnE1);
        //btnRecomen2 = (Button) findViewById(R.id.button2);
        nomInicio = (TextView) findViewById(R.id.textView69);
        btnVerMisAs = (Button) findViewById(R.id.button27);
        nomInicio = (TextView) findViewById(R.id.textView69);

        nomInicio.setText(CurrentUserInfo.Nombre + " " + CurrentUserInfo.ApellidoPaterno + " " + CurrentUserInfo.ApellidoMaterno);

        BuscarAsesoriasCurrentEstudiante();

        btnVerMisAs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarAsesorias();
            }
        });

//        btnRecomen3 = (Button)findViewById(R.id.button11);
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
//        btnRecomen2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                OpenAsesoriaRecomend();
//            }
//        });
//        btnRecomen3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                OpenAsesoriaRecomend();
//            }
//        });

        imageView.setOnClickListener(new View.OnClickListener() {
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

    public void OpenUserMenu() {
        Intent a = new Intent(this, UserMain.class);
        startActivity(a);
        finish();
    }

    public void OpenAsesoriaRecomend() {
        Intent a = new Intent(this, AsesoriaMain.class);
        startActivity(a);
        finish();
    }

    public void ayuda() {
        Intent a = new Intent(this, Soprte.class);
        startActivity(a);
        finish();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }


    void BuscarAsesoriasCurrentEstudiante() {

        try {
            questioMark.setVisibility(View.INVISIBLE);
            CONEXION conex1 = new CONEXION();
            Statement stm1 = conex1.conexion().createStatement();
            ResultSet rs1 = stm1.executeQuery("SELECT \n" +
                    "Titulo,\n" +
                    "asigna.Nombre,\n" +
                    "Fecha, \n" +
                    "CONVERT(VARCHAR(5),Hora,108) as Hora,\n" +
                    "Per.Nombre+' '+ApellidoPaterno+' '+ApellidoMaterno as NombreProfesor\n" +
                    "FROM \n" +
                    "ASOESAsesorias Ase ,\n" +
                    "ASOESAsesoriasInscritas Ins ,\n" +
                    "ASOESAlumnos Alu,\n" +
                    "ASOESUsuarios Us,\n" +
                    "ASOESPersonas Per,\n" +
                    "ASOESAsignaturas asigna\n" +
                    "where \n" +
                    "Us.idUsuario = Alu.idUsuario AND\n" +
                    "Alu.idAlumno = Ins.idAlumno \n" +
                    "AND Ins.idAsesoria = Ase.idAsesoria \n" +
                    "AND Ins.idAlumno = "+CurrentUserInfo.idEstudiante+"\n" +
                    "AND Per.idPersona = Us.idPersona\n" +
                    "AND asigna.idAsignatura = Ase.idAsignatura");

            if (rs1.next()) {

                String a = rs1.getString(1);//Titulo
                String b = rs1.getString(2);//NombreAsignatura
                String c = rs1.getString(3);//Fecha
                String d = rs1.getString(4);//Hora
                String e = rs1.getString(5);//NombreProfe
                String concat = c+" "+d;//FECHA + HORA

                imgAlusiva1.setVisibility(View.VISIBLE);
                btnRecomen1.setVisibility(View.VISIBLE);

                a4.setText(a);
                a1.setText(b);
                a2.setText(concat);
                a3.setText(e);

                a4.setVisibility(View.VISIBLE);
                a1.setVisibility(View.VISIBLE);
                a2.setVisibility(View.VISIBLE);
                a3.setVisibility(View.VISIBLE);


            } else {
                questioMark.setVisibility(View.VISIBLE);
                a4.setVisibility(View.INVISIBLE);
                a1.setVisibility(View.INVISIBLE);
                a2.setVisibility(View.INVISIBLE);
                a3.setVisibility(View.INVISIBLE);
                btnRecomen1.setVisibility(View.INVISIBLE);
                imgAlusiva1.setVisibility(View.INVISIBLE);
            }
        } catch (Exception e) {


        }

    }


    void verificarAsesorias() {
        try {

            CONEXION conex1 = new CONEXION();
            Statement stm1 = conex1.conexion().createStatement();
            ResultSet rs1 = stm1.executeQuery("SELECT * FROM ASOESAsesoriasInscritas where idAlumno = '" + CurrentUserInfo.idEstudiante + "'");

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


        }

    }
}