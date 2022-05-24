package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MisAsesorias extends AppCompatActivity {

    Button a ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_asesorias);
        a = (Button)findViewById(R.id.button18);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMisCursos();
            }
        });
    }
    void OpenMisCursos(){
        Intent a = new Intent(this,MisAsesorias.class);
        startActivity(a);
    }
}