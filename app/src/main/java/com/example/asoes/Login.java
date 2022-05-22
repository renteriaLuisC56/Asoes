package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class Login extends AppCompatActivity {
    TextView txtReg;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtReg = (TextView)findViewById(R.id.lblRegistro);
        txtReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegister();
            }
        });

        btnEntrar = (Button)findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMain();
            }
        });


    }
    public void openRegister(){

    Intent a = new Intent(this,registro2.class);
    startActivity(a);
    }
    public void openMain(){

        Intent a = new Intent(this,MainActivity.class);
        startActivity(a);
    }


}