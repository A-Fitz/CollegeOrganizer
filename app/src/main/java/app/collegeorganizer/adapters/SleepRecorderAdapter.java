package app.collegeorganizer.adapters;

import android.content.Context;
import android.support.text.emoji.EmojiCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import app.collegeorganizer.R;
import app.collegeorganizer.data.Emojis;
import app.collegeorganizer.data.SleepItem;
import app.collegeorganizer.data.SleepQualityTypes;

public class SleepRecorderAdapter extends BaseAdapter {
    private static List<SleepItem> searchArrayList;

    private SimpleDateFormat format_time = new SimpleDateFormat("hh:mm a");

    private LayoutInflater mInflater;

    public SleepRecorderAdapter(Context context, List<SleepItem> results) {
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
            convertView = mInflater.inflate(R.layout.sleep_record_list_item, null);
            holder = new ViewHolder();
            holder.txtTimeType = convertView.findViewById(R.id.list_item_sleep_time_type);
            holder.txtStartTime = convertView
                    .findViewById(R.id.list_item_start_time);
            holder.txtEndTime = convertView.findViewById(R.id.list_item_end_time);
            holder.emojiTextView = convertView.findViewById(R.id.emoji_text_view);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtTimeType.setText(searchArrayList.get(position)
                .getSleepTimeType().toString().substring(0, 1).toUpperCase() + searchArrayList.get(position)
                .getSleepTimeType().toString().substring(1).toLowerCase());

        holder.txtStartTime.setText(String.valueOf(format_time.format(searchArrayList.get(position).getStart_time().getTime())));

        holder.txtEndTime.setText(String.valueOf(format_time.format(searchArrayList.get(position).getEnd_time().getTime())));

        String tempEmojiString = "";

        final EmojiCompat compat = EmojiCompat.get();

        for (SleepQualityTypes sq : searchArrayList.get(position).getSleepQualityTypesList()) {
            switch (sq) {
                case NOT_WITHIN_30_MINUTES:
                    tempEmojiString += compat.process(Emojis.NOT_WITHIN_30_MINUTES);
                    break;
                case WAKE_UP_IN_NIGHT:
                    tempEmojiString += compat.process(Emojis.WAKE_UP_IN_NIGHT);
                    break;
                case BATHROOM:
                    tempEmojiString += compat.process(Emojis.BATHROOM);
                    break;
                case BREATHING:
                    tempEmojiString += compat.process(Emojis.BREATHING);
                    break;
                case COUGH_SNORE:
                    tempEmojiString += compat.process(Emojis.COUGH_SNORE);
                    break;
                case BAD_DREAMS:
                    tempEmojiString += compat.process(Emojis.BAD_DREAMS);
                    break;
                case COLD:
                    tempEmojiString += compat.process(Emojis.COLD);
                    break;
                case HOT:
                    tempEmojiString += compat.process(Emojis.HOT);
                    break;
                case PAIN:
                    tempEmojiString += compat.process(Emojis.PAIN);
                    break;
            }

            holder.emojiTextView.setText(tempEmojiString);
        }

        convertView.setBackgroundColor(searchArrayList.get(position).getColor());

        return convertView;
    }

    static class ViewHolder {
        TextView txtTimeType;
        TextView txtStartTime;
        TextView txtEndTime;
        TextView emojiTextView;
    }
}