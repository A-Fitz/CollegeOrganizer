package app.collegeorganizer.stats;

import app.collegeorganizer.enums.PhysicalActivityStatTypes;
import app.collegeorganizer.enums.SleepStatTypes;
import app.collegeorganizer.enums.StatEnum;

public class EvaluateStats {
    public float getData(StatEnum e, Enum stat) {
        switch (e) {
            case SLEEP:
                EvaluateSleepStats es = new EvaluateSleepStats();
                return es.getData((SleepStatTypes) stat);
            case PHYSICAL_ACTIVITY:
                EvaluatePhysicalActivityStats ev = new EvaluatePhysicalActivityStats();
                return ev.getData((PhysicalActivityStatTypes) stat);
        }
        return 0;
    }
}
