package com.example.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



    public void btn_calc (View v)
    {

        EditText nome = (EditText)findViewById(R.id.nm_ed);
        EditText idade = (EditText)findViewById(R.id.age_ed);
        EditText peso = (EditText)findViewById(R.id.peso_ed);
        EditText altura = (EditText)findViewById(R.id.altura_ed);

        if(nome.getText().toString().matches("") || idade.getText().toString().matches("") )
        {
            return;
        }

        if(peso.getText().toString().matches("") || altura.getText().toString().matches("") )
        {
            return;
        }

        Double age =  Double.parseDouble(idade.getText().toString());
        Double wgh = Double.parseDouble(peso.getText().toString());
        Double hgt = Double.parseDouble(altura.getText().toString());


        Intent a = new Intent(getBaseContext(),Second_activity.class);
        a.putExtra("nome",nome.getText().toString());
        a.putExtra("idade",age);
        a.putExtra("peso",wgh);
        a.putExtra("altura",hgt);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);

    }
}