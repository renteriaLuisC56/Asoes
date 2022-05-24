package com.example.asoes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4_seleccionP extends AppCompatActivity {

    String select = "";
    private ListView lv;
    private String metodos [] = {"TARJETA DE CRÉDITO", "TARJETA DE DÉBITO", "PAYPAL", "MERCADO PAGO"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4_seleccion_p);

        lv = (ListView)findViewById(R.id.lv_MetodosP);

        //Caracteristicas del ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_historial, metodos);
        lv.setAdapter(adapter);

        //Creacion del Metodo para cambiar de pantalla
        Intent intent = new Intent(this, MainActivity5_TarjetaP.class);
        Intent intent2 = new Intent(this, MainActivity6_AppPago.class);

        //Clase anonima que funciona para saber en que item se hizo clic en el ListView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Segun el clic la variable "i" cambiara a un numero entero y seleccionara un item del array
                select = metodos[i];

                //Segun el item que haya seleccionado cambiara de pantalla
                if (select == "TARJETA DE CRÉDITO" || select == "TARJETA DE DÉBITO") {

                    startActivity(intent);
                    finish();

                } else if (select == "PAYPAL" || select == "MERCADO PAGO") {

                    startActivity(intent2);
                    finish();

                }

            }
        });
    }

    public void Regresar(View view) {

        Intent intent = new Intent(this, MainActivity3_asesoria.class);
        startActivity(intent);
        finish();

    }

}