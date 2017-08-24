package com.bwie.xiaodao.view.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.bean.RebateQuery;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;

/**
 * Created by 雨夜 on 2017/8/11.
 */

public class QueryRvAdapterByRebate extends RecyclerView.Adapter<QueryRvAdapterByRebate.ViewHolder> {

    private Context mContext;
    private List<RebateQuery.ObjectBean> mList;
    private int tag;

    public QueryRvAdapterByRebate(Context context, List<RebateQuery.ObjectBean> list, int tag) {
        mContext = context;
        mList = list;
        this.tag = tag;
    }

    public QueryRvAdapterByRebate() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rv_rebate, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RebateQuery.ObjectBean bean = mList.get(position);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm");
        String time = format.format(bean.getCashbackSpecificDate());
        holder.mFanliLvItemDate.setText(time);
        holder.mFanliLvItemTitle.setText(bean.getRecordCoding());

        if (tag == 2) {
            holder.mRebateLayout.setVisibility(View.INVISIBLE);
            holder.mPayTaxesLayout.setVisibility(View.INVISIBLE);
            holder.mItemRvRebateReality.setText("待返利：");
            holder.mRebateRvItemTxtMoneyReality.setText(bean.getCashbackMoney()+"");
        } else if (tag == 1) {
            holder.mRebateLayout.setVisibility(View.VISIBLE);
            holder.mPayTaxesLayout.setVisibility(View.VISIBLE);
            holder.mRebateRvItemTxtMoney.setText(bean.getCashbackMoney()+"");
            holder.mRebateRvItemTxtMoneyReality.setText(bean.getReally()+"");
            holder.mRebateRvItemTxtMoneyPayment.setText(bean.getTaxPayment()+"");
            holder.mItemRvRebateReality.setText("实到：");
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.fanli_lv_item_title)
        TextView mFanliLvItemTitle;
        @BindView(R.id.fanli_lv_item_date)
        TextView mFanliLvItemDate;
        @BindView(R.id.rebate_rv_item_txt_money)
        TextView mRebateRvItemTxtMoney;
        @BindView(R.id.rebate_layout)
        LinearLayout mRebateLayout;
        @BindView(R.id.item_rv_rebate_reality)
        TextView mItemRvRebateReality;
        @BindView(R.id.rebate_rv_item_txt_money_reality)
        TextView mRebateRvItemTxtMoneyReality;
        @BindView(R.id.rebate_rv_item_txt_money_payment)
        TextView mRebateRvItemTxtMoneyPayment;
        @BindView(R.id.pay_taxes_layout)
        LinearLayout mPayTaxesLayout;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
