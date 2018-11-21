package app.collegeorganizer.data;

import java.util.Date;
import java.util.List;

public class SocialEvent {
    private String name;
    private String details;
    private String location;

    private Date time;
    private Date startDate;

    private Date endDate;
    private List<String> repeating;

    private int color;

    public SocialEvent(String name, String details, String location, Date time, Date startDate, Date endDate, List<String> repeating, int color) {
        this.name = name;
        this.details = details;
        this.location = location;
        this.time = time;
        this.startDate = startDate;
        this.endDate = endDate;
        this.repeating = repeating;
        this.color = color;
    }

    public SocialEvent(String name, String details, String location, Date time, Date startDate, int color) {
        this.name = name;
        this.details = details;
        this.location = location;
        this.time = time;
        this.startDate = startDate;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
}
