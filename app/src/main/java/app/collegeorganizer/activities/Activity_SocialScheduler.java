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
import app.collegeorganizer.SocialActivityAdapter;
import app.collegeorganizer.data.SocialEvent;
import app.collegeorganizer.fragments.Fragment_AddSocialActivity;
import app.collegeorganizer.fragments.Fragment_EditSocialActivity;


public class Activity_SocialScheduler extends AppCompatActivity implements DialogInterface.OnDismissListener {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_scheduler);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Social Scheduler");

        list = findViewById(R.id.social_schedule);

        FloatingActionButton fab = findViewById(R.id.add_social_activity);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = Fragment_AddSocialActivity.newInstance();
                newFragment.show(getSupportFragmentManager(), "Add Social Activity");

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SocialEvent item = (SocialEvent) parent.getItemAtPosition(position);
                DialogFragment newFragment = Fragment_EditSocialActivity.newInstance();
                newFragment.show(getSupportFragmentManager(), "Edit Social Activity");
                ((Fragment_EditSocialActivity) newFragment).setItem(item);
            }
        });

        refreshList();
    }

    @Override
    public void onDismiss(final DialogInterface dialog) {
        refreshList();
    }

    private void refreshList() {
        list.setAdapter(null);
        list.setAdapter(new SocialActivityAdapter(this, Activity_Main.socialEventList));
    }

}
