package com.bwie.xiaodao.view.view.activity.mine;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.Application.BaseApplication;
import com.bwie.xiaodao.view.view.activity.BaseActivity;

import org.greenrobot.eventbus.EventBus;

public class SecuritySettingPageActivity extends BaseActivity implements View.OnClickListener {

    private TextView title;
    private Button exitLogin;

    @Override
    public int setMyContentView() {
        return R.layout.security_setting_page;
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
        exitLogin = (Button) findViewById(R.id.exit_login);
        //跳转过来将标题改为目前页面名字
        title.setText(getIntent().getStringExtra("title"));
        exitLogin.setOnClickListener(this);
    }

    @Override
    public void createEvent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.exit_login:
                BaseApplication.getInstence().setLogin(false);
                finish();
                break;
        }
    }
}
