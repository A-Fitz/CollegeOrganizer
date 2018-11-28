package app.collegeorganizer.data;

public class ComparisonOperator_Ratio {
    private float data1;
    private float data2;

    public ComparisonOperator_Ratio(float data1, float data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    @Override
    public String toString() {
        return String.valueOf(data1 / data2);
    }

}
