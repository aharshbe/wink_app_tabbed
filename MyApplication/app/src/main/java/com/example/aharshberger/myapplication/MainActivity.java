package com.example.aharshberger.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    int count_person1 = 1;
    int count_person2 = 1;
    int string_count_int_person_1, string_count_int_person_2;
    SharedPreferences pref;
    SharedPreferences.Editor editor, editor_names;
    String person_1_name_saved, person_2_name_saved;
    TextView person_1, person_2, person_1_count, person_2_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         pref = getApplicationContext().getSharedPreferences("prefs", MODE_PRIVATE);
         editor_names = pref.edit();



            boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
            if (isFirstRun){

                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);

                builder1.setIcon(R.mipmap.ic_launcher_wink);

                builder1.setTitle("Welcome to Wink Tracker!");

                builder1.setMessage("To play, just change the name of each player and start adding up the winks.");

                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Sounds good!",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();

                getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                        .edit()
                        .putBoolean("isFirstRun", false)
                        .apply();
            }


        person_1 = (TextView) findViewById(R.id.person_1);
        person_2 = (TextView) findViewById(R.id.person_2);
        person_1_count = (TextView) findViewById(R.id.Person_1_Count);
        person_2_count = (TextView) findViewById(R.id.Person_2_Count);

        // Creating Shared Prefs

        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs.getBoolean("MyPref", true)) {

            person_1_count.setText(String.valueOf(pref.getInt("Saved_person_1_winks", 0)));
            person_2_count.setText(String.valueOf(pref.getInt("Saved_person_2_winks", 0)));

            person_1.setText(pref.getString("Saved_person_1_name", "Player 1"));
            person_2.setText(pref.getString("Saved_person_2_name", "Player 2"));
        }

    }

    public void clickingHelp(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);

        builder1.setIcon(R.mipmap.ic_launcher_wink);
        builder1.setTitle("Needed help huh?");
        builder1.setMessage("To play, just change the name of each player and start adding up the winks.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Sounds good!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();

        getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .edit()
                .putBoolean("isFirstRun", false)
                .apply();

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

    public void clicking_change_player_2(View view) {

        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.diagloguebox, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.editTextDialogUserInput);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text

                                person_2.setText(userInput.getText());

                                // Trying Shared Prefs
                                person_2_name_saved = userInput.getText().toString();

                                editor.putString("Saved_person_2_name", person_2_name_saved);

                                editor.commit();

                                Log.d("Changed name to: ", person_2_name_saved);
                            }

                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();


    }

    public void clicking_change_player_1(View view) {
        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.diagloguebox, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.editTextDialogUserInput);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text

                                    person_1.setText(userInput.getText());

                                    // Trying Shared Prefs
                                    person_1_name_saved = userInput.getText().toString();

                                    editor.putString("Saved_person_1_name", person_1_name_saved);

                                    editor.commit();

                                    Log.d("Changed name to: ", person_1_name_saved);
                                }

                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    public void clickingTextViewP1(View view) {
        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.diagloguebox, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.editTextDialogUserInput);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text

                                person_1.setText(userInput.getText());

                                // Trying Shared Prefs
                                person_1_name_saved = userInput.getText().toString();

                                editor.putString("Saved_person_1_name", person_1_name_saved);

                                editor.commit();

                                Log.d("Changed name to: ", person_1_name_saved);
                            }

                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    public void clickingTextViewP2(View view) {
             // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.diagloguebox, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.editTextDialogUserInput);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text

                                person_2.setText(userInput.getText());

                                // Trying Shared Prefs
                                person_2_name_saved = userInput.getText().toString();

                                editor.putString("Saved_person_2_name", person_2_name_saved);

                                editor.commit();

                                Log.d("Changed name to: ", person_2_name_saved);
                            }

                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }

    public void clickingSmiley(View view)
    {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);

        builder1.setIcon(R.mipmap.ic_launcher_wink);
        builder1.setTitle(" ");
        builder1.setMessage(pref.getString("Saved_person_1_name", "Player 1") + " Vs. " + pref.getString("Saved_person_2_name", "Player 2"));
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Let's go!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();

        getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .edit()
                .putBoolean("isFirstRun", false)
                .apply();

    }
}


