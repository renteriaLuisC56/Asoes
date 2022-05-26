package com.example.asoes;

import android.os.StrictMode;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;

public class CONEXION {
public String CadenaConexionSQL="jdbc:jtds:sqlserver://proyectoalpha.database.windows.net:1433;DatabaseName=ProyectoAlpha;user=EliasRamos@proyectoalpha;password=Elias123;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;ssl=require";


    public Connection conexion(){

        Connection cnn =null;
        try{
            StrictMode.ThreadPolicy politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            cnn = DriverManager.getConnection(CadenaConexionSQL);

            
        }catch (Exception e){

        String a = "A";
        }
        return  cnn;

    }
}
