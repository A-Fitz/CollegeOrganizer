package app.collegeorganizer.data;

public class ComparisonOperator_Ratio {
    private int data1;
    private int data2;

    public ComparisonOperator_Ratio(int data1, int data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    @Override
    public String toString() {
        return String.valueOf(data1 / data2);
    }

}
