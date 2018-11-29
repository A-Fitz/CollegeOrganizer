package app.collegeorganizer.enums;

public enum PhysicalActivityIntensity {
    LIGHT("Light"),
    HEAVY("Heavy");

    private String friendlyName;

    PhysicalActivityIntensity(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
