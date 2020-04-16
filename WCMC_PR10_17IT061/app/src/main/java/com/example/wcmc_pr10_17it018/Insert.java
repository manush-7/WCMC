package com.example.wcmc_pr10_17it018;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

public class Insert extends AppCompatActivity {

   EditText name,rollno;
   Button insert;
   SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        name=findViewById(R.id.editText);
        rollno=findViewById(R.id.editText2);
        insert=findViewById(R.id.button);

        db=openOrCreateDatabase("myDb", Context.MODE_PRIVATE,null);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name.getText().toString().trim().length()==0 || rollno.getText().toString().trim().length()==0){
                    Toast.makeText(getApplicationContext(),"Please Enter Details", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    try{
                    db.execSQL("INSERT INTO student VALUES('"+name.getText()+"','"+rollno.getText()+"');");
                    Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_SHORT).show();
                }
                    catch (SQLException e){
                        Toast.makeText(getApplicationContext(),"Operation Not Successful",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });





    }
}
