package app.collegeorganizer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import app.collegeorganizer.data.PhysicalActivity;

public class PhysicalActivityAdapter extends BaseAdapter {
    private static List<PhysicalActivity> searchArrayList;

    private LayoutInflater mInflater;

    public PhysicalActivityAdapter(Context context, List<PhysicalActivity> results) {
        searchArrayList = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return searchArrayList.size();
    }

    public Object getItem(int position) {
        return searchArrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.physical_activity_list_item, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.list_item_name);
            holder.txtIntensity = (TextView) convertView
                    .findViewById(R.id.list_item_intensity);
            holder.txtTime = (TextView) convertView.findViewById(R.id.list_item_time);
            holder.txtDays = (TextView) convertView.findViewById(R.id.list_item_days);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtName.setText(searchArrayList.get(position).getName());
        holder.txtIntensity.setText(searchArrayList.get(position)
                .getIntensity().toString().toLowerCase());
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        holder.txtTime.setText(String.format(dateFormat.format(searchArrayList.get(position).getTime())));
        holder.txtDays.setText(String.format(searchArrayList.get(position).getRepeatingDays()));
        convertView.setBackgroundColor(searchArrayList.get(position).getColor());

        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView txtIntensity;
        TextView txtTime;
        TextView txtDays;
    }
}