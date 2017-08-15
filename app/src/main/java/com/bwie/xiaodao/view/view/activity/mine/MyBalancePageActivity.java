package com.bwie.xiaodao.view.view.activity.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.Application.BaseApplication;
import com.bwie.xiaodao.view.model.bean.BalanceBean;
import com.bwie.xiaodao.view.presenter.MinePresenter;
import com.bwie.xiaodao.view.utlis.ConstantUtil;
import com.bwie.xiaodao.view.utlis.NetUtil;
import com.bwie.xiaodao.view.utlis.inet.INet;
import com.bwie.xiaodao.view.view.activity.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBalancePageActivity extends BaseActivity implements View.OnClickListener,INet<BalanceBean>{

    private TextView title, balanceDetails, balanceCount, freezeAmount;
    private CheckBox moneyShowHide;
    private Button buttonMention;
    private Map<String,Object> map;
    private List<BalanceBean.ObjectBean> list;

    @Override
    public int setMyContentView() {
        return R.layout.my_balance_page;
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
        list = new ArrayList<>();
        title = (TextView) findViewById(R.id.titles);
        //余额
        balanceCount = (TextView) findViewById(R.id.balance_count);
        //余额明细
        balanceDetails = (TextView) findViewById(R.id.balance_details);
        //冻结余额
        freezeAmount = (TextView) findViewById(R.id.freeze_amount);
        moneyShowHide = (CheckBox) findViewById(R.id.money_show_hide);
        buttonMention = (Button) findViewById(R.id.button_mention);
        //跳转过来将标题改为目前页面名字
        title.setText(getIntent().getStringExtra("title"));
        buttonMention.setOnClickListener(this);
        balanceDetails.setOnClickListener(this);
        if(BaseApplication.getInstence().getToken()!=null){
            map.put("token",BaseApplication.getInstence().getToken());
            NetUtil.getInstance().postDataFromServer(ConstantUtil.MINE_BALANCE,map,this,BalanceBean.class,"",0);
        }else{
            MinePresenter.getInstance().toastShow(MyBalancePageActivity.this,"没登录哪有余额");
        }
        moneyShowHide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    balanceCount.setText(list.get(0).getBalance()+"");
                    freezeAmount.setText(list.get(0).getFreezeMoney()+"");
                }else{
                    balanceCount.setText("***");
                    freezeAmount.setText("***");
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
            case R.id.button_mention:
                //提交按钮
                break;
            case R.id.balance_details:
                //跳转余额明细
                MinePresenter.getInstance().intentTo(MyBalancePageActivity.this,BalanceDetailsPageActivity.class,"余额明细");
                break;
        }
    }

    @Override
    public void onSuccess(BalanceBean balancezBean, int tag) {
        if(balancezBean != null){
            list.add(balancezBean.getObject());
            balanceCount.setText("***");
            freezeAmount.setText("***");
        }
    }

    @Override
    public void onError(String error) {

    }
}
