package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        //Localizar los controles
        TextView mensaje;
        mensaje = findViewById(R.id.txtRMensaje);

        //Recuperamos la información pasada en el intent
        Bundle bundel = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        String cadena;

        if (bundel.getString("genero").equals("Masculino"))
            cadena = "Hola, bienvenido " + bundel.getString("nombre");
        else
            cadena = "Hola, bienvenida " + bundel.getString("nombre");

        cadena += " \n su fecha de nacimiento es: " + bundel.getString("date")
                + "\n su número de télefono es: " + bundel.getString("phone") + "\n Gracias..!";
        mensaje.setText(cadena);
    }
}