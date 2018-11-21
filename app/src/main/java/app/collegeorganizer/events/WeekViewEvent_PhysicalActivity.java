package app.collegeorganizer.events;

import com.alamkanak.weekview.WeekViewEvent;

public class WeekViewEvent_PhysicalActivity extends WeekViewEvent {
    public WeekViewEvent_PhysicalActivity(long id, String name, int year, int month, int day, int startHour, int startMinute, int endHour, int endMinute, int color) {
        super(id, name, year, month, day, startHour, startMinute, year, month, day, endHour, endMinute);
        super.setColor(color);
    }
}
