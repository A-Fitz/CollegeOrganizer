package app.collegeorganizer.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
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
import app.collegeorganizer.data.PhysicalActivity;
import app.collegeorganizer.data.PhysicalActivityIntensity;

@SuppressLint("NewApi")
public class Fragment_AddPhysicalActivity extends DialogFragment {

    private String name;
    private Calendar startTime = Calendar.getInstance();
    private Calendar endTime = Calendar.getInstance();
    private int color;
    private String details;
    private List<String> repeating = new ArrayList<String>();
    private Calendar repeatUntilDate = Calendar.getInstance();
    private PhysicalActivityIntensity intensity;

    private EditText edit_name;
    private EditText edit_startTime;
    private EditText edit_endTime;
    private EditText edit_details;
    private Spinner edit_intensity;
    private CheckBox edit_repeats;
    private EditText edit_date;
    private EditText edit_repeatUntilDate;
    private CheckBox edit_sunday;
    private CheckBox edit_monday;
    private CheckBox edit_tuesday;
    private CheckBox edit_wednesday;
    private CheckBox edit_thursday;
    private CheckBox edit_friday;
    private CheckBox edit_saturday;
    private Button color_button;

    private ImageButton cancel_button;
    private ImageButton save_button;

    private boolean isRepeating = false;
    private Calendar temp_repeatUntilDate = Calendar.getInstance();
    private Calendar temp_startTime = Calendar.getInstance();
    private Calendar temp_endTime = Calendar.getInstance();
    private int temp_color = 0;

    private SimpleDateFormat format_time = new SimpleDateFormat("hh:mm a");
    private SimpleDateFormat format_date = new SimpleDateFormat("MM/dd/yyy");

    String[] dropdown_intensity_items = { "Light", "Heavy" };

