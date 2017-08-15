package com.bwie.xiaodao.view.Moldle;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.bean.All_grid;

import java.util.List;

/**
 * 类描述：
 * 创建人：xiaoqian
 * 创建时间：2017/8/15 14:28
 */


public class GridBase extends BaseAdapter {
    private Context context;
    private List<All_grid> arrlist;
    private View view;
    private ViewHolder holder;

    public GridBase(Context context, List<All_grid> arrlist) {
        this.context = context;
        this.arrlist = arrlist;
    }

    @Override
    public int getCount() {
        return arrlist.size();
    }

    @Override
    public Object getItem(int position) {
        return arrlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            view = View.inflate(context, R.layout.all_base,null);
            holder = new ViewHolder();
            holder.textView= (TextView) view.findViewById(R.id.allbase_text1);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.textView.setText(arrlist.get(position).getFood1());
        return view;
    }
    class ViewHolder{
        TextView textView;
    }
}
