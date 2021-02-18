package com.example.appgrupal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class Login extends AppCompatActivity {
    private final static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private final static int codigoMain = 1;
    private static Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
                Iterator it = listaUsuarios.listIterator();
                if(listaUsuarios.size()>0) {
                    boolean existe = false;
                    while (it.hasNext()) {
                        Usuario usuarioLista = (Usuario) it.next();
                        if (txtNombre.getText().toString().equals(usuarioLista.getNombre())) {
                            if (txtPass.getText().toString().equals(usuarioLista.getPassword())) {
                                existe = true;
                                Intent intnt = new Intent(Login.this, MenuPrincipal.class);
                                startActivity(intnt);
                                finish();
                            }
                        }
                    }
                    if(!existe)
                    {
                        Toast tostada = Toast.makeText(Login.this, "El usuario o la contraseña son incorrectos", Toast.LENGTH_SHORT);
                        tostada.show();
                    }
                }
                else
                {
                    Toast tostada = Toast.makeText(Login.this, "No hay usuarios registrados", Toast.LENGTH_SHORT);
                    tostada.show();
                }
            }
        });
    }
    public void aRegistro(){
        Intent intnt = new Intent(this, Registro.class);
        startActivityForResult(intnt,codigoMain);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            usuario = (Usuario)data.getExtras().getSerializable("Usuario"); // TODO: 18/02/2021 IMPLEMENTAR LA OBTENCION DE USUARIO POR SHARED PREFERENCES EN VEZ DE RECIBIR EL INTENT. CAMBIAR ESTE ACTIVITY ON RESULT 
            Usuario usuarioRegistrado = new Usuario(usuario.getNombre(),
                    usuario.getApellidos(),
                    usuario.getCorreo(),
                    usuario.getPassword());
            listaUsuarios.add(usuarioRegistrado);
        }
    }

}