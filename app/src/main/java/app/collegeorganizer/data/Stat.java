package app.collegeorganizer.data;

import app.collegeorganizer.enums.ComparisonOperatorType;

public class Stat {
    private Enum data1Type;
    private Enum data2Type;

    private float data1;
    private float data2;
    private ComparisonOperatorType comparisonOperator;

    public Stat(Enum data1Type, float data1, Enum data2Type, float data2, ComparisonOperatorType comparisonOperator) {
        this.data1Type = data1Type;
        this.data1 = data1;
        this.data2Type = data2Type;
        this.data2 = data2;
        this.comparisonOperator = comparisonOperator;
    }

    public Stat(Enum data1Type, float data1) {
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

    public void setData1Type(Enum data1Type) {
        this.data1Type = data1Type;
    }

    public void setData2Type(Enum data2Type) {
        this.data2Type = data2Type;
    }

    public void setData1(float data1) {
        this.data1 = data1;
    }

    public void setData2(float data2) {
        this.data2 = data2;
    }

    public float getData1() {
        return data1;
    }

    public float getData2() {
        return data2;
    }

    public void setComparisonOperator(ComparisonOperatorType comparisonOperator) {
        this.comparisonOperator = comparisonOperator;
    }

    public String getData1Type() {
        return data1Type.toString();
    }

    public String getData2Type() {
        return data2Type.toString();
    }

    public Enum enum_getData1Type() {
        return data1Type;
    }

    public Enum enum_getData2Type() {
        return data2Type;
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
