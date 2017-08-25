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
import com.bwie.xiaodao.view.model.bean.HomeNearBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类描述：
 * 创建人：guodongdong
 * 创建时间：2017/8/15
 */
public class HomeFujinRvAdapter extends RecyclerView.Adapter<HomeFujinRvAdapter.MyHolder> implements View.OnClickListener {

    private Context mContext;
    private List<HomeNearBean> mList;
    private OnItemClickListener mOnItemClickListener = null;

    public HomeFujinRvAdapter(Context context, List<HomeNearBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_fujin,parent,false);
        view.setOnClickListener(this);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
//        int width = DpUtils.dip2px(mContext, 150.0f);
//        int height = DpUtils.dip2px(mContext, 100.0f);
//        Glide.with(mContext)
//                .load(mList.get(position).getImg())
//                .override(width, height)
//                .bitmapTransform(new CenterCrop(mContext),
//                        new MaskTransformation(mContext, R.drawable.rounded_rectangle))
//                .into(holder.mImageView);
        Glide.with(mContext)
                .load(mList.get(position).getImg())
//                .bitmapTransform(new RoundedCornersTransformation(mContext, 30, 0,
//                        RoundedCornersTransformation.CornerType.BOTTOM))
                .into(holder.mImageView);
        holder.title.setText(mList.get(position).getTitle());
        holder.address.setText(mList.get(position).getAddress());
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
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    class MyHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.item_home_nearby_winport_imageView1)
        ImageView mImageView;
        @BindView(R.id.item_home_nearby_winport_title1)
        TextView title;
        @BindView(R.id.item_home_nearby_winport_address1)
        TextView address;
        public MyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }

}
