package com.ebookfrenzy.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Home_Activity extends AppCompatActivity {

    ImageView imageview;
    Button buttonAppt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imageview = findViewById(R.id.previous);
        buttonAppt = findViewById(R.id.Appt);


        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Home_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buttonAppt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Home_Activity.this, First_Step.class);
                startActivity(intent);
            }
        });
    }
}