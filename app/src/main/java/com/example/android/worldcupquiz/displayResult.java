package com.example.android.worldcupquiz;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class displayResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);
        displayResult();
    }

    private void displayResult(){
        Intent obtainResult = getIntent();
        String result = obtainResult.getStringExtra(Intent.EXTRA_TEXT);
        TextView resultDisplay = findViewById(R.id.result_display);
        resultDisplay.setText(result);
    }

    private Dialog createDialog(){
        //Here, I want to create a dialog
        //the dialogBuilder is an object created that sets the properties of the dialog
        //theDialogItself is the actual dialog created
        String resultString = getPlayerAnswer();
        CharSequence result = Html.fromHtml(resultString);
        CharSequence dialogText = Html.fromHtml(getString(R.string.dialog));
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        //set the text on it
        dialogBuilder.setMessage(result);
        dialogBuilder.setPositiveButton(dialogText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //return to the home page
                Intent home = new Intent(getApplicationContext(), intro.class);
                startActivity(home);
            }
        });

        //now, create the dialog
        AlertDialog theDialogItself = dialogBuilder.create();
        return theDialogItself; //return the created dialog
    }

    public void onClickOK(View view) {
        createDialog().show();//call the created dialog and show it!!!

    }

    public String getPlayerAnswer(){
        Intent answers = getIntent();
        boolean ans1 = answers.getBooleanExtra("question1", false);
        boolean ans2 = answers.getBooleanExtra("question2", false);
        boolean ans3 = answers.getBooleanExtra("question3", false);
        boolean ans4 = answers.getBooleanExtra("question4", false);
        boolean ans5 = answers.getBooleanExtra("question5", false);

        String ansDisplay;
        if (ans1){
            ansDisplay = getString(R.string.ans_1Yes);
            }else {ansDisplay = getString(R.string.ans_1No);}
        if (ans2){
            ansDisplay += getString(R.string.ans_2Yes);
        }else {ansDisplay += getString(R.string.ans_2No);}
        if (ans3){
            ansDisplay += getString(R.string.ans_3Yes);
        }else {ansDisplay += getString(R.string.ans_3No);}
        if (ans4){
            ansDisplay += getString(R.string.ans_4Yes);
        }else {ansDisplay += getString(R.string.ans_4No);}
        if (ans5){
            ansDisplay += getString(R.string.ans_5Yes);
        }else {ansDisplay += getString(R.string.ans_5No);}

        return ansDisplay;
    }


}
