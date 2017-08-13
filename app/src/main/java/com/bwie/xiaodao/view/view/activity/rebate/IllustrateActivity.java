package com.bwie.xiaodao.view.view.activity.rebate;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.view.activity.BaseActivity;
import com.bwie.xiaodao.view.view.fragment.FanliFragment;

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
    private List<String> mList;



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
        Intent intent = getIntent();
        int index = intent.getIntExtra("index", 0);
        mList = FanliFragment.getData();
        mHeaderTxtTitle.setText("返利计划说明");
        mFanliLvItemTxtLevel.setText(mList.get(index));
    }

    @Override
    public void initView() {

    }

    @Override
    public void createEvent() {

    }


    @OnClick(R.id.header_img_goback)
    public void onViewClicked() {
        finish();
    }
}
