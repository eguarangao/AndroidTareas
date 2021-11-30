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
    int dia,mes,anio;
    RadioButton women,men;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.edNombre);
        date = findViewById(R.id.edFechaN);
        phone = findViewById(R.id.edTelefono);

        women = findViewById(R.id.rbtFemenino);
        men = findViewById(R.id.rbtMasculino);
    }
    public void Get(){
        Intent intent = new Intent(MainActivity.this,Activity2.class);
        Bundle bundel = new Bundle();
        bundel.putString("nombre",name.getText().toString());
        bundel.putString("f_nacimiento",date.getText().toString());
        bundel.putString("phone",phone.getText().toString());
        if(women.isChecked()){
            bundel.putString("genero",women.getText().toString());
        }
        if(men.isChecked()){
            bundel.putString("genero",men.getText().toString());
        }
        intent.putExtras(bundel);
        startActivity(intent);

    }

    public void clickBtn(View view){
        if(name.getText().toString().equals("") || date.getText().toString().equals("") || (!women.isChecked() && !men.isChecked()) || phone.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(), "Campos obligatorios", Toast.LENGTH_SHORT).show();
        else if(phone.getText().length() != 10)
            Toast.makeText(getApplicationContext(), "La cantidad de dígitos que debe colocar en su télefono es 10", Toast.LENGTH_SHORT).show();
        else
            Get();
    }
    public void vistaCalendar(View view)
    {
        final Calendar calendar = Calendar.getInstance();

        dia = calendar.get(Calendar.DAY_OF_MONTH);
        mes = calendar.get(Calendar.MONTH);
        anio = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view1, year, month, dayOfMonth) -> {
            String fecha = dayOfMonth + "/" + (month + 1) + "/" + year;
            date.setText(fecha);
        }, anio, mes, dia);
        datePickerDialog.show();

    }
}