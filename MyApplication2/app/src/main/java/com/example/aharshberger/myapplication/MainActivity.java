package com.example.aharshberger.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int count_person1 = 1;
    int count_person2 = 1;
    int string_count_int_person_1, string_count_int_person_2;
    SharedPreferences pref;
    SharedPreferences.Editor editor, editor_names;
    String person_1_name_saved, person_2_name_saved;
    TextView person_1, person_2, person_1_count, person_2_count;



    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = (LayoutInflater)
                this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewGroup v = (ViewGroup)inflater.inflate(R.layout.fragment_main, null, false);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        pref = getApplicationContext().getSharedPreferences("prefs", MODE_PRIVATE);
        editor_names = pref.edit();



        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
        if (isFirstRun){

            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);

            builder1.setIcon(R.mipmap.ic_launcher_w);

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


        person_1 = (TextView) v.findViewById(R.id.person_1);
        person_2 = (TextView) v.findViewById(R.id.person_2);
        person_1_count = (TextView) v.findViewById(R.id.Person_1_Count);
        person_2_count = (TextView) v. findViewById(R.id.Person_2_Count);

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




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clickingSmiley(View view) {{

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);

        builder1.setIcon(R.mipmap.ic_launcher_w);
        builder1.setTitle(" ");
        builder1.setMessage("Player 1 vs. Player 2");
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

    public void clicking_reset_person_2(View view) {
        LayoutInflater inflater = (LayoutInflater)
                this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewGroup v = (ViewGroup)inflater.inflate(R.layout.fragment_main, null, false);
        person_2_count = (TextView) v.findViewById(R.id.Person_2_Count);

        count_person2 = 0;

        String string_count_reset_person2 = String.valueOf(count_person2);

        person_2_count.setText(string_count_reset_person2);

        editor.clear();
        editor.commit();


    }

    public void clicking_wink_person_1(View view) {

        LayoutInflater inflater = (LayoutInflater)
                this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewGroup v = (ViewGroup)inflater.inflate(R.layout.fragment_main, null, false);
        person_1_count = (TextView) v.findViewById(R.id.Person_1_Count);

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
        LayoutInflater inflater = (LayoutInflater)
                this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewGroup v = (ViewGroup)inflater.inflate(R.layout.fragment_main, null, false);

        person_2_count = (TextView) v.findViewById(R.id.Person_2_Count);


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
        LayoutInflater inflater = (LayoutInflater)
                this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewGroup v = (ViewGroup)inflater.inflate(R.layout.fragment_main, null, false);
        person_1_count = (TextView) v.findViewById(R.id.Person_1_Count);

        count_person1 = 0;

        String string_count_reset_person1 = String.valueOf(count_person1);

        person_1_count.setText(string_count_reset_person1);

        editor.clear();
        editor.commit();
    }

    public void clickingHelp(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);

        builder1.setIcon(R.mipmap.ic_launcher_w);
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

    public void clicking_change_player_1(View view) {
        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.dialoguebox, null);

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

    public void clicking_change_player_2(View view) {
        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.dialoguebox, null);

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

    public void clickingTextViewP1(final View view) {
        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.dialoguebox, null);

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

                                LayoutInflater li = LayoutInflater.from(MainActivity.this);
                                View v = li.inflate(R.layout.fragment_main, null);

                                person_1 = (TextView) v.findViewById(R.id.person_1);

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
        View promptsView = li.inflate(R.layout.dialoguebox, null);

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


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;

        }

    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
