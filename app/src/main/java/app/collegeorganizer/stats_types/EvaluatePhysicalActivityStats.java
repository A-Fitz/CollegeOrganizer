package app.collegeorganizer.stats_types;

import java.util.Calendar;

public class EvaluatePhysicalActivityStats {

    public float getData(PhysicalActivityStatTypes physicalActivityStatTypes) {
        Calendar oneMonthAgo = Calendar.getInstance();
        oneMonthAgo.add(Calendar.MONTH, -1);
        oneMonthAgo.add(Calendar.DAY_OF_MONTH, -1);

        Calendar oneWeekAgo = Calendar.getInstance();
        oneWeekAgo.add(Calendar.WEEK_OF_MONTH, -1);
        oneWeekAgo.add(Calendar.DAY_OF_MONTH, -1);

        float total = 0;
        int count = 0;

        switch (physicalActivityStatTypes) {

            case HOURS_PER_PHYSICAL_ACTIVITY:
                break;
            case HOURS_PER_PHYSICAL_ACTIVITY_LAST_MONTH:
                break;
            case HOURS_PER_PHYSICAL_ACTIVITY_LAST_WEEK:
                break;
            case HOURS_PER_PHYSICAL_ACTIVITY_ON_SUNDAYS:
                break;
            case HOURS_PER_PHYSICAL_ACTIVITY_ON_MONDAYS:
                break;
            case HOURS_PER_PHYSICAL_ACTIVITY_ON_TUESDAYS:
                break;
            case HOURS_PER_PHYSICAL_ACTIVITY_ON_WEDNESDAYS:
                break;
            case HOURS_PER_PHYSICAL_ACTIVITY_ON_THURSDAYS:
                break;
            case HOURS_PER_PHYSICAL_ACTIVITY_ON_FRIDAYS:
                break;
            case HOURS_PER_PHYSICAL_ACTIVITY_ON_SATURDAYS:
                break;
        }

        return 0;
    }
}
