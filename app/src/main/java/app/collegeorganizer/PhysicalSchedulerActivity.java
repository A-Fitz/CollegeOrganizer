package app.collegeorganizer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class PhysicalSchedulerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_scheduler);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_physical_activity);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = Fragment_AddPhysicalActivityToSchedule.newInstance();
                newFragment.show(getSupportFragmentManager(), "Add Physical Activity");
                int width = getResources().getDimensionPixelSize(R.dimen.popup_width);
                int height = getResources().getDimensionPixelSize(R.dimen.popup_height);
                getDialog().getWindow().setLayout(width, height);
            }
        });
    }

}
