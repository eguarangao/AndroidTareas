package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        TextView mensaje;
        mensaje = findViewById(R.id.txtRMensaje);

        //Información pasada en el intent
        Bundle bundel = this.getIntent().getExtras();

        //Variable que contendra el msj a mostrar
        String cadena;

        if (bundel.getString("genero").equals("Masculino"))
            cadena = "Hola, bienvenido " + bundel.getString("nombre");
        else
            cadena = "Hola, bienvenida " + bundel.getString("nombre");

        cadena += " \n su fecha de nacimiento es: " + bundel.getString("date")
                + "\n su número de télefono es: " + bundel.getString("phone") + "\n Gracias..!";
        //Enviamos el msj
        mensaje.setText(cadena);
    }
}