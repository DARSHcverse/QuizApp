package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Question_2 extends AppCompatActivity {

    ProgressBar progressBar;
    TextView Getname;
    TextView Q2;
    Button A1,A2,A3,A4,Submits,Nexts;
    String Get_A1,Get_A2,Get_A3,Get_A4;

    int Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        progressBar=findViewById(R.id.progressBar4);
        Getname=findViewById(R.id.getname3);
        Q2=findViewById(R.id.question_2);
        A1=findViewById(R.id.answer11);
        A2=findViewById(R.id.answer10);
        A3=findViewById(R.id.answer9);
        A4=findViewById(R.id.answer8);
        Submits=findViewById(R.id.submit3);
        Nexts=findViewById(R.id.next_2);

        Nexts.setVisibility(View.INVISIBLE);

        Intent Recived_To_Q2=getIntent();
        String Get_name=Recived_To_Q2.getStringExtra("xame");
        int Get_result_Q1=Recived_To_Q2.getIntExtra("Result_of_Q1",Result);
        Getname.setText(Get_name);

        String Question="It is created by Google, is one of the most commonly installed mobile OS for mobile devices, with support from various device manufacturers. " +
                "It is an open source OS, which means developers are given access to unlocked hardware to develop new programs.";

        String[] AnswerList={"Linux","Windows","Android","Xamarin"};
        String Correct_Answer="Android";
        Button[] buttons={A1,A2,A3,A4};
        Q2.setText(Question);

        for(int i =0;i<AnswerList.length;i++)
        {
            buttons[i].setText(AnswerList[i]);
        }

        A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Get_A1=A1.getText().toString();
            }
        });

        A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Get_A2=A2.getText().toString();
            }
        });

        A3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Get_A3=A3.getText().toString();
            }
        });

        A4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Get_A4=A4.getText().toString();
            }
        });

        Submits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int x=0;x<buttons.length;x++)
                {
                    if(Get_A1==Correct_Answer || Get_A2==Correct_Answer || Get_A3==Correct_Answer ||Get_A4==Correct_Answer)
                    {
                        if(buttons[x].getText()==Correct_Answer)
                        {
                            buttons[x].setBackgroundColor(Color.GREEN);
                            Result=1;
                            Submits.setVisibility(View.INVISIBLE);
                            Nexts.setVisibility(View.VISIBLE);
                        }

                    }
                    else
                    {
                        buttons[x].setBackgroundColor(Color.RED);
                        if(buttons[x].getText()==Correct_Answer)
                        {
                            buttons[x].setBackgroundColor(Color.GREEN);
                        }
                        Result=0;Submits.setVisibility(View.INVISIBLE);Nexts.setVisibility(View.VISIBLE);


                    }

                }



            }
        });

        Nexts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Result=Result+Get_result_Q1;
                Intent next_q3=new Intent(Question_2.this,Question_3.class);
                next_q3.putExtra("xame2",Getname.getText().toString());
                next_q3.putExtra("Result_of_Q2",Result);
                Log.v(String.valueOf(Result),"CheckResult");
                startActivity(next_q3);

            }
        });



    }
}