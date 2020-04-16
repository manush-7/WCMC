package com.example.wcmc_pr7_17it018;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout c1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1=findViewById(R.id.v1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.optionmenu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.item1:
                c1.setBackgroundColor(Color.RED);
                Toast.makeText(getApplicationContext(),"RED COLOR",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item2:
                c1.setBackgroundColor(Color.GREEN);
                Toast.makeText(getApplicationContext(),"GREEN COLOR",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item3:
                c1.setBackgroundColor(Color.BLUE);
                Toast.makeText(getApplicationContext(),"BLUE COLOR",Toast.LENGTH_SHORT).show();
                return true;

            default :
                return super.onContextItemSelected(item);

        }
    }
}
