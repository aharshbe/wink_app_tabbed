package com.example.aharshberger.empty_file_test;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewMyFirstText;
    EditText editTextMyFirstEditText;
    String mytextfromedittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Show layout files location
        //Create a text view
        //Create an edit text
        //Create button text conversion
        //Create button intent
        //Instantiate text view & edit text
        //Add onClicks for buttons
        //Show manifest
        //Add icon as drawable
        //Change icon
        //Grab text from editText
        //Set text form editText to textView
        //Create new acitivty
        //Create intent
        //Activate intent
        //Place intent in button
        //Place setText in button
        //Intentionally create an error during compile to show logcat

        textViewMyFirstText = (TextView) findViewById(R.id.textView1);
        editTextMyFirstEditText = (EditText) findViewById(R.id.editText1);

    }

    public void clickingChangeText(View view) {

        mytextfromedittext = editTextMyFirstEditText.getText().toString();


        if (mytextfromedittext.equals("Kat")) {
            textViewMyFirstText.setText(mytextfromedittext);
            textViewMyFirstText.setTextColor(Color.BLUE);
            editTextMyFirstEditText.setText("");

        }else if  (mytextfromedittext.equals("Coe")) {
            textViewMyFirstText.setTextColor(Color.GREEN);
            textViewMyFirstText.setText(mytextfromedittext);
            editTextMyFirstEditText.setText("");

       }else
            textViewMyFirstText.setTextColor(Color.RED);
            textViewMyFirstText.setText(mytextfromedittext);
            editTextMyFirstEditText.setText("");
    }

    public void clickingNewActivity(View view) {

        Intent intenttoLogin = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intenttoLogin);

    }
}
