package com.example.android.worldcupquiz;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        Log.v("value", "the value of result is " + result);

        TextView resultDisplay = findViewById(R.id.result_display);
        resultDisplay.setText(result);
    }

    private Dialog createDialog(){
        //Here, I want to create a dialog
        //the dialogBuilder is an object created that sets the properties of the dialog
        //theDialogItself is the actual dialog created
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        //set the text on it
        dialogBuilder.setMessage("Do you want to play again??");
        dialogBuilder.setPositiveButton("Yes! Let's Go!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //return to the home page
            }
        });
        dialogBuilder.setNegativeButton("No, Close!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //close the application
            }
        });

        //now, create the dialog
        AlertDialog theDialogItself = dialogBuilder.create();
        return theDialogItself; //return the created dialog
    }

    public void onClickOK(View view) {
        createDialog().show();//call the created dialog and show it!!!

    }
}
