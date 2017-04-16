package com.example.aharshberger.myapplicationwithpeopleatideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewv;
    EditText editTextv;
    String storetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Show layout files location

        //Create a text view

        editTextv = (EditText) findViewById(R.id.editText);
        textViewv = (TextView) findViewById(R.id.textview);




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


    }

    public void changeactivity(View view) {

    }

    public void changetext(View view) {
         storetext = editTextv.getText().toString();
         textViewv.setText(storetext);


    }
}
