package com.example.appgrupal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView imagenPortada;
    private TextView textViewBienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagenPortada = (ImageView) findViewById(R.id.imagenPortada);
        imagenPortada.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intnt = new Intent(MainActivity.this, Login.class);
                startActivity(intnt);
                finish();
            }
        });
        textViewBienvenida = (TextView) findViewById(R.id.textViewBienvenida);
        textViewBienvenida.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast mensaje = Toast.makeText(MainActivity.this, "Toca la pokeball para continuar!", Toast.LENGTH_SHORT);
                mensaje.show();
            }
        });
    }
}
