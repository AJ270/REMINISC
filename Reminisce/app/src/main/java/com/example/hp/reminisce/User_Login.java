package com.example.hp.reminisce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class User_Login extends AppCompatActivity {
    Button userregisterbutton,userloginbutton;
    EditText email,password;
    String emailID,passwordID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__login);
        userregisterbutton=(Button)findViewById(R.id.User_register);
        userloginbutton=(Button)findViewById(R.id.Button_UserLogin);
        email=(EditText) findViewById(R.id.EditText_UserEmail);
        password=(EditText) findViewById(R.id.EditText_UserPassword);
        userregisterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ToRegisterUser=new Intent(User_Login.this,UserProfileCreateActivity.class);
                startActivity(ToRegisterUser);

            }
        });

        userloginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ToUserHome=new Intent(User_Login.this,User_HomeActivity.class);
                startActivity(ToUserHome);
            }
        });
    }
}
