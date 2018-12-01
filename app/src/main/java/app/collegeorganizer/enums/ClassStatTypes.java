package app.collegeorganizer.enums;

public enum ClassStatTypes {
    TOTAL_HOURS_CLASS("Total hours in class"),
    TOTAL_HOURS_CLASS_LAST_MONTH("Total hours in class in the last month"),
    TOTAL_HOURS_CLASS_LAST_WEEK("Total hours in class in the last week"),
    TOTAL_HOURS_CLASS_SUNDAYS("Total hours in class on Sundays"),
    TOTAL_HOURS_CLASS_MONDAYS("Total hours in class on Mondays"),
    TOTAL_HOURS_CLASS_TUESDAYS("Total hours in class on Tuesdays"),
    TOTAL_HOURS_CLASS_WEDNESDAYS("Total hours in class on Wednesdays"),
    TOTAL_HOURS_CLASS_THURSDAYS("Total hours in class on Thursdays"),
    TOTAL_HOURS_CLASS_FRIDAYS("Total hours in class on Fridays"),
    TOTAL_HOURS_CLASS_SATURDAYS("Total hours in class on Saturdays"),
    AVERAGE_HOURS_PER_CLASS("Average hours per class"),
    AVERAGE_HOURS_PER_CLASS_LAST_MONTH("Average hours per class in the last month"),
    AVERAGE_HOURS_PER_CLASS_LAST_WEEK("Average hours per class in the last week"),
    AVERAGE_HOURS_PER_CLASS_ON_SUNDAYS("Average hours per class on Sundays"),
    AVERAGE_HOURS_PER_CLASS_ON_MONDAYS("Average hours per class on Mondays"),
    AVERAGE_HOURS_PER_CLASS_ON_TUESDAYS("Average hours per class on Tuesdays"),
    AVERAGE_HOURS_PER_CLASS_ON_WEDNESDAYS("Average hours per class on Wednesdays"),
    AVERAGE_HOURS_PER_CLASS_ON_THURSDAYS("Average hours per class on Thursdays"),
    AVERAGE_HOURS_PER_CLASS_ON_FRIDAYS("Average hours per class on Fridays"),
    AVERAGE_HOURS_PER_CLASS_ON_SATURDAYS("Average hours per class on Saturdays");

    private String friendlyName;

    ClassStatTypes(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
