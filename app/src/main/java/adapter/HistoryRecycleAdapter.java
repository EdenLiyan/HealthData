package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.liyan.healthdata.R;

import java.util.List;

import vo.TestData;

/**
 * Created by liyan on 2020/12/2.
 */

public class HistoryRecycleAdapter extends BaseAdapter {

    private Context context;
    private List<TestData> list;
    private ViewHolder viewHolder;

    public HistoryRecycleAdapter(Context context, List<TestData> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.history_recycle_view, null);
            viewHolder = new ViewHolder();
            viewHolder.t1 = convertView.findViewById(R.id.history_date);
            viewHolder.t2 = convertView.findViewById(R.id.history_sex);
            viewHolder.t3 = convertView.findViewById(R.id.history_weight);
            viewHolder.t4 = convertView.findViewById(R.id.history_fat);
            viewHolder.t5 = convertView.findViewById(R.id.history_age);
            viewHolder.t6 = convertView.findViewById(R.id.history_bmi);
            viewHolder.t7 = convertView.findViewById(R.id.history_metabolism);
            viewHolder.t8 = convertView.findViewById(R.id.history_viscera);

            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.t1.setText(list.get(position).gettWeight());


        return convertView;
    }

    class ViewHolder {
        TextView t1;
        TextView t2;
        TextView t3;
        TextView t4;
        TextView t5;
        TextView t6;
        TextView t7;
        TextView t8;
    }
}
