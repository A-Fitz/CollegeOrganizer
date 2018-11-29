package app.collegeorganizer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import app.collegeorganizer.AddNewStatListener;
import app.collegeorganizer.R;
import app.collegeorganizer.data.Stat;
import app.collegeorganizer.enums.PhysicalActivityStatTypes;
import app.collegeorganizer.enums.SleepStatTypes;
import app.collegeorganizer.enums.SocialActivityStatTypes;
import app.collegeorganizer.enums.StatEnum;
import app.collegeorganizer.stats.EvaluateStats;

public class Data_Comparer_StatsAdapter extends BaseAdapter {
    private static List<Stat> statList;

    private LayoutInflater mInflater;
    private AddNewStatListener addNewStatListener;

    public Data_Comparer_StatsAdapter(Context context, List<Stat> results) {
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
            convertView = mInflater.inflate(R.layout.data_comparer_stat_item, null);
            holder = new ViewHolder();
            holder.list_item_stat1_name = convertView.findViewById(R.id.list_item_stat1_name);
            holder.list_item_comparison_operator = convertView.findViewById(R.id.list_item_comparison_operator);
            holder.list_item_stat2_name = convertView.findViewById(R.id.list_item_stat2_name);
            holder.list_item_value = convertView.findViewById(R.id.list_item_value);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        updateStatList();

        holder.list_item_stat1_name.setText(statList.get(position).getData1Type());

        if (!statList.get(position).isOnlyOneData())
            holder.list_item_comparison_operator.setText(statList.get(position).getComparisonOperatorName());

        if (!statList.get(position).isOnlyOneData())
            holder.list_item_stat2_name.setText(statList.get(position).getData2Type());

        holder.list_item_value.setText(statList.get(position).toString());

        return convertView;
    }

    public void setAddNewStatListener(AddNewStatListener addNewStatListener) {
        this.addNewStatListener = addNewStatListener;
    }

    static class ViewHolder {
        TextView list_item_stat1_name;
        TextView list_item_comparison_operator;
        TextView list_item_stat2_name;
        TextView list_item_value;
    }

    private void updateStatList() {
        for (Stat s : statList) {
            int index = statList.indexOf(s);
            EvaluateStats evaluateStats = new EvaluateStats();
            if (s.isOnlyOneData()) {
                Enum data1type = s.enum_getData1Type();
                StatEnum statEnum1 = findType(data1type);
                float value1 = evaluateStats.getData(statEnum1, data1type);
                s.setData1(value1);

                statList.set(index, s);
            } else {
                Enum data1type = s.enum_getData1Type();
                StatEnum statEnum1 = findType(data1type);
                float value1 = evaluateStats.getData(statEnum1, data1type);
                s.setData1(value1);

                Enum data2type = s.enum_getData2Type();
                StatEnum statEnum2 = findType(data2type);
                float value2 = evaluateStats.getData(statEnum2, data2type);
                s.setData2(value2);

                statList.set(index, s);
            }
        }
    }

    private StatEnum findType(Enum find) {
        for (Enum e : SleepStatTypes.values())
            if (find == e)
                return StatEnum.SLEEP;

        for (Enum e : PhysicalActivityStatTypes.values())
            if (find == e)
                return StatEnum.PHYSICAL_ACTIVITY;

        for (Enum e : SocialActivityStatTypes.values())
            if (find == e)
                return StatEnum.SOCIAL_ACTIVITY;

        return null;
    }
}