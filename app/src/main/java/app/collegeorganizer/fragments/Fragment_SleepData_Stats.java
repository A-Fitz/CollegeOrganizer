package app.collegeorganizer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.collegeorganizer.R;
import app.collegeorganizer.adapters.DataStatListAdapter;
import app.collegeorganizer.data.Stat;
import app.collegeorganizer.enums.SleepStatTypes;
import app.collegeorganizer.stats.EvaluateSleepStats;

public class Fragment_SleepData_Stats extends Fragment {

    private ListView list;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_data_stats, viewGroup, false);


        list = view.findViewById(R.id.stats_list);
        list.setAdapter(new DataStatListAdapter(getContext(), getList()));


        return view;
    }

    private List<Stat> getList() {
        List<Stat> temp = new ArrayList<Stat>();

        for (SleepStatTypes statTypes : SleepStatTypes.values()) {
            EvaluateSleepStats evaluateSleepStats = new EvaluateSleepStats();
            temp.add(new Stat(statTypes, evaluateSleepStats.getData(statTypes)));
        }

        return temp;
    }
}