package app.collegeorganizer.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import app.collegeorganizer.fragments.Fragment_SleepData_Charts;
import app.collegeorganizer.fragments.Fragment_SleepData_Stats;

public class SleepDataTabAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public SleepDataTabAdapter(FragmentManager fm, int NoofTabs) {
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
                Fragment_SleepData_Stats stats = new Fragment_SleepData_Stats();
                return stats;
            case 1:
                Fragment_SleepData_Charts charts = new Fragment_SleepData_Charts();
                return charts;
            default:
                return null;
        }
    }
}