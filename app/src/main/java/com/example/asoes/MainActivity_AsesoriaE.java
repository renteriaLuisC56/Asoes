package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity_AsesoriaE extends AppCompatActivity {

    private ListView lv;
    private EditText etxt_id;

    //Array para llenar el ListView (es un ejemplo, deberia llenarse desde la base de datos)
    private String asesorias [] = {"PROGRAMACIÓN\nASESOR: ANGEL OLIVAS\nID:123456", "ALGEBRA\nASESOR: KEYLA PINEDA\nID:123678",
            "CONTABILIDAD\nASESOR: LUIS RENTERÍA\nID:098125","INGLÉS\nASESOR: ELÍAS RAMOS\nID:876456","ING. SOFTWARE\nASESOR: BRENDA AVITIA\nID:456789"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_asesoria_e);

        lv = (ListView)findViewById(R.id.lv_historial1);
        etxt_id = (EditText) findViewById(R.id.Numero);

        //Sirve para modificar las caracteristicas del ListView (la clase list_item_historial vienen las caracteristicas que puse)
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_historial, asesorias);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }

    public void Regresar(View view) { //Funcion del boton Regresar

        Intent intent = new Intent(this, MainActivity_Solicitud.class);
        startActivity(intent);
        finish();

    }

    public void buscarEspecifica(View view) { //Funcion para cambiar a la pantalla de asesorias especificas segun el id
        String id = etxt_id.getText().toString();

        if(id.equals("")) {

            Toast.makeText(this, "Debes Llenar Todos Los Campos", Toast.LENGTH_SHORT).show();
            etxt_id.requestFocus();
            InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
            imm.showSoftInput(etxt_id, InputMethodManager.SHOW_IMPLICIT);

        } else {

            Toast.makeText(this, "BUSCANDO ASESORIA", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity_Asesoria.class);
            startActivity(intent);
            finish();

        }
    }
}