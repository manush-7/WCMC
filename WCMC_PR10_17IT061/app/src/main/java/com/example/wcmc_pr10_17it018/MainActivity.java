package com.example.wcmc_pr10_17it018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.Cursor;

public class MainActivity extends AppCompatActivity {

    Button in,del,viewa;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        in=findViewById(R.id.button5);
        del=findViewById(R.id.button6);
        viewa=findViewById(R.id.button7);

        db=openOrCreateDatabase("myDb", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(name VARCHAR,rollno VARCHAR);");

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Insert.class));
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Delete.class));
            }
        });

        viewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Viewa.class));
            }
        });
}


}
