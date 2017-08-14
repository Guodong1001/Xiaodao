package com.bwie.xiaodao.view.Moldle;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.xiaodao.R;

import java.util.List;

/**
 * 类描述：
 * 创建人：xiaoqian
 * 创建时间：2017/8/14 9:04
 */


public class Foodbase extends BaseAdapter {
    private Context context;
    private List<Food> foodlist;
    private View view;
    private ViewHolder holder;
    private static final int has_discount = 0;
    private static final int No_has_discount = 1;
    public Foodbase(Context context, List<Food> foodlist) {
        this.context = context;
        this.foodlist = foodlist;
    }

    @Override
    public int getCount() {
        return foodlist.size();
    }

    @Override
    public Object getItem(int position) {
        return foodlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        boolean ishas = foodlist.get(position).isDiscount();
        if (ishas) {
            return has_discount;
        }else {
            return No_has_discount;
        }
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        if (convertView == null) {
            holder = new ViewHolder();
            switch (type){
                case has_discount:
                    view = View.inflate(context, R.layout.meishi_basees, null);
                    holder.imageView = (ImageView) view.findViewById(R.id.meishi_image);
                    holder.textView1 = (TextView) view.findViewById(R.id.meishi_tex1);
                    holder.textView2 = (TextView) view.findViewById(R.id.meishi_text2);
                    holder.textView4 = (TextView) view.findViewById(R.id.meishi_text4);
                    holder.textView5 = (TextView) view.findViewById(R.id.meishi_text5);
                    holder.youhui = (TextView) view.findViewById(R.id.youhui);
                    break;
                case No_has_discount:
                    view = View.inflate(context, R.layout.meishi_nobase, null);
                    holder.imageView = (ImageView) view.findViewById(R.id.meishi_image);
                    holder.textView1 = (TextView) view.findViewById(R.id.meishi_tex1);
                    holder.textView2 = (TextView) view.findViewById(R.id.meishi_text2);
                    holder.textView4 = (TextView) view.findViewById(R.id.meishi_text4);
                    holder.textView5 = (TextView) view.findViewById(R.id.meishi_text5);
                    break;
            }
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        switch (type){
            case has_discount:
                holder.imageView.setImageResource(foodlist.get(position).getImage());
                holder.textView1.setText(foodlist.get(position).getName());
                holder.textView2.setText(foodlist.get(position).getMoney()+"");
                holder.textView4.setText(foodlist.get(position).getIntegralr());
                holder.textView5.setText(foodlist.get(position).getDistance());
                holder.youhui.setText(foodlist.get(position).getYouhui());
                break;
            case No_has_discount:
                holder.imageView.setImageResource(foodlist.get(position).getImage());
                holder.textView1.setText(foodlist.get(position).getName());
                holder.textView2.setText(foodlist.get(position).getMoney()+"");
                holder.textView4.setText(foodlist.get(position).getIntegralr());
                holder.textView5.setText(foodlist.get(position).getDistance());
                break;
        }
        return view;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView1, textView2, textView4, textView5, youhui;
    }
}
