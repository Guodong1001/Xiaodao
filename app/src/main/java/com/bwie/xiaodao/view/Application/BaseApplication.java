package com.bwie.xiaodao.view.Application;

import android.app.Application;
import android.support.compat.BuildConfig;

<<<<<<< HEAD
=======
import org.xutils.x;
>>>>>>> 1ef4c9fca7fa88312544e71914a89949b954a276

/**
 * 类描述：
 * 创建人：xiaoqian
 * 创建时间：2017/8/10 17:02
 */


public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
