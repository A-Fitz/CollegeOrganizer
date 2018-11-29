package app.collegeorganizer.stats;

import android.util.Log;

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

        Calendar now = Calendar.getInstance();

        float total = 0;
        int count = 0;

        switch (physicalActivityStatTypes) {

            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().getTime().before(now.getTime())) {
                        total += py.getLength_Hours();
                        count++;
                        Log.e("TESTF", "numinlist:" + Activity_Main._physicalActivityList.size() + " , Count:" + count + " , Total:" + total);
                        Log.e("TESTF", "********************" + py.getMonth() + "/" + py.getDay() + "/" + py.getYear());
                    }

                }
                return total;
            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_LAST_MONTH:
                total = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().getTime().after(oneMonthAgo.getTime())) {
                        if (py.getStartTime().getTime().before(now.getTime()))
                            total += py.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_LAST_WEEK:
                total = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().getTime().after(oneWeekAgo.getTime())) {
                        if (py.getStartTime().getTime().before(now.getTime()))
                            total += py.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_SUNDAYS:
                total = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        if (py.getStartTime().getTime().before(now.getTime()))
                            total += py.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_MONDAYS:
                total = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                        if (py.getStartTime().getTime().before(now.getTime()))
                            total += py.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_TUESDAYS:
                total = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
                        if (py.getStartTime().getTime().before(now.getTime()))
                            total += py.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_WEDNESDAYS:
                total = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
                        if (py.getStartTime().getTime().before(now.getTime()))
                            total += py.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_THURSDAYS:
                total = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
                        if (py.getStartTime().getTime().before(now.getTime()))
                            total += py.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_FRIDAYS:
                total = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                        if (py.getStartTime().getTime().before(now.getTime()))
                            total += py.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_SATURDAYS:
                total = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        if (py.getStartTime().getTime().before(now.getTime()))
                            total += py.getLength_Hours();
                    }
                }
                return total;

            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().getTime().before(now.getTime())) {
                        total += py.getLength_Hours();
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_LAST_MONTH:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().getTime().after(oneMonthAgo.getTime())) {
                        if (py.getStartTime().getTime().before(now.getTime())) {
                            total += py.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_LAST_WEEK:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().getTime().after(oneWeekAgo.getTime())) {
                        if (py.getStartTime().getTime().before(now.getTime())) {
                            total += py.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_SUNDAYS:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        if (py.getStartTime().getTime().before(now.getTime())) {
                            total += py.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_MONDAYS:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                        if (py.getStartTime().getTime().before(now.getTime())) {
                            total += py.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_TUESDAYS:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
                        if (py.getStartTime().getTime().before(now.getTime())) {
                            total += py.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_WEDNESDAYS:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
                        if (py.getStartTime().getTime().before(now.getTime())) {
                            total += py.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_THURSDAYS:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
                        if (py.getStartTime().getTime().before(now.getTime())) {
                            total += py.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_FRIDAYS:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                        if (py.getStartTime().getTime().before(now.getTime())) {
                            total += py.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_SATURDAYS:
                total = 0;
                count = 0;
                for (PhysicalActivity py : Activity_Main._physicalActivityList) {
                    if (py.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        if (py.getStartTime().getTime().before(now.getTime())) {
                            total += py.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
        }

        return 0;
    }
}
