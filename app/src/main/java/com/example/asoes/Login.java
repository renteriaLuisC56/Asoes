package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.asoes.ui.CurrentUserInfo;

import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends AppCompatActivity {
    TextView txtReg, txtContra;
    Button btnEntrar, test;
    EditText txtUser, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtReg = (TextView) findViewById(R.id.lblRegistro);
        txtContra = (TextView) findViewById(R.id.lblContraseña);
        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPass = (EditText) findViewById(R.id.txtPass);
        test = (Button) findViewById(R.id.button19);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MostrarTest();
            }
        });

        //Event registry
        txtReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegister();
            }
        });
        //Event main
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (camposLlenos()) {
                        if (VerificarUser()) {
                            getDatosGeneralesUsuario();
                            getDatosId();
                            if (CurrentUserInfo.typeUser.equalsIgnoreCase("Docente")) {
                                openMainDocente();
                            } else {
                                openMain();
                            }
                        } else {
                            error();
                        }

                    }
                }catch (Exception e) {
                    String a = "a";
                }
                }

        });
        //Event Password
        txtContra = (TextView) findViewById(R.id.lblContraseña);
        txtContra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRecuperaPass();
            }
        });

    }

    public void openRegister() {

        Intent a = new Intent(this, registro2.class);
        startActivity(a);
        finish();
    }

    public void openMain() {

        Intent a = new Intent(this, pantallaPrincipal.class);
        startActivity(a);
        finish();

    }

    public void openMainDocente() {
        Intent a = new Intent(this, pantallaPrincipalDocente.class);
        startActivity(a);
        finish();

    }

    public void openRecuperaPass() {

        Intent a = new Intent(this, recuperaPassword.class);
        startActivity(a);
        finish();
    }

    public boolean camposLlenos() {

        if (TextUtils.isEmpty(txtUser.getText().toString())) {
            Toast.makeText(this, "Llena el campo de 'Usuario' por favor", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(txtPass.getText().toString())) {
            Toast.makeText(this, "Llena el campo de 'Contraseña' por favor", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    boolean VerificarUser() {
        try {
            CONEXION conex1 = new CONEXION();
            Statement stm1 = conex1.conexion().createStatement();
            ResultSet rs1 = stm1.executeQuery("SELECT * FROM ASOESUsuarios WHERE Usuario LIKE '" + txtUser.getText().toString() + "' and Contraseña LIKE '" + txtPass.getText().toString() + "'");

            if (rs1.next()) {
                String f = rs1.getString(1);  //AQUI ATRAPAMOS EL ID DEL USUARIO
                CurrentUserInfo.idUser = f;

                if (rs1.getString(4).equalsIgnoreCase("1")) {
                    CurrentUserInfo.typeUser = "Docente";
                } else {
                    CurrentUserInfo.typeUser = "Estudiante";
                }

                return true;
            } else {

                return false;
            }
        } catch (Exception e) {
            String a = "a";
        }
        return false;
    }

    void MostrarTest() {
        Intent a = new Intent(this, Consulta.class);
        startActivity(a);
    }

    void error() {
        Toast.makeText(this, "Usuario y/o Contraseña Incorrecta.", Toast.LENGTH_SHORT).show();
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

    }
    void getDatosId(){
        try {
            if(CurrentUserInfo.esDocente.equalsIgnoreCase("1")) {
                CONEXION conex1 = new CONEXION();
                Statement stm1 = conex1.conexion().createStatement();
                ResultSet rs1 = stm1.executeQuery("SELECT idDocente FROM ASOESDocentes where idUsuario = '" + CurrentUserInfo.idUser + "'");
                if (rs1.next()) {
                    CurrentUserInfo.idDocente = rs1.getString(1);
                }
            }else{

                CONEXION conex1 = new CONEXION();
                Statement stm1 = conex1.conexion().createStatement();
                ResultSet rs1 = stm1.executeQuery("SELECT idAlumno FROM ASOESAlumnos where idUsuario = '" + CurrentUserInfo.idUser + "'");
                if (rs1.next()) {
                    CurrentUserInfo.idEstudiante = rs1.getString(1);
                }
            }
        }

        catch (Exception e){


        }

    }

}