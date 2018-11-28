package app.collegeorganizer.stats_types;

import java.util.Calendar;
import java.util.List;

import app.collegeorganizer.activities.Activity_Main;
import app.collegeorganizer.data.SleepItem;
import app.collegeorganizer.data.SleepQualityTypes;

public class EvaluateSleepStats {

    public float getData(SleepStatTypes sleepStatTypes) {
        Calendar oneMonthAgo = Calendar.getInstance();
        oneMonthAgo.add(Calendar.MONTH, -1);
        oneMonthAgo.add(Calendar.DAY_OF_MONTH, -1);

        Calendar oneWeekAgo = Calendar.getInstance();
        oneWeekAgo.add(Calendar.WEEK_OF_MONTH, -1);
        oneWeekAgo.add(Calendar.DAY_OF_MONTH, -1);

        float total = 0;
        int count = 0;

        switch (sleepStatTypes) {
            case TOTAL_HOURS_PER_SLEEP:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                    long hours = secs / 3600;
                    total += hours;
                }
                return total;
            case TOTAL_HOURS_PER_SLEEP_LAST_MONTH:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().getTime().after(oneMonthAgo.getTime())) {
                        long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                    }
                }
                return total;
            case TOTAL_HOURS_PER_SLEEP_LAST_WEEK:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().getTime().after(oneWeekAgo.getTime())) {
                        long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                    }
                }
                return total;
            case TOTAL_HOURS_PER_SLEEP_ON_SUNDAYS:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                    }
                }
                return total;
            case TOTAL_HOURS_PER_SLEEP_ON_MONDAYS:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                        long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                    }
                }
                return total;
            case TOTAL_HOURS_PER_SLEEP_ON_TUESDAYS:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
                        long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                    }
                }
                return total;
            case TOTAL_HOURS_PER_SLEEP_ON_WEDNESDAYS:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
                        long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                    }
                }
                return total;
            case TOTAL_HOURS_PER_SLEEP_ON_THURSDAYS:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
                        long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                    }
                }
                return total;
            case TOTAL_HOURS_PER_SLEEP_ON_FRIDAYS:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                        long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                    }
                }
                return total;
            case TOTAL_HOURS_PER_SLEEP_ON_SATURDAYS:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                    }
                }
                return total;

            case AVERAGE_HOURS_PER_SLEEP:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                    long hours = secs / 3600;
                    total += hours;
                    count++;
                }
                return total / count;
            case AVERAGE_HOURS_PER_SLEEP_LAST_MONTH:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().getTime().after(oneMonthAgo.getTime())) {
                        long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SLEEP_LAST_WEEK:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().getTime().after(oneWeekAgo.getTime())) {
                        long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SLEEP_ON_SUNDAYS:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SLEEP_ON_MONDAYS:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                        long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SLEEP_ON_TUESDAYS:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
                        long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SLEEP_ON_WEDNESDAYS:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
                        long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SLEEP_ON_THURSDAYS:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
                        long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SLEEP_ON_FRIDAYS:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                        long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SLEEP_ON_SATURDAYS:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        long secs = (si.getEnd_time().getTime().getTime() - si.getStart_time().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                        count++;
                    }
                }
                return total / count;

            case PSQI_SCORE_ALL_TIME:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    total += getPSQIScore(si);
                }
                return total;
            case PSQI_SCORE_LAST_MONTH:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().getTime().after(oneMonthAgo.getTime())) {
                        total += getPSQIScore(si);
                    }
                }
                return total;
            case PSQI_SCORE_LAST_WEEK:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().getTime().after(oneWeekAgo.getTime())) {
                        total += getPSQIScore(si);
                    }
                }
                return total;
        }
        return 0;
    }

    private float getPSQIScore(SleepItem si) {
        List<SleepQualityTypes> sleepItems = si.getSleepQualityTypesList();

        //get point value related to checked boxes
        int sum = 0;
        if (sleepItems.contains(SleepQualityTypes.NOT_WITHIN_30_MINUTES))
            sum+=3;
        if (sleepItems.contains(SleepQualityTypes.WAKE_UP_IN_NIGHT))
            sum+=3;
        if (sleepItems.contains(SleepQualityTypes.BATHROOM))
            sum+=3;
        if (sleepItems.contains(SleepQualityTypes.BREATHING))
            sum+=3;
        if (sleepItems.contains(SleepQualityTypes.COUGH_SNORE))
            sum+=3;
        if (sleepItems.contains(SleepQualityTypes.COLD))
            sum+=3;
        if (sleepItems.contains(SleepQualityTypes.HOT))
            sum+=3;
        if (sleepItems.contains(SleepQualityTypes.BAD_DREAMS))
            sum+=3;
        if (sleepItems.contains(SleepQualityTypes.PAIN))
            sum+=3;

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
