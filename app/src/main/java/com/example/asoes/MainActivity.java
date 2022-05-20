package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText tv1;
    private ListView lv1;
    private Button btBu;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (EditText) findViewById(R.id.tx1);
        lv1 = (ListView) findViewById(R.id.lv1);
        btBu= (Button) findViewById(R.id.btBu);
        textView2= (TextView) findViewById(R.id.textView2);


        btBu = findViewById(R.id.btBu);

        btBu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Buscar();
            }
        });

    }

    private void Buscar() {
        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"Persona",null,1);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase();

        String codigo = tv1.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila=BaseDeDatos.rawQuery
                    ("select Id_Asignatura, Id_Docente, Links from Asesoria where codigo ="+ codigo,null);

            if(fila.moveToFirst()){
                textView2.setTag(fila.getString(0));
                textView2.setTag(fila.getString(1));
                textView2.setTag(fila.getString(2));
                BaseDeDatos.close();
            }else{
                Toast.makeText(this,"No existe la asesoria",Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }

        }else{
            Toast.makeText(this,"Introduce el nombre de la asesoria",Toast.LENGTH_SHORT).show();
        }
    }


  //  public void Buscar(View view){

  //  }
}