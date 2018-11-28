package app.collegeorganizer.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.collegeorganizer.R;



public class Fragment_ClassSchedule extends Fragment {
    String classes[] = new String [] {"Class 1", "Class 2", "Class 3"};
    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_schedule);

        //android.widget.ListView listView = (android.widget.ListView) android.findViewById(R.id._class_schedule);
    }
}
