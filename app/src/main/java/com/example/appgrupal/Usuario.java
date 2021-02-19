package com.example.appgrupal;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Usuario implements Serializable {
    private String nombre;
    private String apellidos;
    private String correo;
    private String password;

    Usuario(){}
    Usuario(String nombre, String password){
        this.nombre = nombre;
        this.password = password;
    }
    Usuario(String nombre, String apellidos, String correo, String password){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String value){ nombre = value; }
    public String getApellidos(){
        return apellidos;
    }
    public void setApellidos(String value){ apellidos = value; }
    public String getCorreo(){
        return correo;
    }
    public void setCorreo(String value){ correo = value; }
    public String getPassword(){
        return password;
    }
    public void setPassword(String value){ password = value; }
}
