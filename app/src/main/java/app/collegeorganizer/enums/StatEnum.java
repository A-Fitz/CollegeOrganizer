package app.collegeorganizer.enums;

public enum StatEnum {
    SLEEP("Sleep"),
    PHYSICAL_ACTIVITY("Physical Activity"),
    SOCIAL_ACTIVITY("Social Activity"),
    DIET("Diet"),
    CLASS("Class"),
    STUDY("Study");

    private String friendlyName;

    StatEnum(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
