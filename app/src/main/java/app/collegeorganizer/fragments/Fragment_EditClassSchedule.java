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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import app.collegeorganizer.DialogFragmentListener;
import app.collegeorganizer.R;
import app.collegeorganizer.activities.Activity_Main;
import app.collegeorganizer.data.ClassItem;

@SuppressLint("NewApi")
public class Fragment_EditClassSchedule extends DialogFragment {

    private ClassItem item;

    private String name;
    private Calendar startTime;
    private Calendar endTime;
    private int color;
    private String details;
    private String location;
    private String professor;
    private List<String> repeating = new ArrayList<String>();
    private Calendar repeatUntilDate;

    private EditText edit_name;
    private EditText edit_startTime;
    private EditText edit_endTime;
    private EditText edit_details;
    private EditText edit_location;
    private EditText edit_professor;
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

    private ImageButton delete_button;
    private ImageButton cancel_button;
    private ImageButton save_button;

    private boolean isRepeating = false;
    private int temp_color = 0;

    private SimpleDateFormat format_time = new SimpleDateFormat("hh:mm a");
    private SimpleDateFormat format_date = new SimpleDateFormat("MM/dd/yyy");

    private DialogFragmentListener dialogFragmentListener;


    public static Fragment_EditClassSchedule newInstance() {
        return new Fragment_EditClassSchedule();
    }

    private void getItemParts() {
        name = item.getName();
        startTime = item.getStartTime();
        endTime = item.getEndTime();
        color = item.getColor();
        details = item.getDetails();
        location = item.getLocation();
        professor = item.getProfessor();
        if (item.doesRepeat())
            isRepeating = true;

        if (isRepeating) {
            repeating = item.getRepeating();
            repeatUntilDate = item.getRepeatUntilDate();
        }
    }

    public void setItem(ClassItem item) {
        this.item = item;
    }

