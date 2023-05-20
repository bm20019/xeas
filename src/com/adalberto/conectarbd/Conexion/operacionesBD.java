package com.adalberto.conectarbd.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class operacionesBD extends conectarBD {
    
    public operacionesBD(){    
    }
    
    @Deprecated
    public List<Object[]> consultar(String sql){
        List<Object[]> lst = new ArrayList<>();
        PreparedStatement sentencia;
        ResultSet rs = null;
        int cols;
        Object[] fila;
        try{
            sentencia = this.getConexion().prepareStatement(sql);
            rs = sentencia.executeQuery();
            cols = rs.getMetaData().getColumnCount();
            System.out.println("Columnas: "+cols);
            while(rs.next()){
                fila = new Object[cols];
                for (int i = 0; i < cols; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                lst.add(fila);
            }
            this.cerrar();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return lst;
    }
    
    public List<Object[]> consultar(PreparedStatement preparedStatement){
        List<Object[]> lst = new ArrayList<>();
        PreparedStatement sentencia;
        ResultSet rs = null;
        int cols;
        Object[] fila;
        try{
            sentencia = preparedStatement;
            rs = sentencia.executeQuery();
            cols = rs.getMetaData().getColumnCount();
            System.out.println("Columnas: "+cols);
            while(rs.next()){
                fila = new Object[cols];
                for (int i = 0; i < cols; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                lst.add(fila);
            }
            this.cerrar();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        
        return lst;
    }
    
    @Deprecated
    public int ejecutar(String sql){
        int nr = 0;
        try{
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            nr = ps.executeUpdate();
            this.cerrar();
        }catch(SQLException ex){
            System.err.println(ex);
        }
        return nr;
    }
    
    public int ejecutar(PreparedStatement preparedStatement){
        int nr = 0;
        try{
            PreparedStatement ps = preparedStatement;
            nr = ps.executeUpdate();
            this.cerrar();
        }catch(SQLException ex){
            System.err.println(ex);
        }
        return nr;
    }
}
