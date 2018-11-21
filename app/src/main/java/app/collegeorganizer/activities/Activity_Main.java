package app.collegeorganizer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import app.collegeorganizer.R;
import app.collegeorganizer.data.GoogleCalendarColors;
import app.collegeorganizer.data.PhysicalActivity;
import app.collegeorganizer.data.PhysicalActivityIntensity;
import app.collegeorganizer.data.SocialEvent;

public class Activity_Main extends AppCompatActivity {
    public static List<PhysicalActivity> physicalActivityList = new ArrayList<PhysicalActivity>();
    public static List<SocialEvent> socialEventList = new ArrayList<SocialEvent>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("College Organizer");

        /* data buttons */
        final Button button_data_academic = findViewById(R.id.button_data_academic);
        button_data_academic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
            }
        });

        final Button button_data_physical = findViewById(R.id.button_data_physical);
        button_data_physical.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        final Button button_data_social = findViewById(R.id.button_data_social);
        button_data_social.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        final Button button_data_diet = findViewById(R.id.button_data_diet);
        button_data_diet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        final Button button_data_sleep = findViewById(R.id.button_data_sleep);
        button_data_sleep.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        final Button button_data_mood = findViewById(R.id.button_data_mood);
        button_data_mood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        /* applet buttons */
        final Button button_applet_academic = findViewById(R.id.button_applet_academic);
        button_applet_academic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(Activity_Main.this, AcademicActivity.class);
                Activity_Main.this.startActivity(myIntent);
            }
        });

        final Button button_applet_physical = findViewById(R.id.button_applet_physical);
        button_applet_physical.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(Activity_Main.this, Activity_PhysicalActivityScheduler.class);
                Activity_Main.this.startActivity(myIntent);
            }
        });

        final Button button_applet_social = findViewById(R.id.button_applet_social);
        button_applet_social.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(Activity_Main.this, Activity_SocialScheduler.class);
                Activity_Main.this.startActivity(myIntent);
            }
        });

        final Button button_applet_diet = findViewById(R.id.button_applet_diet);
        button_applet_diet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
        final Button button_applet_sleep = findViewById(R.id.button_applet_sleep);
        button_applet_sleep.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
        final Button button_applet_mood = findViewById(R.id.button_applet_mood);
        button_applet_mood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        addTestObjects();
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

        switch(id) {
            case R.id.action_settings: {
                Intent myIntent = new Intent(Activity_Main.this, Activity_Settings.class);
                Activity_Main.this.startActivity(myIntent);
                return true;
            }
            case R.id.action_moveicons: {
                Toast.makeText(this, "move icons clicked", Toast.LENGTH_SHORT).show();
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    private void addTestObjects()
    {
        Calendar calender = Calendar.getInstance();
        GoogleCalendarColors googleCalendarColors = new GoogleCalendarColors();
        physicalActivityList.add(new PhysicalActivity("test1", calender.getTime(), googleCalendarColors.tomato, "test1 details", calender.getTime(), PhysicalActivityIntensity.LIGHT));
        physicalActivityList.add(new PhysicalActivity("test2", calender.getTime(), googleCalendarColors.grape, "test2 details", calender.getTime(), PhysicalActivityIntensity.LIGHT));
        socialEventList.add(new SocialEvent("test1", "test1 details", "test1 location", calender.getTime(), calender.getTime(), googleCalendarColors.banana));
        socialEventList.add(new SocialEvent("test2", "test2 details", "test2 location", calender.getTime(), calender.getTime(), googleCalendarColors.lavender));

        List<String> repeating = new ArrayList<String>();
        Calendar calender2 = calender;
        calender2.set(2009, 5, 19, 20, 14, 00);
        repeating.add("M");
        repeating.add("W");
        repeating.add("F");
        physicalActivityList.add(new PhysicalActivity( "test3", calender.getTime(), googleCalendarColors.blueberry, "test details3" , repeating, calender.getTime(), calender2.getTime(), PhysicalActivityIntensity.LIGHT));
        socialEventList.add(new SocialEvent("test2", "test2 details", "test2 location", calender.getTime(), calender.getTime(), calender.getTime(), repeating, googleCalendarColors.lavender));
    }

}
