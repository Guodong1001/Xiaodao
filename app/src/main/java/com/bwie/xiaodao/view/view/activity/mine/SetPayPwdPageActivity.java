package com.bwie.xiaodao.view.view.activity.mine;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.view.activity.BaseActivity;
import com.bwie.xiaodao.view.view.adapter.NumberKeyBoardAdapter;
import com.bwie.xiaodao.view.view.iview.OnClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 李冯壮 on 2017/8/24.
 */

public class SetPayPwdPageActivity extends BaseActivity {

    private TextView inputPayPwd, payPwdTishi;
    private TextView payPwdOne, payPwdTwo, payPwdThree, payPwdFour, payPwdFive, payPwdSix;
    private Button next;
    private int tag = 0, count;
    private String payPwd;
    private RecyclerView bumberKeyBoard;
    private NumberKeyBoardAdapter boardAdapter;
    private List<String> strList;
    private TextView[] texts;
    private StringBuilder adminPayPwd;

    @Override
    public int setMyContentView() {
        return R.layout.set_pay_pwd_page;
    }

    @Override
    public void initDataFromServer() {

    }

    @Override
    public void initData() {
        payPwdTishi = (TextView) findViewById(R.id.text_tishi);
        inputPayPwd = (TextView) findViewById(R.id.input_pay_pwd);
        payPwdOne = (TextView) findViewById(R.id.pay_pwd_01);
        payPwdTwo = (TextView) findViewById(R.id.pay_pwd_02);
        payPwdThree = (TextView) findViewById(R.id.pay_pwd_03);
        payPwdFour = (TextView) findViewById(R.id.pay_pwd_04);
        payPwdFive = (TextView) findViewById(R.id.pay_pwd_05);
        payPwdSix = (TextView) findViewById(R.id.pay_pwd_06);
        next = (Button) findViewById(R.id.next_pay_pwd);
        addList();
        bumberKeyBoard = (RecyclerView) findViewById(R.id.number_keyboard);
        bumberKeyBoard.setLayoutManager(new GridLayoutManager(SetPayPwdPageActivity.this, 3, GridLayoutManager.VERTICAL, false));
        bumberKeyBoard.addItemDecoration(new DividerItemDecoration(SetPayPwdPageActivity.this, DividerItemDecoration.VERTICAL));
        bumberKeyBoard.addItemDecoration(new DividerItemDecoration(SetPayPwdPageActivity.this, DividerItemDecoration.HORIZONTAL));
        boardAdapter = new NumberKeyBoardAdapter(SetPayPwdPageActivity.this, strList);
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
                if (count == 6) {
                    next.setEnabled(true);
                    adminPayPwd = new StringBuilder();
                    for (int i = 0; i < texts.length; i++) {
                        adminPayPwd.append(texts[i].getText().toString().trim());
                    }
                } else {
                    next.setEnabled(false);
                }
            }
        });
        bumberKeyBoard.setAdapter(boardAdapter);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tag < 1) {
                    inputPayPwd.setText("请确认支付密码");
                    next.setText("确认");
                    payPwd = adminPayPwd.toString();
                    payPwdOne.setText("");
                    payPwdTwo.setText("");
                    payPwdThree.setText("");
                    payPwdFour.setText("");
                    payPwdFive.setText("");
                    payPwdSix.setText("");
                    adminPayPwd = null;
                    count = 0;
                    tag++;
                } else {
                    if (!payPwd.equals(adminPayPwd)) {
                        payPwdTishi.setVisibility(View.VISIBLE);
                    } else {
                        payPwdTishi.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });
    }

    private void addList() {
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
        texts = new TextView[6];
        texts[0] = payPwdOne;
        texts[1] = payPwdTwo;
        texts[2] = payPwdThree;
        texts[3] = payPwdFour;
        texts[4] = payPwdFive;
        texts[5] = payPwdSix;
    }

    @Override
    public void initView() {

    }

    @Override
    public void createEvent() {

    }
}
