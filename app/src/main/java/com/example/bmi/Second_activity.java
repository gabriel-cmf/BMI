package com.example.bmi;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class Second_activity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.second_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle extras = getIntent().getExtras();

        boolean has_extras = (extras != null);
        if (has_extras) {


            String nome = extras.getString("nome");
            double idade = extras.getDouble("idade");
            Double peso = extras.getDouble("peso");
            Double altura = extras.getDouble("altura");

            TextView nome_tv = (TextView)findViewById(R.id.nome);
            TextView idade_tv = (TextView)findViewById(R.id.idade);
            TextView peso_tv = (TextView)findViewById(R.id.peso);
            TextView altura_tv = (TextView)findViewById(R.id.altura2);
            TextView imc_tv = (TextView)findViewById(R.id.imc);
            TextView clas_tv = (TextView)findViewById(R.id.clas);

            int idade_i = (int)(idade);

            nome_tv.setText(nome_tv.getText().toString() + " " + nome);
            idade_tv.setText(idade_tv.getText().toString() + " " + String.valueOf(idade_i) );
            peso_tv.setText(peso_tv.getText().toString() + " " + peso.toString() + " kg");
            altura_tv.setText(altura_tv.getText().toString() + " " + altura.toString() + "m");


            Double imc_val = peso/(altura*altura);
            DecimalFormat df = new DecimalFormat("#.00");

            imc_tv.setText(imc_tv.getText().toString() + " " + df.format(imc_val));



            String clas_val = "Abaixo do Peso";

            if(imc_val>=18.5 && imc_val<25)
            {
                clas_val = "Saudável";
            }

            if(imc_val>=25 && imc_val<30)
            {
                clas_val = "Sobrepeso";
            }

            if(imc_val>=30 && imc_val<35)
            {
                clas_val = "Obesidade Grau I";
            }

            if(imc_val>=35 && imc_val<40)
            {
                clas_val = "Obesidade Grau II (severa)";
            }

            if(imc_val>=40)
            {
                clas_val = "Obesidade Grau III (mórbida)";
            }

            clas_tv.setText(clas_tv.getText().toString() + " " +clas_val);










        }




    }
}
