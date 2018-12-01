package app.collegeorganizer.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import app.collegeorganizer.fragments.Fragment_Class_Scheduler;
import app.collegeorganizer.fragments.Fragment_Grade_Recorder;
import app.collegeorganizer.fragments.Fragment_Study_Scheduler;

public class AcademicSchedulerRecorderTabAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public AcademicSchedulerRecorderTabAdapter(FragmentManager fm, int NoofTabs) {
        super(fm);
        this.mNumOfTabs = NoofTabs;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Fragment_Class_Scheduler class_scheduler = new Fragment_Class_Scheduler();
                return class_scheduler;
            case 1:
                Fragment_Study_Scheduler study_scheduler = new Fragment_Study_Scheduler();
                return study_scheduler;
            case 2:
                Fragment_Grade_Recorder grade_recorder = new Fragment_Grade_Recorder();
                return grade_recorder;
            default:
                return null;
        }
    }
}