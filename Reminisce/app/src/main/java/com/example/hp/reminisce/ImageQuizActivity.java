package com.example.hp.reminisce;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class ImageQuizActivity extends AppCompatActivity {

    ImageView mImageView;
    private TextView mTextView;
    private Button but1;
    private Button but2;
    private Button but3;
    private Button but4;
    private Button exitbutton;
    private DatabaseReference mDatabaseReference;
    TextView scoreboard;

    private question[] mQuestionbank=new question[]{
            new question(R.string.question_family,R.id.b21,R.drawable.family),
            new question(R.string.question_house,R.id.b22,R.drawable.house),
            new question(R.string.question_fruit,R.id.b23,R.drawable.apple),
    };
    private answer[] mAnswerbank=new answer[]{
            new answer(R.string.b1_ans1,R.string.b2_ans1,R.string.b3_ans1),
            new answer(R.string.b1_ans2,R.string.b2_ans2,R.string.b3_ans2),
            new answer(R.string.b1_ans3,R.string.b2_ans3,R.string.b3_ans3)

    };
    private int mCurrentindex1,mCurrentindex2,mbuttonindex,anscount,qno;
    private int button_id;
    public void updatequestion()
    {
        mCurrentindex1=mCurrentindex1+1;
        int quest=mQuestionbank[mCurrentindex1].getMtextidforquestion();
        mTextView.setText(quest);
    }
    public void updateimage()
    {
        mCurrentindex2=mCurrentindex2+1;
        int img=mQuestionbank[mCurrentindex2].getMimageidforquestion();
        mImageView.setImageResource(img);
    }
    public void updateanswer()
    {
        mbuttonindex=mbuttonindex+1;
        int idforbutton1=mAnswerbank[mbuttonindex].getMidbut1();
        int idforbutton2=mAnswerbank[mbuttonindex].getMidbut2();
        int idforbutton3=mAnswerbank[mbuttonindex].getMidbut3();
        but1.setText(idforbutton1);
        but2.setText(idforbutton2);
        but3.setText(idforbutton3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_quiz);


        mImageView=(ImageView)findViewById(R.id.iv21);
        but1=(Button)findViewById(R.id.b21);
        but2=(Button)findViewById(R.id.b22);
        but3=(Button)findViewById(R.id.b23);
        but4=(Button)findViewById(R.id.b24);
        exitbutton=(Button)findViewById(R.id.b24);
        mTextView=(TextView)findViewById(R.id.tv21);
        scoreboard=(TextView)findViewById(R.id.scoreid);
        mCurrentindex1=0;
        mCurrentindex2=0;
        mbuttonindex=0;
        anscount=0;
        qno=1;
        int id1=mQuestionbank[mCurrentindex1].getMtextidforquestion();
        mTextView.setText(id1);
        int idbut1=mAnswerbank[mbuttonindex].getMidbut1();
        int idbut2=mAnswerbank[mbuttonindex].getMidbut2();
        int idbut3=mAnswerbank[mbuttonindex].getMidbut3();
        but1.setText(idbut1);
        but2.setText(idbut2);
        but3.setText(idbut3);

        mDatabaseReference= FirebaseDatabase.getInstance().getReference();
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_id=mQuestionbank[mCurrentindex1].getManswerid();
                if(button_id==R.id.b21)
                {
                    Toast.makeText(ImageQuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                    anscount=anscount+1;
                    qno=qno+1;
                    if(qno<4) {
                        scoreboard.setText("" + anscount);
                        updatequestion();
                        updateimage();
                        updateanswer();
                    }
                    //mimageview.setImageResource(imageArray[currentIndex]);
                    //code for updating
                }
                else
                {
                    Toast.makeText(ImageQuizActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                    scoreboard.setText(""+anscount);
                }
            }
        });

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                button_id=mQuestionbank[mCurrentindex1].getManswerid();
                if(button_id==R.id.b22)
                {
                    Toast.makeText(ImageQuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                    anscount=anscount+1;
                    qno=qno+1;
                    if(qno<4) {
                        scoreboard.setText("" + anscount);
                        updatequestion();
                        updateimage();
                        updateanswer();
                    }
                    //code for updating
                }
                else
                {
                    Toast.makeText(ImageQuizActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                    scoreboard.setText(""+anscount);
                }
            }
        });

        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_id=mQuestionbank[mCurrentindex1].getManswerid();
                if(button_id==R.id.b23)
                {
                    Toast.makeText(ImageQuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                    anscount=anscount+1;
                    qno=qno+1;
                    scoreboard.setText("" + anscount);
                    if(qno<4) {
                        updatequestion();
                        updateimage();
                        updateanswer();
                    }
                    //code for updating
                }
                else
                {
                    Toast.makeText(ImageQuizActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                    scoreboard.setText(""+anscount);
                }
            }
        });

        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date=new Date();
                Calendar cal=Calendar.getInstance();
                cal.setTime(date);
                int month=cal.get(Calendar.MONTH);
                int week=cal.get(Calendar.WEEK_OF_MONTH);
                //int hr=cal.get(Calendar.HOUR_OF_DAY);
                //1.create child in root object
                //2.assign some value to the child
                mDatabaseReference=FirebaseDatabase.getInstance().getReference().child("User1").child(""+week); //user1 to be made dynamic
//                HashMap<String,Integer>dataMap=new HashMap<String, Integer>();
//                 dataMap.put(""+week,anscount);
                // dataMap.put(""+hr,anscount);
                mDatabaseReference.setValue(anscount).addOnCompleteListener(new OnCompleteListener<Void>() {  //to check whether the data is inserted successfully
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                            Toast.makeText(ImageQuizActivity.this, "Successfully completed", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(ImageQuizActivity.this,"Error",Toast.LENGTH_SHORT).show();
                    }
                });
                // mDatabaseReference.child(""+week).setValue(anscount);












                finish();



            }
        });




    }
}
