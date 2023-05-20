package com.adalberto.conectarbd.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectarBD extends configuracion{

    private Connection conexion;

    public conectarBD() {
        String usuario, clave, url, driver;
        usuario = this.getUsuario();
        clave = this.getClaveBD();
        url = this.getUrl();
        driver = this.getDriver();
        System.out.println(String.format("Driver: %s\nUrl: %s\nUsuario: %s\nClave: %s\n",
                driver,
                url,
                usuario,
                clave));
        
        try{
            Class.forName(driver);
            this.conexion = DriverManager.getConnection(url,usuario,clave);
        }catch(SQLException | ClassNotFoundException ex){
            System.err.println(ex);
        }
    }

    public void cerrar() {
        try {
            this.conexion.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Connection getConexion() {
        return this.conexion;
    }
}
