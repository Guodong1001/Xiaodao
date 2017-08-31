package com.bwie.xiaodao.view.Application;

import android.app.Application;
import android.content.SharedPreferences;
import android.support.compat.BuildConfig;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import org.xutils.x;

/**
 * 类描述：
 * 创建人：xiaoqian
 * 创建时间：2017/8/10 17:02
 */


public class BaseApplication extends Application {
    private static BaseApplication mApplication;
    private String token,userName,userPhone;
    private boolean isLogin;
    private boolean isBindWeiXin;
    private boolean isBindAlipay;

    public boolean isBindWeiXin() {
        return isBindWeiXin;
    }

    public void setBindWeiXin(boolean bindWeiXin) {
        isBindWeiXin = bindWeiXin;
        mSp.edit().putBoolean("weixin",bindWeiXin).commit();
    }

    public boolean isBindAlipay() {
        return isBindAlipay;
    }

    public void setBindAlipay(boolean bindAlipay) {
        isBindAlipay = bindAlipay;
        mSp.edit().putBoolean("alipay",bindAlipay).commit();
    }

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        mSp.edit().putString("userName",userName).commit();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
        mSp.edit().putString("userPhone",userPhone).commit();
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
        isBindWeiXin = mSp.getBoolean("weixin",false);
        isBindAlipay = mSp.getBoolean("alipay",false);
        userName = mSp.getString("userName","");
        userPhone = mSp.getString("userPhone","");
        ZXingLibrary.initDisplayOpinion(this);
    }
}
