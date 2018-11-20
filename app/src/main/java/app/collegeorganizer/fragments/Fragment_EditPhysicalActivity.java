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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import app.collegeorganizer.OnColorChosenListener;
import app.collegeorganizer.R;
import app.collegeorganizer.activities.Activity_Main;
import app.collegeorganizer.data.PhysicalActivity;
import app.collegeorganizer.data.PhysicalActivityIntensity;

@SuppressLint("NewApi")
public class Fragment_EditPhysicalActivity extends DialogFragment {

    private PhysicalActivity item;

    private String name;
    private Date time;
    private int color;
    private String details;
    private List<String> repeating = new ArrayList<String>();
    private Date startDate;
    private Date endDate;
    private PhysicalActivityIntensity intensity;

    private EditText edit_name;
    private EditText edit_time;
    private EditText edit_details;
    private Spinner edit_intensity;
    private CheckBox edit_repeats;
    private EditText edit_startDate;
    private EditText edit_endDate;
    private CheckBox edit_sunday;
    private CheckBox edit_monday;
    private CheckBox edit_tuesday;
    private CheckBox edit_wednesday;
    private CheckBox edit_thursday;
    private CheckBox edit_friday;
    private CheckBox edit_saturday;
    private Button color_button;

    private ImageButton delete_button;
    private ImageButton cancel_button;
    private ImageButton save_button;

    private boolean isRepeating = false;
    private Date temp_endDate;
    private Date temp_startDate;
    private Date temp_time;
    private int temp_color;

    String[] dropdown_intensity_items = { "Light", "Heavy" };

    public static Fragment_EditPhysicalActivity newInstance() {
        return new Fragment_EditPhysicalActivity();
    }

    private void getItemParts()
    {
        name = item.getName();
        time = item.getTime();
        color = item.getColor();
        details = item.getDetails();
        startDate = item.getStartDate();
        intensity = item.getIntensity();
        if(item.getRepeatingDays().length() != 0)
            isRepeating = true;

        if(isRepeating) {
            repeating = item.getRepeating();
            endDate = item.getEndDate();
        }
    }

    public void setItem(PhysicalActivity item)
    {
        this.item = item;
    }

