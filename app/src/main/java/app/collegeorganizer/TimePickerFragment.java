package app.collegeorganizer;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class TimePickerFragment extends DialogFragment {
    TimePickerDialog.OnTimeSetListener ontimeset;
    private int hour, minute;

    public TimePickerFragment() {}

    public void setCallBack(TimePickerDialog.OnTimeSetListener ontime) {
        ontimeset = ontime;
    }

    @SuppressLint("NewApi")
    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        hour = args.getInt("hour");
        minute = args.getInt("minute");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new TimePickerDialog(getActivity(), ontimeset, hour, minute, false);
    }
}
