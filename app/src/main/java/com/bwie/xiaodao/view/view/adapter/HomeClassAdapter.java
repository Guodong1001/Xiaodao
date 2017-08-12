package com.bwie.xiaodao.view.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.xiaodao.R;

/**
 * 类描述：
 * 创建人：guodongdong
 * 创建时间：2017/8/12
 */
public class HomeClassAdapter extends RecyclerView.Adapter<HomeClassAdapter.MyHolder>{

    private Context mContext;


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView goodsImg;
        TextView goodsName;
        TextView goodsPrice;
        TextView goodsIntegral;
        TextView goodsDistance;
        public MyHolder(View itemView) {
            super(itemView);
            goodsImg = (ImageView) itemView.findViewById(R.id.item_goods_img);
            goodsName = (TextView) itemView.findViewById(R.id.item_goods_name);
            goodsPrice = (TextView) itemView.findViewById(R.id.item_goods_price);
            goodsIntegral = (TextView) itemView.findViewById(R.id.item_goods_integral);
            goodsDistance = (TextView) itemView.findViewById(R.id.item_goods_distance);
        }
    }
}
