package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity_Asesoria extends AppCompatActivity {

    String materiaA = "";
    private ListView lv;
    private Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_asesoria);

        lv = (ListView)findViewById(R.id.lv_AsesoriasD);
        spin = (Spinner)findViewById(R.id.spHorarios2);

        String horarios [] = {"7:00","8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00"};

        ArrayAdapter<String> adapterSp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, horarios);
        spin.setAdapter(adapterSp);

        materiaA = getIntent().getStringExtra("dato");

        String asesorias [] = {materiaA+"\nASESOR: JOSE ANTONIO\nID: 123456", materiaA+"\nASESOR: BRENDA AVITIA\nID: 456789",
                materiaA+"\nASESOR: LEONEL VAZQUEZ\nID: 789123", materiaA+"\nASESOR: JOSE SOLIS\nID: 456721", materiaA+"\nASESOR: MARCO RODRIGUEZ\nID: 890123"};

        //Sirve para modificar las caracteristicas del ListView (la clase list_item_historial vienen las caracteristicas que puse)
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_historial, asesorias);
       // lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    public void Regresar(View view) {

        Intent intent = new Intent(this, MainActivity_Solicitud.class);
        startActivity(intent);
        finish();

    }

    public void Inscribirse(View view) {

        Intent intent = new Intent(this, MainActivity_SeleccionP.class);
        startActivity(intent);
        finish();

    }
}