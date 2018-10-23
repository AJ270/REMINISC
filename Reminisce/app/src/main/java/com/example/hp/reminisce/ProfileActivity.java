package com.example.hp.reminisce;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    String username,email,photo;

    Uri url;

    FirebaseAuth mAuth;

    TextView u,e;
    Button logout;

    ImageView i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        u=(TextView)findViewById(R.id.username_id);
        e=(TextView)findViewById(R.id.email_id);
        logout=(Button)findViewById(R.id.button_id);
        i=(ImageView)findViewById(R.id.photo_id);

        logout.setOnClickListener(this);

        mAuth=FirebaseAuth.getInstance();


        email=getIntent().getStringExtra("email");
        username=getIntent().getStringExtra("username");
        photo=getIntent().getStringExtra("url");

        url=Uri.parse(photo);

        u.setText(username);
        e.setText(email);

        Picasso.get().load("url").into(i);

    }

    @Override
    public void onClick(View v) {

        mAuth.signOut();

        Intent gotoDocloginActivity=new Intent(ProfileActivity.this,Doctor_Login.class);
        startActivity(gotoDocloginActivity);

    }

    public void onStart() {


        super.onStart();

        FirebaseUser user=mAuth.getCurrentUser();

        if(user==null)
        {
            Intent gotoDocLoginActivity=new Intent(ProfileActivity.this,Doctor_Login.class);
            startActivity(gotoDocLoginActivity);
        }
    }
}