    private void setInitialValues()
    {
        edit_name.setText(name);
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        edit_time.setText(String.format(dateFormat.format(item.getTime())));
        temp_time = item.getTime();
        edit_details.setText(details);
        dateFormat = new SimpleDateFormat("MMM/dd/yyyy");
        edit_startDate.setText(String.format(dateFormat.format(item.getStartDate())));
        temp_startDate = item.getStartDate();
        switch(intensity)
        {
            case LIGHT:
                edit_intensity.setSelection(0);
                break;
            case HEAVY:
                edit_intensity.setSelection(1);
        }
        edit_repeats.setChecked(isRepeating);
        if(isRepeating)
        {
            changeRepeatBoxes();
            dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            edit_endDate.setText(String.format(dateFormat.format(item.getEndDate())));
            temp_endDate = item.getEndDate();
            for(String s : item.getRepeating())
            {
                switch(s)
                {
                    case "SU":
                        edit_sunday.setChecked(true);
                        break;
                    case "M":
                        edit_monday.setChecked(true);
                        break;
                    case "T":
                        edit_tuesday.setChecked(true);
                        break;
                    case "W":
                        edit_wednesday.setChecked(true);
                        break;
                    case "TH":
                        edit_thursday.setChecked(true);
                        break;
                    case "F":
                        edit_friday.setChecked(true);
                        break;
                    case "S":
                        edit_saturday.setChecked(true);
                        break;
                }
            }
        }
        temp_color = item.getColor();
        color_button.setBackgroundColor(temp_color);
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

        edit_name = (EditText) v.findViewById(R.id.textinput_name);
        edit_time = (EditText) v.findViewById(R.id.textinput_time);
        edit_details = (EditText) v.findViewById(R.id.textinput_details);
        edit_intensity = (Spinner) v.findViewById(R.id.activity_intensity_dropdown);
        edit_repeats = (CheckBox) v.findViewById(R.id.repeats_checkbox);
        edit_endDate = (EditText) v.findViewById(R.id.endDate);
        edit_startDate = (EditText) v.findViewById(R.id.startDate);
        edit_sunday = (CheckBox) v.findViewById(R.id.radio_sunday);
        edit_monday = (CheckBox) v.findViewById(R.id.radio_monday);
        edit_tuesday = (CheckBox) v.findViewById(R.id.radio_tuesday);
        edit_wednesday = (CheckBox) v.findViewById(R.id.radio_wednesday);
        edit_thursday = (CheckBox) v.findViewById(R.id.radio_thursday);
        edit_friday = (CheckBox) v.findViewById(R.id.radio_friday);
        edit_saturday = (CheckBox) v.findViewById(R.id.radio_saturday);
        color_button = (Button) v.findViewById(R.id.color_button);

        delete_button = (ImageButton) v.findViewById(R.id.delete_button);
        cancel_button = (ImageButton) v.findViewById(R.id.cancel_button);
        save_button = (ImageButton) v.findViewById(R.id.save_button);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, dropdown_intensity_items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        edit_intensity.setAdapter(adapter);

        delete_button.setVisibility(View.VISIBLE);

        getItemParts();
        setInitialValues();

        return v;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edit_endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(false);
            }
        });
        edit_startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(true);
            }
        });
        color_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showColorPicker();
            }
        });
        edit_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
            }
        });
        edit_repeats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRepeating = !isRepeating;
                changeRepeatBoxes();
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ask if sure TODO
                Activity_Main.physicalActivityList.remove(item);
                dismiss();
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
                    time = temp_time;
                    details = edit_details.getText().toString();
                    switch(edit_intensity.getSelectedItem().toString()) {
                        case "Light":
                            intensity = PhysicalActivityIntensity.LIGHT;
                            break;
                        case "Heavy":
                            intensity = PhysicalActivityIntensity.HEAVY;
                            break;
                    }
                    startDate = temp_startDate;
                    color = temp_color;
                    PhysicalActivity py;
                    if(isRepeating)
                    {
                        changeRepeatBoxes();
                        if(repeating != null)
                            repeating.clear();
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

                        endDate = temp_endDate;
                        py = new PhysicalActivity(name, time, color, details, repeating, startDate, endDate, intensity);
                    } else
                        py = new PhysicalActivity(name, time, color, details, startDate, intensity);

                    int index = Activity_Main.physicalActivityList.indexOf(item);

                    Activity_Main.physicalActivityList.set(index, py);

                    dismiss();
                } else
                {
                    Toast.makeText(getContext(), "Please make sure all fields are filled. Repeating is optional.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean checkInput()
    {
        boolean mainFields = (!isEditTextEmpty(edit_name) && !isEditTextEmpty(edit_details) && !isEditTextEmpty(edit_time) && !isEditTextEmpty(edit_startDate) && temp_color != 0);
        boolean repeatingFields = isOneRepeatCheckBokChecked() && !isEditTextEmpty(edit_endDate);
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
        edit_endDate.setEnabled(isRepeating);
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
        if(start_date)
            date.setCallBack(start_date_listener);
        else
            date.setCallBack(end_date_listener);
        date.show(getFragmentManager(), "Date Picker");
    }

    private void showColorPicker() {
        Fragment_ColorPicker color_picker = new Fragment_ColorPicker();
        color_picker.show(getFragmentManager(), "Color Picker");
        color_picker.DismissListener(color_picker_closeListener);
    }

    private void showTimePicker() {
        Fragment_TimePicker time = new Fragment_TimePicker();
        /**
         * Set Up Current Date Into dialog
         */
        Calendar calender = Calendar.getInstance();
        Bundle args = new Bundle();
        args.putInt("hour", calender.get(Calendar.HOUR));
        args.putInt("minute", calender.get(Calendar.MINUTE));
        time.setArguments(args);
        /**
         * Set Call back to capture selected date
         */
        time.setCallBack(ontime);
        time.show(getFragmentManager(), "Time Picker");
    }

    DatePickerDialog.OnDateSetListener end_date_listener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, monthOfYear, dayOfMonth);
            temp_endDate = calendar.getTime();

            edit_endDate.setText(String.valueOf(monthOfYear+1) + "/" + String.valueOf(dayOfMonth) + "/" + String.valueOf(year));
        }
    };

    DatePickerDialog.OnDateSetListener start_date_listener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, monthOfYear, dayOfMonth);
            temp_startDate = calendar.getTime();

            edit_startDate.setText(String.valueOf(monthOfYear+1) + "/" + String.valueOf(dayOfMonth) + "/" + String.valueOf(year));
        }
    };

    OnColorChosenListener color_picker_closeListener = new OnColorChosenListener() {
        @Override
        public void handleDialogClose(int color) {
            temp_color = color;
            color_button.setBackgroundColor(color);
        }
    };


    TimePickerDialog.OnTimeSetListener ontime = new TimePickerDialog.OnTimeSetListener() {

        public void onTimeSet(TimePicker view, int hour, int minute)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.set(0,0,0, hour, minute);
            temp_time = calendar.getTime();

            edit_time.setText(String.format("%02d:%02d", hour, minute));
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