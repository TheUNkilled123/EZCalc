package com.example.ezcalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.esotericsoftware.kryo.NotNull;
import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.Function;
import com.fathzer.soft.javaluator.Parameters;

import java.util.ArrayList;
import java.util.Iterator;

import io.paperdb.Paper;

import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

public class MainActivity extends AppCompatActivity {
    TextView results;
    TextView resultsHitsory;
    DoubleEvaluator evaluator;
    TextView memoryStatus;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        results = findViewById(R.id.currentView);
        resultsHitsory = findViewById(R.id.historyMiniView);
        memoryStatus = findViewById(R.id.memoryStatus);
        results.setText("");
        ViewPager2 viewPager = findViewById(R.id.viewPager);
        FragmentStateAdapter pageAdapter = new ScreenSlidePageAdapter(this);
        viewPager.setAdapter(pageAdapter);
        if (Paper.book().read("memory") == ""){
            memoryStatus.setVisibility(View.INVISIBLE);
        }else{
            memoryStatus.setVisibility(View.VISIBLE);
        }
        //UI/Fullscreen scaling fixes
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        View decorView = getWindow().getDecorView();
        int uiOptions = SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
       /* Button plus = findViewById(R.id.SIMPLEadding);
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
      Button piButton = findViewById(R.id.piButton);
        Button sinButton = findViewById(R.id.sinButton);
        Button cosButton = findViewById(R.id.cosButton);
        Button openBrackets = findViewById(R.id.openBrackets);
        Button closeBrackets = findViewById(R.id.closeBrackets);
        Button toPowerButton = findViewById(R.id.toPowerButton);
        Button sqrtButton = findViewById(R.id.sqrtButton);
        Button tanButton = findViewById(R.id.tanButton);
        Button absButton = findViewById(R.id.absButton);
        Button lnButton = findViewById(R.id.lnButton);
        Button memoryButton = findViewById(R.id.memoryButton);
        Button memoryClearButton = findViewById(R.id.memoryClearButton);
       */
        Button historyButton = findViewById(R.id.historyButton);

        results.setAutoSizeTextTypeUniformWithConfiguration(1, 60, 1, TypedValue.COMPLEX_UNIT_DIP);

