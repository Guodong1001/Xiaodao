package com.bwie.xiaodao.view.view.activity.rebate;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.bean.CashbackPlan;
import com.bwie.xiaodao.view.view.activity.BaseActivity;
import com.bwie.xiaodao.view.view.fragment.FanliFragment;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IllustrateActivity extends BaseActivity {
    @BindView(R.id.header_txt_title)
    TextView mHeaderTxtTitle;
    @BindView(R.id.fanli_lv_item_img_details)
    ImageView mFanliLvItemImgDetails;
    @BindView(R.id.fanli_lv_item_txt_level)
    TextView mFanliLvItemTxtLevel;
    @BindView(R.id.fanli_lv_item_title)
    TextView mFanliLvItemTitle;
    @BindView(R.id.fanli_lv_item_date)
    TextView mFanliLvItemDate;
    @BindView(R.id.fanli_lv_item_img_level_icon)
    ImageView mFanliLvItemImgLevelIcon;
    @BindView(R.id.fanli_lv_item_txt_money)
    TextView mFanliLvItemTxtMoney;
    private List<CashbackPlan.ObjectBean> mList;
    private Intent mIntent;


    @Override
    public int setMyContentView() {
        return R.layout.activity_illustrate;
    }

    @Override
    public void initDataFromServer() {

    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
        mIntent = getIntent();
        mList = FanliFragment.getData();

    }

    @Override
    public void initView() {
        mHeaderTxtTitle.setText("返利计划说明");
        int index = mIntent.getIntExtra("index", 0);
        mFanliLvItemImgDetails.setVisibility(View.INVISIBLE);
        CashbackPlan.ObjectBean bean = mList.get(index);
        double percent = (bean.getIntegral()/(bean.getConsumeUpper()-bean.getConsumeLower()))*100;
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        String time = format.format(bean.getCashbackSpecificDate());
        if (percent<80){
            mFanliLvItemTxtLevel.setText("有便宜不占，和咸鱼有什么区别？");
        }else if (percent>=80&&percent<=99){
            mFanliLvItemTxtLevel.setText("行百里者半九十，再花一点就返利。");
        }else if (percent>=100){
            mFanliLvItemTxtLevel.setText("继续消费可得多份返利，上不封顶。");
        }
        mFanliLvItemDate.setText(time + "兑换");
        mFanliLvItemTitle.setText(bean.getRecordCoding());
        Glide.with(this).load(bean.getIntegralStyle()).into(mFanliLvItemImgLevelIcon);
    }

    @Override
    public void createEvent() {

    }


    @OnClick(R.id.header_img_goback)
    public void onViewClicked() {
        finish();
    }
}
