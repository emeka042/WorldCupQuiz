package com.example.android.worldcupquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    //What happens when Go is clicked
    public void onClickGo (View view){
        EditText enteredName = findViewById(R.id.player_name);
        String playerName = enteredName.getText().toString();

        if (playerName.trim().isEmpty()){
            //create toast and exit
            String toastMessage = "Please, enter your name!!";
            Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();
        }else{
            //create intent and send to main activity
            Intent openMain = new Intent(this, MainActivity.class);
            openMain.putExtra(Intent.EXTRA_TEXT, playerName);
            startActivity(openMain);
            }

    }


}
