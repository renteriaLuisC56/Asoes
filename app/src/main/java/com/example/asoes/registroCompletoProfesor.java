package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class registroCompletoProfesor extends AppCompatActivity {
    Button entrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_completo_profesor);
        entrar=(Button)findViewById(R.id.button6);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrar();
            }
        });
    }

    void entrar(){
        Intent a = new Intent(this,pantallaPrincipal.class);
        startActivity(a);
    }
}