package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Ingresos;

public class Ingresos_Act extends AppCompatActivity {
    private Spinner Tipo, Enfermedad;
    private TextView Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresos);

        Tipo = findViewById(R.id.sp1);
        Enfermedad = findViewById(R.id.sp2);
        Resultado = findViewById(R.id.tvResultado);

        Ingresos i = new Ingresos();
        ArrayAdapter adapterTipo = new ArrayAdapter(this, android.R.layout.simple_list_item_1, i.getTipo());
        Tipo.setAdapter(adapterTipo);
        ArrayAdapter adapterEnfermedad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, i.getEnfermedad());
        Enfermedad.setAdapter(adapterEnfermedad);
    }

    public void Calcular(View view) {
        Ingresos ingre = new Ingresos();
        int[] TipoPrecio = ingre.getTipoPrecio();
        int[] EnfermedadPrecio = ingre.getEnfermedadPrecio();
        String[] Tipolista = ingre.getTipo();
        String[] Enfermedadlista = ingre.getEnfermedad();
        String tipo = Tipo.getSelectedItem().toString();
        String enfermedad = Enfermedad.getSelectedItem().toString();

        int T = 0;
        int E = 0;

        for (int i = 0; 1 < Tipolista.length; i++) {
            if (Tipolista[i] == tipo) {
                T = i;
                break;
            }
        }

        for (int i = 0; 1 < Enfermedadlista.length; i++) {
            if (Enfermedadlista[i] == enfermedad) {
                E = i;
                break;
            }
        }
        Resultado.setText("La cotizacion final es: " + ingre.Resultado(TipoPrecio[T], EnfermedadPrecio[E]));
    }

    public void Volver(View view) {
        Intent i = new Intent(getBaseContext(), Home_act.class);
        startActivity(i);
    }
}