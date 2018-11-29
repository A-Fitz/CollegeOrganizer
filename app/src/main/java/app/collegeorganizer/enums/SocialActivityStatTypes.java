package app.collegeorganizer.enums;

public enum SocialActivityStatTypes {
    TOTAL_HOURS_PER_SOCIAL_ACTIVITY("Total hours of social activity"),
    TOTAL_HOURS_PER_SOCIAL_ACTIVITY_LAST_MONTH("Total hours of social activity in the last month"),
    TOTAL_HOURS_PER_SOCIAL_ACTIVITY_LAST_WEEK("Total hours of social activity in the last week"),
    TOTAL_HOURS_PER_SOCIAL_ACTIVITY_ON_SUNDAYS("Total hours of social activity on Sundays"),
    TOTAL_HOURS_PER_SOCIAL_ACTIVITY_ON_MONDAYS("Total hours of social activity on Mondays"),
    TOTAL_HOURS_PER_SOCIAL_ACTIVITY_ON_TUESDAYS("Total hours of social activity on Tuesdays"),
    TOTAL_HOURS_PER_SOCIAL_ACTIVITY_ON_WEDNESDAYS("Total hours of social activity on Wednesdays"),
    TOTAL_HOURS_PER_SOCIAL_ACTIVITY_ON_THURSDAYS("Total hours of social activity on Thursdays"),
    TOTAL_HOURS_PER_SOCIAL_ACTIVITY_ON_FRIDAYS("Total hours of social activity on Fridays"),
    TOTAL_HOURS_PER_SOCIAL_ACTIVITY_ON_SATURDAYS("Total hours of social activity on Saturdays"),
    AVERAGE_HOURS_PER_SOCIAL_ACTIVITY("Average hours per social activity"),
    AVERAGE_HOURS_PER_SOCIAL_ACTIVITY_LAST_MONTH("Average hours per social activity in the last month"),
    AVERAGE_HOURS_PER_SOCIAL_ACTIVITY_LAST_WEEK("Average hours per social activity in the last week"),
    AVERAGE_HOURS_PER_SOCIAL_ACTIVITY_ON_SUNDAYS("Average hours per social activity on Sundays"),
    AVERAGE_HOURS_PER_SOCIAL_ACTIVITY_ON_MONDAYS("Average hours per social activity on Mondays"),
    AVERAGE_HOURS_PER_SOCIAL_ACTIVITY_ON_TUESDAYS("Average hours per social activity on Tuesdays"),
    AVERAGE_HOURS_PER_SOCIAL_ACTIVITY_ON_WEDNESDAYS("Average hours per social activity on Wednesdays"),
    AVERAGE_HOURS_PER_SOCIAL_ACTIVITY_ON_THURSDAYS("Average hours per social activity on Thursdays"),
    AVERAGE_HOURS_PER_SOCIAL_ACTIVITY_ON_FRIDAYS("Average hours per social activity on Fridays"),
    AVERAGE_HOURS_PER_SOCIAL_ACTIVITY_ON_SATURDAYS("Average hours per social activity on Saturdays");

    private String friendlyName;

    SocialActivityStatTypes(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
