package com.example.aharshberger.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    EditText person_1_name, person_2_name;
//    public SharedPreferences pref_activity = getApplicationContext().getSharedPreferences("MyPref_acitivty", MODE_PRIVATE);
//    public SharedPreferences.Editor editor_acitivty = pref_activity.edit();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        person_1_name = (EditText) findViewById(R.id.person_1_edittext);
        person_2_name = (EditText) findViewById(R.id.person_2_edittext);

//        editor_acitivty.putBoolean("it was before", true);
//
//        SharedPreferences prefs_names = PreferenceManager.getDefaultSharedPreferences(this);
//        if (prefs_names.getBoolean("MyPref_acitivty", true)) {
//
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
//        }


    }

    public void clicking_next_to_activity(View view) {

        Intent intent = new Intent(this, MainActivity.class);

        String person_1_name_send = person_1_name.getText().toString();
        intent.putExtra("person_1_name_sent", person_1_name_send);


        String person_2_name_send = person_2_name.getText().toString();
        intent.putExtra("person_2_name_sent", person_2_name_send);


        startActivity(intent);
    }

    public void clicking_skip_to_activity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
