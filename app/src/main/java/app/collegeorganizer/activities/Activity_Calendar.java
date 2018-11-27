package app.collegeorganizer.activities;

import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.alamkanak.weekview.DateTimeInterpreter;
import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import app.collegeorganizer.R;
import app.collegeorganizer.data.PhysicalActivity;
import app.collegeorganizer.data.SocialActivity;
import app.collegeorganizer.fragments.Fragment_ViewPhysicalActivityEvent;
import app.collegeorganizer.fragments.Fragment_ViewSocialActivityEvent;


public class Activity_Calendar extends AppCompatActivity implements WeekView.EventClickListener, MonthLoader.MonthChangeListener, WeekView.EventLongPressListener, WeekView.EmptyViewLongPressListener, WeekView.EmptyViewClickListener, WeekView.AddEventClickListener, WeekView.DropListener {
    private static final int TYPE_DAY_VIEW = 1;
    private static final int TYPE_THREE_DAY_VIEW = 2;
    private static final int TYPE_WEEK_VIEW = 3;
    private int mWeekViewType = TYPE_DAY_VIEW;
    private WeekView mWeekView;

    private static List<PhysicalActivity> _physicalActivityList = Activity_Main._physicalActivityList;
    private static List<SocialActivity> _socialActivityList = Activity_Main._socialActivityList;
    private List<WeekViewEvent> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get a reference for the week view in the layout.
        mWeekView = findViewById(R.id.weekView);

        // Show a toast message about the touched event.
        mWeekView.setOnEventClickListener(this);

        // The week view has infinite scrolling horizontally. We have to provide the events of a
        // month every time the month changes on the week view.
        mWeekView.setMonthChangeListener(this);

        // Set long press listener for events.
        mWeekView.setEventLongPressListener(this);

        // Set long press listener for empty view
        mWeekView.setEmptyViewLongPressListener(this);

        // Set EmptyView Click Listener
        mWeekView.setEmptyViewClickListener(this);

        // Set AddEvent Click Listener
        mWeekView.setAddEventClickListener(this);

        // Set Drag and Drop Listener
        //mWeekView.setDropListener(this);

