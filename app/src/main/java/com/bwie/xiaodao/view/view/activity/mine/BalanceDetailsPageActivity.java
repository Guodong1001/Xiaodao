package com.bwie.xiaodao.view.view.activity.mine;

import android.widget.RadioButton;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.view.activity.BaseActivity;

public class BalanceDetailsPageActivity extends BaseActivity {

    private TextView title;
    private RadioButton all;

    @Override
    public int setMyContentView() {
        return R.layout.balance_details_page;
    }

    @Override
    public void initDataFromServer() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        title = (TextView) findViewById(R.id.titles);
        //跳转过来将标题改为目前页面名字
        title.setText(getIntent().getStringExtra("title"));
        //默认初始化一个被点击RadioButton
        all = (RadioButton) findViewById(R.id.balance_all);
        all.setChecked(true);

    }

    @Override
    public void createEvent() {

    }
}
