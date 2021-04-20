package com.example.ezcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.WindowManager;

import java.util.ArrayList;

import io.paperdb.Paper;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Splash extends AppCompatActivity {
    //Inicijalizacija varijabli i elemenata na zaslonu
    int logoDuration = 500;
    int textDuration = 200;
    int splashDelay = 800;
    private ImageView imageView;
    private TextView textView;
    private View view;

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
        setContentView(R.layout.activity_splash);

        //UI/Fullscreen scaling fixes
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageView = (ImageView) findViewById(R.id.AnimiranLogo);
        textView = (TextView) findViewById(R.id.ezcalc);

        handleAnimation(view);
    }

    public void handleAnimation (View view) {

        PropertyValuesHolder logoMove = PropertyValuesHolder.ofFloat("y",1000f,-75f);
        PropertyValuesHolder logoScaleX = PropertyValuesHolder.ofFloat(View.SCALE_X,0.05f,0.7f);
        PropertyValuesHolder logoScaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y,0.05f,0.7f);

        ObjectAnimator logo = ObjectAnimator.ofPropertyValuesHolder(imageView,logoMove,logoScaleX,logoScaleY).setDuration(logoDuration);

        ObjectAnimator ezcalcNull = ObjectAnimator.ofFloat(textView,View.ALPHA,1.0f, 0.0f).setDuration(0);
        ObjectAnimator ezcalcAlpha = ObjectAnimator.ofFloat(textView,View.ALPHA, 0.0f, 1.0f).setDuration(textDuration);


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ezcalcNull,logo,ezcalcAlpha);
        animatorSet.start();

        new Handler().postDelayed(()-> { //Kod u ovoj funkciji se izvede nakon što zadano vrijeme splashDelay istekne.
            Splash.this.startActivity(new Intent(Splash.this, MainActivity.class));
            Splash.this.finish();
        }, splashDelay);
    }
}