    public static Fragment_AddPhysicalActivity newInstance() {
        return new Fragment_AddPhysicalActivity();
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
        View v = inflater.inflate(R.layout.fragment_add_edit_physical_activity, container, false);

        edit_name = v.findViewById(R.id.textinput_name);
        edit_startTime = v.findViewById(R.id.textinput_starttime);
        edit_endTime = v.findViewById(R.id.textinput_endtime);
        edit_details = v.findViewById(R.id.textinput_details);
        edit_intensity = v.findViewById(R.id.activity_intensity_dropdown);
        edit_repeats = v.findViewById(R.id.repeats_checkbox);
        edit_date = v.findViewById(R.id.date);
        edit_repeatUntilDate = v.findViewById(R.id.repeatUntilDate);
        edit_sunday = v.findViewById(R.id.radio_sunday);
        edit_monday = v.findViewById(R.id.radio_monday);
        edit_tuesday = v.findViewById(R.id.radio_tuesday);
        edit_wednesday = v.findViewById(R.id.radio_wednesday);
        edit_thursday = v.findViewById(R.id.radio_thursday);
        edit_friday = v.findViewById(R.id.radio_friday);
        edit_saturday = v.findViewById(R.id.radio_saturday);
        color_button = v.findViewById(R.id.color_button);

        cancel_button = v.findViewById(R.id.cancel_button);
        save_button = v.findViewById(R.id.save_button);

        edit_startTime.setText(String.valueOf(format_time.format(startTime.getTime())));
        edit_date.setText(String.valueOf(format_date.format(startTime.getTime())));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, dropdown_intensity_items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edit_intensity.setAdapter(adapter);

        return v;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edit_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(true);
            }
        });
        edit_repeatUntilDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(false);
            }
        });
        color_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showColorPicker();
            }
        });
        edit_startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker(true);
            }
        });
        edit_endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker(false);
            }
        });
        edit_repeats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRepeating = !isRepeating;
                changeRepeatBoxes();
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
                if(checkInput())
                {
                    name = edit_name.getText().toString();
                    startTime = temp_startTime;
                    endTime = temp_endTime;
                    details = edit_details.getText().toString();
                    switch(edit_intensity.getSelectedItem().toString()) {
                        case "Light":
                            intensity = PhysicalActivityIntensity.LIGHT;
                            break;
                        case "Heavy":
                            intensity = PhysicalActivityIntensity.HEAVY;
                            break;
                    }
                    color = temp_color;
                    PhysicalActivity py;
                    if(isRepeating)
                    {
                        if(edit_sunday.isChecked())
                            repeating.add("SU");
                        if(edit_monday.isChecked())
                            repeating.add("M");
                        if(edit_tuesday.isChecked())
                            repeating.add("T");
                        if(edit_wednesday.isChecked())
                            repeating.add("W");
                        if(edit_thursday.isChecked())
                            repeating.add("TH");
                        if(edit_friday.isChecked())
                            repeating.add("F");
                        if(edit_saturday.isChecked())
                            repeating.add("S");

                        repeatUntilDate = temp_repeatUntilDate;
                        py = new PhysicalActivity(name, startTime, endTime, color, details, repeating, repeatUntilDate, intensity);
                    } else
                        py = new PhysicalActivity(name, startTime, endTime, color, details, intensity);

                    py.setScheduleId(py.hashCode());

                    Activity_Main.physicalScheduleList.add(py);

                    Activity_Main._physicalActivityList.add(py);

                    if (py.doesRepeat())
                        addRepeating(py);

                    dismiss();
                } else
                {
                    Toast.makeText(getContext(), "Please make sure all fields above the save button are filled.", Toast.LENGTH_SHORT).show();
                }
                
            }
        });
    }

    private void addRepeating(PhysicalActivity py) {
        List<String> repeatingDaysTemp = py.getRepeating();
        List<Integer> repeatingDays = getRepeatingDays(repeatingDaysTemp);


        PhysicalActivity temp = new PhysicalActivity(py);

        //Log.d("TESTF", String.valueOf("start: day(" + temp.getDay() + "), month(" + temp.getMonth() + "), year(" + temp.getYear() + ")"));
        //Log.d("TESTF", String.valueOf("repeatUntil: day(" + temp.getRepeatEndDay() + "), month(" + temp.getRepeatEndMonth() + "), year(" + temp.getRepeatEndYear() + ")"));
        //Log.d("TESTF", "-----------------------------------------------------");

        int counter = 0;
        int startWeekDay = py.getStartTime().get(Calendar.DAY_OF_WEEK);
        while (true) {
            temp = new PhysicalActivity(temp);
            for (int i : repeatingDays) {
                if (i <= startWeekDay && counter == 0) {
                    continue;
                }
                PhysicalActivity temp2 = incrementPhysicalActivityDate(temp, i);

                if (temp2.getStartTime().getTime().after(temp2.getRepeatUntilDate().getTime()))
                    return;

                Activity_Main._physicalActivityList.add(temp2);
                counter++;
            }
        }
    }

    private PhysicalActivity incrementPhysicalActivityDate(PhysicalActivity py, int nextDay) {
        Calendar currDay = py.getStartTime();

        Calendar nextStartTime = getNextDay(currDay, nextDay);
        Calendar nextEndTime = (Calendar) nextStartTime.clone();
        nextEndTime.set(Calendar.HOUR_OF_DAY, py.getEndHour());
        nextEndTime.set(Calendar.MINUTE, py.getEndMinute());

        return new PhysicalActivity(py);
    }


    private Calendar getNextDay(Calendar date, int dayOfWeek) {

        int diff = dayOfWeek - date.get(Calendar.DAY_OF_WEEK);
        if (diff <= 0) {
            diff += 7;
        }
        date.add(Calendar.DAY_OF_MONTH, diff);
        //Log.d("TESTF", String.valueOf("********** nextDay: dayOfWeek(" + dayOfWeek + "), diff(" + diff + "), newDate day(" + date.get(Calendar.DAY_OF_MONTH) + "), newDate month(" + date.get(Calendar.MONTH) + ")"));
        return date;
    }

    private List<Integer> getRepeatingDays(List<String> repeatingDaysTemp) {
        List<Integer> repeatingDays = new ArrayList<Integer>();

        for (String str : repeatingDaysTemp) {
            switch (str) {
                case "SU":
                    repeatingDays.add(Calendar.SUNDAY);
                    break;
                case "M":
                    repeatingDays.add(Calendar.MONDAY);
                    break;
                case "T":
                    repeatingDays.add(Calendar.TUESDAY);
                    break;
                case "W":
                    repeatingDays.add(Calendar.WEDNESDAY);
                    break;
                case "TH":
                    repeatingDays.add(Calendar.THURSDAY);
                    break;
                case "F":
                    repeatingDays.add(Calendar.FRIDAY);
                    break;
                case "S":
                    repeatingDays.add(Calendar.SATURDAY);
                    break;
            }
        }

        return repeatingDays;
    }

    private boolean checkInput()
    {
        boolean mainFields = (!isEditTextEmpty(edit_name) && !isEditTextEmpty(edit_startTime) && !isEditTextEmpty(edit_endTime) && !isEditTextEmpty(edit_date) && temp_color != 0);
        boolean repeatingFields = isOneRepeatCheckBokChecked() && !isEditTextEmpty(edit_repeatUntilDate);
        if(!isRepeating)
            return mainFields;
        else
            return (mainFields && repeatingFields);
    }

    private boolean isOneRepeatCheckBokChecked ()
    {
        return (edit_sunday.isChecked() || edit_monday.isChecked() || edit_tuesday.isChecked() ||
                edit_wednesday.isChecked() || edit_thursday.isChecked() || edit_friday.isChecked() || edit_saturday.isChecked());
    }

    private boolean isEditTextEmpty(EditText et)
    {
        return (et.getText().toString().matches(""));
    }

    private void changeRepeatBoxes()
    {
        edit_repeatUntilDate.setEnabled(isRepeating);
        edit_sunday.setEnabled(isRepeating);
        edit_monday.setEnabled(isRepeating);
        edit_tuesday.setEnabled(isRepeating);
        edit_wednesday.setEnabled(isRepeating);
        edit_thursday.setEnabled(isRepeating);
        edit_friday.setEnabled(isRepeating);
        edit_saturday.setEnabled(isRepeating);
    }

    private void showDatePicker(boolean start_date) {
        Fragment_DatePicker date = new Fragment_DatePicker();
        /**
         * Set Up Current Date Into dialog
         */
        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("year", calender.get(Calendar.YEAR));
        args.putInt("month", calender.get(Calendar.MONTH));
        args.putInt("day", calender.get(Calendar.DAY_OF_MONTH));
        date.setArguments(args);
        /**
         * Set Call back to capture selected date
         */
        if (start_date)
            date.setCallBack(start_date_listener);
        else
            date.setCallBack(end_date_listener);
        date.show(getFragmentManager(), "Date Picker");
    }

    DatePickerDialog.OnDateSetListener end_date_listener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, monthOfYear, dayOfMonth);
            temp_repeatUntilDate = calendar;

            edit_repeatUntilDate.setText(format_date.format(temp_repeatUntilDate.getTime()));
        }
    };

    DatePickerDialog.OnDateSetListener start_date_listener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            temp_startTime.set(Calendar.YEAR, year);
            temp_startTime.set(Calendar.MONTH, dayOfMonth);
            temp_startTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            edit_date.setText(format_date.format(temp_startTime.getTime()));
        }
    };

    private void showColorPicker() {
        Fragment_ColorPicker color_picker = new Fragment_ColorPicker();
        color_picker.show(getFragmentManager(), "Color Picker");
        color_picker.DismissListener(color_picker_closeListener);
    }

    OnColorChosenListener color_picker_closeListener = new OnColorChosenListener() {
        @Override
        public void handleDialogClose(int color) {
            temp_color = color;
            color_button.setBackgroundColor(color);
        }
    };

    private void showTimePicker(boolean start_time) {
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
        if (start_time)
            time.setCallBack(start_time_listener);
        else
            time.setCallBack(end_time_listener);
        time.show(getFragmentManager(), "Time Picker");
    }

    TimePickerDialog.OnTimeSetListener start_time_listener = new TimePickerDialog.OnTimeSetListener() {

        public void onTimeSet(TimePicker view, int hour, int minute) {
            temp_startTime.set(Calendar.HOUR_OF_DAY, hour);
            temp_startTime.set(Calendar.MINUTE, minute);

            edit_startTime.setText(String.valueOf(format_time.format(temp_startTime.getTime())));
        }
    };

    TimePickerDialog.OnTimeSetListener end_time_listener = new TimePickerDialog.OnTimeSetListener() {

        public void onTimeSet(TimePicker view, int hour, int minute) {
            temp_endTime = (Calendar) temp_startTime.clone();
            temp_endTime.set(Calendar.HOUR_OF_DAY, hour);
            temp_endTime.set(Calendar.MINUTE, minute);

            edit_endTime.setText(String.valueOf(format_time.format(temp_endTime.getTime())));
        }
    };


    @Override
    public void onResume()
    {
        super.onResume();
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
    }
}