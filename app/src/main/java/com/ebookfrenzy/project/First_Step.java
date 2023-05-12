package com.ebookfrenzy.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class First_Step extends AppCompatActivity {

    CheckBox checkBox, checkBox2, checkBox3, checkBox4, checkBox5;
    Button button_first;
    DBmain dbmain;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_step);

        dbmain = new DBmain(First_Step.this);
        findId();
        insertData();
    }

    private void findId() {
        button_first = (Button) findViewById(R.id.button_first);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
    }

    private void insertData() {
        button_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase = dbmain.getWritableDatabase();
                ContentValues contentValues = new ContentValues();

                CheckBox cb1 = findViewById(R.id.checkBox);
                CheckBox cb2 = findViewById(R.id.checkBox2);
                CheckBox cb3 = findViewById(R.id.checkBox3);
                CheckBox cb4 = findViewById(R.id.checkBox4);
                CheckBox cb5 = findViewById(R.id.checkBox5);

                if (cb1 != null)
                {
                    boolean isChecked = cb1.isChecked();
                    contentValues.put("sub1", checkBox.getText().toString());
                }
                if (cb2 != null)
                {
                    boolean isChecked = cb2.isChecked();
                    contentValues.put("sub2", checkBox2.getText().toString());
                }
                if (cb3 != null)
                {
                    boolean isChecked = cb3.isChecked();
                    contentValues.put("sub3", checkBox3.getText().toString());
                }
                if (cb4 != null)
                {
                    boolean isChecked = cb4.isChecked();
                    contentValues.put("sub4", checkBox4.getText().toString());
                }
                if (cb5 != null)
                {
                    boolean isChecked = cb5.isChecked();
                    contentValues.put("sub5", checkBox5.getText().toString());
                }

                Long rec = sqLiteDatabase.insert("history", null, contentValues);
                if (rec != null) {
                    Toast.makeText(First_Step.this, "data inserted", Toast.LENGTH_SHORT);
                } else {
                    Toast.makeText(First_Step.this, "data not inserted", Toast.LENGTH_SHORT);
                }
                Intent intent = new Intent(First_Step.this, Second_Step.class);
                startActivity(intent);
            }
        });
    }
}