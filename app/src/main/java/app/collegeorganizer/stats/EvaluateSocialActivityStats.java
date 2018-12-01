package app.collegeorganizer.stats;

import java.util.Calendar;

import app.collegeorganizer.activities.Activity_Main;
import app.collegeorganizer.data.SocialActivity;
import app.collegeorganizer.enums.SocialActivityStatTypes;

public class EvaluateSocialActivityStats {

    public float getData(SocialActivityStatTypes socialActivityStatTypes) {
        Calendar oneMonthAgo = Calendar.getInstance();
        oneMonthAgo.add(Calendar.MONTH, -1);
        oneMonthAgo.add(Calendar.DAY_OF_MONTH, -1);

        Calendar oneWeekAgo = Calendar.getInstance();
        oneWeekAgo.add(Calendar.WEEK_OF_MONTH, -1);
        oneWeekAgo.add(Calendar.DAY_OF_MONTH, -1);

        Calendar now = Calendar.getInstance();

        float total = 0;
        int count = 0;

        switch (socialActivityStatTypes) {

            case TOTAL_HOURS_SOCIAL:
                total = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().getTime().before(now.getTime()))
                        total += sa.getLength_Hours();
                }
                return total;
            case TOTAL_HOURS_SOCIAL_LAST_MONTH:
                total = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().getTime().after(oneMonthAgo.getTime())) {
                        if (sa.getStartTime().getTime().before(now.getTime()))
                            total += sa.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_SOCIAL_LAST_WEEK:
                total = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().getTime().after(oneWeekAgo.getTime())) {
                        if (sa.getStartTime().getTime().before(now.getTime()))
                            total += sa.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_SOCIAL_SUNDAYS:
                total = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        if (sa.getStartTime().getTime().before(now.getTime()))
                            total += sa.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_SOCIAL_MONDAYS:
                total = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                        if (sa.getStartTime().getTime().before(now.getTime()))
                            total += sa.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_SOCIAL_TUESDAYS:
                total = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
                        if (sa.getStartTime().getTime().before(now.getTime()))
                            total += sa.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_SOCIAL_WEDNESDAYS:
                total = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
                        if (sa.getStartTime().getTime().before(now.getTime()))
                            total += sa.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_SOCIAL_THURSDAYS:
                total = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
                        if (sa.getStartTime().getTime().before(now.getTime()))
                            total += sa.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_SOCIAL_FRIDAYS:
                total = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                        if (sa.getStartTime().getTime().before(now.getTime()))
                            total += sa.getLength_Hours();
                    }
                }
                return total;
            case TOTAL_HOURS_SOCIAL_SATUDAYS:
                total = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        if (sa.getStartTime().getTime().before(now.getTime()))
                            total += sa.getLength_Hours();
                    }
                }
                return total;

            case AVERAGE_HOURS_PER_SOCIAL_ACTIVITY:
                total = 0;
                count = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().getTime().before(now.getTime())) {
                        total += sa.getLength_Hours();
                        count++;
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SOCIAL_ACTIVITY_LAST_MONTH:
                total = 0;
                count = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().getTime().after(oneMonthAgo.getTime())) {
                        if (sa.getStartTime().getTime().before(now.getTime())) {
                            total += sa.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SOCIAL_ACTIVITY_LAST_WEEK:
                total = 0;
                count = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().getTime().after(oneWeekAgo.getTime())) {
                        if (sa.getStartTime().getTime().before(now.getTime())) {
                            total += sa.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SOCIAL_ACTIVITY_ON_SUNDAYS:
                total = 0;
                count = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        if (sa.getStartTime().getTime().before(now.getTime())) {
                            total += sa.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SOCIAL_ACTIVITY_ON_MONDAYS:
                total = 0;
                count = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                        if (sa.getStartTime().getTime().before(now.getTime())) {
                            total += sa.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SOCIAL_ACTIVITY_ON_TUESDAYS:
                total = 0;
                count = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
                        if (sa.getStartTime().getTime().before(now.getTime())) {
                            total += sa.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SOCIAL_ACTIVITY_ON_WEDNESDAYS:
                total = 0;
                count = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
                        if (sa.getStartTime().getTime().before(now.getTime())) {
                            total += sa.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SOCIAL_ACTIVITY_ON_THURSDAYS:
                total = 0;
                count = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
                        if (sa.getStartTime().getTime().before(now.getTime())) {
                            total += sa.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SOCIAL_ACTIVITY_ON_FRIDAYS:
                total = 0;
                count = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                        if (sa.getStartTime().getTime().before(now.getTime())) {
                            total += sa.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
            case AVERAGE_HOURS_PER_SOCIAL_ACTIVITY_ON_SATURDAYS:
                total = 0;
                count = 0;
                for (SocialActivity sa : Activity_Main._socialActivityList) {
                    if (sa.getStartTime().get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        if (sa.getStartTime().getTime().before(now.getTime())) {
                            total += sa.getLength_Hours();
                            count++;
                        }
                    }
                }
                return total / count;
        }

        return 0;
    }
}
