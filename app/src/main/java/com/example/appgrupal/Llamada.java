package com.example.appgrupal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Llamada extends AppCompatActivity {
    private String phoneNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamadas);
        Button mDialButton = (Button) findViewById(R.id.btn_dial);
        final EditText mPhoneNoEt = (EditText) findViewById(R.id.et_phone_no);
        if(telefonoSP()!=null){
            mPhoneNoEt.setText(telefonoSP());
        }
        mDialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    // TODO: 18/02/2021 PETA EN EL STARTACTIVITY
                phoneNo = mPhoneNoEt.getText().toString();
                if(phoneNo!=null) {
                    String dial = "tel:" + phoneNo;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }else {
                    Toast.makeText(Llamada.this, "Enter a phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private String telefonoSP(){
        SharedPreferences sp_preferenciasUsuario = getSharedPreferences("preferenciasUsuario", Context.MODE_PRIVATE);
        return sp_preferenciasUsuario.getString("phonellama",null);
    }
}