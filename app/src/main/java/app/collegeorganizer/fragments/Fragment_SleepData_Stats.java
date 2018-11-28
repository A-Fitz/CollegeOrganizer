package app.collegeorganizer.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import app.collegeorganizer.AddNewStatListener;
import app.collegeorganizer.DialogFragmentListener;
import app.collegeorganizer.R;
import app.collegeorganizer.activities.Activity_Main;
import app.collegeorganizer.adapters.SleepData_Stats_CategoriesAdapter;

public class Fragment_SleepData_Stats extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    private ListView categories_list;
    private FloatingActionButton fab;

    // newInstance constructor for creating fragment with arguments
    public static Fragment_SleepData_Stats newInstance(int page, String title) {
        Fragment_SleepData_Stats fragmentFirst = new Fragment_SleepData_Stats();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    SleepData_Stats_CategoriesAdapter listAdapter;
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
        fab = view.findViewById(R.id.fab);

        listAdapter = new SleepData_Stats_CategoriesAdapter(view.getContext(), Activity_Main.sleepDataCategoryList);
        categories_list.setAdapter(listAdapter);

        listAdapter.setAddNewStatListener(new AddNewStatListener() {
            @Override
            public void onNewButtonClickListner(int position) {
                showAddSleepDataStatFragment(position);
            }

        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddCategory();
            }
        });

        return view;
    }

    private void showAddCategory() {
        DialogFragment newFragment = Fragment_AddSleepDataCategory.newInstance();
        newFragment.show(getFragmentManager(), "Add Sleep Data Category");
        ((Fragment_AddSleepDataCategory) newFragment).DismissListener(AddSleepDataStatListener);
    }

    private void showAddSleepDataStatFragment(int position) {
        DialogFragment newFragment = Fragment_AddSleepDataStat.newInstance();
        newFragment.show(getFragmentManager(), "Add Sleep Data Stat");
        ((Fragment_AddSleepDataStat) newFragment).setSleepDataCategory(Activity_Main.sleepDataCategoryList.get(position), position);
        ((Fragment_AddSleepDataStat) newFragment).DismissListener(AddSleepDataStatListener);
    }

    private DialogFragmentListener AddSleepDataStatListener = new DialogFragmentListener() {
        @Override
        public void handleDialogClose(int color) {
            listAdapter.notifyDataSetChanged();
            listAdapter.updateCategoryItems();
        }
    };
}