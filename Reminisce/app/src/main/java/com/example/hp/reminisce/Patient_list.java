package com.example.hp.reminisce;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class Patient_list extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ModelPatient> patientlist;
    private DatabaseReference mDatabaseReference;
    int i=0;
    int k=0;
    ArrayList<String>[] a=new ArrayList[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);


        recyclerView=(RecyclerView)findViewById(R.id.rv);

        mDatabaseReference= FirebaseDatabase.getInstance().getReference().child("User Profile");

        for(int j=0;j<100;j++)
        {
            a[j]=new ArrayList<String>();
        }


        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    Map<String,String> map=(Map<String,String>) snapshot.getValue();
                    String name1=map.get("First");
                    String surname1=map.get("Last");
                    String docname1=map.get("DoctorName");
                    String mobileno1=map.get("MobileNo");
                    String em_mobileno1=map.get("Emergency");
                    String relative1=map.get("Relative");

                    a[i].add(name1);
                    a[i].add(surname1);
                    a[i].add(docname1);
                    a[i].add(mobileno1);
                    a[i].add(em_mobileno1);
                    a[i].add(relative1);
                    i=i+1;


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





        patientlist=new ArrayList<>();

        patientlist.add(new ModelPatient(R.drawable.p1,"Rahul","949494","1"));
        patientlist.add(new ModelPatient(R.drawable.p2,"vishwesh","646464","2"));
        patientlist.add(new ModelPatient(R.drawable.p3,"aditya","636363","3"));
        patientlist.add(new ModelPatient(R.drawable.p4,"hr","434343","4"));

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvlayoutmanager=linearLayoutManager;
        recyclerView.setLayoutManager(rvlayoutmanager);

        patientadapt adapt=new patientadapt(this,patientlist);


        recyclerView.setAdapter(adapt);

    }
}
