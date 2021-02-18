package com.example.appgrupal;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Usuario implements Serializable {
    private String nombre;
    private String apellidos;
    private String correo;
    private String password;

    Usuario(){}
    Usuario(String nombre, String apellidos, String correo, String password){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getCorreo(){
        return correo;
    }
    public String getPassword(){
        return password;
    }
}
