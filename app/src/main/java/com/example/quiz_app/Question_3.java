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

public class Question_3 extends AppCompatActivity {


    ProgressBar progressBar;
    TextView Getname;
    TextView Q3;
    Button A1,A2,A3,A4,Submits,Nexts;
    String Get_A1,Get_A2,Get_A3,Get_A4;

    int Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        progressBar=findViewById(R.id.progressBar5);
        Getname=findViewById(R.id.getname4);
        Q3=findViewById(R.id.question_3);
        A1=findViewById(R.id.answer12);
        A2=findViewById(R.id.answer13);
        A3=findViewById(R.id.answer14);
        A4=findViewById(R.id.answer15);
        Submits=findViewById(R.id.submit4);
        Nexts=findViewById(R.id.next_3);

        Nexts.setVisibility(View.INVISIBLE);

        Intent Recived_To_Q3=getIntent();
        String Get_name_3=Recived_To_Q3.getStringExtra("xame2");
        int Get_result_Q2=Recived_To_Q3.getIntExtra("Result_of_Q2",Result);
        Getname.setText(Get_name_3);

        String Question="Which Benefits of Mobile Applications is defined by this?\n" +
                "Modern user input goes beyond clicking and typing. Mobile apps are touch-based, allowing users to control the interface through pointer lock and drag and drop actions.";

        String[] AnswerList={"Convenience","Interactivity","Personalization","Productivity"};
        String Correct_Answer="Interactivity";
        Button[] buttons={A1,A2,A3,A4};
        Q3.setText(Question);

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

                Result=Result+Get_result_Q2;
                Intent next_q2=new Intent(Question_3.this,Question_4.class);
                next_q2.putExtra("xame3",Getname.getText().toString());
                next_q2.putExtra("Result_of_Q3",Result);
                Log.v(String.valueOf(Result),"CheckResult");
                startActivity(next_q2);

            }
        });

    }
}