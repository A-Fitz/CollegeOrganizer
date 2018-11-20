package app.collegeorganizer.data;

import java.util.Date;
import java.util.List;

public class PhysicalActivity {
    private String name;
    private Date time;
    private int color;
    private String details;
    private List<String> repeating;
    private Date endDate;
    private PhysicalActivityIntensity intensity;

    public PhysicalActivity(String name, Date time, int color, String details, List<String> repeating, Date endDate, PhysicalActivityIntensity intensity) {
        this.name = name;
        this.time = time;
        this.color = color;
        this.details = details;
        this.repeating = repeating;
        this.endDate = endDate;
        this.intensity = intensity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<String> getRepeating() {
        return repeating;
    }

    public void setRepeating(List<String> repeating) {
        this.repeating = repeating;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public PhysicalActivityIntensity getIntensity() {
        return intensity;
    }

    public void setIntensity(PhysicalActivityIntensity intensity) {
        this.intensity = intensity;
    }

    public String getRepeatingDays()
    {
        String toRtr = "";
        for(String s : repeating)
        {
            toRtr += s;
        }
        return toRtr;
    }

}