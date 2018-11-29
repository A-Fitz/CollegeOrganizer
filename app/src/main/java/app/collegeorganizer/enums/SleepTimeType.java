package app.collegeorganizer.enums;

public enum SleepTimeType {
    NIGHT("Night"),
    NAP("Nap");

    private String friendlyName;

    SleepTimeType(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
