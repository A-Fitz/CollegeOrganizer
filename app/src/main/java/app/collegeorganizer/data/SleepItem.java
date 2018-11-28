package app.collegeorganizer.data;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import app.collegeorganizer.enums.SleepQualityTypes;
import app.collegeorganizer.enums.SleepTimeType;

public class SleepItem {
    private SleepTimeType sleepTimeType;
    private List<SleepQualityTypes> sleepQualityTypesList;

    private Calendar start_time;
    private Calendar end_time;

    private String details;
    private int color;

    public SleepItem(SleepTimeType sleepTimeType, List<SleepQualityTypes> sleepQualityTypesList, Calendar start_time, Calendar end_time, String details, int color) {
        this.sleepTimeType = sleepTimeType;
        this.sleepQualityTypesList = sleepQualityTypesList;
        this.start_time = start_time;
        this.end_time = end_time;
        this.details = details;
        this.color = color;
    }

    public SleepTimeType getSleepTimeType() {
        return sleepTimeType;
    }

    public void setSleepTimeType(SleepTimeType sleepTimeType) {
        this.sleepTimeType = sleepTimeType;
    }

    public List<SleepQualityTypes> getSleepQualityTypesList() {
        return sleepQualityTypesList;
    }

    public void setSleepQualityTypesList(List<SleepQualityTypes> sleepQualityTypesList) {
        this.sleepQualityTypesList = sleepQualityTypesList;
    }

    public Calendar getStart_time() {
        return start_time;
    }

    public void setStart_time(Calendar start_time) {
        this.start_time = start_time;
    }

    public Calendar getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Calendar end_time) {
        this.end_time = end_time;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SleepItem sleepItem = (SleepItem) o;
        return sleepTimeType == sleepItem.sleepTimeType &&
                Objects.equals(sleepQualityTypesList, sleepItem.sleepQualityTypesList) &&
                Objects.equals(start_time, sleepItem.start_time) &&
                Objects.equals(end_time, sleepItem.end_time) &&
                Objects.equals(details, sleepItem.details);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sleepTimeType, sleepQualityTypesList, start_time, end_time, details);
    }
}
