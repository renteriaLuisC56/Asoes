package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class pantallaPrincipal extends AppCompatActivity {

    ImageView profile;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        imageView = (ImageView) findViewById(R.id.imageView10);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Solicitud();
            }
        });

    }

    public void Solicitud() { //Sirve para cambiar a la pantalla de la asesoria especifica

        Intent intent = new Intent(this, MainActivity_Solicitud.class);
        startActivity(intent);
        finish();


        profile = (ImageView)findViewById(R.id.imageView7);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenUserMenu();
            }
        });



    }
    public void OpenUserMenu() {
        Intent a = new Intent(this, UserMain.class);
        startActivity(a);
    }

    }