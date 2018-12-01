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
import app.collegeorganizer.adapters.ClassScheduleAdapter;
import app.collegeorganizer.data.ClassItem;

public class Fragment_Class_Scheduler extends Fragment implements DialogInterface.OnDismissListener {

    private ListView list;
    private View view;
    private ClassScheduleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_class_scheduler, viewGroup, false);


        list = view.findViewById(R.id.class_schedule);
        adapter = new ClassScheduleAdapter(getContext(), Activity_Main.classScheduleList);
        list.setAdapter(adapter);

        FloatingActionButton fab = view.findViewById(R.id.add_class_schedule);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = Fragment_AddClassSchedule.newInstance();
                ((Fragment_AddClassSchedule) newFragment).DismissListener(RefreshListener);
                newFragment.show(getFragmentManager(), "Add Class");

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClassItem item = (ClassItem) parent.getItemAtPosition(position);
                DialogFragment newFragment = Fragment_EditClassSchedule.newInstance();
                ((Fragment_EditClassSchedule) newFragment).DismissListener(RefreshListener);
                newFragment.show(getFragmentManager(), "Edit Class");
                ((Fragment_EditClassSchedule) newFragment).setItem(item);

            }
        });

        refreshList();

        return view;
    }

    private void refreshList() {
        list.setAdapter(null);
        list.setAdapter(new ClassScheduleAdapter(getContext(), Activity_Main.classScheduleList));
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        refreshList();
    }

    private DialogFragmentListener RefreshListener = new DialogFragmentListener() {
        @Override
        public void handleDialogClose(int color) {
            list.setAdapter(new ClassScheduleAdapter(getContext(), Activity_Main.classScheduleList));
            adapter.notifyDataSetChanged();
        }
    };
}