package com.bwie.xiaodao.view.view.activity.mine;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.bean.BankCardBean;
import com.bwie.xiaodao.view.view.activity.BaseActivity;
import com.bwie.xiaodao.view.view.adapter.BandCardListAdapter;
import com.bwie.xiaodao.view.view.iview.OnClickListener;

import java.util.ArrayList;
import java.util.List;

public class CardPackagePageActivity extends BaseActivity {

    private TextView title, addBankCard;
    private LinearLayout wxBinging, zfbBinding;
    private RecyclerView bankCardList;
    private List<BankCardBean> list;
    private BandCardListAdapter adapter;
    private RecyclerView bumberKeyBoard;

    @Override
    public int setMyContentView() {
        return R.layout.card_package_page;
    }

    @Override
    public void initDataFromServer() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        title = (TextView) findViewById(R.id.titles);
        wxBinging = (LinearLayout) findViewById(R.id.binding_weixin_payment);
        zfbBinding = (LinearLayout) findViewById(R.id.binding_zhifubao_payment);
        bankCardList = (RecyclerView) findViewById(R.id.bank_card_list);
        addBankCard = (TextView) findViewById(R.id.add_bank_card);
        //跳转过来将标题改为目前页面名字
        title.setText(getIntent().getStringExtra("title"));
        list.add(new BankCardBean(R.mipmap.ic_launcher_round, "中国银行", "6222128457215542454"));
        list.add(new BankCardBean(R.mipmap.ic_launcher_round, "招商银行", "6222128457287542210"));
        list.add(new BankCardBean(R.mipmap.ic_launcher_round, "工商银行", "6222128457295417532"));
        bankCardList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new BandCardListAdapter(this, list);
        adapter.setOnClickListener(new OnClickListener.onClickListener() {
            @Override
            public void onClick(View view, int position) {
                View pop = LayoutInflater.from(CardPackagePageActivity.this).inflate(R.layout.bank_card_popupwindows, null);
                bumberKeyBoard = (RecyclerView) pop.findViewById(R.id.number_keyboard);
                PopupWindow popupWindow = new PopupWindow(pop, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                popupWindow.setTouchable(true);
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                } else {
                    //Gravity.CENTER 中心 Gravity.BOTTOM 父控件底部
                    popupWindow.showAtLocation(pop, Gravity.CENTER, 0, 0);
                }

            }
        });
        bankCardList.setAdapter(adapter);
    }

    @Override
    public void createEvent() {

    }
}
