package com.bwie.xiaodao.view.view.activity.mine;

import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.view.activity.BaseActivity;

import java.math.BigDecimal;

/**
 * Created by 李冯壮 on 2017/8/11.
 */

public class ForgotPwdPageActivity extends BaseActivity{

    private TextView title;

    @Override
    public int setMyContentView() {
        return R.layout.forgot_password_page;
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
