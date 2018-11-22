package app.collegeorganizer.activities;

import android.graphics.RectF;
import android.widget.Toast;

import com.alamkanak.weekview.WeekViewEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import app.collegeorganizer.data.PhysicalActivity;
import app.collegeorganizer.data.SocialActivity;

public class Activity_Calendar extends Activity_BaseCalendar {
    private static List<PhysicalActivity> repeating_physicalActivityList = Activity_Main.repeating_physicalActivityList;
    private static List<SocialActivity> repeating_socialActivityList = Activity_Main.repeating_socialActivityList;

    private static List<PhysicalActivity> physicalActivityList = Activity_Main.physicalActivityList;
    private static List<SocialActivity> socialActivityList = Activity_Main.socialActivityList;

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
        List<WeekViewEvent> events = getEvents(newYear, newMonth);

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
        setRepeating();

        for (PhysicalActivity py : Activity_Main.repeating_physicalActivityList) {
            if (py.getMonth() == newMonth - 1 && py.getYear() == newYear) {
                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.DAY_OF_MONTH, py.getDay());
                startTime.set(Calendar.HOUR, py.getStartHour());
                startTime.set(Calendar.MINUTE, py.getStartMinute());
                startTime.set(Calendar.MONTH, newMonth - 1);
                startTime.set(Calendar.YEAR, newYear);

                Calendar endTime = (Calendar) startTime.clone();
                endTime.set(Calendar.HOUR, py.getEndHour());
                endTime.set(Calendar.MINUTE, py.getEndMinute());
                endTime.set(Calendar.MONTH, newMonth - 1);


                WeekViewEvent event = new WeekViewEvent(py.hashCode(), py.getTitle(), startTime, endTime);
                event.setColor(py.getColor());
                tempEvents.add(event);
            }
        }

        for (SocialActivity se : Activity_Main.repeating_socialActivityList) {
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
        Toast.makeText(this, "Clicked " + event.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmptyViewLongPress(Calendar time) {

    }

    @Override
    public void onEventLongPress(WeekViewEvent event, RectF eventRect) {

    }

    private void setRepeating() {
        if (repeating_physicalActivityList.size() != 0)
            repeating_physicalActivityList.clear();

        for (PhysicalActivity py : physicalActivityList) {
            if (py.doesRepeat())
                addTorepeating_physicalActivityList(py);
            else {
                repeating_physicalActivityList.add(py);
            }
        }

        if (repeating_socialActivityList.size() != 0)
            repeating_socialActivityList.clear();

        for (SocialActivity se : socialActivityList) {
            if (se.doesRepeat())
                addTorepeating_socialActivityList(se);
            else {
                repeating_socialActivityList.add(se);
            }
        }
    }

    private void addTorepeating_physicalActivityList(PhysicalActivity py) {
        List<String> repeatingDaysTemp = py.getRepeating();
        List<Integer> repeatingDays = getRepeatingDays(repeatingDaysTemp);

        repeating_physicalActivityList.add(py);

        PhysicalActivity temp = new PhysicalActivity(py);

        //Log.d("TESTF", String.valueOf("start: day(" + temp.getDay() + "), month(" + temp.getMonth() + "), year(" + temp.getYear() + ")"));
        //Log.d("TESTF", String.valueOf("repeatUntil: day(" + temp.getRepeatEndDay() + "), month(" + temp.getRepeatEndMonth() + "), year(" + temp.getRepeatEndYear() + ")"));
        //Log.d("TESTF", "-----------------------------------------------------");

        while (true) {
            temp = new PhysicalActivity(temp);
            for (int i : repeatingDays) {
                //Log.d("TESTF", "i:" + String.valueOf(i) );
                PhysicalActivity temp2 = incrementPhysicalActivityDate(temp, i);

                if (temp2.getDay() > temp2.getRepeatEndDay() && temp2.getMonth() >= temp2.getRepeatEndMonth())
                    return;

                if (temp2.getMonth() > temp2.getRepeatEndMonth() && temp2.getYear() == temp2.getRepeatEndYear())
                    return;

                repeating_physicalActivityList.add(temp2);

                //Log.d("TESTF", String.valueOf("****** Added start: day(" + temp2.getDay() + "), month(" + temp2.getMonth() + "), year(" + temp2.getYear() + ")"));
                //Log.d("TESTF", String.valueOf("****** Added repeatUntil: day(" + temp2.getRepeatEndDay() + "), month(" + temp2.getRepeatEndMonth() + "), year(" + temp2.getRepeatEndYear() + ")"));
            }
        }
    }

    private void addTorepeating_socialActivityList(SocialActivity se) {
        List<String> repeatingDaysTemp = se.getRepeating();
        List<Integer> repeatingDays = getRepeatingDays(repeatingDaysTemp);

        repeating_socialActivityList.add(se);

        SocialActivity temp = new SocialActivity(se);


        while (true) {
            temp = new SocialActivity(temp);
            for (int i : repeatingDays) {
                SocialActivity temp2 = incrementSocialActivityDate(temp, i);

                if (temp2.getDay() > temp2.getRepeatEndDay() && temp2.getMonth() >= temp2.getRepeatEndMonth())
                    return;

                if (temp2.getMonth() > temp2.getRepeatEndMonth() && temp2.getYear() == temp2.getRepeatEndYear())
                    return;

                repeating_socialActivityList.add(temp2);

            }
        }
    }

    private PhysicalActivity incrementPhysicalActivityDate(PhysicalActivity py, int nextDay) {
        Calendar currDay = py.getStartTime();

        Calendar nextStartTime = getNextDay(currDay, nextDay);
        Calendar nextEndTime = (Calendar) nextStartTime.clone();
        nextEndTime.set(Calendar.HOUR, py.getEndHour());
        nextEndTime.set(Calendar.MINUTE, py.getEndMinute());

        PhysicalActivity toReturn = new PhysicalActivity(py);

        return toReturn;
    }

    private SocialActivity incrementSocialActivityDate(SocialActivity se, int nextDay) {
        Calendar currDay = se.getStartTime();

        Calendar nextStartTime = getNextDay(currDay, nextDay);
        Calendar nextEndTime = (Calendar) nextStartTime.clone();
        nextEndTime.set(Calendar.HOUR, se.getEndHour());
        nextEndTime.set(Calendar.MINUTE, se.getEndMinute());

        SocialActivity toReturn = new SocialActivity(se);

        return toReturn;
    }

    private Calendar getNextDay(Calendar date, int dayOfWeek) {

        int diff = dayOfWeek - date.get(Calendar.DAY_OF_WEEK);
        if (diff <= 0) {
            diff += 7;
        }
        date.add(Calendar.DAY_OF_MONTH, diff);
        //Log.d("TESTF", String.valueOf("********** nextDay: dayOfWeek(" + dayOfWeek + "), diff(" + diff + "), newDate day(" + date.get(Calendar.DAY_OF_MONTH) + "), newDate month(" + date.get(Calendar.MONTH) + ")"));
        return date;
    }

    private List<Integer> getRepeatingDays(List<String> repeatingDaysTemp) {
        List<Integer> repeatingDays = new ArrayList<Integer>();

        for (String str : repeatingDaysTemp) {
            switch (str) {
                case "SU":
                    repeatingDays.add(Calendar.SUNDAY);
                    break;
                case "M":
                    repeatingDays.add(Calendar.MONDAY);
                    break;
                case "T":
                    repeatingDays.add(Calendar.TUESDAY);
                    break;
                case "W":
                    repeatingDays.add(Calendar.WEDNESDAY);
                    break;
                case "TH":
                    repeatingDays.add(Calendar.THURSDAY);
                    break;
                case "F":
                    repeatingDays.add(Calendar.FRIDAY);
                    break;
                case "S":
                    repeatingDays.add(Calendar.SATURDAY);
                    break;
            }
        }

        return repeatingDays;
    }
}
