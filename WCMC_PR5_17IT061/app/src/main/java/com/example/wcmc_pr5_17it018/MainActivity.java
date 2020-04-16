package com.example.wcmc_pr5_17it018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText uname, pass;
    Button login, Cancel;
    int counter = 2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = findViewById(R.id.editText);
        pass = findViewById(R.id.editText2);
        login = findViewById(R.id.button);
        Cancel = findViewById(R.id.button2);
        t1 = findViewById(R.id.textView4);
//        t1.setText(counter);

//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                String val1;
//                String val2;
//
//                val1 = uname.getText().toString();
//                val2 = pass.getText().toString();
//
//                String uname1 = "desaideep8998";
//                String pass1 = "dad8998";
//
//                if (counter == 0) {
//
//
//                    login.setEnabled(false);
//
//                }
//
//
//                if (val1.equals(uname1) && val2.equals(pass1)) {
//
//                    startActivity(new Intent(MainActivity.this, Main2Activity.class));
//
//
//                } else if (val1.equals("") || val2.equals("")) {
//
//                    Toast.makeText(getApplicationContext(), "Please Enter Your Details", Toast.LENGTH_LONG).show();
//
//                } else {
//                    counter--;
//                    startActivity(new Intent(MainActivity.this,Main3Activity.class));
//
//                }
//            }
//
//        });

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                System.exit(0);
            }
        });


    }
    }

