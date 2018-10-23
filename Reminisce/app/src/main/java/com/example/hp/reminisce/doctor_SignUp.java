package com.example.hp.reminisce;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class doctor_SignUp extends AppCompatActivity {

   // TextInputLayout mail, password, confirm_password;

    EditText et1,et2;
    Button Next;

    FirebaseAuth mAuth;
    // private DatabaseReference mDatabaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__sign_up);
      //  mail = (TextInputLayout) findViewById(R.id.TextInputEditText_Doctor_RegUsername);
        //password = (TextInputLayout) findViewById(R.id.TextInputEditText_Doctor_RegPassword);
        //confirm_password = (TextInputLayout) findViewById(R.id.TextInutLayout_Doctor_ConfPassword);

        et1=(EditText)findViewById(R.id.email_id);
        et2=(EditText)findViewById(R.id.password_id);
        Next = (Button) findViewById(R.id.Button_Doc_Next);
        mAuth=FirebaseAuth.getInstance();

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regemail=et1.getText().toString().trim();
                String regpass=et2.getText().toString().trim();

                RegUser(regemail,regpass);

            }
        });

//        Next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent nextPageIntent = new Intent(doctor_SignUp.this, DoctorProfileCreate.class);
//                startActivity(nextPageIntent);
//            }
//        });
      /*  Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mailname="";
                mailname= mail.getEditText().getText().toString();
                String pass ="";
                pass= password.getEditText().getText().toString();
                String confirm_pass ="";
                confirm_pass= confirm_password.getEditText().getText().toString();
             //   if (isEmpty(password) || isEmpty(confirm_password)) {
               //     Toast.makeText(doctor_SignUp.this, "enter a password", Toast.LENGTH_SHORT).show();
                //} else if (isEmail(mail) == false) {
              //      mail.setError("enter valid email!");
               // } else if (pass.equals(confirm_pass) && mailname.length() > 0) {
                 //   Toast.makeText(doctor_SignUp.this, "Correct", Toast.LENGTH_SHORT).show();
              //  } else {
               //     Toast.makeText(doctor_SignUp.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                //}
          //    mDatabaseReference= FirebaseDatabase.getInstance().getReference().child("Doctor Profile");
           //     mDatabaseReference.child("Email").setValue(mailname);
//                mDatabaseReference.child("Password").setValue(pass).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if(task.isSuccessful()) {
//                            Toast.makeText(doctor_SignUp.this, "Successfully completed", Toast.LENGTH_SHORT).show();
//                        }
//                        else
//                        {
//                            Toast.makeText(doctor_SignUp.this,"Error",Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
                Intent nextPageIntent = new Intent(doctor_SignUp.this, DoctorProfileCreate.class);
                startActivity(nextPageIntent);

            }
        });
    }


    boolean isEmail(EditText eid) {
        CharSequence email = eid.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }*/
    }

    private void RegUser(String regemail, final String regpass) {

        mAuth.createUserWithEmailAndPassword(regemail,regpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(doctor_SignUp.this,"Successfully registered",Toast.LENGTH_SHORT).show();
                    //i1.setVisibility(View.VISIBLE);
                   // i2.setVisibility(View.INVISIBLE);

                   Intent tohome=new Intent(doctor_SignUp.this,Doctor_Home.class);

                    //Intent tohome=new Intent(doctor_SignUp.this,DoctorProfileCreate.class);
                    startActivity(tohome);
                }
                else
                {
                    et2.setError("Password should be atleast 6 digit long");
                    //i2.setVisibility(View.VISIBLE);
                    //i1.setVisibility(View.INVISIBLE);
                }



            }
        });
    }
}
