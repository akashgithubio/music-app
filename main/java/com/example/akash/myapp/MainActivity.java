package com.example.akash.myapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button play,pause,stop;
    int pos;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=(Button)findViewById(R.id.button);
        pause=(Button)findViewById(R.id.button2);
        stop=(Button)findViewById(R.id.button3);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button2:
                if(mp==null){
                mp=MediaPlayer.create(getApplicationContext(),R.raw.music);
                mp.start();}
                else if(!mp.isPlaying()) {
                    mp.seekTo(pos);
                    mp.start();
                }

                break;
            case R.id.button:
                if(mp!=null){
                mp.pause();
                pos=mp.getCurrentPosition();
                }
                break;
            case R.id.button3:
                if(mp!=null){
                mp.stop();
                mp=null;
                }
                break;

        }

    }
}
