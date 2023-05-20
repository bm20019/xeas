package com.adalberto.conectarbd.Conexion.Dao;

import com.adalberto.conectarbd.Conexion.operacionesBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class daoUsuario extends operacionesBD {

    public boolean validar(String usuario, String clave) {
        System.out.println(String.format("Usuario: %s | Clave: %s", usuario, clave));
        String sql = "select login from usuario where login=? and password=MD5(?)";
        try {
            PreparedStatement ps = this.getConexion().prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            List<Object[]> lst = this.consultar(ps);
            if (lst.size() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return false;
    }
}
