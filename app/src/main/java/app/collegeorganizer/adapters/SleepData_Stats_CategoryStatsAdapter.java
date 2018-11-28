package app.collegeorganizer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import app.collegeorganizer.R;
import app.collegeorganizer.data.Stat;

public class SleepData_Stats_CategoryStatsAdapter extends BaseAdapter {
    private static List<Stat> statList;

    private LayoutInflater mInflater;

    public SleepData_Stats_CategoryStatsAdapter(Context context, List<Stat> results) {
        statList = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return statList.size();
    }

    public Object getItem(int position) {
        return statList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.sleep_stats_list_item, null);
            holder = new ViewHolder();
            holder.list_item_stat1_name = convertView.findViewById(R.id.list_item_stat1_name);
            holder.list_item_comparison_operator = convertView.findViewById(R.id.list_item_comparison_operator);
            holder.list_item_stat2_name = convertView.findViewById(R.id.list_item_stat2_name);
            holder.list_item_value = convertView.findViewById(R.id.list_item_value);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.list_item_stat1_name.setText(statList.get(position).getData1Type());

        if (!statList.get(position).isOnlyOneData())
            holder.list_item_comparison_operator.setText(statList.get(position).getComparisonOperatorName());

        if (!statList.get(position).isOnlyOneData())
            holder.list_item_stat2_name.setText(statList.get(position).getData2Type());

        holder.list_item_value.setText(statList.get(position).toString());

        return convertView;
    }

    static class ViewHolder {
        TextView list_item_stat1_name;
        TextView list_item_comparison_operator;
        TextView list_item_stat2_name;
        TextView list_item_value;
    }
}