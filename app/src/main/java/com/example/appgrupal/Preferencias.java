package com.example.appgrupal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;

public class Preferencias extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new PreferenciasFragment())
                .commit();
    }

    @Override
    public void onStop() {
        super.onStop();
        update();
    }

    public void update(){
        // TODO: 18/02/2021 HAY QUE METER LA NUEVA CONTRASEÑA EN LA LISTA DE USUARIOS SUSTITUYENDO LA ANTIGUA
        // TODO: 18/02/2021 MIRAR QUE ESTO FUNCIONE
        SharedPreferences sp = getSharedPreferences("preferenciasUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor sp_editor = sp.edit();

        String telefonoEmergencia = ((EditTextPreference) findPreference("phonellama")).getText();
        sp_editor.putString("phonellama", telefonoEmergencia);
        String smsEmergencia = ((EditTextPreference) findPreference("phonesms")).getText();
        sp_editor.putString("phonesms", smsEmergencia);
        String correoEmergencia = ((EditTextPreference) findPreference("mail")).getText();
        sp_editor.putString("mail", correoEmergencia);

        sp_editor.commit();
    }
}
