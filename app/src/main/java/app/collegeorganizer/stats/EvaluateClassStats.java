package app.collegeorganizer.stats;

import java.util.Calendar;

import app.collegeorganizer.activities.Activity_Main;
import app.collegeorganizer.data.ClassItem;
import app.collegeorganizer.enums.ClassStatTypes;

public class EvaluateClassStats {

    public float getData(ClassStatTypes classStatTypes) {
        Calendar oneMonthAgo = Calendar.getInstance();
        oneMonthAgo.add(Calendar.MONTH, -1);
        oneMonthAgo.add(Calendar.DAY_OF_MONTH, -1);

        Calendar oneWeekAgo = Calendar.getInstance();
        oneWeekAgo.add(Calendar.WEEK_OF_MONTH, -1);
        oneWeekAgo.add(Calendar.DAY_OF_MONTH, -1);

        Calendar now = Calendar.getInstance();

        float total = 0;
        int count = 0;

        switch (classStatTypes) {

            case TOTAL_HOURS_CLASS:
                total = 0;
                count = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().getTime().before(now.getTime())) {
                        total += c.getLength_Hours();
                        count++;
                        //Log.e("TESTF", "numinlist:" + Activity_Main._classList.size() + " , Count:" + count + " , Total:" + total);
                        //Log.e("TESTF", "********************" + c.getMonth() + "/" + c.getDay() + "/" + c.getYear());
                    }

                }
                return total;
            case TOTAL_HOURS_CLASS_LAST_MONTH:
                total = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().getTime().after(oneMonthAgo.getTime())) {
                        if (c.getStartTime().getTime().before(now.getTime()))
                            total += c.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_CLASS_LAST_WEEK:
                total = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().getTime().after(oneWeekAgo.getTime())) {
                        if (c.getStartTime().getTime().before(now.getTime()))
                            total += c.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_CLASS_SUNDAYS:
                total = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        if (c.getStartTime().getTime().before(now.getTime()))
                            total += c.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_CLASS_MONDAYS:
                total = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                        if (c.getStartTime().getTime().before(now.getTime()))
                            total += c.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_CLASS_TUESDAYS:
                total = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
                        if (c.getStartTime().getTime().before(now.getTime()))
                            total += c.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_CLASS_WEDNESDAYS:
                total = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
                        if (c.getStartTime().getTime().before(now.getTime()))
                            total += c.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_CLASS_THURSDAYS:
                total = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
                        if (c.getStartTime().getTime().before(now.getTime()))
                            total += c.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_CLASS_FRIDAYS:
                total = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                        if (c.getStartTime().getTime().before(now.getTime()))
                            total += c.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_CLASS_SATURDAYS:
                total = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        if (c.getStartTime().getTime().before(now.getTime()))
                            total += c.getLength_Hours();
                    }
                }
                return total;

            case AVERAGE_HOURS_PER_CLASS:
                total = 0;
                count = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().getTime().before(now.getTime())) {
                        total += c.getLength_Hours();
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_CLASS_LAST_MONTH:
                total = 0;
                count = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().getTime().after(oneMonthAgo.getTime())) {
                        if (c.getStartTime().getTime().before(now.getTime())) {
                            total += c.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_CLASS_LAST_WEEK:
                total = 0;
                count = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().getTime().after(oneWeekAgo.getTime())) {
                        if (c.getStartTime().getTime().before(now.getTime())) {
                            total += c.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_CLASS_ON_SUNDAYS:
                total = 0;
                count = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        if (c.getStartTime().getTime().before(now.getTime())) {
                            total += c.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_CLASS_ON_MONDAYS:
                total = 0;
                count = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                        if (c.getStartTime().getTime().before(now.getTime())) {
                            total += c.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_CLASS_ON_TUESDAYS:
                total = 0;
                count = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
                        if (c.getStartTime().getTime().before(now.getTime())) {
                            total += c.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_CLASS_ON_WEDNESDAYS:
                total = 0;
                count = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
                        if (c.getStartTime().getTime().before(now.getTime())) {
                            total += c.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_CLASS_ON_THURSDAYS:
                total = 0;
                count = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
                        if (c.getStartTime().getTime().before(now.getTime())) {
                            total += c.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_CLASS_ON_FRIDAYS:
                total = 0;
                count = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                        if (c.getStartTime().getTime().before(now.getTime())) {
                            total += c.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_CLASS_ON_SATURDAYS:
                total = 0;
                count = 0;
                for (ClassItem c : Activity_Main._classList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        if (c.getStartTime().getTime().before(now.getTime())) {
                            total += c.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
        }

        return 0;
    }
}
