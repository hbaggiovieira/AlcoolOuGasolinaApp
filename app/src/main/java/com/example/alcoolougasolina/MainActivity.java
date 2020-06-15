package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText preencherAlcool, preencherGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preencherAlcool = findViewById(R.id.preencherAlcool);
        preencherGasolina = findViewById(R.id.preencherGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcular (View view) {

        //recuperar valores preenchidos
        String precoAlcool = preencherAlcool.getText().toString();
        String precoGasolina = preencherGasolina.getText().toString();

        //validação dos campos preenchidos
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        if (camposValidados) {

            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            if (valorAlcool / valorGasolina >= 0.7) {
                textResultado.setText("É melhor usar gasolina!");
            } else {
                textResultado.setText("É melhor usar álcool!");
            }

        } else {
            textResultado.setText("Preencha os preços primeiro!");
        }

    }

    public Boolean validarCampos(String pAlcool, String pGasolina) {

        Boolean camposValidados = true;


        if (pAlcool == null || pAlcool.equals("") ) {
            camposValidados = false;
        } else if (pGasolina == null || pGasolina.equals("") ) {
            camposValidados = false;
        }

        return camposValidados;

    }
}