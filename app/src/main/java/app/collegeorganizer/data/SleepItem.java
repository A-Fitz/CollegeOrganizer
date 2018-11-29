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

    public float getStart_Hour() {
        return (this.start_time.get(Calendar.HOUR_OF_DAY) + (this.start_time.get(Calendar.MINUTE) / 100.0f));
    }

    public float getEnd_Hour() {
        return (this.end_time.get(Calendar.HOUR_OF_DAY) + (this.end_time.get(Calendar.MINUTE) / 100.0f));
    }

    public float getLength_Hours() {
        float secs = (end_time.getTime().getTime() - start_time.getTime().getTime()) / 1000;
        return secs / 3600;
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

    public float getPSQIScore() {

        //get point value related to checked boxes
        int sum = 0;
        if (sleepQualityTypesList.contains(SleepQualityTypes.NOT_WITHIN_30_MINUTES))
            sum += 3;
        if (sleepQualityTypesList.contains(SleepQualityTypes.WAKE_UP_IN_NIGHT))
            sum += 3;
        if (sleepQualityTypesList.contains(SleepQualityTypes.BATHROOM))
            sum += 3;
        if (sleepQualityTypesList.contains(SleepQualityTypes.BREATHING))
            sum += 3;
        if (sleepQualityTypesList.contains(SleepQualityTypes.COUGH_SNORE))
            sum += 3;
        if (sleepQualityTypesList.contains(SleepQualityTypes.COLD))
            sum += 3;
        if (sleepQualityTypesList.contains(SleepQualityTypes.HOT))
            sum += 3;
        if (sleepQualityTypesList.contains(SleepQualityTypes.BAD_DREAMS))
            sum += 3;
        if (sleepQualityTypesList.contains(SleepQualityTypes.PAIN))
            sum += 3;

        //get associated PSQI score from point value
        if (sum == 0)
            return 0;
        else if (sum >= 1 && sum <= 5)
            return 2.35f;
        else if (sum >= 6 && sum <= 9)
            return 4.7f;
        else if (sum >= 10 && sum <= 14)
            return 7.05f;
        else if (sum >= 15 && sum <= 18)
            return 9.4f;
        else if (sum >= 19 && sum <= 23)
            return 11.75f;
        else
            return 14.1f;

    }
}
