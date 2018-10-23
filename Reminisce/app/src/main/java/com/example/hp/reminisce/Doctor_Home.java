package com.example.hp.reminisce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Doctor_Home extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    Button ViewProfile,ViewPatients,Recommendation,statistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__home);

        //START THE INTENT HERE
        Intent i=new Intent(getApplicationContext(),PopActivity.class);
        startActivity(i);


        ViewProfile=(Button) findViewById(R.id.Button_Profile);
        ViewPatients=(Button) findViewById(R.id.Button_ShowPatients);
        Recommendation=(Button) findViewById(R.id.Button_Recom);
        statistics=(Button) findViewById(R.id.Button_Statistics);

        // .setBackground(@Dra);

        ViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new intent to join the profile view
            }
        });
        ViewPatients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gotopatientsprofile=new Intent(Doctor_Home.this,Patient_list.class);
                startActivity(gotopatientsprofile);

                //new intent to show list of patients
            }
        });
        Recommendation.setOnClickListener(new View.OnClickListener() {     //goes toDoctor_recommendation.java
            @Override
            public void onClick(View v) {
                Intent doc_recommendation=new Intent(Doctor_Home.this,Doctor_recommendationActivity.class);
                startActivity(doc_recommendation);

                //new intent to join the recommendation view
            }
        });
        statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent statics_activity=new Intent(Doctor_Home.this,StatisticsActivity.class);
                startActivity(statics_activity);

                //new intent to join the statistics view
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(backPressedTime+2000>System.currentTimeMillis()){
            backToast.cancel();
            Toast.makeText(getBaseContext(),"exiting",Toast.LENGTH_SHORT).show();
            finish();
            System.exit(0);
            super.onBackPressed();
        }
        else{
            backToast=Toast.makeText(getBaseContext(),"enter back again to exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime=System.currentTimeMillis();
    }
}
