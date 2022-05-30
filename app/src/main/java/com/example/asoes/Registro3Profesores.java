package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asoes.ui.CurrentUserInfo;

import java.sql.ResultSet;
import java.sql.Statement;

public class Registro3Profesores extends AppCompatActivity {

    //4,8,9,10
    Button btnSiguiente;
    CheckBox cb;
    EditText ed;
    TextView ruta1,ruta2,ruta3,ruta4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro3_profesores);
        btnSiguiente = (Button)findViewById(R.id.btnSigRegProf);
        cb = (CheckBox)findViewById(R.id.checkBox2);
        ed = (EditText) findViewById(R.id.editTextNumberDecimal);

        //ruta1 = (TextView)findViewById(R.id.textView33);
        //ruta2 = (TextView)findViewById(R.id.textView34);
        //ruta3 = (TextView)findViewById(R.id.textView35);
        //ruta4 = (TextView)findViewById(R.id.textView36);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb.isChecked() && (!TextUtils.isEmpty(ed.getText().toString()))) {
                    Registro();
                    RegistroCompletado();
                    finish();
                }else{
                    Toast.makeText(Registro3Profesores.this, "Revisa que los datos esten correctos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void RegistroCompletado(){
        Intent a = new Intent(this, registroCompletoProfesor.class);
        startActivity(a);

    }
    void Registro(){

        try {
            CONEXION conex1 = new CONEXION();
            Statement stm1 = conex1.conexion().createStatement();
            ResultSet rs = stm1.executeQuery("Insert into ASOESDocentes values ('"+ed.getText().toString()+"',"+CurrentUserInfo.idUser+")");
        }catch (Exception e){

        }

    }
    int requestcode=-1;
    public void onActivityResult(int requestcode,int resultcode,Intent data){

        super.onActivityResult(requestcode,resultcode,data);
        Context context = getApplicationContext();
        if(requestcode == resultcode && resultcode== Activity.RESULT_OK){

            if(data==null){
                return;
            }
            Uri uri = data.getData();
            Toast.makeText(this, uri.getPath(), Toast.LENGTH_SHORT).show();

        }
    }



    public void OpenFileChooser(View view){
        Intent a = new Intent(Intent.ACTION_GET_CONTENT);
        a.setType("*/*");
        startActivityForResult(a,requestcode);
    }
}