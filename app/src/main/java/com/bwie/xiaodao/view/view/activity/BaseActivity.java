package com.bwie.xiaodao.view.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bwie.xiaodao.view.Application.BaseApplication;

/**
 * 类描述：
 * 创建人：guodongdong
 * 创建时间：2017/7/12
 */
public abstract class BaseActivity extends AppCompatActivity {
    private boolean isLogin;
    private String token;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(setMyContentView());
        initData();
        initView();
        initDataFromServer();
        addFragment();
        createEvent();
        isLogin = BaseApplication.getInstence().isLogin();
        token = BaseApplication.getInstence().getToken();
    }
    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
        BaseApplication.getInstence().setLogin(login);
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
        BaseApplication.getInstence().setToken(token);
    }
    public abstract int setMyContentView();

    public abstract void initDataFromServer();

    public abstract void initData();


    public abstract void initView();

    public abstract void createEvent();

    public void addFragment(){

    }
    public void back(View v){
        finish();
    }

}
