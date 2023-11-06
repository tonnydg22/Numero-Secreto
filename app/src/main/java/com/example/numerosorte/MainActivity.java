package com.example.numerosorte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int valorsorteado;

    protected void sortearValor() {
        this.valorsorteado = new Random().nextInt(100) + 1;
    }

    public MainActivity(){
        this.sortearValor();
    }
    int cont = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void chutar(View view){
        EditText numUs = findViewById(R.id.editTextNusu);
        TextView texto = findViewById(R.id.textoR);

        String y = numUs.getText().toString();
        int numDigitado = Integer.parseInt(y);

        ++cont;

        if (numDigitado>100 || numDigitado==0)  {
            texto.setText("Apenas números de 1 a 100");
        } else if(valorsorteado>numDigitado){
            texto.setText("O número é maior");
        } else if (valorsorteado<numDigitado) {
            texto.setText("O número é menor");
        } else{
            texto.setText("ACERTOU o número secreto é "+valorsorteado+"\n\nTentativas: "+cont);
        }


        numUs.setText("");




    }

    public void novoJogo(View view){
        TextView texto = findViewById(R.id.textoR);
        sortearValor();
        texto.setText("(Tente acertar o número secreto)");
    }

}