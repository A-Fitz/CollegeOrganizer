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

public class Activity_Main extends AppCompatActivity {
    public static List<PhysicalActivity> physicalActivityList = new ArrayList<PhysicalActivity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("College Organizer");
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        final Button button_data_academic = findViewById(R.id.button_data_academic);
        button_data_academic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
            }
        });

        final Button button_data_physical = findViewById(R.id.button_data_physical);
        button_data_physical.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(Activity_Main.this, Activity_PhysicalActivityScheduler.class);
                Activity_Main.this.startActivity(myIntent);
            }
        });

        final Button button_applet_academic = findViewById(R.id.button_applet_academic);
        button_applet_academic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(Activity_Main.this, AcademicActivity.class);
                Activity_Main.this.startActivity(myIntent);
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
        physicalActivityList.add(new PhysicalActivity( "test1", calender.getTime(), googleCalendarColors.tomato, "test details1" , calender.getTime(), PhysicalActivityIntensity.LIGHT));
        physicalActivityList.add(new PhysicalActivity( "test2", calender.getTime(), googleCalendarColors.grape, "test details2" , calender.getTime(), PhysicalActivityIntensity.LIGHT));

        List<String> repeating = new ArrayList<String>();
        Calendar calender2 = calender;
        calender2.set(2009, 5, 19, 20, 14, 00);
        repeating.add("M");
        repeating.add("W");
        repeating.add("F");
        physicalActivityList.add(new PhysicalActivity( "test3", calender.getTime(), googleCalendarColors.blueberry, "test details3" , repeating, calender.getTime(), calender2.getTime(), PhysicalActivityIntensity.LIGHT));
    }

}
