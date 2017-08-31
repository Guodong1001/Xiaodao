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
import com.bwie.xiaodao.view.bean.BankCardBean;
import com.bwie.xiaodao.view.view.iview.OnClickListener;

import java.util.List;

/**
 * Created by 李冯壮 on 2017/8/15.
 */

public class BandCardListAdapter extends RecyclerView.Adapter<BandCardListAdapter.viewHolder> {

    private Context context;
    private List<BankCardBean> list;
    private OnClickListener.onClickListener onClickListener;

    public BandCardListAdapter(Context context, List<BankCardBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setOnClickListener(OnClickListener.onClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.add_bank_card, parent, false));
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        holder.itemView.setTag(position);
        Glide.with(context).load(list.get(position).getBankCardLogo()).into(holder.bankCardLogo);
        holder.bankCardAccount.setText(list.get(position).getBankCardName() + "（" + list.get(position).getBankCardAccount().substring(15, 19) + "）");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(v, (Integer) v.getTag());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size() == 0 ? 0 : list.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {
        private ImageView bankCardLogo;
        private TextView bankCardAccount;

        public viewHolder(View itemView) {
            super(itemView);
            bankCardAccount = (TextView) itemView.findViewById(R.id.bank_card_account);
            bankCardLogo = (ImageView) itemView.findViewById(R.id.bank_card_logo);
        }
    }
}
