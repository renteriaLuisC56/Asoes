package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.asoes.ui.CurrentUserInfo;

import java.sql.ResultSet;
import java.sql.Statement;

public class EditUserInfo extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5;
    Button btnEdit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_info);

        btnEdit=(Button)findViewById(R.id.btnDoEdit);
        e1=(EditText) findViewById(R.id.editName);
        e2=(EditText) findViewById(R.id.edit2);
        e3=(EditText) findViewById(R.id.edit3);
        e4=(EditText) findViewById(R.id.edit4);
        e5=(EditText) findViewById(R.id.edit5);
        setText();


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doEdit();

                goInit();
            }
        });
    }


void setText(){
try {
    e1.setText(CurrentUserInfo.Nombre);
    e2.setText(CurrentUserInfo.ApellidoPaterno);
    e3.setText(CurrentUserInfo.ApellidoMaterno);
    e4.setText(CurrentUserInfo.CorreoElectronico);
    e5.setText(CurrentUserInfo.FechaNacimiento);
}catch(Exception e ){

    String a = "a";
}

}

void doEdit(){
        String nom,apepa,apema,corr,fechana;

        nom = e1.getText().toString();
        apepa = e2.getText().toString();
        apema = e3.getText().toString();
        corr = e4.getText().toString();
        fechana = e5.getText().toString();


        try{
            CONEXION conex1 = new CONEXION();
            Statement stm1 = conex1.conexion().createStatement();
            stm1.executeQuery("UPDATE ASOESPersonas\n" +
                    "SET Nombre = '"+nom+"', ApellidoPaterno = '"+apepa+"', ApellidoMaterno = '"+apema+"', CorreoElectronico = '"+corr+"',FechaNacimiento='"+fechana+"'\n" +
                    "WHERE idPersona = "+CurrentUserInfo.idPersona+";");

        }catch(Exception e){


        }


}

void goInit(){

        Intent a = new Intent(this,Login.class);
        startActivity(a);
        finish();

}






}