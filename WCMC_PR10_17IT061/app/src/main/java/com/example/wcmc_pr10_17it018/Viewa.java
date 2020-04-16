package com.example.wcmc_pr10_17it018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Viewa extends AppCompatActivity {


    TextView t1;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewa);

        t1=findViewById(R.id.textView4);

        db=openOrCreateDatabase("myDb", Context.MODE_PRIVATE,null);

        Cursor c=db.rawQuery("SELECT * FROM student",null);
        if (c.getCount()==0){
            Toast.makeText(getApplicationContext(),"No Data Found",Toast.LENGTH_SHORT).show();
        }

        StringBuffer result=new StringBuffer();
        while (c.moveToNext()){
            result.append("Name:"+c.getString(0)+"\n");
            result.append("Roll No:"+c.getString(1)+"\n\n");
        }
        t1.setText(result.toString());




        
    }
}
