package com.bwie.xiaodao.view.view.activity.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.view.activity.BaseActivity;

public class CardPackagePageActivity extends BaseActivity {

    private TextView title;

    @Override
    public int setMyContentView() {
        return R.layout.card_package_page;
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
    }

    @Override
    public void createEvent() {

    }
}
