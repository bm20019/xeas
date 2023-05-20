package com.adalberto.conectarbd.Conexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

public class configuracion {

    private Properties propiedades;
    private InputStream entrada;
    private final String driverKey = "driver", usuarioKey = "usuario", claveBDKey = "claveBD", urlKey = "url", claveJwtKey="claveJWT";

    public configuracion() {
        this.setProperty("config.txt");
    }

    public void setProperty(String archivo) {
        String rutaProyecto = Path.of(new File("").getAbsolutePath(), archivo).toString();
        this.propiedades = new Properties();
        try {
            this.entrada = new FileInputStream(rutaProyecto);
            this.propiedades.load(this.entrada);
            System.setProperty(this.driverKey, this.propiedades.getProperty(this.driverKey));
            System.setProperty(this.usuarioKey, this.propiedades.getProperty(this.usuarioKey));
            System.setProperty(this.claveBDKey, this.propiedades.getProperty(this.claveBDKey));
            System.setProperty(this.urlKey, this.propiedades.getProperty(this.urlKey));
            System.setProperty(this.claveJwtKey,this.propiedades.getProperty(this.claveJwtKey));
        } catch (IOException ex) {
            System.err.println("ConfigPath: " + this.entrada);
            System.err.println(ex.getMessage());
        }
    }

    public String getDriver() {
        return System.getProperty(this.driverKey);
    }

    public String getUsuario() {
        return System.getProperty(this.usuarioKey);
    }

    public String getClaveBD() {
        return System.getProperty(this.claveBDKey);
    }

    public String getUrl() {
        return System.getProperty(this.urlKey);
    }
    
    public String getClaveJWT(){
        return System.getProperty(this.claveJwtKey);
    }
}
