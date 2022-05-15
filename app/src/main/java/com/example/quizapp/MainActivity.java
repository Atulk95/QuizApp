package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView question;
    Button next;
    RadioButton option1,option2,option3,option4;
    RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] questions={
                "1.This is the first question",
                "2.This is the second question",
                "3.This is the third question",
                "4.This is the fourth question",
                "5.This is the fifth question"
        };
        String options[][]={
                {"java","python","c","c#"},
                {"nile","ganges","narmada","tapi"},
                {"james clear","robert junior","steave rogers","natasha"},
                {"Ahmedabad","Surat","Pune","Nashik"},
                {"1888","1869","1775","2000"}

        };
        String answer[]={
                options[0][1],
                options[1][3],
                options[2][1],
                options[3][2],
                options[4][0]

        };
        group=findViewById(R.id.group);
        question=findViewById(R.id.question);
        next=findViewById(R.id.button);
        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);
        option4=findViewById(R.id.option4);
        question.setText(questions[0]);
        option1.setText(options[0][0]);
        option2.setText(options[0][1]);
        option3.setText(options[0][2]);
        option4.setText(options[0][3]);

        next.setOnClickListener(new View.OnClickListener() {
            int count=0;
            int index=0;
            @Override
            public void onClick(View view) {

                int id=group.getCheckedRadioButtonId();
                Button ans=findViewById(id);
                String msg=ans.getText().toString();
//                Toast.makeText(MainActivity.this, "Your answers is "+msg, Toast.LENGTH_SHORT).show();
                if(index<questions.length)
                {
                    if(msg.equals(answer[index]))
                    {
                        count++;
                    }
                    index++;
                    if(index==questions.length) {
//                        Toast.makeText(MainActivity.this, "Your score is " + count, Toast.LENGTH_SHORT).show();
                        next.setText("Show Result");
                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent =new Intent(MainActivity.this,MainActivity2.class);
                               String score=Integer.toString(count);
                                intent.putExtra("KEY_EXTRA",score);
                                startActivity(intent);

                            }
                        });
                    }
                    else
                    {
                        question.setText(questions[index]);
                        option1.setText(options[index][0]);
                        option2.setText(options[index][1]);
                        option3.setText(options[index][2]);
                        option4.setText(options[index][3]);
                    }
                }


            }
        });



    }
}