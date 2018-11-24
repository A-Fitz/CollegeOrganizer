package app.collegeorganizer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import app.collegeorganizer.R;
import app.collegeorganizer.data.DietItem;
import app.collegeorganizer.data.GoogleCalendarColors;
import app.collegeorganizer.data.MealCategory;
import app.collegeorganizer.data.PhysicalActivity;
import app.collegeorganizer.data.SocialActivity;

public class Activity_Main extends AppCompatActivity {
    public static List<PhysicalActivity> physicalScheduleList = new ArrayList<PhysicalActivity>();
    public static List<SocialActivity> socialScheduleList = new ArrayList<SocialActivity>();

    public static List<DietItem> dietItemList = new ArrayList<DietItem>();

    public static List<PhysicalActivity> _physicalActivityList = new ArrayList<PhysicalActivity>();
    public static List<SocialActivity> _socialActivityList = new ArrayList<SocialActivity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("College Organizer");

        addDataButtonListeners();
        addAppletButtonListeners();
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
        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = (Calendar) startCalendar.clone();
        GoogleCalendarColors googleCalendarColors = new GoogleCalendarColors();
        /*
        endCalendar.add(Calendar.HOUR, 1);
        physicalActivityList.add(new PhysicalActivity("test1", startCalendar, endCalendar, googleCalendarColors.tomato, "test1 details", PhysicalActivityIntensity.LIGHT));

        Calendar startCalendar1 = (Calendar) startCalendar.clone();
        startCalendar1.add(Calendar.HOUR, 3);
        Calendar endCalendar1 = (Calendar) startCalendar1.clone();
        endCalendar1.add(Calendar.HOUR, 1);
        physicalActivityList.add(new PhysicalActivity("test2", startCalendar1, endCalendar1, googleCalendarColors.grape, "test2 details", PhysicalActivityIntensity.HEAVY));


        Calendar startCalendar2 = (Calendar) startCalendar1.clone();
        startCalendar2.add(Calendar.HOUR, 2);
        Calendar endCalendar2 = (Calendar) startCalendar2.clone();
        endCalendar2.add(Calendar.HOUR, 1);
        socialActivityList.add(new SocialActivity("test3", "test3 details", "test3 location", startCalendar2, endCalendar2, googleCalendarColors.banana));

        Calendar startCalendar3 = (Calendar) startCalendar2.clone();
        startCalendar3.add(Calendar.HOUR, 3);
        Calendar endCalendar3 = (Calendar) startCalendar3.clone();
        endCalendar3.add(Calendar.HOUR, 1);
        Calendar endDate3 = (Calendar) startCalendar3.clone();
        endDate3.add(Calendar.DAY_OF_MONTH, 23);
        List<String> repeating3 = new ArrayList<String>();
        repeating3.add("SU");
        repeating3.add("W");
        repeating3.add("F");
        physicalActivityList.add(new PhysicalActivity("test4", startCalendar3, endCalendar3, googleCalendarColors.grape, "test4 details", repeating3, endDate3, PhysicalActivityIntensity.HEAVY));

        */
        //socialActivityList.add(new SocialActivity("test2", "test2 details", "test2 location", calender.getTime(), calender.getTime(), googleCalendarColors.lavender));
        dietItemList.add(new DietItem("test5 food", MealCategory.BREAKFAST, Calendar.getInstance(), "test5 amount", googleCalendarColors.blueberry));
        dietItemList.add(new DietItem("test6 food", MealCategory.LUNCH, startCalendar, "test6 amount", googleCalendarColors.peacock));
    }


    private void addDataButtonListeners() {
        /* data buttons */
        final Button button_data_academic = findViewById(R.id.button_data_academic);
        button_data_academic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

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
    }

    private void addAppletButtonListeners() {
        /* applet buttons */
        final Button button_applet_calendar = findViewById(R.id.button_applet_calendar);
        button_applet_calendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Main.this, Activity_Calendar.class);
                startActivity(intent);
            }
        });

        final Button button_applet_academic = findViewById(R.id.button_applet_academic);
        button_applet_academic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(Activity_Main.this, Activity_AcademicSchedulerRecorder.class);
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
                Intent myIntent = new Intent(Activity_Main.this, Activity_DietRecorder.class);
                Activity_Main.this.startActivity(myIntent);
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
    }

}
