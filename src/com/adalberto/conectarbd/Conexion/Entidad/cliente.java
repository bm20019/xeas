package com.adalberto.conectarbd.Conexion.Entidad;

public class cliente {
    private int idCliente;
    private String nombre;
    private String apellido;
    
    public cliente(){
    
    }

    public cliente(int idCliente, String nombre, String apellido) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    @Override
    public String toString(){
        return  this.idCliente + " | " + this.nombre + " | " + this.apellido;
    }
}
