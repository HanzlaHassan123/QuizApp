package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView letterTextView, answerTextView;
    private char[] skyLetters = {'b', 'd', 'f', 'h', 'k', 'l', 't'};
    private char[] grassLetters = {'g', 'j', 'p', 'q', 'y'};
    private char[] rootLetters = {'a', 'c', 'e', 'i', 'm', 'n', 'o', 'r', 's', 'u', 'v', 'w', 'x', 'z'};
    private String answerString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       letterTextView=findViewById(R.id.Question);
       letterTextView.setText(getRandomLetter());

       answerTextView=findViewById(R.id.answer);


        Button skyBtn=findViewById(R.id.SkyBtn);

        skyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answerString.equals("Sky Letter")) {
                    answerTextView.setText("Your answer was Correct");
                } else {
                    answerTextView.setText("Wrong! the answer is " + answerString);
                }

                // Wait for 5 seconds and create a new question
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        letterTextView.setText(getRandomLetter());
                        answerTextView.setText("");
                    }
                }, 5000); // 50
            }
        });

        Button grassBtn=findViewById(R.id.grassBtn);
        grassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answerString.equals( "Grass Letter")) {
                    answerTextView.setText(" Your answer was Correct");
                } else {
                    answerTextView.setText("Wrong! the answer is " + answerString);
                }
                // Wait for 5 seconds and create a new question
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        letterTextView.setText(getRandomLetter());
                        answerTextView.setText("");
                    }
                }, 5000);
            }
        });

        Button rootBtn=findViewById(R.id.rootBtn);
        rootBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (answerString.equals( "Root Letter")) {
                            answerTextView.setText("Your answer was Correct");
                        } else {
                            answerTextView.setText("Wrong! the answer is " + answerString);
                        }
                        // Wait for 5 seconds and create a new question
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                letterTextView.setText(getRandomLetter());
                                answerTextView.setText("");
                            }
                        }, 5000);
                    }
                }
        );

    }
    private String getRandomLetter() {
        Random random = new Random();
        int category = random.nextInt(3);
        char letter;
        switch (category) {
            case 0:
                letter = skyLetters[random.nextInt(skyLetters.length)];
                answerString = "Sky Letter";
                break;
            case 1:
                letter = grassLetters[random.nextInt(grassLetters.length)];
                answerString = "Grass Letter";
                break;
            default:
                letter = rootLetters[random.nextInt(rootLetters.length)];
                answerString = "Root Letter";
                break;
        }
        return String.valueOf(letter);
    }
}