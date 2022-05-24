package com.example.asoes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6_AppPago extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity6_app_pago);
    }

    public void Regresar(View view) {

        Intent intent = new Intent(this, MainActivity4_seleccionP.class);
        startActivity(intent);
        finish();

    }
}