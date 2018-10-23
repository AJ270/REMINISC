package com.example.hp.reminisce;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserProfileCreateActivity extends AppCompatActivity {

    TextInputLayout firstn, lastn, emcontactno, docname, contactno;
    Button CreatePro;
    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_create);

        CreatePro=(Button)findViewById(R.id.User_finish_but_id);

        firstn=(TextInputLayout)findViewById(R.id.fn_id);
        lastn=(TextInputLayout)findViewById(R.id.ln_id);
        docname=(TextInputLayout)findViewById(R.id.Doc_name);
        contactno=(TextInputLayout)findViewById(R.id.mobile_id);
        emcontactno=(TextInputLayout)findViewById(R.id.em_mobile_id);

        final Spinner gender_spinner = (Spinner) findViewById(R.id.spinner_gender_id);
        final Spinner contact_spinner=(Spinner)findViewById(R.id.spinner_contact_id);


        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("User Profile");

        String[] gender = {"Female", "Male"};
        String[] contact={"Wife","Husband","Son","Daughter","Others"};

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, gender);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, contact);

        gender_spinner.setAdapter(adapter3);
        contact_spinner.setAdapter(adapter4);

        final String getgender = gender_spinner.getSelectedItem().toString();  //gender
        final String getcontact = contact_spinner.getSelectedItem().toString();        //contact

        CreatePro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname=firstn.getEditText().getText().toString();
                String lastname=lastn.getEditText().getText().toString();
                String em_mobile_no=emcontactno.getEditText().getText().toString();
                String doctor_name=docname.getEditText().getText().toString();
                String mobile_number=contactno.getEditText().getText().toString();

                mDatabaseReference.child(firstname).push().setValue("");
                mDatabaseReference.child(firstname).child("First").setValue(firstname);
                mDatabaseReference.child(firstname).child("Last").setValue(lastname);
                mDatabaseReference.child(firstname).child("Emergency").setValue(em_mobile_no);
                mDatabaseReference.child(firstname).child("DoctorName").setValue(doctor_name);
                mDatabaseReference.child(firstname).child("Gender").setValue(getgender);
                mDatabaseReference.child(firstname).child("Relative").setValue(getcontact);
                mDatabaseReference.child(firstname).child("MobileNo").setValue(mobile_number).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(UserProfileCreateActivity.this,"Successfully Registered",Toast.LENGTH_SHORT).show();
                            Intent gotoUserHome=new Intent(UserProfileCreateActivity.this,User_HomeActivity.class);
                            startActivity(gotoUserHome);
                        }
                        else
                        {
                            Toast.makeText(UserProfileCreateActivity.this,"Error",Toast.LENGTH_SHORT).show();

                        }
                    }
                });


            }
        });


        // tv1=(TextView)findViewById(R.id.tv11);
//        tv2=(TextView)findViewById(R.id.tv22);
//        tv3=(TextView)findViewById(R.id.tv33);
//        tv4=(TextView)findViewById(R.id.tv44);
//        firstname=(TextInputEditText) findViewById(R.id.fn_id);
//        lastname=(TextInputEditText) findViewById(R.id.ln_id);
////        mobileno=(EditText) findViewById(R.id.mobileno_id);
////        emergency_mobileno=(EditText) findViewById(R.id.emergency_mobileno_id);
//        finishbutton=(Button)findViewById(R.id.Doc_finish_but_id);
//        Spinner gender_spinner = (Spinner) findViewById(R.id.spinner_gender_id);
//        Spinner contact_spinner=(Spinner)findViewById(R.id.spinner_contact_id);
//        mDatabaseReference= FirebaseDatabase.getInstance().getReference().child("UserProfile");
//        String[] gender = {"Female", "Male"};
//        String[] contact={"Wife","Husband","Son","Daughter","Others"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, gender);
//        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, contact);
//        gender_spinner.setAdapter(adapter);
//        contact_spinner.setAdapter(adapter2);
//        final String getfn= firstname.getText().toString();
//        final String getln= lastname.getText().toString();
////        String getsmobileno= mobileno.getText().toString();
////        int getmobileno= Integer.parseInt(getsmobileno);
////        String getsemergency_mobileno= emergency_mobileno.getText().toString();
////        int getemergency_mobile_no= Integer.parseInt(getsemergency_mobileno);
//        final String getgender=gender_spinner.getSelectedItem().toString();
//        finishbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mDatabaseReference.child(getfn).child("Name").setValue(getfn);
//                mDatabaseReference.child(getfn).child("Surname").setValue(getln);
//                mDatabaseReference.child(getfn).child("Gender").setValue(getgender).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if(task.isSuccessful())
//                        {
//                            Toast.makeText(UserProfileCreateActivity.this,"Success",Toast.LENGTH_SHORT).show();
//                        }
//                        else
//                        {
//                            Toast.makeText(UserProfileCreateActivity.this,"Error",Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//                Intent gotouserhome=new Intent(UserProfileCreateActivity.this,User_HomeActivity.class);
//                startActivity(gotouserhome);
//
//            }
//        });


    }
}
