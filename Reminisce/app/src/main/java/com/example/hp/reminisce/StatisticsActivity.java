package com.example.hp.reminisce;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StatisticsActivity extends AppCompatActivity {

    private LineChart mLineChart;
    ArrayList<Entry> mEntryArrayList;
    private DatabaseReference mDatabaseReference;
    ValueEventListener mValueEventListener;
    private TextView tv1;
    int arr[]=new int[5];
    // int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        mLineChart=(LineChart)findViewById(R.id.linechartid);
        tv1=(TextView)findViewById(R.id.textView);
        mDatabaseReference= FirebaseDatabase.getInstance().getReference().child("User1");
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mEntryArrayList = new ArrayList<>();
                for(int j=0;j<5;j++) {
                    int score = dataSnapshot.child("" + j).getValue(Integer.class);
                    tv1.setText("" + score);
                    mEntryArrayList.add(new Entry(j, score));
                    Legend legend=mLineChart.getLegend();
                    legend.setEnabled(true);
                    legend.setTextColor(Color.GREEN);
                    legend.setTextSize(12);
                    final LineDataSet mLineDataSet = new LineDataSet(mEntryArrayList, "Quiz Score");
                    LineData data = new LineData(mLineDataSet);
                    mLineChart.setDrawGridBackground(true);
                    mLineChart.setDrawBorders(true);
                    mLineChart.setBorderColor(Color.DKGRAY);
                    mLineChart.setData(data);
                    mLineChart.notifyDataSetChanged();
                    mLineChart.invalidate();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
