package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class registro2 extends AppCompatActivity {

    Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro2);

        btnSiguiente = (Button) findViewById(R.id.btnSigReg2);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    OpenRegistroUser();
            }
        });

    }

    public void OpenRegistroUser() {

        Intent a = new Intent(this, registro.class);
        startActivity(a);
    }


}