package com.adalberto.conectarbd.Conexion.Dao;

import com.adalberto.conectarbd.Conexion.Entidad.cliente;
import com.adalberto.conectarbd.Conexion.operacionesBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class daoCliente extends operacionesBD {

    private final List<cliente> lista;

    public daoCliente() {
        this.lista = new ArrayList<>();
    }

    public List<cliente> getAll() {
        String sql = "select idCliente, nombre, apellido from cliente";
        try {
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            List<Object[]> lst = consultar(ps);
            for (int i = 0; i < lst.size(); i++) {
                cliente cli = new cliente();
                cli.setIdCliente(Integer.parseInt(lst.get(i)[0].toString()));
                cli.setNombre(lst.get(i)[1].toString());
                cli.setApellido(lst.get(i)[2].toString());
                this.lista.add(cli);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return this.lista;
    }
    
    //CRUD
    
    //Read
    public cliente getClienteforId(int id) {
        String sql = "select idCliente, nombre, apellido from cliente where idCliente=?";
        cliente cli = new cliente();
        try {
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            List<Object[]> lst = consultar(ps);
            if (!lst.isEmpty()) {
                cli.setIdCliente(Integer.parseInt(lst.get(0)[0].toString()));
                cli.setNombre(lst.get(0)[1].toString());
                cli.setApellido(lst.get(0)[2].toString());
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return cli;
    }
    
    //Create
    public int crearCliente(cliente cli){
        String sql = "insert into cliente (nombre,apellido) values (?, ?)";
        try {
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getApellido());
            return this.ejecutar(ps);
        } catch (SQLException ex) {
            System.err.println(ex);
            return -1;
        }
    }
    
    //UPDATE
    public int modificarCliente(int id,cliente cli){
        String sql = "update cliente set nombre=?, apellido=? where idCliente=?";
        try {
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getApellido());
            ps.setInt(3, id);
            return this.ejecutar(ps);
        } catch (SQLException ex) {
            System.err.println(ex);
            return -1;
        }
    }
    
    //DELETE
    public int eliminarCliente(int id){
        String sql = "delete from cliente where idCliente=?";
        try {
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setInt(1, id);
            return this.ejecutar(ps);
        } catch (SQLException ex) {
            System.err.println(ex);
            return -1;
        }
    }
}