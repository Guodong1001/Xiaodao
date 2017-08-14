package com.bwie.xiaodao.view.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.presenter.MinePresenter;
import com.bwie.xiaodao.view.utlis.ConstantUtil;
import com.bwie.xiaodao.view.view.activity.mine.AboutWePageActivity;
import com.bwie.xiaodao.view.view.activity.mine.CardPackagePageActivity;
import com.bwie.xiaodao.view.view.activity.mine.CollectPaymentPageActivity;
import com.bwie.xiaodao.view.view.activity.mine.LoginPwdPageActivity;
import com.bwie.xiaodao.view.view.activity.mine.MessagePageActivity;
import com.bwie.xiaodao.view.view.activity.mine.MyBalancePageActivity;
import com.bwie.xiaodao.view.view.activity.mine.RecordConsumptionActivity;
import com.bwie.xiaodao.view.view.activity.mine.RegisiterPageActivity;
import com.bwie.xiaodao.view.view.activity.mine.SecuritySettingPageActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class WodeFragment extends Fragment implements View.OnClickListener {


    private View view;
    private LinearLayout adminLogin, adminNotLogin;
    private TextView userRegister, userLogin, userName, UserPhone;
    private RadioButton rbCollectPayment, rbBalance, rbcardPackage;
    private RelativeLayout recordConsumption, securitySetting, message, aboutWe;

    public WodeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_wode, container, false);

        initView();
        return view;
    }

    private void initView() {
        //找找找找找ID
        adminLogin = (LinearLayout) view.findViewById(R.id.admin_login);
        adminNotLogin = (LinearLayout) view.findViewById(R.id.admin_not_login);
        userRegister = (TextView) view.findViewById(R.id.new_user_register);
        userLogin = (TextView) view.findViewById(R.id.new_urse_login);
        userName = (TextView) view.findViewById(R.id.user_name);
        UserPhone = (TextView) view.findViewById(R.id.user_phone);
        rbCollectPayment = (RadioButton) view.findViewById(R.id.button_collect_payment);
        rbcardPackage = (RadioButton) view.findViewById(R.id.button_card_package);
        rbBalance = (RadioButton) view.findViewById(R.id.button_balance);
        recordConsumption = (RelativeLayout) view.findViewById(R.id.record_consumption);
        securitySetting = (RelativeLayout) view.findViewById(R.id.security_setting);
        message = (RelativeLayout) view.findViewById(R.id.message);
        aboutWe = (RelativeLayout) view.findViewById(R.id.about_we);
        //写监听啊
        userRegister.setOnClickListener(this);
        userLogin.setOnClickListener(this);
        rbCollectPayment.setOnClickListener(this);
        rbcardPackage.setOnClickListener(this);
        rbBalance.setOnClickListener(this);
        recordConsumption.setOnClickListener(this);
        securitySetting.setOnClickListener(this);
        message.setOnClickListener(this);
        aboutWe.setOnClickListener(this);

        //判断是否登录
        if(ConstantUtil.LOGINSTATUS){
            adminLogin.setVisibility(View.VISIBLE);
            adminNotLogin.setVisibility(View.GONE);
        }else{
            adminLogin.setVisibility(View.GONE);
            adminNotLogin.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.new_user_register:
                //跳转至注册页面
                MinePresenter.getInstance().intentTo(getContext(), RegisiterPageActivity.class,"注册");
                break;
            case R.id.new_urse_login:
                //跳转至登录页面
                MinePresenter.getInstance().intentTo(getContext(), LoginPwdPageActivity.class,"登录");
                break;
            case R.id.button_collect_payment:
                //跳转至收付款页面
                MinePresenter.getInstance().intentTo(getContext(), CollectPaymentPageActivity.class,"收付款");
                break;
            case R.id.button_card_package:
                //跳转至卡包页面
                MinePresenter.getInstance().intentTo(getContext(), CardPackagePageActivity.class,"卡包");
                break;
            case R.id.button_balance:
                //跳转至余额页面
                MinePresenter.getInstance().intentTo(getContext(), MyBalancePageActivity.class,"余额");
                break;
            case R.id.record_consumption:
                //跳转至消费记录详情页面
                MinePresenter.getInstance().intentTo(getContext(), RecordConsumptionActivity.class,"消费详情");
                break;
            case R.id.security_setting:
                //跳转至安全设置页面
                MinePresenter.getInstance().intentTo(getContext(), SecuritySettingPageActivity.class,"安全设置");
                break;
            case R.id.message:
                //跳转至消息页面
                MinePresenter.getInstance().intentTo(getContext(), MessagePageActivity.class,"消息");
                break;
            case R.id.about_we:
                //跳转至关于我们页面
                MinePresenter.getInstance().intentTo(getContext(), AboutWePageActivity.class,"关于我们");
                break;
        }
    }


}
