package app.collegeorganizer;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;


public class PhysicalSchedulerActivity extends AppCompatActivity implements DialogInterface.OnDismissListener {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_scheduler);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = (ListView) findViewById(R.id.physical_activity_schedule);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_physical_activity);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = Fragment_AddPhysicalActivityToSchedule.newInstance();
                newFragment.show(getSupportFragmentManager(), "Add Physical Activity");

            }
        });


    }

    @Override
    public void onDismiss(final DialogInterface dialog) {
        list.setAdapter(null);
        final ListView lv = (ListView) findViewById(R.id.physical_activity_schedule);
        lv.setAdapter(new PhysicalActivityAdapter(this, MainActivity.physicalActivityList));
    }

}
