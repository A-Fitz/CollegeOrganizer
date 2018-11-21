package app.collegeorganizer.activities;

import com.alamkanak.weekview.WeekViewEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import app.collegeorganizer.data.PhysicalActivity;
import app.collegeorganizer.data.SocialEvent;

public class Activity_Calendar extends Activity_BaseCalendar {

    @Override
    public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
        List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();

        for (PhysicalActivity py : Activity_Main.physicalActivityList) {
            //TODO if stuff starts being weird it's because of here, maybe an if statement is needed
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
            events.add(event);
        }

        for (SocialEvent se : Activity_Main.socialEventList) {
            //TODO if stuff starts being weird it's because of here, maybe an if statement is needed
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
            events.add(event);
        }

        return events;
    }

}
