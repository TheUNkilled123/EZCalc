package com.example.ezcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.WindowManager;

import java.util.ArrayList;

import io.paperdb.Paper;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Inicijalizacija Paper biblioteke i postavljanje podataka ako već ne postoje
        Paper.init(this);
        if (Paper.book().read("calculatorHistory") == null){
            ArrayList<String> empty=new ArrayList<String>();
            Paper.book().write("calculatorHistory",empty);
        }
        if (Paper.book().read("memory") == null){
            Paper.book().write("memory","");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);
        //UI/Fullscreen scaling fixes
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        int delay = 1000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {  //Kod u ovoj funkciji se izvede nakon što zadano vrijeme u delay istekne.
                Splash.this.startActivity(new Intent(Splash.this, MainActivity.class));
                Splash.this.finish();
            }
        },delay);


    }
}