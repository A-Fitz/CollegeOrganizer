package app.collegeorganizer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import app.collegeorganizer.data.SocialEvent;

public class SocialActivityAdapter extends BaseAdapter {
    private static List<SocialEvent> searchArrayList;

    private LayoutInflater mInflater;

    public SocialActivityAdapter(Context context, List<SocialEvent> results) {
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
            convertView = mInflater.inflate(R.layout.social_activity_list_item, null);
            holder = new ViewHolder();
            holder.txtName = convertView.findViewById(R.id.list_item_name);
            holder.txtDate = convertView
                    .findViewById(R.id.list_item_date);
            holder.txtTime = convertView.findViewById(R.id.list_item_time);
            holder.txtDays = convertView.findViewById(R.id.list_item_days);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtName.setText(searchArrayList.get(position).getName());

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        holder.txtDate.setText(String.format(dateFormat.format(searchArrayList.get(position).getStartDate())));

        dateFormat = new SimpleDateFormat("HH:mm");
        holder.txtTime.setText(String.format(dateFormat.format(searchArrayList.get(position).getTime())));

        holder.txtDays.setText(String.format(searchArrayList.get(position).getRepeatingDays()));
        convertView.setBackgroundColor(searchArrayList.get(position).getColor());

        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView txtDate;
        TextView txtTime;
        TextView txtDays;
    }
}