        historyButton.setOnClickListener(v -> {
            try {
                MainActivity.this.startActivity(new Intent(MainActivity.this, HistoryActivity.class));
            }
            catch(Exception e){
                Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        /*

        plus.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    int stringlen = results.length();
                    if(results.getText().charAt(stringlen - 1) != '\0' && results.getText().charAt(stringlen - 1) != '+' &&  results.getText().charAt(stringlen - 1) != '-' &&  results.getText().charAt(stringlen - 1) != '/' &&  results.getText().charAt(stringlen - 1) != '%' &&  results.getText().charAt(stringlen - 1) != '.' && results.getText().charAt(stringlen - 1) != '*'){
                        results.setText(results.getText()+"+");
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
                    results.setText(results.getText()+"0");
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
                    results.setText(results.getText()+"1");
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
                    results.setText(results.getText()+"2");
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
                    results.setText(results.getText()+"3");
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
                    results.setText(results.getText()+"4");
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
                    results.setText(results.getText()+"5");
                    //results.append("5");
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
                    results.setText(results.getText()+"6");
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
                    results.setText(results.getText()+"7");
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
                    results.setText(results.getText()+"8");
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
                    results.setText(results.getText()+"9");
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
                    resultsHitsory.setText("");
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
                    int stringlen = results.length();
                    if(results.getText().charAt(stringlen - 1) != '\0' && results.getText().charAt(stringlen - 1) != '+' &&  results.getText().charAt(stringlen - 1) != '-' &&  results.getText().charAt(stringlen - 1) != '/' &&  results.getText().charAt(stringlen - 1) != '%' &&  results.getText().charAt(stringlen - 1) != '.' && results.getText().charAt(stringlen - 1) != '*'){
                        results.setText(results.getText()+"%");
                    }
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
                        results.setText(results.getText()+"/");
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
                        results.setText(results.getText()+"*");
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
                    if(results.getText().charAt(stringlen - 1) != '+' &&  results.getText().charAt(stringlen - 1) != '-'  &&  results.getText().charAt(stringlen - 1) != '.'){
                        results.setText(results.getText()+"-");
                    }else if(results.getText().charAt(stringlen - 1) == '+'){
                        String myshit = results.getText().toString();
                        myshit = myshit.substring(0, myshit.length() - 1);
                        results.setText(myshit);
                        results.setText(results.getText()+"-");
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
            public void onClick(View v) {
                try {
                    Double result = evaluator.evaluate(String.valueOf(results.getText()));
                    ArrayList<String> currentValues = Paper.book().read("calculatorHistory");
                    resultsHitsory.setText(results.getText());
                    results.setText(results.getText()+"=");
                    if (result % 1 == 0) {
                        currentValues.add(results.getText() + " = " + (int) Math.round(result));
                        results.setText(Integer.toString((int) Math.round(result)));
                    } else {
                        currentValues.add(results.getText() + " = " + result);
                        results.setText(String.valueOf(result));
                    }
                    Paper.book().write("calculatorHistory", currentValues);
                }catch(Exception e){
                    results.setText("ERROR");
                }
            }
        });

        decimal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    int stringlen = results.length();
                    if(results.getText().charAt(stringlen - 1) != '.'){
                        if(results.getText().charAt(stringlen - 1) == '\0' || results.getText().charAt(stringlen - 1) == '+' ||  results.getText().charAt(stringlen - 1) == '-' ||  results.getText().charAt(stringlen - 1) == '/' ||  results.getText().charAt(stringlen - 1) == '%' || results.getText().charAt(stringlen - 1) == '*'){
                            results.setText(results.getText()+"0.");
                        }else{
                            if(!isInsideDecimal(results.getText().toString())) {
                                results.setText(results.getText()+"0.");
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



        /*
        piButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.setText(results.getText()+"pi");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        sinButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.setText(results.getText()+"sin(");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        cosButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.setText(results.getText()+"cos(");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        openBrackets.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.setText(results.getText()+"(");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        closeBrackets.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.setText(results.getText()+")");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        toPowerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.setText(results.getText()+"^");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        sqrtButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.setText(results.getText()+"sqrt(");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        tanButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.setText(results.getText()+"tan(");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        absButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.setText(results.getText()+"abs(");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        lnButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    results.setText(results.getText()+"ln(");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        memoryButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    Paper.book().write("memory",results.getText());
                    memoryStatus.setVisibility(View.VISIBLE);
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        memoryClearButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    Paper.book().write("memory","");
                    memoryStatus.setVisibility(View.INVISIBLE);
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

    private static class ScreenSlidePageAdapter extends FragmentStateAdapter {

        public ScreenSlidePageAdapter(FragmentActivity fa) {
            super(fa);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new FragmentSimple();
                case 1:
                    return new FragmentScientfic();
            }
            return null;
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }
        //Definicija dugmadi
        public void onClick(View view){

            Function SQRT = new Function("sqrt", 1);
            Parameters params = DoubleEvaluator.getDefaultParameters();
            params.add(SQRT);
            DoubleEvaluator evaluator = new DoubleEvaluator(params){
                @Override
                protected Double evaluate(Function function, Iterator arguments, Object evaluationContext) {
                    if (function == SQRT) {
                        // Implements the new function
                        return Math.sqrt((Double) arguments.next());
                    } else {
                        // If it's another function, pass it to DoubleEvaluator
                        return super.evaluate(function, arguments, evaluationContext);
                    }
                }
            };

            int id = view.getId();
            if (id==R.id.SIMPLEbtn0){
                try {
                    results.setText(results.getText()+"0");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if(id==R.id.SIMPLEbtn1){
                try {
                    results.setText(results.getText()+"1");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if(id==R.id.SIMPLEbt2){
                try {
                    results.setText(results.getText()+"2");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if(id==R.id.SIMPLEbtn3){
                try {
                    results.setText(results.getText()+"3");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if(id==R.id.SIMPLEbtn4){
                try {
                    results.setText(results.getText()+"4");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if(id==R.id.SIMPLEbt5){
                try {
                    results.setText(results.getText()+"5");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if(id==R.id.SIMPLEbtn6){
                try {
                    results.setText(results.getText()+"6");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if(id==R.id.SIMPLEbtn7){
                try {
                    results.setText(results.getText()+"7");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if(id==R.id.SIMPLEbt8){
                try {
                    results.setText(results.getText()+"8");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if(id==R.id.SIMPLEbtn9){
                try {
                    results.setText(results.getText()+"9");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if(id==R.id.SIMPLEdeleteALL){
                try {
                    results.setText("");
                    resultsHitsory.setText("");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if(id==R.id.SIMPLEdelete){
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
            else if(id==R.id.SIMPLEmultiply){
                try {
                    int stringlen = results.length();
                    if(results.getText().charAt(stringlen - 1) != '\0' && results.getText().charAt(stringlen - 1) != '+' &&  results.getText().charAt(stringlen - 1) != '-' &&  results.getText().charAt(stringlen - 1) != '/' &&  results.getText().charAt(stringlen - 1) != '%' &&  results.getText().charAt(stringlen - 1) != '.' && results.getText().charAt(stringlen - 1) != '*'){
                        results.setText(results.getText()+"*");
                    }
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if(id==R.id.SIMPLEoduzimanje){
                int stringlen = results.length();
                try {
                    if(results.getText().charAt(stringlen - 1) != '+' &&  results.getText().charAt(stringlen - 1) != '-'  &&  results.getText().charAt(stringlen - 1) != '.'){
                        results.setText(results.getText()+"-");
                    }else if(results.getText().charAt(stringlen - 1) == '+'){
                        String myshit = results.getText().toString();
                        myshit = myshit.substring(0, myshit.length() - 1);
                        results.setText(myshit);
                        results.setText(results.getText()+"-");
                        Toast toast = Toast.makeText(getApplicationContext(),"Plus i minus daju minus :)",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if(id==R.id.SIMPLEdivideResidueButton){
                try {
                    int stringlen = results.length();
                    if(results.getText().charAt(stringlen - 1) != '\0' && results.getText().charAt(stringlen - 1) != '+' &&  results.getText().charAt(stringlen - 1) != '-' &&  results.getText().charAt(stringlen - 1) != '/' &&  results.getText().charAt(stringlen - 1) != '%' &&  results.getText().charAt(stringlen - 1) != '.' && results.getText().charAt(stringlen - 1) != '*'){
                        results.setText(results.getText()+"%");
                    }
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if(id==R.id.SIMPLEdivide){
                try {
                    int stringlen = results.length();
                    if(results.getText().charAt(stringlen - 1) != '\0' && results.getText().charAt(stringlen - 1) != '+' &&  results.getText().charAt(stringlen - 1) != '-' &&  results.getText().charAt(stringlen - 1) != '/' &&  results.getText().charAt(stringlen - 1) != '%' &&  results.getText().charAt(stringlen - 1) != '.' && results.getText().charAt(stringlen - 1) != '*'){
                        results.setText(results.getText()+"/");
                    }
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else if(id==R.id.SIMPLEadding){
                try {
                    int stringlen = results.length();
                    if(results.getText().charAt(stringlen - 1) != '\0' && results.getText().charAt(stringlen - 1) != '+' &&  results.getText().charAt(stringlen - 1) != '-' &&  results.getText().charAt(stringlen - 1) != '/' &&  results.getText().charAt(stringlen - 1) != '%' &&  results.getText().charAt(stringlen - 1) != '.' && results.getText().charAt(stringlen - 1) != '*'){
                        results.setText(results.getText()+"+");
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
            else if(id==R.id.SIMPLEequals) {
                    Double result = evaluator.evaluate(results.getText().toString());
                    ArrayList<String> currentValues = Paper.book().read("calculatorHistory");
                    resultsHitsory.setText(results.getText());
                    results.setText(results.getText() + "=");
                    if (result % 1 == 0) {
                        currentValues.add(results.getText() + " = " + (int) Math.round(result));
                        results.setText(Integer.toString((int) Math.round(result)));
                    } else {
                        currentValues.add(results.getText() + " = " + result);
                        results.setText(String.valueOf(result));
                    }
                    Paper.book().write("calculatorHistory", currentValues);

            }
            else if(id==R.id.SIMPLEdecimalPoint){
                try {
                    int stringlen = results.length();
                    if(results.getText().charAt(stringlen - 1) != '.'){
                        if(results.getText().charAt(stringlen - 1) == '\0' || results.getText().charAt(stringlen - 1) == '+' ||  results.getText().charAt(stringlen - 1) == '-' ||  results.getText().charAt(stringlen - 1) == '/' ||  results.getText().charAt(stringlen - 1) == '%' || results.getText().charAt(stringlen - 1) == '*'){
                            results.setText(results.getText()+"0.");
                        }else{
                            if(!isInsideDecimal(results.getText().toString())) {
                                results.setText(results.getText()+"0.");
                            }
                        }
                    }
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            else if(id==R.id.piButton){
                try {
                    results.setText(results.getText()+"pi");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            else if(id==R.id.sinButton){
                try {
                    int stringlen = results.length();
                    if(results.getText().charAt(stringlen - 1) != '\0' && results.getText().charAt(stringlen - 1) != '+' &&  results.getText().charAt(stringlen - 1) != '-' &&  results.getText().charAt(stringlen - 1) != '/' &&  results.getText().charAt(stringlen - 1) != '%' &&  results.getText().charAt(stringlen - 1) != '.' && results.getText().charAt(stringlen - 1) != '*'){
                        results.setText(results.getText()+"sin(");
                    }
                    else{
                        results.setText(results.getText()+"*sin(");
                    }
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            else if(id==R.id.cosButton){
                try {
                    int stringlen = results.length();
                    if(results.getText().charAt(stringlen - 1) == '\0' && results.getText().charAt(stringlen - 1) == '+' &&  results.getText().charAt(stringlen - 1) == '-' &&  results.getText().charAt(stringlen - 1) == '/' &&  results.getText().charAt(stringlen - 1) == '%' &&  results.getText().charAt(stringlen - 1) == '.' && results.getText().charAt(stringlen - 1) == '*'){
                        results.setText(results.getText()+"cos(");
                    }
                    else{
                        results.setText(results.getText()+"*cos(");
                    }
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            else if(id==R.id.tanButton){
                try {
                    int stringlen = results.length();
                    if(results.getText().charAt(stringlen - 1) == '\0' && results.getText().charAt(stringlen - 1) == '+' &&  results.getText().charAt(stringlen - 1) == '-' &&  results.getText().charAt(stringlen - 1) == '/' &&  results.getText().charAt(stringlen - 1) == '%' &&  results.getText().charAt(stringlen - 1) == '.' && results.getText().charAt(stringlen - 1) == '*'){
                        results.setText(results.getText()+"tan(");
                    }
                    else{
                        results.setText(results.getText()+"*tan(");
                    }
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            else if(id==R.id.absButton){
                try {
                    int stringlen = results.length();
                    if(results.getText().charAt(stringlen - 1) == '\0' && results.getText().charAt(stringlen - 1) == '+' &&  results.getText().charAt(stringlen - 1) == '-' &&  results.getText().charAt(stringlen - 1) == '/' &&  results.getText().charAt(stringlen - 1) == '%' &&  results.getText().charAt(stringlen - 1) == '.' && results.getText().charAt(stringlen - 1) == '*'){
                        results.setText(results.getText()+"abs(");
                    }
                    else{
                        results.setText(results.getText()+"*abs(");
                    }
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            else if(id==R.id.lnButton){
                try {
                    int stringlen = results.length();
                    if(results.getText().charAt(stringlen - 1) == '\0' && results.getText().charAt(stringlen - 1) == '+' &&  results.getText().charAt(stringlen - 1) == '-' &&  results.getText().charAt(stringlen - 1) == '/' &&  results.getText().charAt(stringlen - 1) == '%' &&  results.getText().charAt(stringlen - 1) == '.' && results.getText().charAt(stringlen - 1) == '*'){
                        results.setText(results.getText()+"ln(");
                    }
                    else{
                        results.setText(results.getText()+"*ln(");
                    }
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            else if(id==R.id.sqrtButton){
                try {
                    int stringlen = results.length();
                    if(results.getText().charAt(stringlen - 1) == '\0' && results.getText().charAt(stringlen - 1) == '+' &&  results.getText().charAt(stringlen - 1) == '-' &&  results.getText().charAt(stringlen - 1) == '/' &&  results.getText().charAt(stringlen - 1) == '%' &&  results.getText().charAt(stringlen - 1) == '.' && results.getText().charAt(stringlen - 1) == '*'){
                        results.setText(results.getText()+"sqrt(");
                    }
                    else{
                        results.setText(results.getText()+"*sqrt(");
                    }
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            else if(id==R.id.openBrackets){
                try {
                    results.setText(results.getText()+"(");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            else if(id==R.id.closeBrackets){
                try {
                    results.setText(results.getText()+")");
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            else if(id==R.id.toPowerButton){
                try {
                    int stringlen = results.length();
                    if(results.getText().charAt(stringlen - 1) != '\0' && results.getText().charAt(stringlen - 1) != '+' &&  results.getText().charAt(stringlen - 1) != '-' &&  results.getText().charAt(stringlen - 1) != '/' &&  results.getText().charAt(stringlen - 1) != '%' &&  results.getText().charAt(stringlen - 1) != '.' && results.getText().charAt(stringlen - 1) != '*'){
                        results.setText(results.getText()+"^");
                    }
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            else if(id==R.id.memoryButton){
                try {
                    if(results.length() != 0 && results.getText() != "0"){
                        Paper.book().write("calculatorHistory",results.getText());
                        memoryStatus.setVisibility(View.VISIBLE);
                    }
                    else{
                        Paper.book().write("calculatorHistory","");
                        memoryStatus.setVisibility(View.INVISIBLE);
                    }
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            else if(id==R.id.memoryClearButton){
                try {
                    results.setText(Paper.book().read("calculatorHistory"));
                }
                catch(Exception e){
                    Toast toast = Toast.makeText(getApplicationContext(),"Generic string error!",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }


        }






}