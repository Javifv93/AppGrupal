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
        addPreferencesFromResource(R.xml.preferencias);
    }

    @Override
    public void onStop() {
        super.onStop();
        update();
    }

    public void update(){
        SharedPreferences sp_preferenciasUsuario = getSharedPreferences("preferenciasUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor sp_editor_pref = sp_preferenciasUsuario.edit();

        String telefonoEmergencia = ((EditTextPreference) findPreference("phonellama")).getText();
        sp_editor_pref.putString("phonellama", telefonoEmergencia);
        String smsEmergencia = ((EditTextPreference) findPreference("phonesms")).getText();
        sp_editor_pref.putString("phonesms", smsEmergencia);
        String correoEmergencia = ((EditTextPreference) findPreference("mail")).getText();
        sp_editor_pref.putString("mail", correoEmergencia);

        sp_editor_pref.commit();

        System.out.println("LLAMADA: "+telefonoEmergencia+" SMS: "+smsEmergencia+" CORREO: "+correoEmergencia);

        sp_editor_pref.commit();
    }
}
