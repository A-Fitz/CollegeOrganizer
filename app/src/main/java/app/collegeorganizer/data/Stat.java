package app.collegeorganizer.data;

import app.collegeorganizer.stats_types.SleepStatTypes;

public class Stat {
    private SleepStatTypes data1Type;
    private SleepStatTypes data2Type;

    private float data1;
    private float data2;
    private ComparisonOperatorType comparisonOperator;

    public Stat(SleepStatTypes data1Type, float data1, SleepStatTypes data2Type, float data2, ComparisonOperatorType comparisonOperator) {
        this.data1Type = data1Type;
        this.data1 = data1;
        this.data2Type = data2Type;
        this.data2 = data2;
        this.comparisonOperator = comparisonOperator;
    }

    public Stat(SleepStatTypes data1Type, float data1) {
        this.data1Type = data1Type;
        this.data1 = data1;
    }

    @Override
    public String toString() {
        if (!isOnlyOneData()) {
            switch (comparisonOperator) {
                case VS:
                    ComparisonOperator_VS tempVS = new ComparisonOperator_VS(String.valueOf(data1), String.valueOf(data2));
                    return tempVS.toString();
                case RATIO:
                    ComparisonOperator_Ratio tempRatio = new ComparisonOperator_Ratio(data1, data2);
                    return tempRatio.toString();
                default:
                    return null;
            }
        } else {
            return String.valueOf(data1);
        }

    }

    public String getData1Type() {
        return data1Type.toString();
    }

    public String getData2Type() {
        return data1Type.toString();
    }

    public String getComparisonOperatorName() {
        if (!isOnlyOneData()) {
            switch (comparisonOperator) {
                case VS:
                    return "vs";
                case RATIO:
                    return "per";
                default:
                    return null;
            }
        } else {
            return "";
        }
    }

    public boolean isOnlyOneData() {
        return data2Type == null;
    }
}
