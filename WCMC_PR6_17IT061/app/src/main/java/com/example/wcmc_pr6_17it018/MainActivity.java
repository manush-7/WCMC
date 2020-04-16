package com.example.wcmc_pr6_17it018;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
//import android.hardware.camera2.CameraAccessException;
//import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button On, Off;

//    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        On = findViewById(R.id.button);
        Off = findViewById(R.id.button2);


        On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                CameraManager camera = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
//                try {
//                    String CameraId = camera.getCameraIdList()[0];
//                    camera.setTorchMode(CameraId, true);
//                } catch (CameraAccessException e) {
//                    e.printStackTrace();
//                }

                Toast.makeText(getApplicationContext(), "Flash On", Toast.LENGTH_SHORT).show();

            }
        });

        Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                CameraManager camera =
//                        (CameraManager) getSystemService(Context.CAMERA_SERVICE);
//                try {
//                    String CameraId = camera.getCameraIdList()[0];
//                    camera.setTorchMode(CameraId, false);
//                } catch (CameraAccessException e) {
//                    e.printStackTrace();
//                }

                Toast.makeText(getApplicationContext(), "Flash Off", Toast.LENGTH_SHORT).show();
            }

        });


    }
}
