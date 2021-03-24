package com.example.ezcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import com.fathzer.soft.javaluator.DoubleEvaluator;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DoubleEvaluator evaluator = new DoubleEvaluator();


        TextView results = findViewById(R.id.currentView);
        TextView resultsHitsory = findViewById(R.id.historyMiniView);
        results.setText("");
        //UI/Fullscreen scaling fixes
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        Button plus = findViewById(R.id.SIMPLEadding);
        Button btn0 = findViewById(R.id.SIMPLEbtn0);
        Button btn1 = findViewById(R.id.SIMPLEbtn1);
        Button btn2 = findViewById(R.id.SIMPLEbt2);
        Button btn3 = findViewById(R.id.SIMPLEbtn3);
        Button btn4 = findViewById(R.id.SIMPLEbtn4);
        Button btn5 = findViewById(R.id.SIMPLEbt5);
        Button btn6 = findViewById(R.id.SIMPLEbtn6);
        Button btn7 = findViewById(R.id.SIMPLEbtn7);
        Button btn8 = findViewById(R.id.SIMPLEbt8);
        Button btn9 = findViewById(R.id.SIMPLEbtn9);
        Button clearAll = findViewById(R.id.SIMPLEdeleteALL);
        Button delete = findViewById(R.id.SIMPLEdelete);
        Button ostatakDijeljenja = findViewById(R.id.SIMPLEdivideResidueButton);
        Button divide = findViewById(R.id.SIMPLEdivide);
        Button multiply = findViewById(R.id.SIMPLEmultiply);
        Button minus = findViewById(R.id.SIMPLEoduzimanje);
        Button equals = findViewById(R.id.SIMPLEequals);
        Button decimal = findViewById(R.id.SIMPLEdecimalPoint);
        Button historyButton = findViewById(R.id.historyButton);



        //Wall of shit incoming...
        plus.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    int stringlen = results.length();
                    if(results.getText().charAt(stringlen - 1) != '\0' && results.getText().charAt(stringlen - 1) != '+' &&  results.getText().charAt(stringlen - 1) != '-' &&  results.getText().charAt(stringlen - 1) != '/' &&  results.getText().charAt(stringlen - 1) != '%' &&  results.getText().charAt(stringlen - 1) != '.' && results.getText().charAt(stringlen - 1) != '*'){
                        results.append("+");
                    }
                    else if(results.getText().charAt(stringlen - 1) == '-'){
                        Toast toast = Toast.makeText(getApplicationContext(),"Plus i minus daju minus :)",Toast.LENGTH_SHORT);
                        toast.show();
                    }

                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        btn0.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {

                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.append("1");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.append("2");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.append("3");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.append("4");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.append("5");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.append("6");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.append("7");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.append("8");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.append("9");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        clearAll.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.setText("");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    String myshit = results.getText().toString();
                    myshit = myshit.substring(0, myshit.length() - 1);
                    results.setText(myshit);
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        ostatakDijeljenja.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {

                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    int stringlen = results.length();
                    if(results.getText().charAt(stringlen - 1) != '\0' && results.getText().charAt(stringlen - 1) != '+' &&  results.getText().charAt(stringlen - 1) != '-' &&  results.getText().charAt(stringlen - 1) != '/' &&  results.getText().charAt(stringlen - 1) != '%' &&  results.getText().charAt(stringlen - 1) != '.' && results.getText().charAt(stringlen - 1) != '*'){
                        results.append("/");
                    }
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    int stringlen = results.length();
                    if(results.getText().charAt(stringlen - 1) != '\0' && results.getText().charAt(stringlen - 1) != '+' &&  results.getText().charAt(stringlen - 1) != '-' &&  results.getText().charAt(stringlen - 1) != '/' &&  results.getText().charAt(stringlen - 1) != '%' &&  results.getText().charAt(stringlen - 1) != '.' && results.getText().charAt(stringlen - 1) != '*'){
                        results.append("*");
                    }
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int stringlen = results.length();
                try {
                    if(results.getText().charAt(stringlen - 1) != '+' &&  results.getText().charAt(stringlen - 1) != '-' &&  results.getText().charAt(stringlen - 1) != '/' &&  results.getText().charAt(stringlen - 1) != '%' &&  results.getText().charAt(stringlen - 1) != '.' && results.getText().charAt(stringlen - 1) != '*'){
                        results.append("-");
                    }else if(results.getText().charAt(stringlen - 1) == '+'){
                        String myshit = results.getText().toString();
                        myshit = myshit.substring(0, myshit.length() - 1);
                        results.setText(myshit);
                        results.append("-");
                        Toast toast = Toast.makeText(getApplicationContext(),"Plus i minus daju minus :)",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        equals.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {

                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        decimal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    int stringlen = results.length();
                    if(results.getText().charAt(stringlen - 1) != '.'){
                        if(results.getText().charAt(stringlen - 1) == '\0' || results.getText().charAt(stringlen - 1) == '+' ||  results.getText().charAt(stringlen - 1) == '-' ||  results.getText().charAt(stringlen - 1) == '/' ||  results.getText().charAt(stringlen - 1) == '%' || results.getText().charAt(stringlen - 1) == '*'){
                            results.append("0.");
                        }else{
                            if(!isInsideDecimal(results.getText().toString())) {
                                results.append(".");
                            }
                        }
                    }
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        historyButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {

                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });



        /*All code below is only for testing purposes and not final -- Sav kod ispod je samo za test i nije finalan.

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
*/
    }

    private boolean isInsideDecimal(String str)
    {

           int len = str.length();

           for (int i = len - 1; i >= 0; i--) {
               if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '/' || str.charAt(i) == '%' || str.charAt(i) == '*') {
                   return false;
               }
               else if (str.charAt(i) == '.'){
                   return true;
               }
           }
           return false;



    }
}