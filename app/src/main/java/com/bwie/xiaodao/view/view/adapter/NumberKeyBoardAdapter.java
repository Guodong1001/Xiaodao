package com.bwie.xiaodao.view.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.xiaodao.R;

/**
 * Created by 李冯壮 on 2017/8/16.
 */

public class NumberKeyBoardAdapter extends RecyclerView.Adapter<NumberKeyBoardAdapter.viewHolder>{

    private Context context;
    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new viewHolder(View.inflate(context,R.layout.number_keyboard,null));
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class viewHolder extends RecyclerView.ViewHolder {
        private TextView number;
        public viewHolder(View itemView) {
            super(itemView);
            number = (TextView) itemView.findViewById(R.id.number_keyboard_item);
        }
    }
}
