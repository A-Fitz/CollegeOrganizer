package app.collegeorganizer.stats;

import java.util.Calendar;

import app.collegeorganizer.activities.Activity_Main;
import app.collegeorganizer.data.PhysicalActivity;
import app.collegeorganizer.enums.PhysicalActivityStatTypes;

public class EvaluatePhysicalActivityStats {

    public float getData(PhysicalActivityStatTypes physicalActivityStatTypes) {
        Calendar oneMonthAgo = Calendar.getInstance();
        oneMonthAgo.add(Calendar.MONTH, -1);
        oneMonthAgo.add(Calendar.DAY_OF_MONTH, -1);

        Calendar oneWeekAgo = Calendar.getInstance();
        oneWeekAgo.add(Calendar.WEEK_OF_MONTH, -1);
        oneWeekAgo.add(Calendar.DAY_OF_MONTH, -1);

        float total = 0;
        int count = 0;

        switch (physicalActivityStatTypes) {

            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY:
                total = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                    long hours = secs / 3600;
                    total += hours;
                }
                return total;
            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_LAST_MONTH:
                total = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().getTime().after(oneMonthAgo.getTime())) {
                        long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                    }
                }
                return total;
            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_LAST_WEEK:
                total = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().getTime().after(oneWeekAgo.getTime())) {
                        long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                    }
                }
                return total;
            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_SUNDAYS:
                total = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                    }
                }
                return total;
            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_MONDAYS:
                total = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                        long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                    }
                }
                return total;
            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_TUESDAYS:
                total = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
                        long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                    }
                }
                return total;
            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_WEDNESDAYS:
                total = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
                        long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                    }
                }
                return total;
            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_THURSDAYS:
                total = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
                        long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                    }
                }
                return total;
            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_FRIDAYS:
                total = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                        long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                    }
                }
                return total;
            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_SATURDAYS:
                total = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                    }
                }
                return total;

            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                    long hours = secs / 3600;
                    total += hours;
                    count++;
                }
                return total / count;
            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_LAST_MONTH:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().getTime().after(oneMonthAgo.getTime())) {
                        long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_LAST_WEEK:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().getTime().after(oneWeekAgo.getTime())) {
                        long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_SUNDAYS:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_MONDAYS:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                        long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_TUESDAYS:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
                        long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_WEDNESDAYS:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
                        long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_THURSDAYS:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
                        long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_FRIDAYS:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                        long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_SATURDAYS:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        long secs = (py.getEndTime().getTime().getTime() - py.getStartTime().getTime().getTime()) / 1000;
                        long hours = secs / 3600;
                        total += hours;
                        count++;
                    }
                }
                return total / count;
        }

        return 0;
    }
}
