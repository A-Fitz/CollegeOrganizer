package app.collegeorganizer.fragments;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;

public class Fragment_TimePicker extends DialogFragment {
    TimePickerDialog.OnTimeSetListener ontimeset;
    private int hour, minute;

    public Fragment_TimePicker() {}

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
