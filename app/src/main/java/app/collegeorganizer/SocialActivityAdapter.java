package app.collegeorganizer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import app.collegeorganizer.data.SocialEvent;

public class SocialActivityAdapter extends BaseAdapter {
    private static List<SocialEvent> searchArrayList;

    private SimpleDateFormat format_time = new SimpleDateFormat("hh:mm a");
    private SimpleDateFormat format_date = new SimpleDateFormat("MM/dd/yyy");

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

        holder.txtDate.setText(format_date.format(searchArrayList.get(position).getStartTime().getTime()));

        holder.txtTime.setText(String.valueOf(format_time.format(searchArrayList.get(position).getStartTime().getTime())));

        holder.txtDays.setText(searchArrayList.get(position).getRepeatingDays());
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