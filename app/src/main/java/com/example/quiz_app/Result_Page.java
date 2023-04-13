package com.example.quiz_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result_Page extends AppCompatActivity {

    TextView FinalName,ResultCheck;

    Button NewQ, Finished;

    int Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        FinalName=findViewById(R.id.getname7);
        ResultCheck=findViewById(R.id.Final_Chk);
        NewQ=findViewById(R.id.New_quiz);
        Finished=findViewById(R.id.Finish);

        Intent Recived_To_Final=getIntent();
        String Get_name_5=Recived_To_Final.getStringExtra("User_name");
        int Get_result_Final=Recived_To_Final.getIntExtra("Result_of_Q5",Result);
        FinalName.setText("Congratulations "+Get_name_5);

        ResultCheck.setText("Your Score:\n"+Get_result_Final+"/5");

        Finished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent BackToFirst=new Intent(Result_Page.this,MainActivity.class);
                startActivity(BackToFirst);

            }
        });


    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode  == 1){
            if (resultCode == RESULT_OK){
                String valueFromSecondActivity = data.getStringExtra("key");
            }
        }
    }
}