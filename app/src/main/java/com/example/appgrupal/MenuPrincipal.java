package com.example.appgrupal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuPrincipal extends AppCompatActivity {
    private Button btnPreferencias;
    private Button btnLlamadas;
    private Button btnSms;
    private Button btnCorreo;
    Intent intnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        // TODO: 18/02/2021 IMPLEMENTAR BOTONES DE ACCESO A LLAMADA, SMS y CORREO 
        // TODO: 18/02/2021 LLAMADA COJERA EL TELEFONO DE EMERGENCIA Y LO USARä PARA LLAMAR 
        // TODO: 18/02/2021 SMS OBTENDRA LA UBICACION Y LA MANDARA EN SMS 
        // TODO: 18/02/2021 CORREO ABRIRA LA CAMARA, SACARA UNA FOTO Y LA MANDARA POR CORREO

        btnPreferencias= findViewById(R.id.preferencias);  
        btnPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intnt = new Intent(MenuPrincipal.this, Preferencias.class);
                startActivity(intnt);
            }
        });
        btnLlamadas= findViewById(R.id.llamada);
        btnLlamadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intnt = new Intent(MenuPrincipal.this, Llamada.class);
                startActivity(intnt);
            }
        });
        btnSms= findViewById(R.id.sms);
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intnt = new Intent(MenuPrincipal.this, Sms.class);
                startActivity(intnt);
            }
        });
        btnCorreo= findViewById(R.id.correo);
        btnCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intnt = new Intent(MenuPrincipal.this, Camara.class);
                startActivity(intnt);
            }
        });
    }
}
