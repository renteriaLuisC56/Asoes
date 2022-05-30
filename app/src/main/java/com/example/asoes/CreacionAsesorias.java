package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreacionAsesorias extends AppCompatActivity {


    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion_asesorias);

        next = (Button)findViewById(R.id.button22);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CracionExitosa();
            }
        });
    }
    void CracionExitosa(){
        Intent a = new Intent(this,AsesoriaCreadaConExito.class);
        startActivity(a);
        finish();
    }

}