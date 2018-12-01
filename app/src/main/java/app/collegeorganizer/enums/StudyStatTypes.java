package app.collegeorganizer.enums;

public enum StudyStatTypes {
    TOTAL_HOURS_STUDY("Total hours studying"),
    TOTAL_HOURS_STUDY_LAST_MONTH("Total hours studying in the last month"),
    TOTAL_HOURS_STUDY_LAST_WEEK("Total hours studying in the last week"),
    TOTAL_HOURS_STUDY_SUNDAYS("Total hours studying on Sundays"),
    TOTAL_HOURS_STUDY_MONDAYS("Total hours studying on Mondays"),
    TOTAL_HOURS_STUDY_TUESDAYS("Total hours studying on Tuesdays"),
    TOTAL_HOURS_STUDY_WEDNESDAYS("Total hours studying on Wednesdays"),
    TOTAL_HOURS_STUDY_THURSDAYS("Total hours studying on Thursdays"),
    TOTAL_HOURS_STUDY_FRIDAYS("Total hours studying on Fridays"),
    TOTAL_HOURS_STUDY_SATURDAYS("Total hours studying on Saturdays"),
    AVERAGE_HOURS_PER_STUDY("Average hours per studying period"),
    AVERAGE_HOURS_PER_STUDY_LAST_MONTH("Average hours per studying period in the last month"),
    AVERAGE_HOURS_PER_STUDY_LAST_WEEK("Average hours per studying period in the last week"),
    AVERAGE_HOURS_PER_STUDY_ON_SUNDAYS("Average hours per studying period on Sundays"),
    AVERAGE_HOURS_PER_STUDY_ON_MONDAYS("Average hours per studying period on Mondays"),
    AVERAGE_HOURS_PER_STUDY_ON_TUESDAYS("Average hours per studying period on Tuesdays"),
    AVERAGE_HOURS_PER_STUDY_ON_WEDNESDAYS("Average hours per studying period on Wednesdays"),
    AVERAGE_HOURS_PER_STUDY_ON_THURSDAYS("Average hours per studying period on Thursdays"),
    AVERAGE_HOURS_PER_STUDY_ON_FRIDAYS("Average hours per studying period on Fridays"),
    AVERAGE_HOURS_PER_STUDY_ON_SATURDAYS("Average hours per studying period on Saturdays");

    private String friendlyName;

    StudyStatTypes(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