    private void setInitialValues() {
        edit_name.setText(name);
        edit_startTime.setText(String.valueOf(format_time.format(item.getStartTime().getTime())));
        startTime = item.getStartTime();
        edit_endTime.setText(String.valueOf(format_time.format(item.getEndTime().getTime())));
        endTime = item.getEndTime();
        edit_details.setText(details);
        edit_date.setText(format_date.format(item.getStartTime().getTime()));
        edit_location.setText(item.getLocation());
        edit_professor.setText(item.getProfessor());
        edit_repeats.setChecked(isRepeating);
        if (isRepeating) {
            changeRepeatBoxes();
            edit_repeatUntilDate.setText(format_date.format(item.getRepeatUntilDate().getTime()));
            repeatUntilDate = item.getRepeatUntilDate();
            for (String s : item.getRepeating()) {
                switch (s) {
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

        if (dialogFragmentListener != null) {
            dialogFragmentListener.handleDialogClose(0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_edit_class, container, false);

        edit_name = v.findViewById(R.id.textinput_name);
        edit_startTime = v.findViewById(R.id.textinput_starttime);
        edit_endTime = v.findViewById(R.id.textinput_endtime);
        edit_details = v.findViewById(R.id.textinput_details);
        edit_location = v.findViewById(R.id.textinput_location);
        edit_professor = v.findViewById(R.id.textinput_professor);
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

        delete_button = v.findViewById(R.id.delete_button);
        cancel_button = v.findViewById(R.id.cancel_button);
        save_button = v.findViewById(R.id.save_button);

        delete_button.setVisibility(View.VISIBLE);

        getItemParts();
        setInitialValues();

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
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ask if sure TODO
                Activity_Main.classScheduleList.remove(item);
                deleteAll();
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
                if (checkInput()) {
                    name = edit_name.getText().toString();
                    details = edit_details.getText().toString();
                    location = edit_location.getText().toString();
                    professor = edit_professor.getText().toString();
                    color = temp_color;
                    ClassItem c;
                    if (isRepeating) {
                        changeRepeatBoxes();
                        if (repeating != null)
                            repeating.clear();
                        if (edit_sunday.isChecked())
                            repeating.add("SU");
                        if (edit_monday.isChecked())
                            repeating.add("M");
                        if (edit_tuesday.isChecked())
                            repeating.add("T");
                        if (edit_wednesday.isChecked())
                            repeating.add("W");
                        if (edit_thursday.isChecked())
                            repeating.add("TH");
                        if (edit_friday.isChecked())
                            repeating.add("F");
                        if (edit_saturday.isChecked())
                            repeating.add("S");

                        c = new ClassItem(name, startTime, endTime, color, details, location, professor, repeating, repeatUntilDate);
                    } else
                        c = new ClassItem(name, startTime, endTime, color, details, location, professor);

                    c.setScheduleId(c.hashCode());

                    int index = Activity_Main.classScheduleList.indexOf(item);
                    Activity_Main.classScheduleList.set(index, c);

                    //if original didn't repeat but edited does
                    if (!item.doesRepeat() && c.doesRepeat()) {
                        setAllActivities(c);
                        addRepeating(c);
                    }
                    //if original repeats but edited does not
                    else if (item.doesRepeat() && !c.doesRepeat()) {
                        deleteAll();
                        Activity_Main._classList.add(c);
                    }
                    //if we need to remove extraneous activities because the new repeat-until-date is before the original
                    else if (c.doesRepeat() && c.getRepeatUntilDate().before(item.getRepeatUntilDate())) {
                        setAllActivities(c);
                        deleteExtraActivities(c.getScheduleId());
                    }
                    //if we need to add extra activities because the new repeat-until-date is later than the original
                    else if (c.doesRepeat() && c.getRepeatUntilDate().after(item.getRepeatUntilDate())) {
                        setAllActivities(c);
                        addExtraActivities(c);
                    } else
                    //just edited regular fields
                    {
                        setAllActivities(c);
                    }

                    dismiss();
                } else {
                    Toast.makeText(getContext(), "Please make sure all fields above the save button are filled.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void deleteExtraActivities(long tempScheduleId) {
        Iterator<ClassItem> itr = Activity_Main._classList.iterator();
        while (itr.hasNext()) {
            ClassItem c = itr.next();

            if (c.getScheduleId() == tempScheduleId) {
                if (c.getStartTime().after(c.getRepeatUntilDate())) {
                    itr.remove();
                }
            }
        }
    }

    private void addExtraActivities(ClassItem c) {
        ClassItem temp = c;

        // gets the last spot of the activity and adds repeating on top of it
        for (ClassItem p : Activity_Main._classList) {
            if (p.getScheduleId() == c.getScheduleId()) {
                temp = p;
            }
        }

        addRepeating(temp);
    }

    private void setAllActivities(ClassItem c) {
        long tempScheduleId = item.getScheduleId();
        for (ClassItem that : Activity_Main._classList) {
            if (that.getScheduleId() == tempScheduleId) {
                int index = Activity_Main._classList.indexOf(that);
                that.setName(c.getName());
                that.setDetails(c.getDetails());
                that.setRepeating(c.getRepeating());
                that.setRepeatUntilDate(c.getRepeatUntilDate());
                that.setColor(c.getColor());
                that.setLocation(c.getLocation());
                that.setProfessor(c.getProfessor());
                that.setStartMinute(c.getStartMinute());
                that.setStartHour(c.getStartHour());

                that.setEndMinute(c.getEndMinute());
                that.setEndHour(c.getEndHour());
                that.setScheduleId(c.getScheduleId());

                Activity_Main._classList.set(index, that);
            }
        }
    }

    private void deleteAll() {
        Iterator<ClassItem> itr = Activity_Main._classList.iterator();
        while (itr.hasNext()) {
            ClassItem c = itr.next();

            if (c.getScheduleId() == item.getScheduleId()) {
                itr.remove();
            }
        }
    }

    private void addRepeating(ClassItem c) {
        List<String> repeatingDaysTemp = c.getRepeating();
        List<Integer> repeatingDays = getRepeatingDays(repeatingDaysTemp);


        ClassItem temp = new ClassItem(c);

        //Log.d("TESTF", String.valueOf("start: day(" + temp.getDay() + "), month(" + temp.getMonth() + "), year(" + temp.getYear() + ")"));
        //Log.d("TESTF", String.valueOf("repeatUntil: day(" + temp.getRepeatEndDay() + "), month(" + temp.getRepeatEndMonth() + "), year(" + temp.getRepeatEndYear() + ")"));
        //Log.d("TESTF", "-----------------------------------------------------");

        int counter = 0;
        int startWeekDay = c.getStartTime().get(Calendar.DAY_OF_WEEK);
        while (true) {
            temp = new ClassItem(temp);
            for (int i : repeatingDays) {
                if (i <= startWeekDay && counter == 0) {
                    continue;
                }
                ClassItem temp2 = incrementClassItemDate(temp, i);

                if (temp2.getStartTime().getTime().after(temp2.getRepeatUntilDate().getTime()))
                    return;

                Activity_Main._classList.add(temp2);
                counter++;
            }
        }
    }

    private ClassItem incrementClassItemDate(ClassItem c, int nextDay) {
        Calendar currDay = c.getStartTime();

        Calendar nextStartTime = getNextDay(currDay, nextDay);
        Calendar nextEndTime = (Calendar) nextStartTime.clone();
        nextEndTime.set(Calendar.HOUR_OF_DAY, c.getEndHour());
        nextEndTime.set(Calendar.MINUTE, c.getEndMinute());

        return new ClassItem(c);
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

    private boolean checkInput() {
        boolean mainFields = (!isEditTextEmpty(edit_name) && !isEditTextEmpty(edit_location) && !isEditTextEmpty(edit_startTime) && !isEditTextEmpty(edit_endTime) && !isEditTextEmpty(edit_date) && temp_color != 0);
        boolean repeatingFields = isOneRepeatCheckBokChecked() && !isEditTextEmpty(edit_repeatUntilDate);
        if (!isRepeating)
            return mainFields;
        else
            return (mainFields && repeatingFields);
    }

    private boolean isOneRepeatCheckBokChecked() {
        return (edit_sunday.isChecked() || edit_monday.isChecked() || edit_tuesday.isChecked() ||
                edit_wednesday.isChecked() || edit_thursday.isChecked() || edit_friday.isChecked() || edit_saturday.isChecked());
    }

    private boolean isEditTextEmpty(EditText et) {
        return (et.getText().toString().matches(""));
    }

    private void changeRepeatBoxes() {
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
            repeatUntilDate = calendar;

            edit_repeatUntilDate.setText(format_date.format(repeatUntilDate.getTime()));
        }
    };

    DatePickerDialog.OnDateSetListener start_date_listener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            startTime.set(Calendar.YEAR, year);
            startTime.set(Calendar.MONTH, monthOfYear);
            startTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            edit_date.setText(format_date.format(startTime.getTime()));
        }
    };

    private void showColorPicker() {
        Fragment_ColorPicker color_picker = new Fragment_ColorPicker();
        color_picker.show(getFragmentManager(), "Color Picker");
        color_picker.DismissListener(color_picker_closeListener);
    }

    DialogFragmentListener color_picker_closeListener = new DialogFragmentListener() {
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
        args.putInt("hour", calender.get(Calendar.HOUR));
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
            startTime.set(Calendar.HOUR, hour);
            startTime.set(Calendar.MINUTE, minute);

            edit_startTime.setText(String.valueOf(format_time.format(startTime.getTime())));
        }
    };

    TimePickerDialog.OnTimeSetListener end_time_listener = new TimePickerDialog.OnTimeSetListener() {

        public void onTimeSet(TimePicker view, int hour, int minute) {
            endTime = (Calendar) startTime.clone();
            endTime.set(Calendar.HOUR_OF_DAY, hour);
            endTime.set(Calendar.MINUTE, minute);

            edit_endTime.setText(String.valueOf(format_time.format(endTime.getTime())));
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

    public void DismissListener(DialogFragmentListener dialogFragmentListener) {
        this.dialogFragmentListener = dialogFragmentListener;
    }
}