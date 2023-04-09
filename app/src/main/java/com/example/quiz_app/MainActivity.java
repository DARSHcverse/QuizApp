package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Name;
    Button Start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name=findViewById(R.id.NameText);
        Start=findViewById(R.id.Start);

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Q1=new Intent(MainActivity.this,Question_1.class);
                Q1.putExtra("Quiz_Q1","Answer");
                Q1.putExtra("User_name",Name.getText().toString());
                startActivity(Q1);
            }
        });

    }
}