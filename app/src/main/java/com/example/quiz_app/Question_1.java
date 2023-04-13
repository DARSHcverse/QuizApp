package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class Question_1 extends AppCompatActivity {

    ProgressBar progressBar;
    TextView getname;
    TextView Q1;
    Button AW1,AW2,AW3,AW4,Submit,Next;
    String Get_A1,Get_A2,Get_A3,Get_A4;

    int Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);

        progressBar=findViewById(R.id.progressBar);
        getname=findViewById(R.id.Getname);
        Q1=findViewById(R.id.question_1);
        AW1=findViewById(R.id.Answer1);
        AW2=findViewById(R.id.answer2);
        AW3=findViewById(R.id.answer3);
        AW4=findViewById(R.id.answer4);
        Submit=findViewById(R.id.submit);
        Next=findViewById(R.id.next_1);

        Next.setVisibility(View.INVISIBLE);

        Intent SentIntent=getIntent();
        String Get_Name=SentIntent.getStringExtra("User_name");
        getname.setText("Welcome "+Get_Name);

        String Question="An operating system (OS) built exclusively for mobile devices such as smartphones, tablets, PDAs, etc. Similar to a standard OS but is relatively simple and light.";

        String[] AnswerList={"Macintosh Operating System","Windows Operating System","Mobile Operating System","Linux Operating System"};
        String Correct_Answer="Mobile Operating System";
        Button[] buttons={AW1,AW2,AW3,AW4};


        Q1.setText(Question);

        for(int i =0;i<AnswerList.length;i++)
        {
            buttons[i].setText(AnswerList[i]);
        }

        AW1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Get_A1=AW1.getText().toString();
            }
        });

        AW2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Get_A2=AW2.getText().toString();
            }
        });

        AW3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Get_A3=AW3.getText().toString();
            }
        });

        AW4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Get_A4=AW4.getText().toString();
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
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
                            Submit.setVisibility(View.INVISIBLE);
                            Next.setVisibility(View.VISIBLE);
                        }

                    }
                    else
                    {
                        buttons[x].setBackgroundColor(Color.RED);
                        if(buttons[x].getText()==Correct_Answer)
                        {
                            buttons[x].setBackgroundColor(Color.GREEN);
                        }
                        Result=0;Submit.setVisibility(View.INVISIBLE);Next.setVisibility(View.VISIBLE);


                    }

                }

            }
        });



        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent next_q2=new Intent(Question_1.this,Question_2.class);
                next_q2.putExtra("xame",getname.getText().toString());
                next_q2.putExtra("Result_of_Q1",Result);
                Log.v(String.valueOf(Result),"CheckResult");
                startActivity(next_q2);


            }
        });

    }

}