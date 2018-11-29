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

public class DataStatListAdapter extends BaseAdapter {
    private static List<Stat> statList;

    private LayoutInflater mInflater;

    public DataStatListAdapter(Context context, List<Stat> results) {
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
            convertView = mInflater.inflate(R.layout.stats_item, null);
            holder = new ViewHolder();
            holder.txtStatName = convertView.findViewById(R.id.stat_name);
            holder.txtStatValue = convertView.findViewById(R.id.stat_value);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtStatName.setText(statList.get(position).getData1Type());

        holder.txtStatValue.setText(statList.get(position).toString());

        return convertView;
    }

    static class ViewHolder {
        TextView txtStatName;
        TextView txtStatValue;
    }
}