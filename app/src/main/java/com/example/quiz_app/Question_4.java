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

public class Question_4 extends AppCompatActivity {

    ProgressBar progressBar;
    TextView Getname;
    TextView Q4;
    Button A1,A2,A3,A4,Submits,Nexts;
    String Get_A1,Get_A2,Get_A3,Get_A4;

    int Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

        progressBar=findViewById(R.id.progressBar7);
        Getname=findViewById(R.id.getname5);
        Q4=findViewById(R.id.question_4);
        A1=findViewById(R.id.answer17);
        A2=findViewById(R.id.answer18);
        A3=findViewById(R.id.answer19);
        A4=findViewById(R.id.answer20);
        Submits=findViewById(R.id.submit5);
        Nexts=findViewById(R.id.next_4);

        Nexts.setVisibility(View.INVISIBLE);

        Intent Recived_To_Q4=getIntent();
        String Get_name_4=Recived_To_Q4.getStringExtra("xame3");
        int Get_result_Q3=Recived_To_Q4.getIntExtra("Result_of_Q3",Result);
        Getname.setText(Get_name_4);

        String Question="A programming environment that has been packaged as an application program.";

        String[] AnswerList={"Programming Language","Android SDK","Visual Studio","Integrated Development Environment"};
        String Correct_Answer="Integrated Development Environment";
        Button[] buttons={A1,A2,A3,A4};
        Q4.setText(Question);

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

                Result=Result+Get_result_Q3;
                Intent next_q2=new Intent(Question_4.this,Question_5.class);
                next_q2.putExtra("xame4",Getname.getText().toString());
                next_q2.putExtra("Result_of_Q4",Result);
                Log.v(String.valueOf(Result),"CheckResult");
                startActivity(next_q2);

            }
        });
    }
}