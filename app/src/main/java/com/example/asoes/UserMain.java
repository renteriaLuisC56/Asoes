package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class UserMain extends AppCompatActivity {


    Button btn,btn1,cerrar;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        btn = (Button)findViewById(R.id.button13);
        btn1 = (Button)findViewById(R.id.button12);
        img = (ImageView)findViewById(R.id.imageView12);
        cerrar = (Button)findViewById(R.id.cerrar);

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLogin();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreAsesorias();
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
    }


}
