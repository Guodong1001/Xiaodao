package com.bwie.xiaodao.view.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/**
 * Created by 李冯壮 on 2017/8/11.
 */

public class MinePresenter {

    private static MinePresenter instance = null;
    private MinePresenter(){}
    public static MinePresenter getInstance(){
        if(instance == null){
            instance = new MinePresenter();
        }
        return instance;
    }
    //跳转方法
    public void intentTo(Context context, Class<?> cls, String text){
        Intent intent = new Intent(context,cls);
        if(!TextUtils.isEmpty(text)){
            intent.putExtra("title",text);
        }
        context.startActivity(intent);
    }
}
