package com.example.hp.reminisce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class VideoPlaylistActivity extends AppCompatActivity {

    Button PlayVideo1,PlayVideo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_playlist);

        PlayVideo1=(Button) findViewById(R.id.Button_Play);
        PlayVideo2=(Button) findViewById(R.id.Button_Play2);

        PlayVideo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(VideoPlaylistActivity.this,"Playing 1st Video",Toast.LENGTH_SHORT).show();
                Intent toPlay=new Intent(VideoPlaylistActivity.this,VideoPlayActivity.class);
                toPlay.putExtra("video","1");
                startActivity(toPlay);
            }
        });

        PlayVideo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(VideoPlaylistActivity.this,"Playing 2nd Video",Toast.LENGTH_SHORT).show();
                Intent toPlay=new Intent(VideoPlaylistActivity.this,VideoPlayActivity.class);
                toPlay.putExtra("video","2");
                startActivity(toPlay);
            }
        });


    }
}
