package com.bwie.xiaodao.view.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.Moldle.NearShops;

import java.util.List;

/**
 * 类描述：
 * 创建人：guodongdong
 * 创建时间：2017/8/11
 */
public class HomeClassShowAdapter extends RecyclerView.Adapter<HomeClassShowAdapter.MyHolder> implements View.OnClickListener {

    private Context mContext;
    private List<NearShops.ObjectBean.ListBean> mList;
    private OnItemClickListener mOnItemClickListener = null;
    public HomeClassShowAdapter(Context context, List<NearShops.ObjectBean.ListBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_goods_rv, parent, false);
        view.setOnClickListener(this);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

//        Glide.with(mContext)
//                .load(mList.get(position).getPicture())
//                .into(holder.goodsImg);

        Glide.with(mContext).load(mList.get(position).getPicture())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.goodsImg);

        holder.goodsName.setText(mList.get(position).getShopName());
        holder.goodsPrice.setText("￥" + mList.get(position).getPerCapitaConsumption() + "/人");

        SpannableString spannableString = new SpannableString("积分率" + mList.get(position).getIntegralRate() + "%");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#ff0000"));
        spannableString.setSpan(colorSpan, 3, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        holder.goodsIntegral.setText(spannableString);
        holder.goodsDistance.setText(mList.get(position).getDistance());
        holder.itemView.setTag(position);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    class MyHolder extends RecyclerView.ViewHolder {
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

    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

}
