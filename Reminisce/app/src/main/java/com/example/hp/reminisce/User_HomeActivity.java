package com.example.hp.reminisce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class User_HomeActivity extends AppCompatActivity {

    Button Rem;
    Button videobutton;
    Button imagequizbutton;
    Button navigationbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__home);

        Rem=(Button) findViewById(R.id.Button_Rem);
        videobutton=(Button)findViewById(R.id.video_but_id2);
        imagequizbutton=(Button)findViewById(R.id.quiz_but_id);
        navigationbutton=(Button)findViewById(R.id.navigation_id);

        Rem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Userlistpage1=new Intent(User_HomeActivity.this,Reminder_homeActivity.class);
                startActivity(Userlistpage1);
            }
        });

        videobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Userlistpage2=new Intent(User_HomeActivity.this,VideoPlaylistActivity.class);
                startActivity(Userlistpage2);
            }
        });
        imagequizbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(User_HomeActivity.this,ImageQuizActivity.class);
                startActivity(i);
            }
        });

        navigationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gotonavigation=new Intent(User_HomeActivity.this,Navigation_Home_Activity.class);
                startActivity(gotonavigation);
            }
        });
    }
}
