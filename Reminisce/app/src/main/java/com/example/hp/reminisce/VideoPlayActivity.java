package com.example.hp.reminisce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoPlayActivity extends AppCompatActivity {

    VideoView video;
    Button play,pause,seekForward,seekBack,nextVideo,prevVideo;
    TextView timeOn,timeRem;
    String getVideoNumber;
    int increment=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);

        video=(VideoView) findViewById(R.id.VideoView_Video);
        play=(Button) findViewById(R.id.Button_Playstart);
        pause=(Button) findViewById(R.id.Button_Pausevideo);
        seekForward=(Button) findViewById(R.id.Button_SeekForward);
        seekBack=(Button) findViewById(R.id.Button_seekBack);
        nextVideo=(Button) findViewById(R.id.Button_NextVideo);
        prevVideo=(Button) findViewById(R.id.Button_PrevVideo);
        timeRem=(TextView) findViewById(R.id.TextView_TimeRem);
        timeOn=(TextView) findViewById(R.id.TextView_TimeOn);

        MediaController MC=new MediaController(this);
        final String videoNumber1="android.resource://"+getPackageName()+"/"+R.raw.videoforapp;
        final String videoNumber2="android.resource://"+getPackageName()+"/"+R.raw.video2forapp;


        Intent i=getIntent();

        getVideoNumber=i.getExtras().getString("video","1");

        if(getVideoNumber.equals("1")){
            video.setVideoPath(videoNumber1);
            increment=0;
        }
        else{
            video.setVideoPath(videoNumber2);
            increment=1;
        }
        video.start();
        pause.setVisibility(View.VISIBLE);
        play.setVisibility(View.INVISIBLE);

        //   timeOn.setText(video.getCurrentPosition()/1000+":"+video.getCurrentPosition()%1000);
        //  float tRem=video.getDuration()-video.getCurrentPosition();
        //  timeRem.setText((int)tRem+":"+tRem%100);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video.start();
                pause.setVisibility(View.VISIBLE);
                play.setVisibility(View.INVISIBLE);
                // float tRem=video.getDuration()-video.getCurrentPosition();
                // timeRem.setText((int)tRem+":"+tRem%100);
                // timeOn.setText(video.getCurrentPosition()/1000+":"+video.getCurrentPosition()%1000);
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video.pause();
                pause.setVisibility(View.INVISIBLE);
                play.setVisibility(View.VISIBLE);
                int tRem=video.getDuration()-video.getCurrentPosition();
                tRem=tRem/1000;
                Toast.makeText(VideoPlayActivity.this,"Time Remainig:"+tRem+" seconds",Toast.LENGTH_SHORT).show();
                //   double tRem=video.getDuration()-video.getCurrentPosition();
                //  timeRem.setText((int)tRem/1000+":"+tRem%100);
                //  timeOn.setText(video.getCurrentPosition()/1000+":"+video.getCurrentPosition()%1000);
                //  timeOn.clearComposingText();
            }
        });

        nextVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment++;
                if(increment%2==1){

                    video.setVideoPath(videoNumber2);
                    video.start();
                    pause.setVisibility(View.VISIBLE);
                    play.setVisibility(View.INVISIBLE);
                }
                else{
                    video.setVideoPath(videoNumber1);
                    video.start();
                    pause.setVisibility(View.VISIBLE);
                    play.setVisibility(View.INVISIBLE);
                }
                //  Toast.makeText(Video.this,"Playlist ends here",Toast.LENGTH_SHORT).show();


            }
        });

        prevVideo.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment++;
                if(increment%2==0){
                    video.setVideoPath(videoNumber1);
                    video.start();
                    pause.setVisibility(View.VISIBLE);
                    play.setVisibility(View.INVISIBLE);
                }
                else {
                    video.setVideoPath(videoNumber2);
                    video.start();
                    pause.setVisibility(View.VISIBLE);
                    play.setVisibility(View.INVISIBLE);
                }
                //     Toast.makeText(Video.this,"No previous video",Toast.LENGTH_SHORT).show();
//
                //  }

            }
        }));



        seekForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video.seekTo(video.getCurrentPosition()+2000);
            }
        });


        seekBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video.seekTo(video.getCurrentPosition()-2000);
            }
        });
    }
}
