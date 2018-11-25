package app.collegeorganizer.activities;

import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.alamkanak.weekview.WeekViewEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import app.collegeorganizer.data.PhysicalActivity;
import app.collegeorganizer.data.SocialActivity;
import app.collegeorganizer.fragments.Fragment_ViewPhysicalActivityEvent;
import app.collegeorganizer.fragments.Fragment_ViewSocialActivityEvent;

public class Activity_Calendar extends Activity_BaseCalendar {
    private static List<PhysicalActivity> _physicalActivityList = Activity_Main._physicalActivityList;
    private static List<SocialActivity> _socialActivityList = Activity_Main._socialActivityList;
    private List<WeekViewEvent> events;

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
        if (this.events != null)
            this.events.clear();

        this.events = getEvents(newYear, newMonth);

        /*for (WeekViewEvent event : events) {
            Log.d("TESTF", "Event Month: " + String.valueOf(event.getStartTime().get(Calendar.MONTH)));
            Log.d("TESTF", "New Month: " + String.valueOf(newMonth-1));
            Log.d("TESTF", "eventmonth == newmonth: " + String.valueOf(event.getStartTime().get(Calendar.MONTH)== newMonth-1));
            Log.d("TESTF", "-----------------------------------------------------");

        }*/

        return events;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        //refresh?
    }

    @Override
    public void onEmptyViewLongPress(Calendar time) {

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
}
