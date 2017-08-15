package com.bwie.xiaodao.view.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.xiaodao.view.utlis.ConstantUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if(ConstantUtil.LOGINSTATUS){

        }
        context.startActivity(intent);
    }

    //判断当前号码是否是正确的手机号码
    public static boolean isPhoneNumberValid(String phoneNumber) {
        boolean isValid = false;
        CharSequence inputStr = phoneNumber;
        //正则表达式
        String phone="^1[34578]\\d{9}$" ;

        Pattern pattern = Pattern.compile(phone);
        Matcher matcher = pattern.matcher(inputStr);

        if(matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
    public void toastShow(Context context,String text){
        Toast.makeText(context,text,Toast.LENGTH_LONG).show();
    }
}
