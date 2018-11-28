package app.collegeorganizer.activities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.text.emoji.EmojiCompat;
import android.support.text.emoji.FontRequestEmojiCompatConfig;
import android.support.text.emoji.bundled.BundledEmojiCompatConfig;
import android.support.v4.provider.FontRequest;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import app.collegeorganizer.AlarmReceiver;
import app.collegeorganizer.DeviceBootReceiver;
import app.collegeorganizer.R;
import app.collegeorganizer.TimePreference;
import app.collegeorganizer.data.DataComparerCategory;
import app.collegeorganizer.data.DietItem;
import app.collegeorganizer.data.GoogleCalendarColors;
import app.collegeorganizer.data.PhysicalActivity;
import app.collegeorganizer.data.SleepItem;
import app.collegeorganizer.data.SocialActivity;
import app.collegeorganizer.data.Stat;
import app.collegeorganizer.enums.MealCategory;
import app.collegeorganizer.enums.SleepQualityTypes;
import app.collegeorganizer.enums.SleepStatTypes;
import app.collegeorganizer.enums.SleepTimeType;

public class Activity_Main extends AppCompatActivity {
    public static List<PhysicalActivity> physicalScheduleList = new ArrayList<PhysicalActivity>();
    public static List<SocialActivity> socialScheduleList = new ArrayList<SocialActivity>();

    public static List<DietItem> dietItemList = new ArrayList<DietItem>();
    public static List<SleepItem> sleepItemList = new ArrayList<SleepItem>();

    public static List<PhysicalActivity> _physicalActivityList = new ArrayList<PhysicalActivity>();
    public static List<SocialActivity> _socialActivityList = new ArrayList<SocialActivity>();

    public static List<DataComparerCategory> dataComparerCategoryList = new ArrayList<DataComparerCategory>();

    public static boolean TESTING = true; //there is a setting preference for this

    private static final String TAG = "MainActivity";

    /**
     * Change this to {@code false} when you want to use the downloadable Emoji font.
     */
    private static final boolean USE_BUNDLED_EMOJI = true;

    private SimpleDateFormat format_time = new SimpleDateFormat("hh:mm aa");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("College Organizer");

        initEmojiCompat();

        addDataButtonListeners();
        addAppletButtonListeners();
        if (TESTING)
            addTestObjects();

        getSleepualityNotificationPrefs();
    }

    private void getSleepualityNotificationPrefs() {
        PreferenceManager.setDefaultValues(this, R.xml.pref_notification, false);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        Boolean dailyNotify = sharedPref.getBoolean("preference_switch_sleep_notification", false);

        PackageManager pm = this.getPackageManager();
        ComponentName receiver = new ComponentName(this, DeviceBootReceiver.class);
        Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        // if user enabled daily notifications
        if (dailyNotify) {
            String timePreference = sharedPref.getString("preference_timepicker_sleep_notification", " ");

            int chosenHour = TimePreference.getHour(timePreference);
            int chosenMinute = TimePreference.getMinute(timePreference);

            //Toast.makeText(this, "got time: " + chosenHour + ":" + chosenMinute, Toast.LENGTH_SHORT).show();

            //region Enable Daily Notifications
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());

            if (TESTING)
                calendar.add(Calendar.SECOND, 2);
            else {
                calendar.set(Calendar.HOUR_OF_DAY, chosenHour);
                calendar.set(Calendar.MINUTE, chosenMinute);
            }

            // if notification time is before selected time, send notification the next day
            if (calendar.before(Calendar.getInstance())) {
                calendar.add(Calendar.DATE, 1);
                if (TESTING)
                    Toast.makeText(this, "day added", Toast.LENGTH_SHORT).show();
            }

            if (manager != null) {
                manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY, pendingIntent);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                    if (TESTING)
                        Toast.makeText(this, "alarm set for: " + String.valueOf(format_time.format(calendar.getTime())), Toast.LENGTH_SHORT).show();
                }
            }
            //To enable Boot Receiver class
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);
            //endregion
        } else { //Disable Daily Notifications
            if (PendingIntent.getBroadcast(this, 0, alarmIntent, 0) != null && manager != null) {
                manager.cancel(pendingIntent);
                //Toast.makeText(this,"Notifications were disabled",Toast.LENGTH_SHORT).show();
            }
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                    PackageManager.DONT_KILL_APP);
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

        switch(id) {
            case R.id.action_settings: {
                Intent myIntent = new Intent(Activity_Main.this, Activity_Settings.class);
                Activity_Main.this.startActivity(myIntent);
                return true;
            }
            case R.id.action_moveicons: {
                if (TESTING)
                    Toast.makeText(this, "move icons clicked", Toast.LENGTH_SHORT).show();
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    private void initEmojiCompat() {
        final EmojiCompat.Config config;
        if (USE_BUNDLED_EMOJI) {
            // Use the bundled font for EmojiCompat
            config = new BundledEmojiCompatConfig(getApplicationContext());
        } else {
            // Use a downloadable font for EmojiCompat
            final FontRequest fontRequest = new FontRequest(
                    "com.google.android.gms.fonts",
                    "com.google.android.gms",
                    "Noto Color Emoji Compat",
                    R.array.com_google_android_gms_fonts_certs);
            config = new FontRequestEmojiCompatConfig(getApplicationContext(), fontRequest);
        }

        EmojiCompat.init(config);
    }

    private void addTestObjects()
    {
        final Button button_test_notification = findViewById(R.id.button_test_notification);
        button_test_notification.setText("TEST NOTIFICATION");
        button_test_notification.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getSleepualityNotificationPrefs();
            }
        });

        Calendar startCalendar = Calendar.getInstance();

        dietItemList.add(new DietItem("test5 food", MealCategory.BREAKFAST, Calendar.getInstance(), "test5 amount", GoogleCalendarColors.blueberry));
        dietItemList.add(new DietItem("test6 food", MealCategory.LUNCH, startCalendar, "test6 amount", GoogleCalendarColors.peacock));

        List<SleepQualityTypes> sleepQualityTypesList = new ArrayList<SleepQualityTypes>();
        sleepQualityTypesList.add(SleepQualityTypes.NOT_WITHIN_30_MINUTES);
        Calendar sleepStart = Calendar.getInstance();
        sleepStart.set(Calendar.HOUR_OF_DAY, 18);
        Calendar sleepEnd = (Calendar) sleepStart.clone();
        sleepEnd.set(Calendar.HOUR_OF_DAY, 8);
        sleepEnd.add(Calendar.DAY_OF_MONTH, 1);
        sleepItemList.add(new SleepItem(SleepTimeType.NIGHT, sleepQualityTypesList, sleepStart, sleepEnd, "", GoogleCalendarColors.peacock));

        List<Stat> statList = new ArrayList<Stat>();
        statList.add(new Stat(SleepStatTypes.PSQI_SCORE_ALL_TIME, 900));
        dataComparerCategoryList.add(new DataComparerCategory("test category", statList, GoogleCalendarColors.basil));
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
        final Button button_data_comparer = findViewById(R.id.button_data_comparer);
        button_data_comparer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Main.this, Activity_Data_Comparer.class);
                startActivity(intent);
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
                Intent myIntent = new Intent(Activity_Main.this, Activity_SleepRecorder.class);
                Activity_Main.this.startActivity(myIntent);
            }
        });
        final Button button_applet_mood = findViewById(R.id.button_applet_mood);
        button_applet_mood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }

}
