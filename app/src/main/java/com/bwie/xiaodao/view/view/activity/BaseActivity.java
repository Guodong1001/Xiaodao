package com.bwie.xiaodao.view.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 类描述：
 * 创建人：guodongdong
 * 创建时间：2017/7/12
 */
public abstract class BaseActivity extends AppCompatActivity {
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
    }
    public abstract int setMyContentView();

    public abstract void initDataFromServer();

    public abstract void initData();


    public abstract void initView();

    public abstract void createEvent();

    public void addFragment(){

    }

}
