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
import app.collegeorganizer.data.DataComparerCategory;

public class Data_Comparer_CategoriesAdapter extends BaseAdapter {
    private static List<DataComparerCategory> dataComparerCategoryList;

    private LayoutInflater mInflater;
    private Context context;
    private AddNewStatListener addNewStatListener;
    private Data_Comparer_StatsAdapter items_adapter;

    public Data_Comparer_CategoriesAdapter(Context context, List<DataComparerCategory> results) {
        dataComparerCategoryList = results;
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public int getCount() {
        return dataComparerCategoryList.size();
    }

    public Object getItem(int position) {
        return dataComparerCategoryList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.data_comparer_category_item, null);
            holder = new ViewHolder();
            holder.category_name = convertView.findViewById(R.id.category_name);
            holder.listview_category_items = convertView
                    .findViewById(R.id.listview_category_items);
            holder.button_add_stat = convertView.findViewById(R.id.button_add_stat);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.category_name.setText(dataComparerCategoryList.get(position).getName());
        items_adapter = new Data_Comparer_StatsAdapter(parent.getContext(), dataComparerCategoryList.get(position).getStatList());
        holder.listview_category_items.setAdapter(items_adapter);

        holder.button_add_stat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (addNewStatListener != null) {
                    addNewStatListener.onNewButtonClickListner(position);
                }
            }
        });

        convertView.setBackgroundColor(dataComparerCategoryList.get(position).getColor());

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