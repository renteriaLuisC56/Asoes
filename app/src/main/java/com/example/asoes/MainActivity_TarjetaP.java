package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity_TarjetaP extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tarjeta_p);
        btn = (Button)findViewById(R.id.btn_Pagar2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenPagoCompletado();
            }
        });
    }

    public void Regresar(View view) {

        Intent intent = new Intent(this, MainActivity_SeleccionP.class);
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