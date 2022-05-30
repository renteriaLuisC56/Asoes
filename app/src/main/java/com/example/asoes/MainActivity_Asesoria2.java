package com.example.asoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity_Asesoria2 extends AppCompatActivity {

    String materiaID, busqueda, idAsignatura, idAsesoria, idDocente, idUsuario, idPersona, Nom, apellidoP, apellidoM, costo;
    private ListView lv;
    private Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_asesoria);

        lv = (ListView)findViewById(R.id.lv_AsesoriasD);
        spin = (Spinner)findViewById(R.id.spHorarios2);

        String horarios [] = {"7:00","8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00"};

        ArrayAdapter<String> adapterSp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, horarios);
        spin.setAdapter(adapterSp);

        materiaID = getIntent().getStringExtra("datoID");

        //String asesorias [] = {materiaA+"\nASESOR: JOSE ANTONIO\nID: 123456", materiaA+"\nASESOR: BRENDA AVITIA\nID: 456789",
        //materiaA+"\nASESOR: LEONEL VAZQUEZ\nID: 789123", materiaA+"\nASESOR: JOSE SOLIS\nID: 456721", materiaA+"\nASESOR: MARCO RODRIGUEZ\nID: 890123"};
        consultarLista();
        String asesorias [] = {busqueda};
        //Sirve para modificar las caracteristicas del ListView (la clase list_item_historial vienen las caracteristicas que puse)
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_historial, asesorias);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    public void Regresar(View view) {

        Intent intent = new Intent(this, MainActivity_AsesoriaE.class);
        startActivity(intent);
        finish();

    }

    public void consultarLista() {
        try{
            CONEXION conex = new CONEXION();
            Statement stm = conex.conexion().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM ASOESASIGNATURAS WHERE idAsignatura ='" + materiaID + "'");
            if(rs.next()){
                idAsignatura = rs.getString(1);
            } else {
                busqueda = ("No Hay Asesorías Con ID " + materiaID + " Disponibles");
            }

            CONEXION conex2 = new CONEXION();
            Statement stm2 = conex2.conexion().createStatement();
            ResultSet rs2 = stm2.executeQuery("SELECT * FROM ASOESASESORIAS WHERE idAsignatura ='" + idAsignatura + "'");
            if (rs2.next()) {
                idAsesoria = rs2.getString(1);
                idDocente = rs2.getString(8);
            }

            CONEXION conex3 = new CONEXION();
            Statement stm3 = conex3.conexion().createStatement();
            ResultSet rs3 = stm3.executeQuery("SELECT * FROM ASOESDOCENTES WHERE idDocente ='" + idDocente + "'");
            if (rs3.next()) {
                idUsuario = rs3.getString(3);
                costo = rs3.getString(2);
            }

            CONEXION conex4 = new CONEXION();
            Statement stm4 = conex4.conexion().createStatement();
            ResultSet rs4 = stm4.executeQuery("SELECT * FROM ASOESUSUARIOS WHERE idUsuario ='" + idUsuario + "'");
            if (rs4.next()) {
                idPersona = rs4.getString(5);
            }

            CONEXION conex5 = new CONEXION();
            Statement stm5 = conex5.conexion().createStatement();
            ResultSet rs5 = stm5.executeQuery("SELECT * FROM ASOESPERSONAS WHERE idPersona ='" + idPersona + "'");
            if (rs5.next()) {
                Nom = rs5.getString(2);
                apellidoP = rs5.getString(3);
                apellidoM = rs5.getString(4);
            }

            busqueda=("MATERIA: "+rs.getString(2) + "\nASESOR: " + Nom + " " + apellidoP + " " +apellidoM + "\nID ASESORÍA: " + idAsesoria);

        }catch (Exception e){
            Toast.makeText(this, "Error viejo", Toast.LENGTH_SHORT).show();
        }
    }

    public void Inscribirse(View view) {

        Intent intent = new Intent(this, MainActivity_SeleccionP.class);
        intent.putExtra("datoID", materiaID);
        intent.putExtra("datoC", costo);
        startActivity(intent);

    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}