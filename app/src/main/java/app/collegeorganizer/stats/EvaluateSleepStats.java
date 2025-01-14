package app.collegeorganizer.stats;

import java.util.Calendar;

import app.collegeorganizer.activities.Activity_Main;
import app.collegeorganizer.data.SleepItem;
import app.collegeorganizer.enums.SleepStatTypes;

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
            case TOTAL_HOURS_SLEEPING:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    total += si.getLength_Hours();
                }
                return total;
            case TOTAL_HOURS_SLEEPING_LAST_MONTH:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().getTime().after(oneMonthAgo.getTime())) {
                        total += si.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_SLEEPING_LAST_WEEK:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().getTime().after(oneWeekAgo.getTime())) {
                        total += si.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_SLEEPING_SUNDAYS:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        total += si.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_SLEEPING_MONDAYS:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                        total += si.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_SLEEPING_TUESDAYS:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
                        total += si.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_SLEEPING_WEDNESDAYS:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
                        total += si.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_SLEEPING_THURSDAYS:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
                        total += si.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_SLEEPING_FRIDAYS:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                        total += si.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_SLEEPING_SATURDAYS:
                total = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        total += si.getLength_Hours();
                    }
                }
                return total;

            case AVERAGE_HOURS_PER_SLEEP:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    total += si.getLength_Hours();
                    count++;
                }
                return total / count;
            case AVERAGE_HOURS_PER_SLEEP_LAST_MONTH:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().getTime().after(oneMonthAgo.getTime())) {
                        total += si.getLength_Hours();
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SLEEP_LAST_WEEK:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().getTime().after(oneWeekAgo.getTime())) {
                        total += si.getLength_Hours();
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SLEEP_ON_SUNDAYS:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        total += si.getLength_Hours();
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SLEEP_ON_MONDAYS:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                        total += si.getLength_Hours();
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SLEEP_ON_TUESDAYS:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
                        total += si.getLength_Hours();
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SLEEP_ON_WEDNESDAYS:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
                        total += si.getLength_Hours();
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SLEEP_ON_THURSDAYS:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
                        total += si.getLength_Hours();
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SLEEP_ON_FRIDAYS:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                        total += si.getLength_Hours();
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SLEEP_ON_SATURDAYS:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        total += si.getLength_Hours();
                        count++;
                    }
                }
                return total / count;

            case PSQI_SCORE_ALL_TIME:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    total += si.getPSQIScore();
                    count++;
                }
                return total / count;
            case PSQI_SCORE_LAST_MONTH:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().getTime().after(oneMonthAgo.getTime())) {
                        total += si.getPSQIScore();
                        count++;

                    }
                }
                return total / count;
            case PSQI_SCORE_LAST_WEEK:
                total = 0;
                count = 0;
                for (SleepItem si : Activity_Main.sleepItemList) {
                    if (si.getStart_time().getTime().after(oneWeekAgo.getTime())) {
                        total += si.getPSQIScore();
                        count++;
                    }
                }
                return total / count;
        }
        return 0;
    }
}
