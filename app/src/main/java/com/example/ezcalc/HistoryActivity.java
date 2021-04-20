package com.example.ezcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import io.paperdb.Paper;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        //UI/Fullscreen scaling fixes
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageButton back = findViewById(R.id.Back);
        ImageButton deleteHistory = findViewById(R.id.deleteHistory);

        setView();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HistoryActivity.this.finish();
            }
        });

        deleteHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> empty=new ArrayList<String>();
                Paper.book().write("calculatorHistory",empty);
                setView();
            }
        });
    }



public void setView(){
    ListView list = findViewById(R.id.list);

    ArrayList<String> stringArrayValues = Paper.book().read("calculatorHistory");
    ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringArrayValues){
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            // Get the Item from ListView
            View view = super.getView(position, convertView, parent);

            // Initialize a TextView for ListView each Item
            TextView tv = (TextView) view.findViewById(android.R.id.text1);

            // Set the text color of TextView (ListView Item)
            tv.setMaxWidth(200);
            tv.setTextColor(Color.WHITE);
            tv.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            tv.setAutoSizeTextTypeUniformWithConfiguration(1, 29, 1, TypedValue.COMPLEX_UNIT_DIP);


            // Generate ListView Item using TextView
            return view;
        }
    };
    list.setAdapter(listAdapter);
}
}