package com.example.aharshberger.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    int count_person1 = 1;
    int count_person2 = 1;
    SharedPreferences pref;
    SharedPreferences.Editor editor;


    TextView person_1, person_2, person_1_count, person_2_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String name1_received = intent.getStringExtra("person_1_name_sent");
        String name2_received = intent.getStringExtra("person_2_name_sent");

        person_1 = (TextView) findViewById(R.id.person_1);
        person_2 = (TextView) findViewById(R.id.person_2);

        person_1.setText(name1_received);
        person_2.setText(name2_received);

        person_1_count = (TextView) findViewById(R.id.Person_1_Count);
        person_2_count = (TextView) findViewById(R.id.Person_2_Count);


    }


        public void clicking_wink_person_1 (View view) {

            person_1_count = (TextView) findViewById(R.id.Person_1_Count);

            if (count_person1 == 0){

                count_person1 = 1;

            }else{

                String string_count = String.valueOf(count_person1++);

                person_1_count.setText(string_count);


            }

        }



    public void clicking_wink_person_2(View view) {

        person_2_count = (TextView) findViewById(R.id.Person_2_Count);

        String string_count = String.valueOf(count_person2++);


        person_2_count.setText(string_count);


    }


    public void clicking_reset_person_1(View view) {


        person_1_count = (TextView) findViewById(R.id.Person_1_Count);

        count_person1 = 0;

        String string_count_reset_person1 = String.valueOf(count_person1);

        person_1_count.setText(string_count_reset_person1);
    }

    public void clicking_reset_person_2(View view) {

        person_2_count = (TextView) findViewById(R.id.Person_2_Count);

        count_person2 = 0;

        String string_count_reset_person2 = String.valueOf(count_person2);

        person_2_count.setText(string_count_reset_person2);


    }

    public void clicking_back_to_activity(View view) {

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

}
