package com.example.ezcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        int delay = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {  //Kod u ovoj funkciji se izvede nakon što zadano vrijeme u delay istekne.
                Splash.this.startActivity(new Intent(Splash.this, MainActivity.class));
                Splash.this.finish();
            }
        },delay);


    }
}