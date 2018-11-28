package app.collegeorganizer.stats_types;

public enum PhysicalActivityStatTypes {
    HOURS_PER_PHYSICAL_ACTIVITY("Hours per physical activity"),
    HOURS_PER_PHYSICAL_ACTIVITY_LAST_MONTH("Hours per physical activity in the last month"),
    HOURS_PER_PHYSICAL_ACTIVITY_LAST_WEEK("Hours per physical activity in the last week"),
    HOURS_PER_PHYSICAL_ACTIVITY_ON_SUNDAYS("Hours per physical activity on Sundays"),
    HOURS_PER_PHYSICAL_ACTIVITY_ON_MONDAYS("Hours per physical activity on Mondays"),
    HOURS_PER_PHYSICAL_ACTIVITY_ON_TUESDAYS("Hours per physical activity on Tuesdays"),
    HOURS_PER_PHYSICAL_ACTIVITY_ON_WEDNESDAYS("Hours per physical activity on Wednesdays"),
    HOURS_PER_PHYSICAL_ACTIVITY_ON_THURSDAYS("Hours per physical activity on Thursdays"),
    HOURS_PER_PHYSICAL_ACTIVITY_ON_FRIDAYS("Hours per physical activity on Fridays"),
    HOURS_PER_PHYSICAL_ACTIVITY_ON_SATURDAYS("Hours per physical activity on Saturdays");

    private String friendlyName;

    PhysicalActivityStatTypes(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
