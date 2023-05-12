package com.ebookfrenzy.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DisplayData extends AppCompatActivity {
    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;
    ListView listView;
    String[]name,name2;
    int[]id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        dBmain=new DBmain(DisplayData.this);
        findId();
        displayData();
    }

    private void displayData() {
        sqLiteDatabase=dBmain.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from history",null);
        listView=findViewById(R.id.lv);
        if(cursor.getCount()>0){
            id=new int[cursor.getCount()];
            name=new String[cursor.getCount()];
            name2=new String[cursor.getCount()];
            int i=0;
            while(cursor.moveToNext()){
                id[i]=cursor.getInt(0);
                name[i]=cursor.getString(1);
                name2[i]=cursor.getString(2);
                i++;
            }
            Custom custom=new Custom();
            listView.setAdapter(custom);
        }
    }

    private void findId() {listView=findViewById(R.id.lv);}

    private class Custom extends BaseAdapter {
        @Override
        public int getCount() {
            return name.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView7, textView9;
            convertView= LayoutInflater.from(DisplayData.this).inflate(R.layout.singledata, parent, false);
            textView7=(TextView) convertView.findViewById(R.id.textView7);
            textView9=(TextView) convertView.findViewById(R.id.textView9);

            textView7.setText(name[position]);
            textView9.setText(name2[position]);
            return convertView;
        }
    }
}