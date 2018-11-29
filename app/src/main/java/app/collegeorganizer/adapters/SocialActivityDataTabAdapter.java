package app.collegeorganizer.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import app.collegeorganizer.fragments.Fragment_SocialActivityData_Charts;
import app.collegeorganizer.fragments.Fragment_SocialActivityData_Stats;

public class SocialActivityDataTabAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public SocialActivityDataTabAdapter(FragmentManager fm, int NoofTabs) {
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
                Fragment_SocialActivityData_Stats stats = new Fragment_SocialActivityData_Stats();
                return stats;
            case 1:
                Fragment_SocialActivityData_Charts charts = new Fragment_SocialActivityData_Charts();
                return charts;
            default:
                return null;
        }
    }
}