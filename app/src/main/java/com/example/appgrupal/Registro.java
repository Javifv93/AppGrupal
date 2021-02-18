package com.example.appgrupal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registro  extends AppCompatActivity
{
    private Button cancelar;
    private Button registrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        cancelar = (Button) findViewById(R.id.buttonCancelar);
        cancelar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intnt = new Intent(Registro.this, Login.class);
                startActivity(intnt);
                finish();
            }
        });
        registrarse = (Button) findViewById(R.id.buttonRegistrarse);
        registrarse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intnt = getIntent();

                EditText ETnombre = findViewById(R.id.editTextTextNombre);
                EditText ETapellidos = findViewById(R.id.editTextTextApellidos);
                EditText ETcorreo = findViewById(R.id.editTextTextEmail);
                EditText ETpass = findViewById(R.id.editTextPassword);
                EditText ETconfirmar = findViewById(R.id.editTextTextConfirmarPassword);

                if(ETpass.getText().toString().equals(ETconfirmar.getText().toString())&&ETpass.length()>0)
                {
                    if((ETnombre.length()>0)&&(ETapellidos.length()>0)&&(ETcorreo.length()>0)) // TODO: 18/02/2021 IMPLEMENTAR GUARDADO DE USUARIO POR SHAREDPREFERENCES EN VEZ DE PASARLO POR INTENT 
                    {
                        Usuario nuevoUsuario = new Usuario(ETnombre.getText().toString(),
                                ETapellidos.getText().toString(),
                                ETcorreo.getText().toString(),
                                ETpass.getText().toString());
                        intnt.putExtra("Usuario", nuevoUsuario);
                        setResult(RESULT_OK,intnt);
                        finish();
                    }
                    else
                    {
                        Toast tostada = Toast.makeText(Registro.this, "Debes cubrir todos los datos", Toast.LENGTH_SHORT);
                        tostada.show();
                    }
                }
                else
                {
                    Toast tostada = Toast.makeText(Registro.this, "Las contraseñsa no coinciden", Toast.LENGTH_SHORT);
                    tostada.show();
                }

            }
        });
    }
}