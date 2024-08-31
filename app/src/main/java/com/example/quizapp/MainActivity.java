package com.example.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup answersRadioGroup;
    private RadioButton answer1, answer2, answer3, answer4;
    private Button submitButton;

    private String[] questions = {
            " What is the official mascot of the Tokyo 2020 Paralympic Games?",
            "What is 2 + 2?",
            "What is the capital of Germany?"
    };

    private String[][] answers = {
            {"Someity", "Miraitowa", "Vinny", "Sunny"},
            {"3", "4", "5", "6"},
            {"Berlin", "Madrid", "Lisbon", "Vienna"}
    };

    private int[] correctAnswers = {0, 1, 0}; // Index of correct answer in answers array

    private int currentQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        answersRadioGroup = findViewById(R.id.answersRadioGroup);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        submitButton = findViewById(R.id.submitButton);

        loadQuestion();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = answersRadioGroup.getCheckedRadioButtonId();
                int answerIndex = -1;

                if (selectedId == answer1.getId()) {
                    answerIndex = 0;
                } else if (selectedId == answer2.getId()) {
                    answerIndex = 1;
                } else if (selectedId == answer3.getId()) {
                    answerIndex = 2;
                } else if (selectedId == answer4.getId()) {
                    answerIndex = 3;
                }

                if (answerIndex == correctAnswers[currentQuestion]) {
                    Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
                }

                currentQuestion++;
                if (currentQuestion < questions.length) {
                    loadQuestion();
                } else {
                    Toast.makeText(MainActivity.this, "Quiz finished!", Toast.LENGTH_LONG).show();
                    submitButton.setEnabled(false);
                }
            }
        });
    }

    private void loadQuestion() {
        questionTextView.setText(questions[currentQuestion]);
        answer1.setText(answers[currentQuestion][0]);
        answer2.setText(answers[currentQuestion][1]);
        answer3.setText(answers[currentQuestion][2]);
        answer4.setText(answers[currentQuestion][3]);
        answersRadioGroup.clearCheck();
    }
}
