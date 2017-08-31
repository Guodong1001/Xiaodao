package com.bwie.xiaodao.view.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.model.bean.GoodsShowBean;

import java.util.List;

/**
 * 类描述：
 * 创建人：guodongdong
 * 创建时间：2017/8/11
 */
public class HomeClassShowAdapter extends RecyclerView.Adapter<HomeClassShowAdapter.MyHolder> implements View.OnClickListener {

    private Context mContext;
    private List<GoodsShowBean.ObjectBean> mList;
    private OnItemClickListener mOnItemClickListener = null;

    public HomeClassShowAdapter(Context context, List<GoodsShowBean.ObjectBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_goods_rv, parent, false);
        //点击跳转到详情页
        view.setOnClickListener(this);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        GoodsShowBean.ObjectBean bean = mList.get(position);

//        int width = DpUtils.dip2px(mContext, 150.0f);
//        int height = DpUtils.dip2px(mContext, 100.0f);
        Glide.with(mContext)
                .load(bean.getPicture())
//                .override(width, height)
//                .bitmapTransform(new CenterCrop(mContext),
//                        new MaskTransformation(mContext, R.drawable.rounded_rectangle))
                .into(holder.goodsImg);
//                .override(width, height)
//                .bitmapTransform(new CenterCrop(mContext),
//                        new MaskTransformation(mContext, R.drawable.rounded_rectangle))
//                .into(holder.goodsImg);
//        Glide.with(mContext)
//                .load(bean.getPicture())
//                .bitmapTransform(new RoundedCornersTransformation(mContext, 30, 0,
//                        RoundedCornersTransformation.CornerType.BOTTOM))
//                .into(holder.goodsImg);
        holder.goodsName.setText(bean.getShopName());
        holder.goodsPrice.setText("￥" + bean.getPerCapitaConsumption() + "/人");
        holder.goodsIntegral.setText("积分率" + bean.getIntegralRate() + "%");
        holder.goodsDistance.setText(bean.getAddress());
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
