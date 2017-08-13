package com.bwie.xiaodao.view.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.xiaodao.R;

import java.util.List;

/**
 * Created by 雨夜 on 2017/8/10.
 */

public class AdapterLvFanli extends BaseAdapter {
    private Context mContext;
    private List<String> mList;
    private int itemCount = 2;

    public AdapterLvFanli(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        if (mList.size() > 2) {
            return itemCount;
        }else {
            return mList.size();
        }
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder = null;
        if (convertView==null){
            convertView = View.inflate(mContext,R.layout.item_lv_fanli,null);
            holder = new viewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.fanli_lv_item_txt_level);
            convertView.setTag(holder);
        }else {
            holder = (viewHolder) convertView.getTag();
        }
        holder.text.setText(mList.get(position));
        return convertView;
    }

    class viewHolder {
        TextView text;
    }
    public void addItemNum(int number)
    {
        itemCount = number;
    }
}

