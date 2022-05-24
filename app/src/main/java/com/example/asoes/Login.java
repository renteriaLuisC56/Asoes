package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class Login extends AppCompatActivity {
    TextView txtReg,txtContra;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtReg = (TextView)findViewById(R.id.lblRegistro);
        txtContra = (TextView)findViewById(R.id.lblContraseña);
        //Event registry
        txtReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegister();
            }
        });
        //Event main
        btnEntrar = (Button)findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMain();
            }
        });
        //Event Password
        txtContra =(TextView)findViewById(R.id.lblContraseña);
        txtContra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRecuperaPass();
            }
        });

    }
    public void openRegister(){

    Intent a = new Intent(this,registro2.class);
    startActivity(a);
    }
    public void openMain(){

         Intent a = new Intent(this,pantallaPrincipal.class);
         startActivity(a);
    }
    public void openRecuperaPass(){

        Intent a = new Intent(this,recuperaPassword.class);
        startActivity(a);
    }


}