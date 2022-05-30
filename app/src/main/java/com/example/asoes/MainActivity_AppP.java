package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity_AppP extends AppCompatActivity {

    String costo;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app_p);

        costo = getIntent().getStringExtra("datoC");

        btn = (Button)findViewById(R.id.btnPagar2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenPagoCompletado();
            }
        });
    }

    public void Regresar(View view) {

        Intent intent = new Intent(this, MainActivity_SeleccionP.class);
        intent.putExtra("datoC", costo);
        startActivity(intent);
        finish();

    }

    void OpenPagoCompletado(){
        Intent a = new Intent(this,PagoCompletado.class);
        startActivity(a);
        finish();
    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}