package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class registro extends AppCompatActivity {

    RadioButton rbProfesor,rbAlumno;
    Button btnSig;
    EditText txtRegUser,txtRegPass,txtRegPassConfirm,txtRegCorreo;
    CheckBox terminos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        rbProfesor = (RadioButton) findViewById(R.id.radioButton);
        rbAlumno = (RadioButton) findViewById(R.id.radioButton2);
        btnSig = (Button)findViewById(R.id.button3);
        txtRegUser=(EditText)findViewById(R.id.txtRegUser);
        txtRegPass=(EditText)findViewById(R.id.txtRegPass);
        txtRegPassConfirm=(EditText)findViewById(R.id.txtRegPassConf);
        //txtRegCorreo=(EditText)findViewById(R.id.txtRegCorreo);
        terminos=(CheckBox)findViewById(R.id.terminos);



        btnSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(rbProfesor.isChecked()){
                    if(camposLlenos() && terminos()) {
                        OpenRegistroProfe();
                    }
                }else if(rbAlumno.isChecked()){
                    if(camposLlenos() && terminos()) {
                        RegNormalFin();
                    }
                }else{
                    //Seleccione algo.
                   seleccioneAlgo();
                }


            }
        });

    }

    public void OpenRegistroProfe() {

        Intent a = new Intent(this, Registro3Profesores.class);
        startActivity(a);

    }
    public void RegNormalFin() {

        Intent a = new Intent(this, registroCompleto.class);
        startActivity(a);

    }
    public boolean camposLlenos(){

        if(TextUtils.isEmpty(txtRegUser.getText().toString())){
            Toast.makeText(this, "Llena el campo de 'Usuario' por favor", Toast.LENGTH_SHORT).show();
            return false;
        }else if(TextUtils.isEmpty(txtRegPass.getText().toString())){
            Toast.makeText(this, "Llena el campo de 'Contraseña' por favor", Toast.LENGTH_SHORT).show();
            return false;
        }else if(TextUtils.isEmpty(txtRegPassConfirm.getText().toString())){
            Toast.makeText(this, "Repite tu contraseña por favor.", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }
    void seleccioneAlgo(){
        Toast.makeText(this, "Selecciona si eres  docente.", Toast.LENGTH_SHORT).show();
    }
    public boolean terminos(){
        if(terminos.isChecked()){
            return true;
        }
        Toast.makeText(this, "Para continuar, debes aceptar nuestros terminos y condiciones.", Toast.LENGTH_SHORT).show();
        return false;
    }

}