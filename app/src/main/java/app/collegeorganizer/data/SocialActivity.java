package app.collegeorganizer.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class SocialActivity {
    private String name;
    private String details;
    private String location;

    private Calendar startTime;
    private Calendar endTime;

    private Calendar repeatUntilDate;
    private List<String> repeating;

    private int color;

    private long scheduleId; //schedule item sets this as its hashcode, same for all repeating types of it

    public SocialActivity(String name, String details, String location, Calendar startTime, Calendar endTime, Calendar repeatUntilDate, List<String> repeating, int color) {
        this.name = name;
        this.details = details;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.repeatUntilDate = repeatUntilDate;
        this.repeating = repeating;
        this.color = color;
    }

    public SocialActivity(String name, String details, String location, Calendar startTime, Calendar endTime, int color) {
        this.name = name;
        this.details = details;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.color = color;
    }

    public SocialActivity(SocialActivity copy) {
        this.name = copy.getName();
        this.startTime = (Calendar) copy.getStartTime().clone();
        this.endTime = (Calendar) copy.getEndTime().clone();
        this.color = copy.color;
        this.details = copy.getDetails();
        this.repeating = new ArrayList<String>();
        this.repeating.addAll(copy.repeating);
        this.repeatUntilDate = (Calendar) copy.getRepeatUntilDate().clone();
        this.location = copy.getLocation();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        if (details == null)
            return "";
        else
            return details;
    }

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public Calendar getRepeatUntilDate() {
        return repeatUntilDate;
    }

    public void setRepeatUntilDate(Calendar repeatUntilDate) {
        this.repeatUntilDate = repeatUntilDate;
    }

    public List<String> getRepeating() {
        return repeating;
    }

    public void setRepeating(List<String> repeating) {
        this.repeating = repeating;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getRepeatingDays() {
        if (repeating == null || repeating.size() == 0)
            return "";
        else {
            StringBuilder toRtr = new StringBuilder();
            for (String s : repeating) {
                toRtr.append(s).append("-");
            }

            return toRtr.substring(0, toRtr.length() - 1);
        }
    }

    public boolean doesRepeat() {
        return getRepeatingDays().length() != 0;
    }

    public int getStartMinute() {
        return startTime.get(Calendar.MINUTE);
    }

    public int getStartHour() {
        return startTime.get(Calendar.HOUR_OF_DAY);
    }

    public int getDay() {
        return startTime.get(Calendar.DAY_OF_MONTH);
    }

    public int getMonth() {
        return startTime.get(Calendar.MONTH);
    }

    public int getYear() {
        return startTime.get(Calendar.YEAR);
    }

    public int getEndMinute() {
        return endTime.get(Calendar.MINUTE);
    }

    public int getEndHour() {
        return endTime.get(Calendar.HOUR_OF_DAY);
    }

    public int getRepeatEndDay() {
        return repeatUntilDate.get(Calendar.DAY_OF_MONTH);
    }

    public int getRepeatEndMonth() {
        return repeatUntilDate.get(Calendar.MONTH);
    }

    public int getRepeatEndYear() {
        return repeatUntilDate.get(Calendar.YEAR);
    }


    public void setStartMinute(int startMinute) {
        this.startTime.set(Calendar.MINUTE, startMinute);
    }

    public void setStartHour(int startHour) {
        this.startTime.set(Calendar.HOUR_OF_DAY, startHour);
    }

    public void setDay(int day) {
        this.startTime.set(Calendar.DAY_OF_MONTH, day);
        this.endTime.set(Calendar.DAY_OF_MONTH, day);
    }

    public void setMonth(int month) {
        this.startTime.set(Calendar.MONTH, month);
        this.endTime.set(Calendar.MONTH, month);
    }

    public void setYear(int year) {
        this.startTime.set(Calendar.YEAR, year);
        this.endTime.set(Calendar.YEAR, year);
    }

    public void setEndMinute(int endMinute) {
        this.endTime.set(Calendar.MINUTE, endMinute);
    }

    public void setEndHour(int endHour) {
        this.endTime.set(Calendar.HOUR_OF_DAY, endHour);
    }

    public void setRepeatEndDay(int endDay) {
        this.repeatUntilDate.set(Calendar.DAY_OF_MONTH, endDay);
    }

    public void setRepeatEndMonth(int endMonth) {
        this.repeatUntilDate.set(Calendar.MONTH, endMonth);
    }

    public void setRepeatEndYear(int endYear) {
        this.repeatUntilDate.set(Calendar.YEAR, endYear);
    }

    public String getTitle() {
        return "Social Activity : " + this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialActivity that = (SocialActivity) o;
        return color == that.color &&
                Objects.equals(name, that.name) &&
                Objects.equals(details, that.details) &&
                Objects.equals(location, that.location) &&
                Objects.equals(repeatUntilDate, that.repeatUntilDate) &&
                Objects.equals(repeating, that.repeating);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, details, location, startTime, endTime, repeatUntilDate, repeating, color);
    }
}
