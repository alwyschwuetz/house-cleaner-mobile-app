package com.ebookfrenzy.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Second_Step extends AppCompatActivity {

    DBmain dbmain;
    SQLiteDatabase sqLiteDatabase;
    Button button_second;
    CheckBox checkBox6, checkBox7, checkBox8, checkBox9, checkBox10;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_step);
        dbmain = new DBmain(Second_Step.this);
        findId();
        insertData();
    }

    private void findId() {
        button_second = (Button) findViewById(R.id.button_second);
        checkBox6 = (CheckBox) findViewById(R.id.checkBox6);
        checkBox7 = (CheckBox) findViewById(R.id.checkBox7);
        checkBox8 = (CheckBox) findViewById(R.id.checkBox8);
        checkBox9 = (CheckBox) findViewById(R.id.checkBox9);
        checkBox10 = (CheckBox) findViewById(R.id.checkBox10);
        editText = (EditText) findViewById(R.id.editText);
    }

    private void insertData() {
        button_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLiteDatabase = dbmain.getWritableDatabase();
                ContentValues contentValues = new ContentValues();

                CheckBox cb6 = findViewById(R.id.checkBox6);
                CheckBox cb7 = findViewById(R.id.checkBox7);
                CheckBox cb8 = findViewById(R.id.checkBox8);
                CheckBox cb9 = findViewById(R.id.checkBox9);
                CheckBox cb10 = findViewById(R.id.checkBox10);

                if (cb6 != null){
                    boolean isChecked = cb6.isChecked();
                    contentValues.put("sub6", checkBox6.getText().toString());
                }
                if (cb7 != null)
                {
                    boolean isChecked = cb7.isChecked();
                    contentValues.put("sub7", checkBox7.getText().toString());
                }
                if (cb8 != null)
                {
                    boolean isChecked = cb8.isChecked();
                    contentValues.put("sub8", checkBox8.getText().toString());
                }
                if (cb9 != null)
                {
                    boolean isChecked = cb9.isChecked();
                    contentValues.put("sub9", checkBox9.getText().toString());
                }
                if (cb10 != null)
                {
                    boolean isChecked = cb10.isChecked();
                    contentValues.put("sub10", checkBox10.getText().toString());
                }

                Long rec = sqLiteDatabase.insert("history", null, contentValues);
                if (rec != null) {
                    Toast.makeText(Second_Step.this, "data inserted", Toast.LENGTH_SHORT);
                } else {
                    Toast.makeText(Second_Step.this, "data not inserted", Toast.LENGTH_SHORT);
                }
                Intent intent = new Intent(Second_Step.this, Third_Step.class);
                startActivity(intent);
            }
        });
    }
}