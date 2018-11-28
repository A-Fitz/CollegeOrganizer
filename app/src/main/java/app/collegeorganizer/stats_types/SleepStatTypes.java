package app.collegeorganizer.stats_types;

public enum SleepStatTypes {
    TOTAL_HOURS_PER_SLEEP("Total hours per sleep"),
    TOTAL_HOURS_PER_SLEEP_LAST_MONTH("Total hours per sleep in the last month"),
    TOTAL_HOURS_PER_SLEEP_LAST_WEEK("Total hours per sleep in the last week"),
    TOTAL_HOURS_PER_SLEEP_ON_SUNDAYS("Total hours per sleep on Sundays"),
    TOTAL_HOURS_PER_SLEEP_ON_MONDAYS("Total hours per sleep on Mondays"),
    TOTAL_HOURS_PER_SLEEP_ON_TUESDAYS("Total hours per sleep on Tuesdays"),
    TOTAL_HOURS_PER_SLEEP_ON_WEDNESDAYS("Total hours per sleep on Wednesdays"),
    TOTAL_HOURS_PER_SLEEP_ON_THURSDAYS("Total hours per sleep on Thursdays"),
    TOTAL_HOURS_PER_SLEEP_ON_FRIDAYS("Total hours per sleep on Fridays"),
    TOTAL_HOURS_PER_SLEEP_ON_SATURDAYS("Total hours per sleep on Saturdays"),
    AVERAGE_HOURS_PER_SLEEP("Average hours per sleep"),
    AVERAGE_HOURS_PER_SLEEP_LAST_MONTH("Average hours per sleep in the last month"),
    AVERAGE_HOURS_PER_SLEEP_LAST_WEEK("Average hours per sleep in the last week"),
    AVERAGE_HOURS_PER_SLEEP_ON_SUNDAYS("Average hours per sleep on Sundays"),
    AVERAGE_HOURS_PER_SLEEP_ON_MONDAYS("Average hours per sleep on Mondays"),
    AVERAGE_HOURS_PER_SLEEP_ON_TUESDAYS("Average hours per sleep on Tuesdays"),
    AVERAGE_HOURS_PER_SLEEP_ON_WEDNESDAYS("Average hours per sleep on Wednesdays"),
    AVERAGE_HOURS_PER_SLEEP_ON_THURSDAYS("Average hours per sleep on Thursdays"),
    AVERAGE_HOURS_PER_SLEEP_ON_FRIDAYS("Average hours per sleep on Fridays"),
    AVERAGE_HOURS_PER_SLEEP_ON_SATURDAYS("Average hours per sleep on Saturdays"),
    PSQI_SCORE_ALL_TIME("Average PSQI score"),
    PSQI_SCORE_LAST_MONTH("Average PSQI score in the last month"),
    PSQI_SCORE_LAST_WEEK("Average PSQI score in the last week");

    private String friendlyName;

    SleepStatTypes(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
