package com.example.hp.reminisce;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.math.BigInteger;

public class Doctor_recommendationActivity extends AppCompatActivity {

    Button call1,call2,call3,call4,call5,call6;
    TextView doctorhead,doc_info;
    private DatabaseReference mDatabaseReference;
    BigInteger mobileno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_recommendation);

        call1=(Button)findViewById(R.id.doc1);
        call2=(Button)findViewById(R.id.doc2);
        call3=(Button)findViewById(R.id.doc3);
        call4=(Button)findViewById(R.id.doc4);
        call5=(Button)findViewById(R.id.doc5);
        call6=(Button)findViewById(R.id.doc6);
        doctorhead=(TextView)findViewById(R.id.textView12);
        doc_info=(TextView)findViewById(R.id.textView20);
        mDatabaseReference= FirebaseDatabase.getInstance().getReference().child("Doctor Profile");
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name=dataSnapshot.child("First").getValue(String.class);
                String hospital_name=dataSnapshot.child("hosp").getValue(String.class);
                String speciality=dataSnapshot.child("Speciality").getValue(String.class);
                String contact=dataSnapshot.child("contact_number").getValue(String.class);
                mobileno=new BigInteger(contact);
                doctorhead.setText("                   DR."+name);
                doc_info.setText("\n " + speciality + "\n" + hospital_name + "\n Phone" + mobileno);
               // doc_info.setText("\n "+hospital_name);
               // doc_info.setText("\n Phone"+mobileno);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Intent.ACTION_DIAL);
                i1.setData(Uri.parse("tel:1234567890"));
                if (i1.resolveActivity(getPackageManager()) != null) {
                    startActivity(i1);
                }



            }
        });
        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(Intent.ACTION_DIAL);
                i2.setData(Uri.parse("tel:1234567890"));
                if (i2.resolveActivity(getPackageManager()) != null) {
                    startActivity(i2);
                }

            }
        });
        call3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Intent.ACTION_DIAL);
                i3.setData(Uri.parse("tel:1234567890"));
                if (i3.resolveActivity(getPackageManager()) != null) {
                    startActivity(i3);

                }
            }
        });
        call4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(Intent.ACTION_DIAL);
                i4.setData(Uri.parse("tel:1234567890"));
                if (i4.resolveActivity(getPackageManager()) != null) {
                    startActivity(i4);

                }

            }
        });
        call5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(Intent.ACTION_DIAL);

                i5.setData(Uri.parse("tel:123456"));
                if (i5.resolveActivity(getPackageManager()) != null) {
                    startActivity(i5);

                }
            }
        });
        call6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6 = new Intent(Intent.ACTION_DIAL);
                i6.setData(Uri.parse("tel:1234567890"));
                if (i6.resolveActivity(getPackageManager()) != null) {
                    startActivity(i6);

                }
            }
        });
    }
}
