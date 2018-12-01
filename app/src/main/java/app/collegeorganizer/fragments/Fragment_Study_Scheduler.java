package app.collegeorganizer.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import app.collegeorganizer.DialogFragmentListener;
import app.collegeorganizer.R;
import app.collegeorganizer.activities.Activity_Main;
import app.collegeorganizer.adapters.StudyScheduleAdapter;
import app.collegeorganizer.data.StudyItem;

public class Fragment_Study_Scheduler extends Fragment implements DialogInterface.OnDismissListener {

    private ListView list;
    private View view;
    private StudyScheduleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_study_scheduler, viewGroup, false);


        list = view.findViewById(R.id.study_schedule);
        adapter = new StudyScheduleAdapter(getContext(), Activity_Main.studyScheduleList);
        list.setAdapter(adapter);

        FloatingActionButton fab = view.findViewById(R.id.add_study_schedule);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = Fragment_AddStudySchedule.newInstance();
                ((Fragment_AddStudySchedule) newFragment).DismissListener(RefreshListener);
                newFragment.show(getFragmentManager(), "Add Study Time");

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StudyItem item = (StudyItem) parent.getItemAtPosition(position);
                DialogFragment newFragment = Fragment_EditStudySchedule.newInstance();
                ((Fragment_EditStudySchedule) newFragment).DismissListener(RefreshListener);
                newFragment.show(getFragmentManager(), "Edit Study Time");
                ((Fragment_EditStudySchedule) newFragment).setItem(item);

            }
        });

        refreshList();

        return view;
    }

    private void refreshList() {
        list.setAdapter(null);
        list.setAdapter(new StudyScheduleAdapter(getContext(), Activity_Main.studyScheduleList));
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        refreshList();
    }

    private DialogFragmentListener RefreshListener = new DialogFragmentListener() {
        @Override
        public void handleDialogClose(int color) {
            list.setAdapter(new StudyScheduleAdapter(getContext(), Activity_Main.studyScheduleList));
            adapter.notifyDataSetChanged();
        }
    };
}