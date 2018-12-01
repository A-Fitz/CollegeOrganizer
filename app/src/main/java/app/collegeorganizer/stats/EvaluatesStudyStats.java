package app.collegeorganizer.stats;

import java.util.Calendar;

import app.collegeorganizer.activities.Activity_Main;
import app.collegeorganizer.data.StudyItem;
import app.collegeorganizer.enums.StudyStatTypes;

public class EvaluatesStudyStats {

    public float getData(StudyStatTypes studyStatTypes) {
        Calendar oneMonthAgo = Calendar.getInstance();
        oneMonthAgo.add(Calendar.MONTH, -1);
        oneMonthAgo.add(Calendar.DAY_OF_MONTH, -1);

        Calendar oneWeekAgo = Calendar.getInstance();
        oneWeekAgo.add(Calendar.WEEK_OF_MONTH, -1);
        oneWeekAgo.add(Calendar.DAY_OF_MONTH, -1);

        Calendar now = Calendar.getInstance();

        float total = 0;
        int count = 0;

        switch (studyStatTypes) {

            case TOTAL_HOURS_STUDY:
                total = 0;
                count = 0;
                for (StudyItem c : Activity_Main._studyList) {
                    if (c.getStartTime().getTime().before(now.getTime())) {
                        total += c.getLength_Hours();
                        count++;
                        //Log.e("TESTF", "numinlist:" + Activity_Main._studyList.size() + " , Count:" + count + " , Total:" + total);
                        //Log.e("TESTF", "********************" + c.getMonth() + "/" + c.getDay() + "/" + c.getYear());
                    }

                }
                return total;
            case TOTAL_HOURS_STUDY_LAST_MONTH:
                total = 0;
                for (StudyItem c : Activity_Main._studyList) {
                    if (c.getStartTime().getTime().after(oneMonthAgo.getTime())) {
                        if (c.getStartTime().getTime().before(now.getTime()))
                            total += c.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_STUDY_LAST_WEEK:
                total = 0;
                for (StudyItem c : Activity_Main._studyList) {
                    if (c.getStartTime().getTime().after(oneWeekAgo.getTime())) {
                        if (c.getStartTime().getTime().before(now.getTime()))
                            total += c.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_STUDY_SUNDAYS:
                total = 0;
                for (StudyItem c : Activity_Main._studyList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        if (c.getStartTime().getTime().before(now.getTime()))
                            total += c.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_STUDY_MONDAYS:
                total = 0;
                for (StudyItem c : Activity_Main._studyList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                        if (c.getStartTime().getTime().before(now.getTime()))
                            total += c.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_STUDY_TUESDAYS:
                total = 0;
                for (StudyItem c : Activity_Main._studyList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
                        if (c.getStartTime().getTime().before(now.getTime()))
                            total += c.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_STUDY_WEDNESDAYS:
                total = 0;
                for (StudyItem c : Activity_Main._studyList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
                        if (c.getStartTime().getTime().before(now.getTime()))
                            total += c.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_STUDY_THURSDAYS:
                total = 0;
                for (StudyItem c : Activity_Main._studyList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
                        if (c.getStartTime().getTime().before(now.getTime()))
                            total += c.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_STUDY_FRIDAYS:
                total = 0;
                for (StudyItem c : Activity_Main._studyList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                        if (c.getStartTime().getTime().before(now.getTime()))
                            total += c.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_STUDY_SATURDAYS:
                total = 0;
                for (StudyItem c : Activity_Main._studyList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        if (c.getStartTime().getTime().before(now.getTime()))
                            total += c.getLength_Hours();
                    }
                }
                return total;

            case AVERAGE_HOURS_PER_STUDY:
                total = 0;
                count = 0;
                for (StudyItem c : Activity_Main._studyList) {
                    if (c.getStartTime().getTime().before(now.getTime())) {
                        total += c.getLength_Hours();
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_STUDY_LAST_MONTH:
                total = 0;
                count = 0;
                for (StudyItem c : Activity_Main._studyList) {
                    if (c.getStartTime().getTime().after(oneMonthAgo.getTime())) {
                        if (c.getStartTime().getTime().before(now.getTime())) {
                            total += c.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_STUDY_LAST_WEEK:
                total = 0;
                count = 0;
                for (StudyItem c : Activity_Main._studyList) {
                    if (c.getStartTime().getTime().after(oneWeekAgo.getTime())) {
                        if (c.getStartTime().getTime().before(now.getTime())) {
                            total += c.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_STUDY_ON_SUNDAYS:
                total = 0;
                count = 0;
                for (StudyItem c : Activity_Main._studyList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        if (c.getStartTime().getTime().before(now.getTime())) {
                            total += c.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_STUDY_ON_MONDAYS:
                total = 0;
                count = 0;
                for (StudyItem c : Activity_Main._studyList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                        if (c.getStartTime().getTime().before(now.getTime())) {
                            total += c.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_STUDY_ON_TUESDAYS:
                total = 0;
                count = 0;
                for (StudyItem c : Activity_Main._studyList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
                        if (c.getStartTime().getTime().before(now.getTime())) {
                            total += c.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_STUDY_ON_WEDNESDAYS:
                total = 0;
                count = 0;
                for (StudyItem c : Activity_Main._studyList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
                        if (c.getStartTime().getTime().before(now.getTime())) {
                            total += c.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_STUDY_ON_THURSDAYS:
                total = 0;
                count = 0;
                for (StudyItem c : Activity_Main._studyList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
                        if (c.getStartTime().getTime().before(now.getTime())) {
                            total += c.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_STUDY_ON_FRIDAYS:
                total = 0;
                count = 0;
                for (StudyItem c : Activity_Main._studyList) {
                    if (c.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                        if (c.getStartTime().getTime().before(now.getTime())) {
                            total += c.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_STUDY_ON_SATURDAYS:
                total = 0;
                count = 0;
                for (StudyItem c : Activity_Main._studyList) {
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