        // Set up a date time interpreter to interpret how the date and time will be formatted in
        // the week view. This is optional.
        setupDateTimeInterpreter(false);
    }

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {

        this.events = getEvents(newYear, newMonth);

        /*for (WeekViewEvent event : events) {
            Log.d("TESTF", "Event Month: " + String.valueOf(event.getStartTime().get(Calendar.MONTH)));
            Log.d("TESTF", "New Month: " + String.valueOf(newMonth-1));
            Log.d("TESTF", "eventmonth == newmonth: " + String.valueOf(event.getStartTime().get(Calendar.MONTH)== newMonth-1));
            Log.d("TESTF", "-----------------------------------------------------");

        }*/

        return events;
    }

    private List<WeekViewEvent> getEvents(int newYear, int newMonth) {
        List<WeekViewEvent> tempEvents = new ArrayList<>();


        for (PhysicalActivity py : _physicalActivityList) {
            if (py.getMonth() == newMonth - 1 && py.getYear() == newYear) {
                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.DAY_OF_MONTH, py.getDay());
                startTime.set(Calendar.HOUR_OF_DAY, py.getStartHour());
                startTime.set(Calendar.MINUTE, py.getStartMinute());
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);

                Calendar endTime = (Calendar) startTime.clone();
                endTime.set(Calendar.HOUR_OF_DAY, py.getEndHour());
                endTime.set(Calendar.MINUTE, py.getEndMinute());
                endTime.set(Calendar.MONTH, newMonth - 1);


                WeekViewEvent event = new WeekViewEvent(py.hashCode(), py.getTitle(), startTime, endTime);

                event.setColor(py.getColor());

                //Log.d("TESTF", String.valueOf(py.getStartHour()));
                tempEvents.add(event);
            }
        }

        for (SocialActivity se : _socialActivityList) {
            if (se.getMonth() == newMonth - 1 && se.getYear() == newYear) {
                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.DAY_OF_MONTH, se.getDay());
                startTime.set(Calendar.HOUR, se.getStartHour());
                startTime.set(Calendar.MINUTE, se.getStartMinute());
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);

                Calendar endTime = (Calendar) startTime.clone();
                endTime.set(Calendar.HOUR, se.getEndHour());
                endTime.set(Calendar.MINUTE, se.getEndMinute());
                endTime.set(Calendar.MONTH, newMonth - 1);

                WeekViewEvent event = new WeekViewEvent(se.hashCode(), se.getTitle(), startTime, endTime);

                event.setColor(se.getColor());
                tempEvents.add(event);
            }
        }

        return tempEvents;
    }

    private Object findActivityByID(long id) {
        for (PhysicalActivity py : _physicalActivityList) {
            if (py.hashCode() == id)
                return py;
        }
        for (SocialActivity se : _socialActivityList) {
            if (se.hashCode() == id)
                return se;
        }

        return null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        /*mWeekView.setShowDistinctPastFutureColor(true);
        mWeekView.setShowDistinctWeekendColor(true);
        mWeekView.setFutureBackgroundColor(Color.rgb(24,85,96));
        mWeekView.setFutureWeekendBackgroundColor(Color.rgb(255,0,0));
        mWeekView.setPastBackgroundColor(Color.rgb(85,189,200));
        mWeekView.setPastWeekendBackgroundColor(Color.argb(50, 0,255,0));*/

        mWeekView.setShowNowLine(true);
        mWeekView.setNowLineColor(android.R.color.holo_blue_light);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_calendar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        setupDateTimeInterpreter(id == R.id.action_week_view);
        switch (id) {
            case R.id.action_today:
                mWeekView.goToToday();
                return true;
            case R.id.action_day_view:
                if (mWeekViewType != TYPE_DAY_VIEW) {
                    item.setChecked(!item.isChecked());
                    mWeekViewType = TYPE_DAY_VIEW;
                    mWeekView.setNumberOfVisibleDays(1);

                    // Lets change some dimensions to best fit the view.
                    mWeekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()));
                    mWeekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                    mWeekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                }
                return true;
            case R.id.action_three_day_view:
                if (mWeekViewType != TYPE_THREE_DAY_VIEW) {
                    item.setChecked(!item.isChecked());
                    mWeekViewType = TYPE_THREE_DAY_VIEW;
                    mWeekView.setNumberOfVisibleDays(3);

                    // Lets change some dimensions to best fit the view.
                    mWeekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()));
                    mWeekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                    mWeekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                }
                return true;
            case R.id.action_week_view:
                if (mWeekViewType != TYPE_WEEK_VIEW) {
                    item.setChecked(!item.isChecked());
                    mWeekViewType = TYPE_WEEK_VIEW;
                    mWeekView.setNumberOfVisibleDays(7);

                    // Lets change some dimensions to best fit the view.
                    mWeekView.setColumnGap((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics()));
                    mWeekView.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, getResources().getDisplayMetrics()));
                    mWeekView.setEventTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 10, getResources().getDisplayMetrics()));
                }
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Set up a date time interpreter which will show short date values when in week view and long
     * date values otherwise.
     *
     * @param shortDate True if the date values should be short.
     */
    private void setupDateTimeInterpreter(final boolean shortDate) {
        mWeekView.setDateTimeInterpreter(new DateTimeInterpreter() {
            @Override
            public String interpretDate(Calendar date) {
                SimpleDateFormat weekdayNameFormat = new SimpleDateFormat("EEE", Locale.getDefault());
                String weekday = weekdayNameFormat.format(date.getTime());
                SimpleDateFormat format = new SimpleDateFormat(" M/d", Locale.getDefault());

                // All android api level do not have a standard way of getting the first letter of
                // the week day name. Hence we get the first char programmatically.
                // Details: http://stackoverflow.com/questions/16959502/get-one-letter-abbreviation-of-week-day-of-a-date-in-java#answer-16959657
                if (shortDate)
                    weekday = String.valueOf(weekday.charAt(0));
                return weekday.toUpperCase() + format.format(date.getTime());
            }

            @Override
            public String interpretTime(int hour, int minutes) {
                String strMinutes = String.format("%02d", minutes);
                if (hour > 11) {
                    return (hour - 12) + ":" + strMinutes + " PM";
                } else {
                    if (hour == 0) {
                        return "12:" + strMinutes + " AM";
                    } else {
                        return hour + ":" + strMinutes + " AM";
                    }
                }
            }
        });
    }

    protected String getEventTitle(Calendar time) {
        return String.format("Event of %02d:%02d %s/%d", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE), time.get(Calendar.MONTH) + 1, time.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onEventClick(WeekViewEvent event, RectF eventRect) {
        Object eventByID = findActivityByID(event.getId());

        if (eventByID instanceof PhysicalActivity) {
            PhysicalActivity item = (PhysicalActivity) eventByID;
            DialogFragment newFragment = Fragment_ViewPhysicalActivityEvent.newInstance();
            newFragment.show(getSupportFragmentManager(), "View Event");
            ((Fragment_ViewPhysicalActivityEvent) newFragment).setEvent(item);
        } else if (eventByID instanceof SocialActivity) {
            SocialActivity item = (SocialActivity) eventByID;
            DialogFragment newFragment = Fragment_ViewSocialActivityEvent.newInstance();
            newFragment.show(getSupportFragmentManager(), "View Event");
            ((Fragment_ViewSocialActivityEvent) newFragment).setEvent(item);
        }
    }

    @Override
    public void onEventLongPress(WeekViewEvent event, RectF eventRect) {
        Object activity = findActivityByID(event.getId());

        this.events.remove(event);

        if (activity instanceof PhysicalActivity) {
            PhysicalActivity item = (PhysicalActivity) activity;
            _physicalActivityList.remove(item);
        } else if (activity instanceof SocialActivity) {
            SocialActivity item = (SocialActivity) activity;
            _socialActivityList.remove(item);
        }

        //refresh
        mWeekView.notifyDatasetChanged();
    }

    @Override
    public void onEmptyViewLongPress(Calendar time) {
        Toast.makeText(this, "Empty view long pressed: " + getEventTitle(time), Toast.LENGTH_SHORT).show();
    }

    public WeekView getWeekView() {
        return mWeekView;
    }

    @Override
    public void onEmptyViewClicked(Calendar date) {
        Toast.makeText(this, "Empty view" + " clicked: " + getEventTitle(date), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAddEventClicked(Calendar startTime, Calendar endTime) {
        Toast.makeText(this, "Add event clicked.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDrop(View view, Calendar date) {
        Toast.makeText(this, "View dropped to " + date.toString(), Toast.LENGTH_SHORT).show();
    }
}