package com.adalberto.conectarbd.Conexion.Entidad;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class usuario {

    private String username;
    private String password;

    public usuario() {

    }

    public usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String HASH(String cadena) {
        String text = cadena;
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(text.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            String hash = sb.toString();
            return hash;
        } catch (NoSuchAlgorithmException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        return String.format("{\n\t\"%s\":\"%s\",\n\t\"%s\":\"%s\"\n}", "username", this.username, "password", this.HASH(this.password));
    }
}
