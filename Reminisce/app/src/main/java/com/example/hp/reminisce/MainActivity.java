package com.example.hp.reminisce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Button Doctor_Main,User_Main;
    ImageButton Doctor_main,User_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Doctor_main=(ImageButton) findViewById(R.id.ImageButton_Doctor_Main);//to direct to doctor's login page
        User_main=(ImageButton) findViewById(R.id.ImageButton_User_Main);//to direct to user's login page

        //Doctor's login Intent
        Doctor_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ToDocLogin=new Intent(MainActivity.this,Doctor_Login.class);
                startActivity(ToDocLogin);
            }
        });

        //User's login Intent
        User_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ToUserLogin=new Intent(MainActivity.this,User_Login.class);
                startActivity(ToUserLogin);

            }
        });
    }
}
