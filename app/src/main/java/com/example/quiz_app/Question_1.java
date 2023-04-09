package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Question_1 extends AppCompatActivity {

    ProgressBar progressBar;

    TextView getname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);

        progressBar=findViewById(R.id.progressBar);
        getname=findViewById(R.id.Getname);


        Intent SentIntent=getIntent();
        String Get_Name=SentIntent.getStringExtra("User_name");

        getname.setText("Welcome "+Get_Name);




    }
}