package com.example.android.worldcupquiz;

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


    public void submitButton(View view) {

        int score = 0;

        score = score + evaluateQuestion1() + evaluateQuestion2() + evaluateQuestion3()
                + evaluateQuestion4() + evaluateQuestion5();

        String displayText = getPlayerName() + ", you got " + score + " questions correct!";
        if (score == 5) {
            displayText += "\n World Cup Genius";
        } else displayText += "\n You tried shaa";

        // Toast.makeText(this, displayText, Toast.LENGTH_LONG).show();

        Intent sendResult = new Intent(this, displayResult.class);
        sendResult.putExtra(Intent.EXTRA_TEXT, displayText);
        startActivity(sendResult);
    }

    private int evaluateQuestion1() {
        RadioButton checkedButton = (RadioButton) findViewById(R.id.south_radio);
        if (checkedButton.isChecked()) {
            return 1;
        } else {
            return 0;
        }

    }

    private int evaluateQuestion2() {
        CheckBox spain = (CheckBox) findViewById(R.id.spain_checkbox);
        CheckBox england = (CheckBox) findViewById(R.id.england_checkbox);
        CheckBox uruguay = (CheckBox) findViewById(R.id.uruguay_checkbox);
        CheckBox argentina = (CheckBox) findViewById(R.id.argentina_checkbox);
        CheckBox brazil = (CheckBox) findViewById(R.id.brazil_checkbox);
        boolean checked = !spain.isChecked() && uruguay.isChecked()
                && argentina.isChecked() && !england.isChecked() && brazil.isChecked();

        if (checked) {
            return 1;
        } else return 0;

    }

    private int evaluateQuestion3() {
        EditText coach = (EditText) findViewById(R.id.coach_text);
        String coachNameEntered = coach.getText().toString();
        if (coachNameEntered.equals("Lars Lagerback")) {
            return 1;
        } else return 0;
    }

    private int evaluateQuestion4() {
        RadioButton checkedButton = (RadioButton) findViewById(R.id.nineth_radio);
        if (checkedButton.isChecked()) {
            return 1;
        } else {
            return 0;
        }

    }

    private int evaluateQuestion5() {
        RadioButton checkedButton = (RadioButton) findViewById(R.id.button_1930);
        if (checkedButton.isChecked()) {
            return 1;
        } else {
            return 0;
        }
    }

    private String getPlayerName() {
//        EditText enteredName = (EditText) findViewById(R.id.player_name);
//        String playerName = enteredName.getText().toString();
//
        Intent name = getIntent();
        String playerName = name.getStringExtra(Intent.EXTRA_TEXT);

        return playerName;
    }
}


