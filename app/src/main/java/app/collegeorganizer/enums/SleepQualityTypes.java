package app.collegeorganizer.enums;

public enum SleepQualityTypes {
    NOT_WITHIN_30_MINUTES("Cannot get to sleep within 30 minutes "),
    WAKE_UP_IN_NIGHT("Wake up in the middle of the night or early morning "),
    BATHROOM("Have to get up to use the bathroom "),
    BREATHING("Cannot breathe comfortably "),
    COUGH_SNORE("Cough or snore loudly "),
    COLD("Feel too cold "),
    HOT("Feel too hot"),
    BAD_DREAMS("Have bad dreams "),
    PAIN("Feel pain");

    private String friendlyName;

    SleepQualityTypes(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
