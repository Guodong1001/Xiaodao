package com.bwie.xiaodao.view.view.activity.mine;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.model.bean.BankCardMessageBean;
import com.bwie.xiaodao.view.view.activity.BaseActivity;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by 李冯壮 on 2017/8/22.
 */

public class AddBankCardPageActivity extends BaseActivity {
    private TextView title;
    private EditText NaCardPeople, bankCardNumber, openBankKind, openCity, openBank;
    private Button sureAddBankCard;
    private BankCardMessageBean bean;

    @Override
    public int setMyContentView() {
        return R.layout.add_bank_card_page;
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
        bankCardNumber = (EditText) findViewById(R.id.bank_card_number);
        openBankKind = (EditText) findViewById(R.id.open_bank_kind);
        openCity = (EditText) findViewById(R.id.open_city);
        openBank = (EditText) findViewById(R.id.open_bank);
        sureAddBankCard = (Button) findViewById(R.id.sure_add_bank_card);
        title.setText(getIntent().getStringExtra("title"));
        bean = new BankCardMessageBean(bankCardNumber.getText().toString(),
                openBankKind.getText().toString(),
                openCity.getText().toString(),
                openBank.getText().toString());
        //点击确定添加银行卡
        sureAddBankCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(bean);
                finish();
            }
        });
    }

    @Override
    public void createEvent() {

    }
}
