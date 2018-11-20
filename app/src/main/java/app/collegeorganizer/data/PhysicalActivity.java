package app.collegeorganizer.data;

import android.graphics.Color;

import java.sql.Time;
import java.time.DayOfWeek;
import java.util.Date;
import java.util.List;

public class PhysicalActivity {
    private String name;
    private Date date;
    private Time time;
    private Color color;
    private String details;
    private List<DayOfWeek> repeating;
    private PhysicalActivityIntensity intensity;

    public PhysicalActivity(String name, Date date, Time time, Color color, String details, List<DayOfWeek> repeating, PhysicalActivityIntensity intensity) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.color = color;
        this.details = details;
        this.repeating = repeating;
        this.intensity = intensity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<DayOfWeek> getRepeating() {
        return repeating;
    }

    public void setRepeating(List<DayOfWeek> repeating) {
        this.repeating = repeating;
    }

    public PhysicalActivityIntensity getIntensity() {
        return intensity;
    }

    public void setIntensity(PhysicalActivityIntensity intensity) {
        this.intensity = intensity;
    }
}
