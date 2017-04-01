package com.example.aharshberger.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
    int string_count_int_person_1, string_count_int_person_2;
    SharedPreferences pref, pref_names;
    SharedPreferences.Editor editor, editor_names;
    Intent intent;


    TextView person_1, person_2, person_1_count, person_2_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref_names = getApplicationContext().getSharedPreferences("MyPref_names", MODE_PRIVATE);
        editor_names = pref_names.edit();

         intent = getIntent();
         String name1_received_sp = intent.getStringExtra("person_1_name_sent");
         String name2_received_sp = intent.getStringExtra("person_2_name_sent");

         editor_names.putString("Name1_saved", name1_received_sp);
         editor_names.putString("Name2_saved", name2_received_sp);

         editor_names.commit();

         Log.d("checking name", pref_names.getString("Name1_saved","Austin"));


        SharedPreferences prefs_names = PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs_names.getBoolean("MyPref_names", true)) {

            person_1 = (TextView) findViewById(R.id.person_1);
            person_2 = (TextView) findViewById(R.id.person_2);

            String person_1_name_saved = pref_names.getString("Name1_saved","Austin");
            String person_2_name_saved = pref_names.getString("Name2_saved","Bryan");

            person_1.setText(person_1_name_saved);
            person_2.setText(person_2_name_saved);



        }else{

            Intent intent = getIntent();
            String name1_received = intent.getStringExtra("person_1_name_sent");
            String name2_received = intent.getStringExtra("person_2_name_sent");

            person_1 = (TextView) findViewById(R.id.person_1);
            person_2 = (TextView) findViewById(R.id.person_2);

            person_1.setText(name1_received);
            person_2.setText(name2_received);

        }
        person_1_count = (TextView) findViewById(R.id.Person_1_Count);
        person_2_count = (TextView) findViewById(R.id.Person_2_Count);

        // Creating Shared Prefs

        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs.getBoolean("MyPref", true)) {

            person_1_count.setText(String.valueOf(pref.getInt("Saved_person_1_winks", 0)));
            person_2_count.setText(String.valueOf(pref.getInt("Saved_person_2_winks", 0)));
        }






    }


        public void clicking_wink_person_1 (View view) {

            person_1_count = (TextView) findViewById(R.id.Person_1_Count);

            //Adding logic to add shared pref to the incrementer

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            if (prefs.getBoolean("MyPref", true)) {

                int person_1_count_shared_to_add = pref.getInt("Saved_person_1_winks", 0);

                String string_count = String.valueOf(person_1_count_shared_to_add+1);

                person_1_count.setText(string_count);

                string_count_int_person_1 = Integer.valueOf(string_count);

                editor.putInt("Saved_person_1_winks", string_count_int_person_1);

                editor.commit();

                Log.d("Number in the editor", String.valueOf(string_count_int_person_1));


            }else{
                String string_count = String.valueOf(count_person1++);

                person_1_count.setText(string_count);

                //////Shared Prefs

                string_count_int_person_1 = Integer.valueOf(string_count);

                editor.putInt("Saved_person_1_winks", string_count_int_person_1);

                editor.commit();

                Log.d("Number in the editor", String.valueOf(string_count_int_person_1));

            }





        }




    public void clicking_wink_person_2(View view) {

        person_2_count = (TextView) findViewById(R.id.Person_2_Count);


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs.getBoolean("MyPref", true)){

            int person_2_count_shared_to_add = pref.getInt("Saved_person_2_winks", 0);

            String string_count = String.valueOf(person_2_count_shared_to_add+1);

            person_2_count.setText(string_count);

            string_count_int_person_2 = Integer.valueOf(string_count);

            editor.putInt("Saved_person_2_winks", string_count_int_person_2);

            editor.commit();

            Log.d("Number in the editor", String.valueOf(string_count_int_person_2));

        }else {



            String string_count = String.valueOf(count_person2++);

            person_2_count.setText(string_count);

            // Trying Shared Prefs
            string_count_int_person_2 = Integer.valueOf(string_count);

            editor.putInt("Saved_person_2_winks", string_count_int_person_2);

            editor.commit();

            Log.d("Number in the editor", String.valueOf(string_count_int_person_2));
        }


    }




    public void clicking_reset_person_1(View view) {


        person_1_count = (TextView) findViewById(R.id.Person_1_Count);

        count_person1 = 0;

        String string_count_reset_person1 = String.valueOf(count_person1);

        person_1_count.setText(string_count_reset_person1);

        editor.clear();
        editor.commit();
    }

    public void clicking_reset_person_2(View view) {

        person_2_count = (TextView) findViewById(R.id.Person_2_Count);

        count_person2 = 0;

        String string_count_reset_person2 = String.valueOf(count_person2);

        person_2_count.setText(string_count_reset_person2);

        editor.clear();
        editor.commit();


    }

    public void clicking_back_to_activity(View view) {

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);

        editor_names.clear();
        editor_names.commit();



        Log.d("Clicked back to remove", "Edited");
    }

}
