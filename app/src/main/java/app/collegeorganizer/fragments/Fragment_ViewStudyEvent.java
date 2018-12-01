package app.collegeorganizer.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import app.collegeorganizer.R;
import app.collegeorganizer.data.StudyItem;

public class Fragment_ViewStudyEvent extends DialogFragment {
    private StudyItem event;

    private TextView name;
    private TextView details;
    private TextView location;
    private TextView date;
    private TextView starttime;
    private TextView endtime;
    private TextView repeatsevery;
    private TextView repeatuntil;

    private TextView label_repeatsevery;
    private TextView label_repeatuntil;

    private SimpleDateFormat format_time = new SimpleDateFormat("hh:mm a");
    private SimpleDateFormat format_date = new SimpleDateFormat("MM/dd/yyy");

    public static Fragment_ViewStudyEvent newInstance() {
        return new Fragment_ViewStudyEvent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view_study_event, container, false);

        name = v.findViewById(R.id.textview_name);
        details = v.findViewById(R.id.textview_details);
        location = v.findViewById(R.id.textview_location);
        date = v.findViewById(R.id.textview_date);
        starttime = v.findViewById(R.id.textview_starttime);
        endtime = v.findViewById(R.id.textview_endtime);
        repeatsevery = v.findViewById(R.id.textview_repeatsevery);
        repeatuntil = v.findViewById(R.id.textview_repeatuntil);

        label_repeatsevery = v.findViewById(R.id.label_repeatsevery);
        label_repeatuntil = v.findViewById(R.id.label_repeatuntil);

        return v;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name.setText(event.getName());
        details.setText(event.getDetails());
        location.setText(event.getLocation());
        date.setText(format_date.format(event.getStartTime().getTime()));
        starttime.setText(format_time.format(event.getStartTime().getTime()));
        endtime.setText(format_time.format(event.getEndTime().getTime()));
        if (event.doesRepeat()) {
            repeatsevery.setText(event.getRepeatingDays());
            repeatuntil.setText(format_date.format(event.getRepeatUntilDate().getTime()));
        } else {
            label_repeatsevery.setVisibility(View.GONE);
            repeatsevery.setVisibility(View.GONE);
            label_repeatuntil.setVisibility(View.GONE);
            repeatuntil.setVisibility(View.GONE);
        }

    }

    public void setEvent(StudyItem event) {
        this.event = event;
    }
}
