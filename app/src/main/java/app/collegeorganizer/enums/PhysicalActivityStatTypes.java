package app.collegeorganizer.enums;

public enum PhysicalActivityStatTypes {
    TOTAL_HOURS_PER_PHYSICAL_ACTIVITY("Total hours of physical activity"),
    TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_LAST_MONTH("Total hours of physical activity in the last month"),
    TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_LAST_WEEK("Total hours of physical activity in the last week"),
    TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_SUNDAYS("Total hours of physical activity on Sundays"),
    TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_MONDAYS("Total hours of physical activity on Mondays"),
    TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_TUESDAYS("Total hours of physical activity on Tuesdays"),
    TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_WEDNESDAYS("Total hours of physical activity on Wednesdays"),
    TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_THURSDAYS("Total hours of physical activity on Thursdays"),
    TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_FRIDAYS("Total hours of physical activity on Fridays"),
    TOTAL_HOURS_PER_PHYSICAL_ACTIVITY_ON_SATURDAYS("Total hours of physical activity on Saturdays"),
    AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY("Average hours per physical activity"),
    AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_LAST_MONTH("Average hours per physical activity in the last month"),
    AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_LAST_WEEK("Average hours per physical activity in the last week"),
    AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_SUNDAYS("Average hours per physical activity on Sundays"),
    AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_MONDAYS("Average hours per physical activity on Mondays"),
    AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_TUESDAYS("Average hours per physical activity on Tuesdays"),
    AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_WEDNESDAYS("Average hours per physical activity on Wednesdays"),
    AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_THURSDAYS("Average hours per physical activity on Thursdays"),
    AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_FRIDAYS("Average hours per physical activity on Fridays"),
    AVERAGE_HOURS_PER_PHYSICAL_ACTIVITY_ON_SATURDAYS("Average hours per physical activity on Saturdays");

    private String friendlyName;

    PhysicalActivityStatTypes(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
