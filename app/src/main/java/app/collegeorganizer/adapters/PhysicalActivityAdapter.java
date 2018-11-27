package app.collegeorganizer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import app.collegeorganizer.R;
import app.collegeorganizer.data.PhysicalActivity;

public class PhysicalActivityAdapter extends BaseAdapter {
    private static List<PhysicalActivity> searchArrayList;

    private SimpleDateFormat format_time = new SimpleDateFormat("hh:mm a");
    private SimpleDateFormat format_date = new SimpleDateFormat("MM/dd/yyy");

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
            holder.txtName = convertView.findViewById(R.id.list_item_name);
            holder.txtIntensity = convertView
                    .findViewById(R.id.list_item_intensity);
            holder.txtTime = convertView.findViewById(R.id.list_item_time);
            holder.txtDays = convertView.findViewById(R.id.list_item_days);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtName.setText(searchArrayList.get(position).getName());
        holder.txtIntensity.setText(searchArrayList.get(position)
                .getIntensity().toString().substring(0, 1).toUpperCase() + searchArrayList.get(position)
                .getIntensity().toString().substring(1).toLowerCase());

        holder.txtTime.setText(String.valueOf(format_time.format(searchArrayList.get(position).getStartTime().getTime())));
        holder.txtDays.setText(searchArrayList.get(position).getRepeatingDays());
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