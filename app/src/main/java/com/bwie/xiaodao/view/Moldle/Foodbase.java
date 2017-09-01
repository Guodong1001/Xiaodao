package com.bwie.xiaodao.view.Moldle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.view.activity.rebate.AdreessMap;

import java.util.List;

/**
 * 类描述：
 * 创建人：xiaoqian
 * 创建时间：2017/8/14 9:04
 */


public class Foodbase extends BaseAdapter {
    private Context context;
    private List<Food> arrlist;
    private View view;
    private ViewHolder holder;
    public Foodbase(Context context, List<Food> arrlist) {
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
        if (convertView == null) {
            holder = new ViewHolder();
                    view = View.inflate(context, R.layout.meishi_basees, null);
                    holder.imageView = (ImageView) view.findViewById(R.id.meishi_image);
                    holder.textView1 = (TextView) view.findViewById(R.id.meishi_tex1);
                    holder.textView2 = (TextView) view.findViewById(R.id.meishi_text2);
                    holder.textView4 = (TextView) view.findViewById(R.id.meishi_text4);
                    holder.textView5 = (TextView) view.findViewById(R.id.meishi_text5);
                    view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
                Glide.with(context).load(arrlist.get(position).getObject().getPicture()).into(holder.imageView);
                holder.textView1.setText(arrlist.get(position).getObject().getShopName());
                holder.textView2.setText(arrlist.get(position).getObject().getIntegralRate()+"");
                holder.textView4.setText(arrlist.get(position).getObject().getPerCapitaConsumption()+"");
                holder.textView5.setText(arrlist.get(position).getObject().getAddress());
                holder.textView5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = holder.textView1.getText().toString();
                        String address = holder.textView4.getText().toString();
                        Intent intent=new Intent(context, AdreessMap.class);
                        Bundle bunder=new Bundle();
                        bunder.putString("name",name);
                        bunder.putString("adress",address);
                        intent.putExtras(bunder);
                        context.startActivity(intent);
                    }
                });
        return view;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView1, textView2, textView4, textView5;

    }
}
