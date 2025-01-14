package app.collegeorganizer.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import app.collegeorganizer.R;
import app.collegeorganizer.adapters.PhysicalActivityAdapter;
import app.collegeorganizer.data.PhysicalActivity;
import app.collegeorganizer.fragments.Fragment_AddPhysicalActivity;
import app.collegeorganizer.fragments.Fragment_EditPhysicalActivity;


public class Activity_PhysicalActivityScheduler extends AppCompatActivity implements DialogInterface.OnDismissListener {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_scheduler);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Physical Activity Scheduler");

        list = findViewById(R.id.physical_activity_schedule);

        FloatingActionButton fab = findViewById(R.id.add_physical_activity);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = Fragment_AddPhysicalActivity.newInstance();
                newFragment.show(getSupportFragmentManager(), "Add Physical Activity");

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PhysicalActivity item = (PhysicalActivity) parent.getItemAtPosition(position);
                DialogFragment newFragment = Fragment_EditPhysicalActivity.newInstance();
                newFragment.show(getSupportFragmentManager(), "Edit Physical Activity");
                ((Fragment_EditPhysicalActivity) newFragment).setItem(item);
            }
        });

        refreshList();
    }

    @Override
    public void onDismiss(final DialogInterface dialog) {
        refreshList();
    }

    private void refreshList()
    {
        list.setAdapter(null);
        list.setAdapter(new PhysicalActivityAdapter(this, Activity_Main.physicalScheduleList));
    }

}
