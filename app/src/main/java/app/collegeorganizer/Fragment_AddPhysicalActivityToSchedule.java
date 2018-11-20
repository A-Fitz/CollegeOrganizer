package app.collegeorganizer;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment_AddPhysicalActivityToSchedule extends DialogFragment {
    static Fragment_AddPhysicalActivityToSchedule newInstance() {
        return new Fragment_AddPhysicalActivityToSchedule();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_physical_activity_to_schedule, container, false);
        return v;
    }
}