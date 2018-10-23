package com.example.hp.reminisce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reminder_homeActivity extends AppCompatActivity {

    Button setRem;
    Button addAct;
    Button viewAct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_home);

        setRem=(Button) findViewById(R.id.Button_SetRem1);
        setRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SetRemi=new Intent(Reminder_homeActivity.this,SetReminderActivity.class);
                startActivity(SetRemi);
            }
        });

        addAct=(Button) findViewById(R.id.button_add_act);
        addAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent add_act=new Intent(Reminder_homeActivity.this,Add_View_ReminderActivity.class);
                startActivity(add_act);
            }
        });

        viewAct=(Button) findViewById(R.id.button_view_act);
        viewAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent view_act=new Intent(Reminder_homeActivity.this,ReminderListActivity.class);
                startActivity(view_act);
            }
        });

    }
}
