package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.asoes.ui.CurrentUserInfo;

import java.sql.ResultSet;
import java.sql.Statement;

public class registro extends AppCompatActivity {

    RadioButton rbProfesor,rbAlumno;
    Button btnSig;
    EditText txtRegUser,txtRegPass,txtRegPassConfirm,txtRegCorreo;
    CheckBox terminos;
    String idPersona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        rbProfesor = (RadioButton) findViewById(R.id.radioButton);
        rbAlumno = (RadioButton) findViewById(R.id.radioButton2);
        btnSig = (Button)findViewById(R.id.button3);
        txtRegUser=(EditText)findViewById(R.id.txtRegUser);
        txtRegPass=(EditText)findViewById(R.id.txtRegPass);
        txtRegPassConfirm=(EditText)findViewById(R.id.txtRegPassConf);
        //txtRegCorreo=(EditText)findViewById(R.id.txtRegCorreo);
        terminos=(CheckBox)findViewById(R.id.terminos);



        btnSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (rbProfesor.isChecked()) {
                        if (camposLlenos() && terminos()) {
                            if(RegistrarDocente()) {
                                getUserId();
                                OpenRegistroProfe();
                                finish();
                            }
                        }
                    } else if (rbAlumno.isChecked()) {
                        if (camposLlenos() && terminos()) {
                            if(RegistrarAlumno()) {
                                getUserId();
                                RegNormalFin();
                                finish();
                            }
                        }
                    } else {
                        //Seleccione algo.
                        seleccioneAlgo();
                    }

                    }catch(Exception e){

                    }
                }

        });

    }

    public void OpenRegistroProfe() {

        Intent a = new Intent(this, Registro3Profesores.class);
        startActivity(a);

    }
    public void RegNormalFin() {

        Intent a = new Intent(this, registroCompleto.class);
        startActivity(a);

    }
    public boolean camposLlenos(){

        if(TextUtils.isEmpty(txtRegUser.getText().toString())){
            Toast.makeText(this, "Llena el campo de 'Usuario' por favor", Toast.LENGTH_SHORT).show();
            return false;
        }else if(TextUtils.isEmpty(txtRegPass.getText().toString())){
            Toast.makeText(this, "Llena el campo de 'Contraseña' por favor", Toast.LENGTH_SHORT).show();
            return false;
        }else if(TextUtils.isEmpty(txtRegPassConfirm.getText().toString())){
            Toast.makeText(this, "Repite tu contraseña por favor.", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }
    void seleccioneAlgo(){
        Toast.makeText(this, "Selecciona si eres  docente.", Toast.LENGTH_SHORT).show();
    }
    public boolean terminos(){
        if(terminos.isChecked()){
            return true;
        }
        Toast.makeText(this, "Para continuar, debes aceptar nuestros terminos y condiciones.", Toast.LENGTH_SHORT).show();
        return false;
    }

    boolean RegistrarAlumno(){

        try{
        //INSERTA USUARIO
            CONEXION conex1 = new CONEXION();
            Statement stm1 = conex1.conexion().createStatement();
            ResultSet rs1 = stm1.executeQuery("SELECT idPersona FROM ASOESPersonas order by idPersona desc");

            if(rs1.next()) {
                CurrentUserInfo.idPersona = rs1.getString(1);
            }

            CONEXION conex = new CONEXION();
            Statement stm = conex.conexion().createStatement();
            ResultSet rs = stm.executeQuery("Insert into ASOESUsuarios values ('"+txtRegUser.getText().toString()+"','"+txtRegPass.getText().toString()+"','0','"+ CurrentUserInfo.idPersona +"')");


        }catch (Exception e){

        }
        //Obtenido idUser

        try{

            CONEXION conex1 = new CONEXION();
            Statement stm1 = conex1.conexion().createStatement();
            ResultSet rs1 = stm1.executeQuery("SELECT idUsuario FROM ASOESUsuarios order by idUsuario desc");

            if(rs1.next()) {
                CurrentUserInfo.idUser = rs1.getString(1);
            }

        }catch (Exception e ){

        }

        //INSERTA ALUMNO
        try{
            CONEXION conex = new CONEXION();
            Statement stm = conex.conexion().createStatement();
            ResultSet rs = stm.executeQuery("Insert into ASOESAlumnos values ("+CurrentUserInfo.idUser+")");

        }catch (Exception e ){

        }
        return  true;
    }

    boolean RegistrarDocente(){

        try{

            CONEXION conex1 = new CONEXION();
            Statement stm1 = conex1.conexion().createStatement();
            ResultSet rs1 = stm1.executeQuery("SELECT idPersona FROM ASOESPersonas order by idPersona desc");

            if(rs1.next()) {
                idPersona = rs1.getString(1);
            }

            CONEXION conex = new CONEXION();
            Statement stm = conex.conexion().createStatement();
            stm.executeQuery("Insert into ASOESUsuarios values ('"+txtRegUser.getText().toString()+"','"+txtRegPass.getText().toString()+"','1','"+idPersona+"')");


        }catch (Exception e){

        }
        return true;



    }

    void getUserId(){
        try {
            CONEXION conex1 = new CONEXION();
            Statement stm1 = conex1.conexion().createStatement();
            ResultSet rs1 = stm1.executeQuery("SELECT idUsuario FROM ASOESUsuarios order by idUsuario desc");


            if (rs1.next()) {
                String f = rs1.getString(1);
                CurrentUserInfo.idUser =f;
            }
        }catch (Exception e){
        String a = "a";
        }
    }

}