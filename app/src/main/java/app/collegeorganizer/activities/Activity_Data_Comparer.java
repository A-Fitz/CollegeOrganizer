package app.collegeorganizer.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import app.collegeorganizer.AddNewStatListener;
import app.collegeorganizer.DialogFragmentListener;
import app.collegeorganizer.R;
import app.collegeorganizer.adapters.Data_Comparer_CategoriesAdapter;
import app.collegeorganizer.data.DataComparerCategory;
import app.collegeorganizer.fragments.Fragment_AddDataComparerCategory;
import app.collegeorganizer.fragments.Fragment_AddDataComparerStat;
import app.collegeorganizer.fragments.Fragment_EditDataComparerCategory;

public class Activity_Data_Comparer extends AppCompatActivity {

    private ListView categories_list;
    private FloatingActionButton fab;
    private Data_Comparer_CategoriesAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_comparer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        categories_list = findViewById(R.id.categories_list);
        fab = findViewById(R.id.fab);

        listAdapter = new Data_Comparer_CategoriesAdapter(this, Activity_Main.dataComparerCategoryList);
        categories_list.setAdapter(listAdapter);

        listAdapter.setAddNewStatListener(new AddNewStatListener() {
            @Override
            public void onNewButtonClickListner(int position) {
                showAddSleepDataStatFragment(position);
            }

        });

        //TODO this doesn't work, not sure why
        categories_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Activity_Data_Comparer.this, "clicked", Toast.LENGTH_SHORT).show();

                DataComparerCategory item = (DataComparerCategory) parent.getItemAtPosition(position);
                DialogFragment newFragment = Fragment_EditDataComparerCategory.newInstance();
                newFragment.show(getSupportFragmentManager(), "Edit Data Category");
                ((Fragment_EditDataComparerCategory) newFragment).setDataComparerCategory(item);
                ((Fragment_EditDataComparerCategory) newFragment).DismissListener(RefreshListener);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddCategory();
            }
        });


    }

    private void showAddCategory() {
        DialogFragment newFragment = Fragment_AddDataComparerCategory.newInstance();
        newFragment.show(getSupportFragmentManager(), "Add Data Category");
        ((Fragment_AddDataComparerCategory) newFragment).DismissListener(RefreshListener);
    }

    private void showAddSleepDataStatFragment(int position) {
        DialogFragment newFragment = Fragment_AddDataComparerStat.newInstance();
        newFragment.show(getSupportFragmentManager(), "Add Data Stat");
        ((Fragment_AddDataComparerStat) newFragment).setDataCategory(Activity_Main.dataComparerCategoryList.get(position), position);
        ((Fragment_AddDataComparerStat) newFragment).DismissListener(RefreshListener);
    }

    private DialogFragmentListener RefreshListener = new DialogFragmentListener() {
        @Override
        public void handleDialogClose(int color) {
            listAdapter.notifyDataSetChanged();
            listAdapter.updateCategoryItems();
        }
    };


}
