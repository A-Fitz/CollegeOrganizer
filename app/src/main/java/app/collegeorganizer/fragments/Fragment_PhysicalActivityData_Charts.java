package app.collegeorganizer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.EntryXComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app.collegeorganizer.R;
import app.collegeorganizer.activities.Activity_Main;
import app.collegeorganizer.data.GoogleCalendarColors;
import app.collegeorganizer.data.PhysicalActivity;

public class Fragment_PhysicalActivityData_Charts extends Fragment {
    private View view;
    private LineChart chart;
    private Spinner dropdown_chart_type;

    private String[] dropdown_chart_types = {"Start Hour & Length", "End Hour & Length", "Start Hour & End Hour"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_data_charts, viewGroup, false);

        chart = view.findViewById(R.id.chart);
        dropdown_chart_type = view.findViewById(R.id.dropdown_chart_type);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, dropdown_chart_types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown_chart_type.setAdapter(adapter);

        dropdown_chart_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String chosen = dropdown_chart_type.getSelectedItem().toString();

                switch (chosen) {
                    case "Start Hour & Length":
                        start_hour_and_length_CHART();
                        break;
                    case "End Hour & Length":
                        end_hour_and_length_CHART();
                        break;
                    case "Start Hour & End Hour":
                        start_hour_and_end_hour_CHART();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    private void start_hour_and_length_CHART() {
        List<Entry> entries = new ArrayList<Entry>();

        for (PhysicalActivity physicalActivity : Activity_Main._physicalActivityList) {

            entries.add(new Entry(physicalActivity.getStart_Hour(), physicalActivity.getLength_Hours()));
        }

        Collections.sort(entries, new EntryXComparator());

        LineDataSet dataSet = new LineDataSet(entries, "Start Hour & Length"); // add entries to dataset
        dataSet.setColor(GoogleCalendarColors.peacock);
        dataSet.setValueTextColor(GoogleCalendarColors.graphite);

        LineData lineData = new LineData(dataSet);

        Description thisDesc = new Description();
        thisDesc.setText("Start Hour (x) : Physical Activity Length (y)");
        chart.setDescription(thisDesc);
        chart.setData(lineData);
        chart.invalidate(); // refresh
    }

    private void end_hour_and_length_CHART() {
        List<Entry> entries = new ArrayList<Entry>();

        for (PhysicalActivity PhysicalActivity : Activity_Main._physicalActivityList) {

            entries.add(new Entry(PhysicalActivity.getEnd_Hour(), PhysicalActivity.getLength_Hours()));
        }

        Collections.sort(entries, new EntryXComparator());

        LineDataSet dataSet = new LineDataSet(entries, "End Hour & Length"); // add entries to dataset
        dataSet.setColor(GoogleCalendarColors.grape);
        dataSet.setValueTextColor(GoogleCalendarColors.graphite);

        LineData lineData = new LineData(dataSet);

        Description thisDesc = new Description();
        thisDesc.setText("End Hour (x) : Physical Activity Length (y)");
        chart.setDescription(thisDesc);
        chart.setData(lineData);
        chart.invalidate(); // refresh
    }

    private void start_hour_and_end_hour_CHART() {
        List<Entry> entries = new ArrayList<Entry>();

        for (PhysicalActivity PhysicalActivity : Activity_Main._physicalActivityList) {

            entries.add(new Entry(PhysicalActivity.getStart_Hour(), PhysicalActivity.getEnd_Hour()));
        }

        Collections.sort(entries, new EntryXComparator());

        LineDataSet dataSet = new LineDataSet(entries, "Start Hour & End Hour"); // add entries to dataset
        dataSet.setColor(GoogleCalendarColors.grape);
        dataSet.setValueTextColor(GoogleCalendarColors.graphite);

        LineData lineData = new LineData(dataSet);

        Description thisDesc = new Description();
        thisDesc.setText("Start Hour (x) : End Hour (y)");
        chart.setDescription(thisDesc);
        chart.setData(lineData);
        chart.invalidate(); // refresh
    }
}