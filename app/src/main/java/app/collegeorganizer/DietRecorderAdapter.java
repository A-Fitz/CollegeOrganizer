package app.collegeorganizer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import app.collegeorganizer.data.DietItem;

public class DietRecorderAdapter extends BaseAdapter {
    private static List<DietItem> searchArrayList;
    Date chosenDate = Calendar.getInstance().getTime();

    private LayoutInflater mInflater;

    public DietRecorderAdapter(Context context, List<DietItem> results) {
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
            convertView = mInflater.inflate(R.layout.diet_record_list_item, null);
            holder = new ViewHolder();
            holder.txtMealcategory = convertView.findViewById(R.id.list_item_mealcategory);
            holder.txtFoodname = convertView
                    .findViewById(R.id.list_item_foodname);
            holder.txtTime = convertView.findViewById(R.id.list_item_time);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtMealcategory.setText(searchArrayList.get(position)
                .getMealCategory().toString().substring(0, 1).toUpperCase() + searchArrayList.get(position)
                .getMealCategory().toString().substring(1).toLowerCase());

        holder.txtFoodname.setText(searchArrayList.get(position).getFoodName());

        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        holder.txtTime.setText(String.format(dateFormat.format(searchArrayList.get(position).getTime())));

        convertView.setBackgroundColor(searchArrayList.get(position).getColor());

        return convertView;
    }

    static class ViewHolder {
        TextView txtMealcategory;
        TextView txtFoodname;
        TextView txtTime;
    }
}