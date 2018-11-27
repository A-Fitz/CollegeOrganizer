package app.collegeorganizer.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import app.collegeorganizer.OnColorChosenListener;
import app.collegeorganizer.R;
import app.collegeorganizer.activities.Activity_Main;
import app.collegeorganizer.data.SleepItem;
import app.collegeorganizer.data.SleepQualityTypes;
import app.collegeorganizer.data.SleepTimeType;

@SuppressLint("NewApi")
public class Fragment_AddSleepRecord extends DialogFragment {

    private SleepTimeType sleepTimeType;
    private List<SleepQualityTypes> sleepQualityTypesList = new ArrayList<SleepQualityTypes>();
    private Calendar start_time = Calendar.getInstance();
    private Calendar end_time = Calendar.getInstance();
    private String details;
    private int color;

    private Spinner edit_sleepTimeType;
    private CheckBox edit_NOT_WITHIN_30_MINUTES;
    private CheckBox edit_WAKE_UP_IN_NIGHT;
    private CheckBox edit_BATHROOM;
    private CheckBox edit_BREATHING;
    private CheckBox edit_COUGH_SNORE;
    private CheckBox edit_COLD;
    private CheckBox edit_HOT;
    private CheckBox edit_BAD_DREAMS;
    private CheckBox edit_PAIN;
    private EditText edit_start_time;
    private EditText edit_end_time;
    private EditText edit_details;

    private Button color_button;

    private ImageButton cancel_button;
    private ImageButton save_button;

    private int temp_color = 0;

    private SimpleDateFormat format_time = new SimpleDateFormat("hh:mm a");

    String[] dropdown_sleep_time_type_items = {"Night", "Nap"};

    public static Fragment_AddSleepRecord newInstance() {
        return new Fragment_AddSleepRecord();
    }

    @Override
    public void onDismiss(final DialogInterface dialog) {
        super.onDismiss(dialog);
        final Activity activity = getActivity();
        if (activity instanceof DialogInterface.OnDismissListener) {
            ((DialogInterface.OnDismissListener) activity).onDismiss(dialog);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_edit_sleep_record, container, false);

        edit_sleepTimeType = v.findViewById(R.id.dropdown_sleep_time_type);
        edit_NOT_WITHIN_30_MINUTES = v.findViewById(R.id.checkbox_NOT_WITHIN_30_MINUTES);
        edit_WAKE_UP_IN_NIGHT = v.findViewById(R.id.checkbox_WAKE_UP_IN_NIGHT);
        edit_BATHROOM = v.findViewById(R.id.checkbox_BATHROOM);
        edit_BREATHING = v.findViewById(R.id.checkbox_BREATHING);
        edit_COUGH_SNORE = v.findViewById(R.id.checkbox_COUGH_SNORE);
        edit_COLD = v.findViewById(R.id.checkbox_COLD);
        edit_HOT = v.findViewById(R.id.checkbox_HOT);
        edit_BAD_DREAMS = v.findViewById(R.id.checkbox_BAD_DREAMS);
        edit_PAIN = v.findViewById(R.id.checkbox_PAIN);
        edit_start_time = v.findViewById(R.id.textinput_start_time);
        edit_end_time = v.findViewById(R.id.textinput_end_time);
        edit_details = v.findViewById(R.id.textinput_details);

        color_button = v.findViewById(R.id.color_button);

        cancel_button = v.findViewById(R.id.cancel_button);
        save_button = v.findViewById(R.id.save_button);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, dropdown_sleep_time_type_items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edit_sleepTimeType.setAdapter(adapter);

        return v;
    }

