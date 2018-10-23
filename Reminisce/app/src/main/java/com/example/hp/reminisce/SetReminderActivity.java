package com.example.hp.reminisce;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import static java.lang.Integer.parseInt;

public class SetReminderActivity extends AppCompatActivity {

    Button b,stop;
    EditText e1, e2, e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_reminder);

        e1=(EditText) findViewById(R.id.EditText_Hr);
        e2=(EditText) findViewById(R.id.EditText_Min);
        e3=(EditText) findViewById(R.id.EditText_Sec);
        b = (Button) findViewById(R.id.Button_SetAlarm);
        stop=(Button) findViewById(R.id.Button_User_Stop);
        Toast.makeText(SetReminderActivity.this,"Activity started",Toast.LENGTH_SHORT).show();

        Intent notificationIntent = new Intent(SetReminderActivity.this, AlarmReceiver.class);
        final PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(SetReminderActivity.this,"Reminder set",Toast.LENGTH_SHORT);

                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);


                Editable s1 = (Editable) e1.getText();
                Editable s2 = (Editable) e2.getText();
                Editable s3 = (Editable) e3.getText();
                int ei1 = parseInt(s1.toString());
                int ei2 = parseInt(s2.toString());
                int ei3 = parseInt(s3.toString());
                Calendar cal = Calendar.getInstance();
                //     cal.add(Calendar.SECOND, 5);
                cal.set(Calendar.HOUR_OF_DAY, ei1);
                cal.set(Calendar.MINUTE, ei2);
                cal.set(Calendar.SECOND, 0);
                //    alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 1000 * ei3, broadcast);
                Toast.makeText(SetReminderActivity.this,"Reminder set "+s1.toString()+" "+s2.toString(),Toast.LENGTH_SHORT).show();
            }    });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                alarmManager.cancel(broadcast);
                Toast.makeText(SetReminderActivity.this,"Reminder stopped ",Toast.LENGTH_SHORT).show();
            }    });
    }
}
