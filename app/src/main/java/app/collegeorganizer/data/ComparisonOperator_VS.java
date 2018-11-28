package app.collegeorganizer.data;

public class ComparisonOperator_VS {
    private String data1;
    private String data2;

    public ComparisonOperator_VS(String data1, String data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    @Override
    public String toString() {
        return data1 + " vs " + data2;
    }

}
