package com.example.hp.reminisce;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class Doctor_Login extends AppCompatActivity implements View.OnClickListener {

    private GoogleSignInClient mGoogleSignInClient;

    private static final int RC_SIGN_IN = 125;

    private FirebaseAuth mAuth;

    private SignInButton googlebutton;

    Button LogIn, SignUp;

    EditText et1, et2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__login);

        mAuth = FirebaseAuth.getInstance();

        googlebutton=(SignInButton)findViewById(R.id.googlebtn);

//FOR GOOGLE SIGN-IN
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

//FOR GOOGLE SIGN-IN
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        googlebutton.setOnClickListener(this);

        et1 = (EditText) findViewById(R.id.emailid);
        et2 = (EditText) findViewById(R.id.passwordid);


        LogIn = (Button) findViewById(R.id.loginid);
        SignUp = (Button) findViewById(R.id.Button_Doc_SignUp);


//FOR FIREBASE LOGIN AND PASSWORD
        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String logemail = et1.getText().toString().trim();
                String logpass = et2.getText().toString().trim();
                loginuser(logemail, logpass);
                //String name ="";
               // name= usernameDoc.getEditText().getText().toString();
                //String pw ="";
                //pw= passwordDoc.getEditText().getText().toString();
                //if (isEmail(usernameDoc.getEditText()) == false || name.isEmpty()==true) {                   //to check that entered email is in valid form or not
                  //  username.setError("enter valid email!");
                //} else {
//                    Intent DoctorLogIn = new Intent(Doctor_Login.this, Doctor_Home.class);
//                    startActivity(DoctorLogIn);
                //}
            }
        });


//SIGNUP METHOD
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DoctorSignUp = new Intent(Doctor_Login.this, doctor_SignUp.class);
                startActivity(DoctorSignUp);
            }
        });
    }


//FOR GOOGLE SIGN-IN
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent,RC_SIGN_IN);
    }



//FOR GOOGLE SIGN-IN
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w("Tag", "Google sign in failed", e);
                // ...
            }
        }
    }



//FOR GOOGLE SIGN-IN
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null) {
            updateUI(currentUser);
        }
    }


//FOR GOOGLE SIGN-IN
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d("Tag", "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Tag", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Tag", "signInWithCredential:failure", task.getException());
                            //Snackbar.make(findViewById(R.id.main_layout), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });


    }
//FOR GOOGLE SIGN-IN
    @Override
    public void onClick(View v) {
        signIn();
    }



//FOR GOOGLE SIGN-IN
    private void updateUI(FirebaseUser user)
    {
        String username=user.getDisplayName();
        String email=user.getEmail();
        Uri url=user.getPhotoUrl();

        Intent gotoprofileactivity=new Intent(Doctor_Login.this,Doctor_Home.class);


        //Intent gotoprofileactivity=new Intent(Doctor_Login.this,DoctorProfileCreate.class);

        gotoprofileactivity.putExtra("username",username);
        gotoprofileactivity.putExtra("email",email);
        gotoprofileactivity.putExtra("url",String.valueOf(url));
        startActivity(gotoprofileactivity);



    }




    boolean isEmail(EditText eid){
        CharSequence email=eid.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text){
        CharSequence str=text.getText().toString();
        return TextUtils.isEmpty(str);
    }





//THIS FUNCTION IS USED FOR FIREBASE EMAIL AND PASSWORD
    private void loginuser(String logemail, String logpass) {
        mAuth.signInWithEmailAndPassword(logemail, logpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Toast.makeText(Doctor_Login.this, "Successfully login", Toast.LENGTH_SHORT).show();
                    Intent tohome=new Intent(Doctor_Login.this,Doctor_Home.class);
                    startActivity(tohome);
                }
                else
                {
                    et1.setError("Credentials do not match");
                   // et2.setError("Credentials do not match");
                }
            }
        });


    }


}
