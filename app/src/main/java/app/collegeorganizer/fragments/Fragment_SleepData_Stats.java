package app.collegeorganizer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import app.collegeorganizer.R;
import app.collegeorganizer.activities.Activity_Main;
import app.collegeorganizer.adapters.SleepData_Stats_CategoriesAdapter;

public class Fragment_SleepData_Stats extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    private ListView categories_list;

    // newInstance constructor for creating fragment with arguments
    public static Fragment_SleepData_Stats newInstance(int page, String title) {
        Fragment_SleepData_Stats fragmentFirst = new Fragment_SleepData_Stats();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sleepdata_stats, container, false);

        categories_list = view.findViewById(R.id.categories_list);

        categories_list.setAdapter(new SleepData_Stats_CategoriesAdapter(view.getContext(), Activity_Main.sleepDataCategoryList));

        return view;
    }
}