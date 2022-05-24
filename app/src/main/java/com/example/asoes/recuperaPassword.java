package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class recuperaPassword extends AppCompatActivity {

    Button btn;
    EditText Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recupera_password);
        btn = (Button)findViewById(R.id.btnBackLogin);
        Email = (EditText) findViewById(R.id.txtRecuEmail);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //onBackPressed();

                if(camposLlenos()){
                   correoEnviado();
                }

            }
        });
    }


    public boolean camposLlenos(){

        if(TextUtils.isEmpty(Email.getText().toString())) {
            Toast.makeText(this, "Llena el campo de 'E-mail' por favor", Toast.LENGTH_SHORT).show();
            return false;
        }



        return true;
    }
    void correoEnviado(){
        Toast.makeText(this, "Se a enviado el Email.", Toast.LENGTH_SHORT).show();
    }
}