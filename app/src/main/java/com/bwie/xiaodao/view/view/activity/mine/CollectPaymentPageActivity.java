package com.bwie.xiaodao.view.view.activity.mine;

import android.view.View;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.presenter.MinePresenter;
import com.bwie.xiaodao.view.view.activity.BaseActivity;

/**
 * Created by 李冯壮 on 2017/8/11.
 */

public class CollectPaymentPageActivity extends BaseActivity implements View.OnClickListener{

    private TextView title,collectionBill;

    @Override
    public int setMyContentView() {
        return R.layout.collect_payment_page;
    }

    @Override
    public void initDataFromServer() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        title = (TextView) findViewById(R.id.titles);
        collectionBill = (TextView) findViewById(R.id.collection_bill);
        //跳转过来将标题改为目前页面名字
        title.setText(getIntent().getStringExtra("title"));
        collectionBill.setOnClickListener(this);
    }

    @Override
    public void createEvent() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.collection_bill :
                MinePresenter.getInstance().intentTo(CollectPaymentPageActivity.this,BalanceDetailsPageActivity.class,"余额明细");
                break;
        }
    }
}
