package app.collegeorganizer.enums;

public enum ComparisonOperatorType {
    VS("vs"),
    RATIO("ratio");

    private String friendlyName;

    ComparisonOperatorType(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
