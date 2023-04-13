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

public class Question_5 extends AppCompatActivity {

    ProgressBar progressBar;
    TextView Getname;
    TextView Q4;
    Button A1,A2,A3,A4,Submits,Nexts;
    String Get_A1,Get_A2,Get_A3,Get_A4;

    int Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        progressBar=findViewById(R.id.progressBar8);
        Getname=findViewById(R.id.getname6);
        Q4=findViewById(R.id.question_5);
        A1=findViewById(R.id.answer21);
        A2=findViewById(R.id.answer22);
        A3=findViewById(R.id.answer23);
        A4=findViewById(R.id.answer24);
        Submits=findViewById(R.id.submit6);
        Nexts=findViewById(R.id.next_5);

        Nexts.setVisibility(View.INVISIBLE);

        Intent Recived_To_Q5=getIntent();
        String Get_name_5=Recived_To_Q5.getStringExtra("xame4");
        int Get_result_Q4=Recived_To_Q5.getIntExtra("Result_of_Q4",Result);
        Getname.setText(Get_name_5);

        String Question="It includes everything that can be used to create amazing apps for iPhone and iPad. It allows users to build apps and run them directly on their Apple devices.";

        String[] AnswerList={"Xcode","Swift","Android SDK","Visual Studio Xamarin"};
        String Correct_Answer="Xcode";
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

                Result=Result+Get_result_Q4;
                Intent next_q2=new Intent(Question_5.this,Result_Page.class);
                next_q2.putExtra("xame5",Getname.getText().toString());
                next_q2.putExtra("Result_of_Q5",Result);
                Log.v(String.valueOf(Result),"CheckResult");
                startActivity(next_q2);

            }
        });

    }
}