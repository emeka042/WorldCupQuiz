package com.example.android.worldcupquiz;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    boolean question1Correct;
    boolean question2Correct;
    boolean question3Correct;
    boolean question4Correct;
    boolean question5Correct;


    public void submitButton(View view) {

        int score = 0;

        score = score + evaluateQuestion1() + evaluateQuestion2() + evaluateQuestion3()
                + evaluateQuestion4() + evaluateQuestion5();

        String displayText = getPlayerName() + ", you got " + score + " questions correct!";
        if (score == 5) {
            displayText += "\n World Cup Genius";
        } else displayText += "\n You tried shaa";

        Intent sendResult = new Intent(this, displayResult.class);
        sendResult.putExtra(Intent.EXTRA_TEXT, displayText);
        sendResult.putExtra("question1", question1Correct);
        sendResult.putExtra("question2", question2Correct);
        sendResult.putExtra("question3", question3Correct);
        sendResult.putExtra("question4", question4Correct);
        sendResult.putExtra("question5", question5Correct);
        startActivity(sendResult);
    }

    private int evaluateQuestion1() {
        RadioButton checkedButton = findViewById(R.id.south_radio);
        if (checkedButton.isChecked()) {
            question1Correct = true;
            return 1;
        } else {
            question1Correct = false;
            return 0;
        }
    }

    private int evaluateQuestion2() {
        CheckBox spain = findViewById(R.id.spain_checkbox);
        CheckBox england = findViewById(R.id.england_checkbox);
        CheckBox uruguay = findViewById(R.id.uruguay_checkbox);
        CheckBox argentina = findViewById(R.id.argentina_checkbox);
        CheckBox brazil = findViewById(R.id.brazil_checkbox);
        boolean checked = !spain.isChecked() && uruguay.isChecked()
                && argentina.isChecked() && !england.isChecked() && brazil.isChecked();

        if (checked) {
            question2Correct = true;
            return 1;
        } else {
            question2Correct = false;
            return 0;
        }

    }

    private int evaluateQuestion3() {
        EditText coach = findViewById(R.id.coach_text);
        String coachNameEntered = coach.getText().toString();
        if (coachNameEntered.trim().equals("Lars Lagerback")) {
            question3Correct = true;
            return 1;
        } else {
            question3Correct = false;
            return 0;
        }
    }

    private int evaluateQuestion4() {
        RadioButton checkedButton = findViewById(R.id.nineth_radio);
        if (checkedButton.isChecked()) {
            question4Correct = true;
            return 1;
        } else {
            question4Correct = false;
            return 0;
        }

    }

    private int evaluateQuestion5() {
        RadioButton checkedButton = findViewById(R.id.button_1930);
        if (checkedButton.isChecked()) {
            question5Correct = true;
            return 1;
        } else {
            question5Correct = false;
            return 0;
        }
    }

    private String getPlayerName() {
        Intent name = getIntent();
        return name.getStringExtra(Intent.EXTRA_TEXT);
    }
}


