package com.example.appgrupal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class Login extends AppCompatActivity {
    private final static int codigoMain = 1;
    private static Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //limpiarSP();

        final EditText txtNombre = (EditText) findViewById(R.id.ETnombre);
        final EditText txtPass = (EditText) findViewById(R.id.ETpassword);
        final Button BttnEntrar = (Button) findViewById(R.id.BttnEntrar);
        final Button BttnRegistrarse = (Button) findViewById((R.id.BttnRegistrarse));

        BttnRegistrarse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                aRegistro();
            }
        });
        BttnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("datosUsuario", Context.MODE_PRIVATE);
                usuario = new Usuario(sp.getString("nombre",null), sp.getString("pass", null));
                if((usuario.getNombre()!=null)&&(usuario.getPassword()!=null)){
                    if (txtNombre.getText().toString().equals(usuario.getNombre())) {
                        if (txtPass.getText().toString().equals(usuario.getPassword())) {
                            Intent intnt = new Intent(Login.this, MenuPrincipal.class);
                            startActivity(intnt);
                        }
                        else {usuarioIncorrecto();}
                    }
                    else {usuarioIncorrecto();}
                }
                else {usuarioIncorrecto();}
            }
        });
    }
    public void usuarioIncorrecto(){
        Toast tostada = Toast.makeText(
                Login.this,
                (usuario.getNombre()!=null) ? "El usuario o la contraseña son incorrectos" : "No hay usuarios registrados",
                Toast.LENGTH_SHORT);
        tostada.show();
    }
    public void aRegistro(){
        Intent intnt = new Intent(this, Registro.class);
        startActivity(intnt);
    }
    public void limpiarSP(){
        SharedPreferences sp = getSharedPreferences("datosUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor sp_editor = sp.edit();
        sp_editor.clear().apply();
    }
}