package app.collegeorganizer.stats_types;

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
