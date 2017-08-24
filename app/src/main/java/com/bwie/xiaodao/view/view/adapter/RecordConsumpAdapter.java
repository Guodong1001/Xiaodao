package com.bwie.xiaodao.view.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.model.bean.RecordBean2;
import com.bwie.xiaodao.view.view.iview.RecordLink;

import java.util.List;

/**
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/8/14 13:59
 */

public class RecordConsumpAdapter extends RecyclerView.Adapter<RecordConsumpAdapter.ViewHolder> implements View.OnClickListener {
    private Context context;
    private List<RecordBean2> list;
    private RecordLink recordLink;

    public void setRecordLink(RecordLink recordLink) {
        this.recordLink = recordLink;
    }

    public RecordConsumpAdapter(Context context, List<RecordBean2> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.record_adapter_item,null);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.recordName.setText(list.get(position).getName());
        holder.recordTuiKuan.setChecked(list.get(position).isFalg());
        holder.recordCost.setText(list.get(position).getCart());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        if (v!=null){
            recordLink.OnRecprdLink(v, (Integer) v.getTag());
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView recordName;
        private CheckBox recordTuiKuan;
        private TextView recordCost;
        public ViewHolder(View itemView) {
            super(itemView);
            recordName = (TextView) itemView.findViewById(R.id.record_name);
            recordTuiKuan = (CheckBox) itemView.findViewById(R.id.record_tuikuan);
            recordCost = (TextView) itemView.findViewById(R.id.record_cost);
        }
    }
}
