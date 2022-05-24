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

public class Login extends AppCompatActivity {
    TextView txtReg,txtContra;
    Button btnEntrar;
    EditText txtUser,txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtReg = (TextView)findViewById(R.id.lblRegistro);
        txtContra = (TextView)findViewById(R.id.lblContraseña);
        txtUser=(EditText)findViewById(R.id.txtUser);
        txtPass=(EditText)findViewById(R.id.txtPass);

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
                if(camposLlenos()) {
                    openMain();
                }
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
    public boolean camposLlenos(){

        if(TextUtils.isEmpty(txtUser.getText().toString())){
            Toast.makeText(this, "Llena el campo de 'Usuario' por favor", Toast.LENGTH_SHORT).show();
            return false;
        }else if(TextUtils.isEmpty(txtPass.getText().toString())){
            Toast.makeText(this, "Llena el campo de 'Contraseña' por favor", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }


}