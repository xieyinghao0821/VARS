package bupt.xyh.vars.bupt.xyh.vars.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import bupt.xyh.vars.R;
import bupt.xyh.vars.bupt.xyh.vars.model.WiFi;

/**
 * Created by Administrator on 2017/7/25.
 */

public class WiFiAdapter extends ArrayAdapter<WiFi> {
    private int resourceId;

    /**
     * @param context，上下文
     * @param textViewResourceId，ListView子项布局的id
     * @param objects，数据
     */
    public WiFiAdapter(Context context, int textViewResourceId, List<WiFi> objects) {
        super(context, textViewResourceId, objects);
        this.resourceId = textViewResourceId;
    }

    /**
     * 该方法在每个子项被滚动到屏幕内的时候会被调用
     *
     * @param position
     * @param convertView，将之前加载好的布局进行缓存，以便之后可以进行重用
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        WiFi wifi = getItem(position);//得到当前项的WiFi实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);//为子项加载传入的布局
            viewHolder = new ViewHolder();
            viewHolder.wifi_desc = (TextView) view.findViewById(R.id.wifi_desc);
            view.setTag(viewHolder);//将ViewHolder存储在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
        }
        viewHolder.wifi_desc.setText(wifi.toString());
        return view;
    }

    class ViewHolder {
        TextView wifi_desc;
    }
}
