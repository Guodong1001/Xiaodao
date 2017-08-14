package com.bwie.xiaodao.view.view.activity;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by aensun on 2017-07-15.
 */
public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(this);
    }
}
