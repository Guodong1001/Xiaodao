package com.bwie.xiaodao.view.view.activity.mine;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.Application.BaseApplication;
import com.bwie.xiaodao.view.bean.BankCardBean;
import com.bwie.xiaodao.view.model.bean.BankCardMessageBean;
import com.bwie.xiaodao.view.model.bean.LoginPasswordBean;
import com.bwie.xiaodao.view.presenter.MinePresenter;
import com.bwie.xiaodao.view.view.activity.BaseActivity;
import com.bwie.xiaodao.view.view.adapter.BandCardListAdapter;
import com.bwie.xiaodao.view.view.adapter.NumberKeyBoardAdapter;
import com.bwie.xiaodao.view.view.iview.OnClickListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class CardPackagePageActivity extends BaseActivity {

    private static final String TAG = "TAG";
    private TextView title, payPwd01, payPwd02, payPwd03, payPwd04, payPwd05, payPwd06;
    private LinearLayout wxBinging, zfbBinding,addBankCard;
    private RecyclerView bankCardList;
    private List<BankCardBean> list;
    private BandCardListAdapter adapter;
    private RecyclerView bumberKeyBoard;
    private NumberKeyBoardAdapter boardAdapter;
    private List<String> strList;
    private int count;
    private TextView[] texts;
    private StringBuilder adminPayPwd;
    private ImageView closePopupwindow;

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
        //初始化eventbus
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        list = new ArrayList<>();
        strList = new ArrayList<>();
        strList.add("1");
        strList.add("2");
        strList.add("3");
        strList.add("4");
        strList.add("5");
        strList.add("6");
        strList.add("7");
        strList.add("8");
        strList.add("9");
        strList.add("");
        strList.add("0");
        strList.add("");
        title = (TextView) findViewById(R.id.titles);
        wxBinging = (LinearLayout) findViewById(R.id.binding_weixin_payment);
        zfbBinding = (LinearLayout) findViewById(R.id.binding_zhifubao_payment);
        bankCardList = (RecyclerView) findViewById(R.id.bank_card_list);
        addBankCard = (LinearLayout) findViewById(R.id.add_bank_card);
        texts = new TextView[6];

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
                payPwd01 = (TextView) pop.findViewById(R.id.pay_pwd_01);
                payPwd02 = (TextView) pop.findViewById(R.id.pay_pwd_02);
                payPwd03 = (TextView) pop.findViewById(R.id.pay_pwd_03);
                payPwd04 = (TextView) pop.findViewById(R.id.pay_pwd_04);
                payPwd05 = (TextView) pop.findViewById(R.id.pay_pwd_05);
                payPwd06 = (TextView) pop.findViewById(R.id.pay_pwd_06);
                texts[0] = payPwd01;
                texts[1] = payPwd02;
                texts[2] = payPwd03;
                texts[3] = payPwd04;
                texts[4] = payPwd05;
                texts[5] = payPwd06;
                closePopupwindow = (ImageView) pop.findViewById(R.id.close_popupwindows);
                bumberKeyBoard = (RecyclerView) pop.findViewById(R.id.number_keyboard);
                bumberKeyBoard.setLayoutManager(new GridLayoutManager(CardPackagePageActivity.this, 3, GridLayoutManager.VERTICAL, false));
                bumberKeyBoard.addItemDecoration(new DividerItemDecoration(CardPackagePageActivity.this, DividerItemDecoration.VERTICAL));
                bumberKeyBoard.addItemDecoration(new DividerItemDecoration(CardPackagePageActivity.this, DividerItemDecoration.HORIZONTAL));
                boardAdapter = new NumberKeyBoardAdapter(CardPackagePageActivity.this, strList);
                boardAdapter.setOnClickListener(new OnClickListener.onClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        if (position != 11 && count < 6) {
                            texts[count].setText(strList.get(position));
                            count++;
                        }
                        if (position == 11 && count > 0) {
                            count--;
                            texts[count].setText("");
                        }
                        if(count == 6){
                            adminPayPwd = new StringBuilder();
                            for (int i = 0; i < texts.length; i++) {
                                adminPayPwd.append(texts[i].getText().toString().trim());
                            }
                        }
                    }
                });
                bumberKeyBoard.setAdapter(boardAdapter);
                final PopupWindow popupWindow = new PopupWindow(pop, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                popupWindow.setTouchable(true);
                popupWindow.setOutsideTouchable(true);
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                } else {
                    popupWindow.showAtLocation(pop, Gravity.BOTTOM, 0, 0);
                }
                closePopupwindow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        count=0;
                    }
                });
            }
        });
        bankCardList.setAdapter(adapter);

        addBankCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MinePresenter.getInstance().intentTo(CardPackagePageActivity.this, AddBankCardPageActivity.class,"添加银行卡");
            }
        });
    }

    @Override
    public void createEvent() {

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(BankCardMessageBean event) {
//        String bankCardAccount = event.getBankCardNumber().substring(12, 15);
//        list.add(new BankCardBean(R.mipmap.ic_launcher_round,event.getOpenBankKind(),bankCardAccount));
//        Log.e(TAG, "onMessageEvent: "+list.size() );
//        boardAdapter.notifyDataSetChanged();
    }
}