    public void setDate(Calendar toDate) {
        start_time.set(Calendar.DAY_OF_MONTH, toDate.get(Calendar.DAY_OF_MONTH));
        start_time.set(Calendar.MONTH, toDate.get(Calendar.MONTH));
        start_time.set(Calendar.YEAR, toDate.get(Calendar.YEAR));
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        color_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showColorPicker();
            }
        });
        edit_start_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker(true);
            }
        });
        edit_end_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker(false);
            }
        });
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ask if sure TODO
                dismiss();
            }
        });
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkInput()) {
                    switch (edit_sleepTimeType.getSelectedItem().toString()) {
                        case "Night":
                            sleepTimeType = SleepTimeType.NIGHT;
                            break;
                        case "Lunch":
                            sleepTimeType = SleepTimeType.NAP;
                            break;
                    }

                    if (edit_NOT_WITHIN_30_MINUTES.isChecked())
                        sleepQualityTypesList.add(SleepQualityTypes.NOT_WITHIN_30_MINUTES);
                    if (edit_WAKE_UP_IN_NIGHT.isChecked())
                        sleepQualityTypesList.add(SleepQualityTypes.WAKE_UP_IN_NIGHT);
                    if (edit_BATHROOM.isChecked())
                        sleepQualityTypesList.add(SleepQualityTypes.BATHROOM);
                    if (edit_BREATHING.isChecked())
                        sleepQualityTypesList.add(SleepQualityTypes.BREATHING);
                    if (edit_COUGH_SNORE.isChecked())
                        sleepQualityTypesList.add(SleepQualityTypes.COUGH_SNORE);
                    if (edit_COLD.isChecked())
                        sleepQualityTypesList.add(SleepQualityTypes.COLD);
                    if (edit_HOT.isChecked())
                        sleepQualityTypesList.add(SleepQualityTypes.HOT);
                    if (edit_BAD_DREAMS.isChecked())
                        sleepQualityTypesList.add(SleepQualityTypes.BAD_DREAMS);
                    if (edit_PAIN.isChecked())
                        sleepQualityTypesList.add(SleepQualityTypes.PAIN);

                    details = edit_details.getText().toString();
                    color = temp_color;

                    SleepItem s = new SleepItem(sleepTimeType, sleepQualityTypesList, start_time, end_time, details, color);

                    Activity_Main.sleepItemList.add(s);

                    dismiss();
                } else {
                    Toast.makeText(getContext(), "Please make sure all fields above the save button are filled.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private boolean checkInput() {
        boolean mainFields = (!isEditTextEmpty(edit_start_time) && !isEditTextEmpty(edit_end_time) && temp_color != 0);
        return mainFields;
    }

    private boolean isEditTextEmpty(EditText et) {
        return (et.getText().toString().matches(""));
    }

    private void showColorPicker() {
        Fragment_ColorPicker color_picker = new Fragment_ColorPicker();
        color_picker.show(getFragmentManager(), "Color Picker");
        color_picker.DismissListener(color_picker_closeListener);
    }

    private void showTimePicker(boolean startTime) {
        Fragment_TimePicker time = new Fragment_TimePicker();
        /**
         * Set Up Current Date Into dialog
         */
        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("hour", calender.get(Calendar.HOUR_OF_DAY));
        args.putInt("minute", calender.get(Calendar.MINUTE));
        time.setArguments(args);
        /**
         * Set Call back to capture selected date
         */
        if (startTime)
            time.setCallBack(ontime_start);
        else
            time.setCallBack(ontime_end);
        time.show(getFragmentManager(), "Time Picker");
    }

    TimePickerDialog.OnTimeSetListener ontime_start = new TimePickerDialog.OnTimeSetListener() {

        public void onTimeSet(TimePicker view, int hour, int minute) {
            start_time.set(Calendar.HOUR_OF_DAY, hour);
            start_time.set(Calendar.MINUTE, minute);

            edit_start_time.setText(String.valueOf(format_time.format(start_time.getTime())));
        }
    };

    TimePickerDialog.OnTimeSetListener ontime_end = new TimePickerDialog.OnTimeSetListener() {

        public void onTimeSet(TimePicker view, int hour, int minute) {
            end_time.set(Calendar.HOUR_OF_DAY, hour);
            end_time.set(Calendar.MINUTE, minute);

            edit_end_time.setText(String.valueOf(format_time.format(end_time.getTime())));
        }
    };

    OnColorChosenListener color_picker_closeListener = new OnColorChosenListener() {
        @Override
        public void handleDialogClose(int color) {
            temp_color = color;
            color_button.setBackgroundColor(color);
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
    }
}