package app.collegeorganizer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import app.collegeorganizer.ExpandingListView;
import app.collegeorganizer.R;
import app.collegeorganizer.data.SleepDataCategory;

public class SleepData_Stats_CategoriesAdapter extends BaseAdapter {
    private static List<SleepDataCategory> sleepDataCategoryList;

    private LayoutInflater mInflater;

    public SleepData_Stats_CategoriesAdapter(Context context, List<SleepDataCategory> results) {
        sleepDataCategoryList = results;
        mInflater = LayoutInflater.from(context);
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

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.sleep_stats_category_item, null);
            holder = new ViewHolder();
            holder.category_name = convertView.findViewById(R.id.category_name);
            holder.listview_category_items = convertView
                    .findViewById(R.id.listview_category_items);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.category_name.setText(sleepDataCategoryList.get(position).getName());
        holder.listview_category_items.setAdapter(new SleepData_Stats_CategoryStatsAdapter(parent.getContext(), sleepDataCategoryList.get(position).getStatList()));

        convertView.setBackgroundColor(sleepDataCategoryList.get(position).getColor());

        return convertView;
    }

    static class ViewHolder {
        TextView category_name;
        ExpandingListView listview_category_items;
    }
}