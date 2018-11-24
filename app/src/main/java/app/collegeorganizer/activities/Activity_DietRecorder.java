package app.collegeorganizer.activities;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import app.collegeorganizer.DietRecorderAdapter;
import app.collegeorganizer.R;
import app.collegeorganizer.data.DietItem;
import app.collegeorganizer.fragments.Fragment_AddDietRecord;
import app.collegeorganizer.fragments.Fragment_DatePicker;
import app.collegeorganizer.fragments.Fragment_EditDietRecord;


public class Activity_DietRecorder extends AppCompatActivity implements DialogInterface.OnDismissListener {

    private ListView list;
    private ImageButton calendar_button;
    private TextView date_text;
    private Calendar time = Calendar.getInstance();
    private Calendar chosenDate = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_recorder);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Diet Recorder");

        list = findViewById(R.id.diet_records);
        calendar_button = findViewById(R.id.calendar_button);
        date_text = findViewById(R.id.date_text);

        FloatingActionButton fab = findViewById(R.id.add_diet_record);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = Fragment_AddDietRecord.newInstance();
                newFragment.show(getSupportFragmentManager(), "Add Diet Record");

            }
        });

        calendar_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DietItem item = (DietItem) parent.getItemAtPosition(position);
                DialogFragment newFragment = Fragment_EditDietRecord.newInstance();
                newFragment.show(getSupportFragmentManager(), "Edit Diet Record");
                ((Fragment_EditDietRecord) newFragment).setItem(item);
            }
        });

        date_text.setText(String.format(String.valueOf(time.get(Calendar.MONTH) + 1) + "/" + String.valueOf(time.get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(time.get(Calendar.YEAR))));
        refreshList();
    }

    @Override
    public void onDismiss(final DialogInterface dialog) {
        refreshList();
    }

    private List<DietItem> getListForDate(Calendar d) {
        List<DietItem> temp = new ArrayList<DietItem>();

        for (DietItem dietItem : Activity_Main.dietItemList) {
            Calendar posDate = dietItem.getTime();
            String posDateString = String.format(String.valueOf(posDate.get(Calendar.MONTH)) + "/" + String.valueOf(posDate.get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(posDate.get(Calendar.YEAR)));
            String chosenDateString = String.format(String.valueOf(d.get(Calendar.MONTH)) + "/" + String.valueOf(d.get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(d.get(Calendar.YEAR)));

            if (posDateString.matches(chosenDateString))
                temp.add(dietItem);
        }

        return temp;
    }

    private void refreshList() {
        list.setAdapter(null);
        list.setAdapter(new DietRecorderAdapter(this, getListForDate(chosenDate)));
    }

    private void showDatePicker() {
        Fragment_DatePicker date = new Fragment_DatePicker();
        /**
         * Set Up Current Date Into dialog
         */
        Bundle args = new Bundle();
        args.putInt("year", chosenDate.get(Calendar.YEAR));
        args.putInt("month", chosenDate.get(Calendar.MONTH));
        args.putInt("day", chosenDate.get(Calendar.DAY_OF_MONTH));
        date.setArguments(args);
        /**
         * Set Call back to capture selected date
         */
        date.setCallBack(date_listener);
        date.show(getSupportFragmentManager(), "Date Picker");
    }

    DatePickerDialog.OnDateSetListener date_listener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, monthOfYear, dayOfMonth);
            chosenDate = calendar;

            date_text.setText(String.valueOf(monthOfYear + 1) + "/" + String.valueOf(dayOfMonth) + "/" + String.valueOf(year));

            refreshList();
        }
    };

}
