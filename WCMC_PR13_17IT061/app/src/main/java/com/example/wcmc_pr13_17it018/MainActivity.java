package com.example.wcmc_pr13_17it018;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PictureInPictureParams;
import android.content.res.Configuration;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Rational;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {

    String src="/storage/emulated/0/WhatsApp/Media/WhatsApp Video/VID-20200126-WA0002.mp4";
    Button b1;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView videoView =(VideoView)findViewById(R.id.videoView);
        actionBar=getSupportActionBar();
    b1=findViewById(R.id.button);


        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);



        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse(src));
        videoView.requestFocus();
        videoView.start();

        b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Display display=getWindowManager().getDefaultDisplay();
            Point size =new Point();
            display.getSize(size);
            int width=size.x;
            int height=size.y;

            Rational aspectRatio=new Rational(width,height);
            PictureInPictureParams.Builder mPictureInParamsBuilder=new PictureInPictureParams.Builder();
        mPictureInParamsBuilder.setAspectRatio(aspectRatio).build();

                enterPictureInPictureMode(mPictureInParamsBuilder.build());
            }
        }
    });
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        if(isInPictureInPictureMode){
            actionBar.hide();
    }else{
actionBar.show();
    }

    }
}
