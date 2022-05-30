package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.asoes.ui.CurrentUserInfo;

public class MisAsesorias extends AppCompatActivity {

    Button a,eliminar,editar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_asesorias);
        a = (Button)findViewById(R.id.button18);
        eliminar = (Button)findViewById(R.id.btnEliminar);
        editar = (Button)findViewById(R.id.btnEditar);

        if(CurrentUserInfo.esDocente.equalsIgnoreCase("1")){
            eliminar.setVisibility(View.VISIBLE);
            editar.setVisibility(View.VISIBLE);
        }

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IrInicio();
            }
        });
    }
    void IrInicio(){

        if(CurrentUserInfo.esDocente.equalsIgnoreCase("1")) {
            Intent a = new Intent(this, pantallaPrincipalDocente.class);
            startActivity(a);
            finish();
        }else{
            Intent a = new Intent(this, pantallaPrincipal.class);
            startActivity(a);
            finish();
        }
    }
}