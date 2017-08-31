package com.bwie.xiaodao.view.view.activity.mine;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.model.bean.BankCardMessageBean;
import com.bwie.xiaodao.view.presenter.MinePresenter;
import com.bwie.xiaodao.view.view.activity.BaseActivity;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by 李冯壮 on 2017/8/22.
 */

public class AddBankCardPageActivity extends BaseActivity {
    private TextView title;
    private EditText NaCardPeople, bankCardNumber, openBankKind, openCity, openBank;
    private Button sureAddBankCard;

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
        bankCardNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //点击确定添加银行卡
        sureAddBankCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bankCardNumber.getText().toString().trim().length() < 19) {
                    MinePresenter.getInstance().toastShow(AddBankCardPageActivity.this, "请输入正确的银行卡");
                } else {
                    EventBus.getDefault().post(new BankCardMessageBean(bankCardNumber.getText().toString(),
                            openBankKind.getText().toString(),
                            openCity.getText().toString(),
                            openBank.getText().toString()));
                    finish();
                }
            }
        });
    }

    @Override
    public void createEvent() {

    }
}
