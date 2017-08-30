package com.bwie.xiaodao.view.view.activity.mine;

import android.content.Intent;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.Application.BaseApplication;
import com.bwie.xiaodao.view.model.bean.LoginPasswordBean;
import com.bwie.xiaodao.view.presenter.MinePresenter;
import com.bwie.xiaodao.view.utlis.NetUtil;
import com.bwie.xiaodao.view.utlis.inet.INet;
import com.bwie.xiaodao.view.view.activity.BaseActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 李冯壮 on 2017/8/11.
 */

public class LoginPwdPageActivity extends BaseActivity implements View.OnClickListener, INet<LoginPasswordBean> {

    private static final String TAG = "TAG";
    private TextView title, forgetPassword, LoginPrompt;
    private EditText loginPhone, loginPassword;
    private Button login;
    private Map<String, Object> map;
    private CheckBox eggVisibility;

    @Override
    public int setMyContentView() {
        return R.layout.login_password_page;
    }

    @Override
    public void initDataFromServer() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        map = new HashMap<>();
        title = (TextView) findViewById(R.id.titles);
        loginPhone = (EditText) findViewById(R.id.login_input_phone);
        loginPassword = (EditText) findViewById(R.id.login_input_password);
        forgetPassword = (TextView) findViewById(R.id.login_forget_password);
        login = (Button) findViewById(R.id.login);
        LoginPrompt = (TextView) findViewById(R.id.Login_prompt);
        eggVisibility = (CheckBox) findViewById(R.id.password_visibility);
        //跳转过来将标题改为目前页面名字
        title.setText(getIntent().getStringExtra("title"));
        login.setOnClickListener(this);
        forgetPassword.setOnClickListener(this);
        login.setEnabled(false);

        //登录手机号判断
        loginPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (start - 1 == 0) {
                    login.setEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 11) {
                    LoginPrompt.setVisibility(View.VISIBLE);
                    login.setEnabled(false);
                } else {
                    LoginPrompt.setVisibility(View.INVISIBLE);
                    map.put("phone", loginPhone.getText().toString().trim());
                    login.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!MinePresenter.isPhoneNumberValid(s.toString())) {
                    LoginPrompt.setVisibility(View.VISIBLE);
                    map.put("phone", s.toString());
                } else {
                    LoginPrompt.setVisibility(View.INVISIBLE);
                }
            }
        });

        //登录密码是否正确
        loginPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (start - 1 == 0) {
                    login.setEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 6) {
                    LoginPrompt.setText("密码不能小于6位");
                    LoginPrompt.setVisibility(View.VISIBLE);
                    login.setEnabled(false);
                } else {
                    LoginPrompt.setVisibility(View.INVISIBLE);
                    map.put("password", loginPassword.getText().toString().trim());
                    login.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        eggVisibility.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    loginPassword.setTransformationMethod(null);
                    loginPassword.setSelection(loginPassword.length());
                } else {
                    loginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    loginPassword.setSelection(loginPassword.length());
                }
            }
        });
    }

    @Override
    public void createEvent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                map.put("merchant", "0");
                //请求数据
                NetUtil.getInstance().postDataFromServer("http://123.57.33.185:8088/user/login", map, this, LoginPasswordBean.class, "", 0);
                break;
            case R.id.login_forget_password:
                Intent intent = new Intent(LoginPwdPageActivity.this, ForgotPwdPageActivity.class);
                intent.putExtra("title", "忘记密码");
                startActivity(intent);
                NetUtil.getInstance().postDataFromServer("http://123.57.33.185:8088/user/login",map,this,LoginPasswordBean.class,getToken(),0);

                break;
        }
    }

    @Override
    public void onSuccess(LoginPasswordBean loginPasswordBean, int tag) {
        if (loginPasswordBean.getObject() == null) {
            LoginPrompt.setVisibility(View.VISIBLE);
            login.setEnabled(false);
            LoginPrompt.setText("用户名密码错误");
        } else {
            MinePresenter.getInstance().toastShow(LoginPwdPageActivity.this, "登录成功");
            EventBus.getDefault().post(loginPasswordBean);
            BaseApplication.getInstence().setLogin(true);
            BaseApplication.getInstence().setToken(loginPasswordBean.getObject().getToken());
            finish();
        }
    }

    @Override
    public void onError(String error) {
        Log.e(TAG, "onError: " + error);
    }
}
