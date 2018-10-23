package com.example.hp.reminisce;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Calendar;

public class DoctorProfileCreate extends AppCompatActivity {

    Button CreatePro;
    Calendar mCurrentDate;
    int day, month, year;
    TextInputLayout firstn, lastn, registerno, hospname, contactno;
    private DatabaseReference mDatabaseReference;

   // public SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile_create);

       // sp=getSharedPreferences("Login",MODE_PRIVATE);

//        if(sp.getBoolean("Logged",false))
//        {
//            gotoDoctor_Home();
//        }

        CreatePro = (Button) findViewById(R.id.Button_finishReg);
        Spinner dropdown = findViewById(R.id.Spinner);
        Spinner dropDegree = findViewById(R.id.Spinner_Degree);
        firstn=(TextInputLayout)findViewById(R.id.fn_id);
        lastn=(TextInputLayout)findViewById(R.id.ln_id);
        registerno=(TextInputLayout)findViewById(R.id.rn_id);
        hospname=(TextInputLayout)findViewById(R.id.hospital_id);
        contactno=(TextInputLayout)findViewById(R.id.mobile_id);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Doctor Profile");
//create a list of items for the spinner.
        String[] gender = new String[]{"Male", "Female"};
        String[] degree = new String[]{"Neurologist", "Geriatric psychiatrists", "geriatrician"};

//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, gender);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, degree);

//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        dropDegree.setAdapter(adapter2);
        final String getselectedoption = dropdown.getSelectedItem().toString();  //gender
        final String getDegree = dropDegree.getSelectedItem().toString();        //speciality

        CreatePro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname=firstn.getEditText().getText().toString();
                String lastname=lastn.getEditText().getText().toString();
                String registration_no=registerno.getEditText().getText().toString();
                String hospital_name=hospname.getEditText().getText().toString();
                String mobile_number=contactno.getEditText().getText().toString();
                mDatabaseReference.child(firstname).push().setValue("");
                mDatabaseReference.child(firstname).child("First").setValue(firstname);
                mDatabaseReference.child(firstname).child("Last").setValue(lastname);
                mDatabaseReference.child(firstname).child("rn").setValue(registration_no);
                mDatabaseReference.child(firstname).child("hosp").setValue(hospital_name);
                mDatabaseReference.child(firstname).child("Gender").setValue(getselectedoption);
                mDatabaseReference.child(firstname).child("Speciality").setValue(getDegree);
                mDatabaseReference.child(firstname).child("contact_number").setValue(mobile_number).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(DoctorProfileCreate.this,"Successful",Toast.LENGTH_SHORT).show();
                            Intent gotoDoctorHome=new Intent(DoctorProfileCreate.this,Doctor_Home.class);
                            startActivity(gotoDoctorHome);
                           // sp.edit().putBoolean("Logged",true).apply();

                           // gotoDoctor_Home();
                        }
                        else
                        {
                            Toast.makeText(DoctorProfileCreate.this,"Error",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

//        CreatePro.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final String Name=name.getText().toString();
//                final String Surname=surname.getText().toString();
//                if(isEmpty(name)) {
//                    name.setError("enter valid name");
//                    Toast.makeText(DoctorProfileCreate.this, "Enter valid name", Toast.LENGTH_SHORT).show();
//                }
//                if(isEmpty(surname)) {
//                    surname.setError("enter valid surname");
//                    Toast.makeText(DoctorProfileCreate.this, "Enter valid Surname", Toast.LENGTH_SHORT).show();
//                }
//                //if(Phone.length()!=10)
//                //  Toast.makeText(DoctorProfileCreate.this,"Enter valid mobile number",Toast.LENGTH_SHORT).show();
//
//                if(Name.length()>0 && Surname.length()>0 ) {
//                    Toast.makeText(DoctorProfileCreate.this, "Successfully created Profile", Toast.LENGTH_SHORT).show();
//                    mDatabaseReference.child("Name").setValue(Name);
//                    mDatabaseReference.child("Surname").setValue(Surname);
////                    mDatabaseReference.child("Contact").setValue(Phone);
//                    mDatabaseReference.child("Gender").setValue(getselectedoption);
////                    mDatabaseReference.child("Registration Number").setValue(RegNo1);
////                    mDatabaseReference.child("Name od Hospital").setValue(NameofHos);
//                    mDatabaseReference.child("Speciality").setValue(getDegree).addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            if(task.isSuccessful())
//                            {
//                                Toast.makeText(DoctorProfileCreate.this,"Successfully created profile",Toast.LENGTH_SHORT).show();
//                            }
//                            else
//                            {
//                                Toast.makeText(DoctorProfileCreate.this,"Error",Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//
//
//                    Intent homeIntent = new Intent(DoctorProfileCreate.this, Doctor_Home.class);
//                    startActivity(homeIntent);
//                }
//            }
//        });
//    }
//    boolean isEmpty(EditText text){
//        CharSequence str=text.getText().toString();
//        return TextUtils.isEmpty(str);
//
//
//    }


    }

//    private void gotoDoctor_Home() {
//        Intent toDocHomeAct=new Intent(DoctorProfileCreate.this,Doctor_Home.class);
//        startActivity(toDocHomeAct);
//
//    }
}