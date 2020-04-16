package com.example.wcmc_pr9_17it018;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView w;
    EditText t1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button3);
        t1 = findViewById(R.id.editText2);
        w = findViewById(R.id.webview);
        w.loadUrl("https://www.google.com");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                w.getSettings().setLoadsImagesAutomatically(true);
                w.getSettings().setJavaScriptEnabled(true);
                w.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                w.loadUrl(t1.getText().toString());
            }
        });
    }
}
