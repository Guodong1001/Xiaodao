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
import com.bwie.xiaodao.view.bean.RecordQuery;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;

/**
 * Created by 雨夜 on 2017/8/11.
 */

public class QueryRvAdapterByRecord extends RecyclerView.Adapter<QueryRvAdapterByRecord.ViewHolder> {

    private Context mContext;
    private List<RecordQuery.ObjectBean.EntitysBean> mList;
    private int tag;
    private String mStrDate;

    public QueryRvAdapterByRecord(Context context, List<RecordQuery.ObjectBean.EntitysBean> list, int tag) {
        mContext = context;
        mList = list;
        this.tag = tag;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rv_record, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RecordQuery.ObjectBean.EntitysBean bean = mList.get(position);
        SimpleDateFormat formattime = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatdate = new SimpleDateFormat("dd");
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        long nowtime = System.currentTimeMillis();
        String time = formattime.format(bean.getCreateTime());
        String date = formatdate.format(bean.getCreateTime());
        String datetoday = formatdate.format(nowtime);
        int today = Integer.parseInt(datetoday);
        int day = Integer.parseInt(date);
        if (today==day){
            mStrDate = "今天";
        }else if (today-day==1){
            mStrDate = "昨天";
        }else{
            mStrDate = format.format(bean.getCreateTime());
        }
        holder.mRebateRvItemName.setText(bean.getName());
        holder.mRebateRvItemTxtIntegral.setText(bean.getIntegral());
        holder.mRebateRvItemTxtMoney.setText(String.format("%.2f",bean.getMoney()));
        holder.mRecordRvItemTxtTime.setText(time);
        holder.mRecordRvItemTxtDate.setText(mStrDate);
        Glide.with(mContext).load(bean.getIntegralStyle()).into(holder.mRecordRvItemImg);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rebate_rv_item_name)
        TextView mRebateRvItemName;
        @BindView(R.id.rebate_rv_item_txt_money)
        TextView mRebateRvItemTxtMoney;
        @BindView(R.id.rebate_rv_item_txt_integral)
        TextView mRebateRvItemTxtIntegral;
        @BindView(R.id.record_rv_item_img)
        ImageView mRecordRvItemImg;
        @BindView(R.id.record_rv_item_txt_date)
        TextView mRecordRvItemTxtDate;
        @BindView(R.id.record_rv_item_txt_time)
        TextView mRecordRvItemTxtTime;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
