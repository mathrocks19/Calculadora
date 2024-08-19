package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText numero1EditText, numero2EditText;
    TextView resultadoTextView;
    Button botaoAC, botaoDividir, botaoMultiplicar, botaoSubtrair, botaoSomar, botaoIgual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1EditText = findViewById(R.id.numero1EditText);
        numero2EditText = findViewById(R.id.numero2EditText);
        resultadoTextView = findViewById(R.id.resultadoTextView);

        botaoAC = findViewById(R.id.botaoAC);
        botaoDividir = findViewById(R.id.botaoDividir);
        botaoMultiplicar = findViewById(R.id.botaoMultiplicar);
        botaoSubtrair = findViewById(R.id.botaoSubtrair);
        botaoSomar = findViewById(R.id.botaoSomar);


        botaoAC.setOnClickListener(view -> {
            numero1EditText.setText("");
            numero2EditText.setText("");
            resultadoTextView.setText("");
        });
        botaoSomar.setOnClickListener(view -> {
            calcular("+");
        });
        botaoSubtrair.setOnClickListener(view -> {
            calcular("-");
        });
        botaoMultiplicar.setOnClickListener(view -> {
            calcular("*");
        });
        botaoDividir.setOnClickListener(view -> {
            calcular("/");
        });
        botaoIgual.setOnClickListener(view -> {
            calcular("=");
        });

    }

    private void calcular(String operacao) {
        double numero1 = Double.parseDouble(numero1EditText.getText().toString());
        double numero2 = Double.parseDouble(numero2EditText.getText().toString());
        double resultado = 0;

        switch (operacao) {
            case "+":
                resultado = numero1 + numero2;
                break;
            case "-":
                resultado = numero1 - numero2;
                break;
            case "*":
                resultado = numero1 * numero2;
                break;
            case "/":
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                } else {
                    resultadoTextView.setText("Erro: Divisão por zero");
                    return;
                }
                break;
            case "=":
                resultado = numero1;
                break;
        }

        resultadoTextView.setText(String.valueOf(resultado));
    }
}