package com.bwie.xiaodao.view.view.activity.mine;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.bean.BankCardBean;
import com.bwie.xiaodao.view.model.bean.BankCardMessageBean;
import com.bwie.xiaodao.view.view.activity.BaseActivity;
import com.bwie.xiaodao.view.view.adapter.BandCardListAdapter;
import com.bwie.xiaodao.view.view.adapter.NumberKeyBoardAdapter;

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
        setBindAlipay(true);
        setBindWeiXin(false);
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
