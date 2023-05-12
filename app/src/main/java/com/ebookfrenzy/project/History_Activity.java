package com.ebookfrenzy.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class History_Activity extends AppCompatActivity {
    Button displayer;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        //display data
        displayer = findViewById(R.id.display);
        displayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                startActivity(new Intent(History_Activity.this, DisplayData.class));
            }
        });
        ImageView imageview;

        imageview = findViewById(R.id.previous);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(History_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}