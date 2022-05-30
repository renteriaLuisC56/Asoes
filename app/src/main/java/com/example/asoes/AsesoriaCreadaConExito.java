package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AsesoriaCreadaConExito extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asesoria_creada_con_exito);

        btn = (Button)findViewById(R.id.button23);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goMisCursos();

            }
        });
    }
    void goMisCursos(){
        Intent a = new Intent(this,MisAsesorias.class);
        startActivity(a);
        finish();
    }

}