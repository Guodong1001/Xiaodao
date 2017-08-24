package com.bwie.xiaodao.view.view.activity.mine;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.Application.BaseApplication;
import com.bwie.xiaodao.view.presenter.MinePresenter;
import com.bwie.xiaodao.view.view.activity.BaseActivity;

import org.greenrobot.eventbus.EventBus;

public class SecuritySettingPageActivity extends BaseActivity implements View.OnClickListener {

    private TextView title,securityLoginPwd,securityPayPwd,securityGesturePwd,securityPhone;
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
        securityLoginPwd = (TextView) findViewById(R.id.security_setting_reset_login_pwd);
        securityPayPwd = (TextView) findViewById(R.id.security_setting_reset_pay_pwd);
        securityGesturePwd = (TextView) findViewById(R.id.security_setting_reset_gesture_pwd);
        securityPhone = (TextView) findViewById(R.id.security_setting_reset_phone_number);
        exitLogin = (Button) findViewById(R.id.exit_login);
        //跳转过来将标题改为目前页面名字
        title.setText(getIntent().getStringExtra("title"));
        exitLogin.setOnClickListener(this);
        securityLoginPwd.setOnClickListener(this);
        securityPayPwd.setOnClickListener(this);
        securityGesturePwd.setOnClickListener(this);
        securityPhone.setOnClickListener(this);
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
            case R.id.security_setting_reset_login_pwd:
                MinePresenter.getInstance().intentTo(SecuritySettingPageActivity.this,ForgotPwdPageActivity.class,"忘记密码");
                break;
            case R.id.security_setting_reset_pay_pwd:
                break;
            case R.id.security_setting_reset_gesture_pwd:
                break;
            case R.id.security_setting_reset_phone_number:
                break;
        }
    }
}
