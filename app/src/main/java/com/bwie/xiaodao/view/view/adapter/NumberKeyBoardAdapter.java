package com.bwie.xiaodao.view.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.view.iview.OnClickListener;

import java.util.List;

/**
 * Created by 李冯壮 on 2017/8/16.
 */

public class NumberKeyBoardAdapter extends RecyclerView.Adapter<NumberKeyBoardAdapter.viewHolder> {

    private static final int TYPE1 = 1;
    private static final int TYPE2 = 2;
    private static final int TYPE3 = 3;
    private Context context;
    private List<String> list;
    private OnClickListener.onClickListener onClickListener;

    public NumberKeyBoardAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    public void setOnClickListener(OnClickListener.onClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE1){
            return new viewHolder(View.inflate(context, R.layout.number_keyboard, null));
        }else{
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(R.drawable.shouji);
            return new viewHolder(imageView);
        }
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        holder.itemView.setTag(position);
        if(position !=11){
            holder.number.setText(list.get(position).toString());
        }
        if(position == 9 || position == 11){
            holder.itemView.setBackgroundColor(Color.parseColor("#cccccc"));
        }
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

    @Override
    public int getItemViewType(int position) {
        if (position == 11) {
            return TYPE3;
        } else {
            return TYPE1;
        }
    }

    class viewHolder extends RecyclerView.ViewHolder {
        private TextView number;

        public viewHolder(View itemView) {
            super(itemView);
            number = (TextView) itemView.findViewById(R.id.number_keyboard_item);
        }
    }
}
