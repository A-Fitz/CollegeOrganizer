package app.collegeorganizer.data;

public class Stat {
    private String data1Type;
    private String data2Type;

    private Object data1;
    private Object data2;
    private ComparisonOperatorType comparisonOperator;

    public Stat(String data1Type, Object data1, String data2Type, Object data2, ComparisonOperatorType comparisonOperator) {
        this.data1Type = data1Type;
        this.data1 = data1;
        this.data2Type = data2Type;
        this.data2 = data2;
        this.comparisonOperator = comparisonOperator;
    }

    public Stat(String data1Type, Object data1) {
        this.data1Type = data1Type;
        this.data1 = data1;
    }

    @Override
    public String toString() {
        if (!isOnlyOneData()) {
            switch (comparisonOperator) {
                case VS:
                    ComparisonOperator_VS tempVS = new ComparisonOperator_VS(data1.toString(), data2.toString());
                    return tempVS.toString();
                default:
                    return null;
            }
        } else {
            return data1.toString();
        }

    }

    public String getData1Type() {
        return data1Type;
    }

    public String getData2Type() {
        return data2Type;
    }

    public String getComparisonOperatorName() {
        return comparisonOperator.toString().toLowerCase();
    }

    public boolean isOnlyOneData() {
        return data2 == null;
    }
}
