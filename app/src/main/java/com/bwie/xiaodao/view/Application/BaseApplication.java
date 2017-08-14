package com.bwie.xiaodao.view.Application;

import android.app.Application;
import android.content.SharedPreferences;
import android.support.compat.BuildConfig;

import org.xutils.x;

/**
 * 类描述：
 * 创建人：xiaoqian
 * 创建时间：2017/8/10 17:02
 */


public class BaseApplication extends Application {
    private static BaseApplication mApplication;
    private String token;
    private boolean isLogin;
    private SharedPreferences mSp;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
        mSp.edit().putBoolean("isLogin",login).commit();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
        mSp.edit().putString("token",token).commit();
    }
    public static BaseApplication getInstence(){
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        mSp = getSharedPreferences("config", MODE_PRIVATE);
        token = mSp.getString("token","");
        isLogin = mSp.getBoolean("isLogin",false);
    }
}
