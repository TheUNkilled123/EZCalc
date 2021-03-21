package com.example.ezcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import com.fathzer.soft.javaluator.DoubleEvaluator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DoubleEvaluator evaluator = new DoubleEvaluator();





        //All code below is only for testing purposes and not final -- Sav kod ispod je samo za test i nije finalan.

        TextView view = findViewById(R.id.MainView);
        Button calc = findViewById(R.id.solve);
        TextInputEditText text = findViewById(R.id.toSolve);
        Button addP = findViewById(R.id.zagradaTest);

        addP.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int stringlen = text.length();
                try {
                    if ((text.getText().charAt(stringlen - 1) != '*') || (text.getText().charAt(stringlen - 1) != '/') || (text.getText().charAt(stringlen - 1) != '(')){
                        //int temp = text.getText();
                        text.getText().append("*(");
                    }
                }
                catch(Exception e){
                    view.setText("ERROR");
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

        calc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    view.setText(String.valueOf(evaluator.evaluate(String.valueOf(text.getText()))));
                }
                catch(Exception e){
                    view.setText("ERROR");
                    Toast toast = Toast.makeText(getApplicationContext(),"Null expression error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }
}