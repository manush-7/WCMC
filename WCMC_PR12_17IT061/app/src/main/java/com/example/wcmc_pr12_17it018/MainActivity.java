package com.example.wcmc_pr12_17it018;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.RecognizerResultsIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    TextView a, b, op,c;
    private int aa,bb;
    private char opop;
    private int result1;
    Button result;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = findViewById(R.id.textView4);
        op = findViewById(R.id.textView3);
        b = findViewById(R.id.textView2);
        result=findViewById(R.id.button);
        textToSpeech=new TextToSpeech(this,this);
        c=findViewById(R.id.textView6);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
                startActivityForResult(intent, 10);

            }
        });
        op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
                startActivityForResult(intent, 30);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
                startActivityForResult(intent, 20);
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result1 = performCalculations();
                c.setText(String.valueOf(result1));
                textToSpeech.speak(String.valueOf(result1),TextToSpeech.QUEUE_ADD,null);
               }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            switch (requestCode) {
                case 10:
                    int intFound = getNumberFromResult(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS));
                    if (intFound != -1) {
                        aa = intFound;
                        a.setText(String.valueOf(intFound));
                    } else {
                        Toast.makeText(getApplicationContext(), "Sorry, I didn't catch that! Please try again", Toast.LENGTH_LONG).show();
                    }
                    break;
                case 20:
                    intFound = getNumberFromResult(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS));
                    if (intFound != -1) {
                        bb = intFound;
                        b.setText(String.valueOf(intFound));
                    } else {
                        Toast.makeText(getApplicationContext(), "Sorry, I didn't catch that! Please try again", Toast.LENGTH_LONG).show();
                    }
                    break;
                case 30:
                    char operatorFound = getOperatorFromResult(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS));
                    if (operatorFound != '0') {
                        opop = operatorFound;
                        op.setText(String.valueOf(operatorFound));
                    } else {
                        Toast.makeText(getApplicationContext(), "Sorry, I didn't catch that! Please try again", Toast.LENGTH_LONG).show();
                    }
            }
        } else {
            Toast.makeText(getApplicationContext(), "Failed to recognize speech!", Toast.LENGTH_LONG).show();
        }
    }

    private int getNumberFromResult(ArrayList<String> results) {
        for (String str : results) {
            if (getIntNumberFromText(str) != -1) {
                return getIntNumberFromText(str);
            }
        }
        return -1;
    }

    private char getOperatorFromResult(ArrayList<String> results) {
        for (String str : results) {
            if (getCharOperatorFromText(str) != '0') {
                return getCharOperatorFromText(str);
            }
        }
        return '0';
    }

    private int getIntNumberFromText(String strNum) {
        switch (strNum) {
            case "zero":
                return 0;
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
        }
        return -1;
    }



    private char getCharOperatorFromText(String strOper) {
        switch (strOper) {
            case "plus":
            case "add":
                return '+';
            case "minus":
            case "subtract":
                return '-';
            case "times":
            case "multiply":
                return '*';
            case "divided by":
            case "divide":
                return '/';
            case "power":
            case "raised to":
                return '^';
        }
        return '0';
    }



    private int performCalculations() {
        switch (opop) {
            case '+':
                return aa + bb;
            case '-':
                return aa - bb;
            case '*':
                return aa * bb;
            case '/':
                return aa / bb;
            case '^':
                return aa ^ bb;
        }
        return -999;
    }

    @Override
    public void onInit(int status) {

    }
}



