package app.collegeorganizer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import app.collegeorganizer.AddNewStatListener;
import app.collegeorganizer.ExpandingListView;
import app.collegeorganizer.R;
import app.collegeorganizer.data.SleepDataCategory;

public class SleepData_Stats_CategoriesAdapter extends BaseAdapter {
    private static List<SleepDataCategory> sleepDataCategoryList;

    private LayoutInflater mInflater;
    private Context context;
    private AddNewStatListener addNewStatListener;
    private SleepData_Stats_CategoryStatsAdapter items_adapter;

    public SleepData_Stats_CategoriesAdapter(Context context, List<SleepDataCategory> results) {
        sleepDataCategoryList = results;
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public int getCount() {
        return sleepDataCategoryList.size();
    }

    public Object getItem(int position) {
        return sleepDataCategoryList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.sleep_stats_category_item, null);
            holder = new ViewHolder();
            holder.category_name = convertView.findViewById(R.id.category_name);
            holder.listview_category_items = convertView
                    .findViewById(R.id.listview_category_items);
            holder.button_add_stat = convertView.findViewById(R.id.button_add_stat);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.category_name.setText(sleepDataCategoryList.get(position).getName());
        items_adapter = new SleepData_Stats_CategoryStatsAdapter(parent.getContext(), sleepDataCategoryList.get(position).getStatList());
        holder.listview_category_items.setAdapter(items_adapter);

        holder.button_add_stat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (addNewStatListener != null) {
                    addNewStatListener.onNewButtonClickListner(position);
                }
            }
        });

        convertView.setBackgroundColor(sleepDataCategoryList.get(position).getColor());

        return convertView;
    }

    public void setAddNewStatListener(AddNewStatListener addNewStatListener) {
        this.addNewStatListener = addNewStatListener;
    }

    public void updateCategoryItems() {
        items_adapter.notifyDataSetChanged();
    }

    static class ViewHolder {
        TextView category_name;
        ExpandingListView listview_category_items;
        ImageButton button_add_stat;
    }
}