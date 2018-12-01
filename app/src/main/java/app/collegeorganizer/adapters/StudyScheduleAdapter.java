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
import app.collegeorganizer.data.StudyItem;

public class StudyScheduleAdapter extends BaseAdapter {
    private static List<StudyItem> searchArrayList;

    private SimpleDateFormat format_time = new SimpleDateFormat("hh:mm a");

    private LayoutInflater mInflater;

    public StudyScheduleAdapter(Context context, List<StudyItem> results) {
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
            convertView = mInflater.inflate(R.layout.study_schedule_list_item, null);
            holder = new ViewHolder();
            holder.txtName = convertView.findViewById(R.id.list_item_name);
            holder.txtTime = convertView.findViewById(R.id.list_item_time);
            holder.txtDays = convertView.findViewById(R.id.list_item_days);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtName.setText(searchArrayList.get(position).getName());


        holder.txtTime.setText(String.valueOf(format_time.format(searchArrayList.get(position).getStartTime().getTime())));

        holder.txtDays.setText(searchArrayList.get(position).getRepeatingDays());
        convertView.setBackgroundColor(searchArrayList.get(position).getColor());

        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView txtTime;
        TextView txtDays;
    }
}