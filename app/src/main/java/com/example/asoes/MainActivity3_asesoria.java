package com.example.asoes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3_asesoria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_asesoria);

    }

    public void Regresar(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    public void Inscribirse(View view) {

        Intent intent = new Intent(this, MainActivity4_seleccionP.class);
        startActivity(intent);
        finish();

    }
}