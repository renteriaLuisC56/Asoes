package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity_TarjetaP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tarjeta_p);
    }

    public void Regresar(View view) {

        Intent intent = new Intent(this, MainActivity_SeleccionP.class);
        startActivity(intent);
        finish();

    }
}