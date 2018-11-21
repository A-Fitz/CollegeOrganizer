package app.collegeorganizer.data;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class SocialEvent {
    private String name;
    private String details;
    private String location;

    private Calendar startTime;
    private Calendar endTime;

    private Calendar repeatUntilDate;
    private List<String> repeating;

    private int color;

    public SocialEvent(String name, String details, String location, Calendar startTime, Calendar endTime, Calendar repeatUntilDate, List<String> repeating, int color) {
        this.name = name;
        this.details = details;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.repeatUntilDate = repeatUntilDate;
        this.repeating = repeating;
        this.color = color;
    }

    public SocialEvent(String name, String details, String location, Calendar startTime, Calendar endTime, int color) {
        this.name = name;
        this.details = details;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.color = color;
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
            String toRtr = "";
            for (String s : repeating) {
                toRtr += s + "-";
            }

            return toRtr.substring(0, toRtr.length() - 1);
        }
    }

    public int getStartMinute() {
        return startTime.get(Calendar.MINUTE);
    }

    public int getStartHour() {
        return startTime.get(Calendar.HOUR);
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
        return endTime.get(Calendar.HOUR);
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

    public String getTitle() {
        return "Social Event : " + this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialEvent that = (SocialEvent) o;
        return color == that.color &&
                Objects.equals(name, that.name) &&
                Objects.equals(details, that.details) &&
                Objects.equals(location, that.location) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(repeatUntilDate, that.repeatUntilDate) &&
                Objects.equals(repeating, that.repeating);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, details, location, startTime, endTime, repeatUntilDate, repeating, color);
    }
}
