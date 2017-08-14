package com.bwie.xiaodao.view.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.bean.CashbackPlan;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 雨夜 on 2017/8/10.
 */

public class AdapterLvFanli extends BaseAdapter {
    private Context mContext;
    private List<CashbackPlan.ObjectBean> mList;
    private int itemCount = 2;

    public AdapterLvFanli(Context context, List<CashbackPlan.ObjectBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        if (mList.size() > 2) {
            return itemCount;
        } else {
            return mList.size();
        }
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_lv_fanli, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        CashbackPlan.ObjectBean bean = mList.get(position);
        double percent = (bean.getIntegral()/(bean.getConsumeUpper()-bean.getConsumeLower()))*100;

        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        String time = format.format(bean.getCashbackSpecificDate());
        if (percent<80){
            holder.mFanliLvItemTxtLevel.setText("有便宜不占，和咸鱼有什么区别？");
        }else if (percent>=80&&percent<=99){
            holder.mFanliLvItemTxtLevel.setText("行百里者半九十，再花一点就返利。");
        }else if (percent>=100){
            holder.mFanliLvItemTxtLevel.setText("继续消费可得多份返利，上不封顶。");
        }

        holder.mFanliLvItemDate.setText(time+"兑换");
        holder.mFanliLvItemTitle.setText(bean.getRecordCoding());
        Glide.with(mContext).load(bean.getIntegralStyle()).into(holder.mFanliLvItemImgLevelIcon);
        return convertView;
    }

    public void addItemNum(int number) {
        itemCount = number;
    }

    class ViewHolder {
        @BindView(R.id.fanli_lv_item_title)
        TextView mFanliLvItemTitle;
        @BindView(R.id.fanli_lv_item_date)
        TextView mFanliLvItemDate;
        @BindView(R.id.fanli_lv_item_img_level_icon)
        ImageView mFanliLvItemImgLevelIcon;
        @BindView(R.id.fanli_lv_item_txt_level)
        TextView mFanliLvItemTxtLevel;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

