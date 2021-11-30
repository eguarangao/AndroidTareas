package com.example.practica1;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText name, date, phone;
    int day, month, year;
    RadioButton women, men;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Direccionamos las varianles a sus respectivos id
        name = findViewById(R.id.edNombre);
        date = findViewById(R.id.edFechaN);
        phone = findViewById(R.id.edTelefono);
        women = findViewById(R.id.rbtFemenino);
        men = findViewById(R.id.rbtMasculino);
    }

    //metodo para obtener la informacion a enviar
    public void GetInfo() {
        //Declacion del Intent
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        Bundle bundel = new Bundle();
        //Asignacion de la información
        bundel.putString("nombre", name.getText().toString());
        bundel.putString("date", date.getText().toString());
        bundel.putString("phone", phone.getText().toString());
        if (women.isChecked()) {
            bundel.putString("genero", women.getText().toString());
        }
        if (men.isChecked()) {
            bundel.putString("genero", men.getText().toString());
        }
        // Añadimos la información al intent
        intent.putExtras(bundel);
        // Iniciamos la nueva actividad
        startActivity(intent);

    }

    public void clickBtn(View view) {
        //validación de espacios en blanco
        if (name.getText().toString().equals("") || date.getText().toString().equals("") ||
                (!women.isChecked() && !men.isChecked()) || phone.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(),
                    "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
            //validacion de numeros <10
        else if (phone.getText().length() != 10)
            Toast.makeText(getApplicationContext(),
                    "La cantidad de dígitos que debe colocar en su télefono es 10",
                    Toast.LENGTH_SHORT).show();
        else//aplicamos el metodo que obtiene la informacion de la actividad
            GetInfo();
    }

    //Metodo para la vista del calendario
    public void vistaCalendar(View view) {
        //Declaracion del objecto
        Calendar calendar = Calendar.getInstance();

        //direccionamos las variables a surespectivo dato
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        //aplicacion de lambda para la fecha
        DatePickerDialog dpd = new DatePickerDialog(this,
                (view1, year, month, dayOfMonth) -> {
                    String fecha = dayOfMonth + "/" + (month + 1) + "/" + year;
                    date.setText(fecha);
                }, year, month, day);
        //Abrimos el calendario
        dpd.show();

    }
}