package app.collegeorganizer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import app.collegeorganizer.notifications.Notification_SleepQuality;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Notification_SleepQuality.notify(context, "test", 1);
    }
}