package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class pantallaPrincipal extends AppCompatActivity {

    ImageView profile, help;
    Button btnRecomen1,btnRecomen2,btnRecomen3;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        imageView = (ImageView) findViewById(R.id.imageView10);
        help =(ImageView)findViewById(R.id.imageView9);
        profile = (ImageView)findViewById(R.id.imageView7);
        btnRecomen1 = (Button)findViewById(R.id.button);
        btnRecomen2 = (Button)findViewById(R.id.button2);
        btnRecomen3 = (Button)findViewById(R.id.button11);
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
        btnRecomen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenAsesoriaRecomend();
            }
        });

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
    }

    public void OpenAsesoriaRecomend(){
        Intent a = new Intent(this,AsesoriaMain.class);
        startActivity(a);
    }
    public void ayuda(){
        Intent a = new Intent(this,Soprte.class);
        startActivity(a);
    }

    }