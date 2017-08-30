package com.bwie.xiaodao.view.view.activity.mine;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.view.activity.BaseActivity;

/**
 * Created by 李冯壮 on 2017/8/24.
 */

public class SetPayPwdPageActivity extends BaseActivity{

    private TextView inputPayPwd;
    private EditText payPwdOne,payPwdTwo,payPwdThree,payPwdFour,payPwdFive,payPwdSix;
    private Button next;
    private int tag = 0;
    private String payPwd;

    @Override
    public int setMyContentView() {
        return R.layout.set_pay_pwd_page;
    }

    @Override
    public void initDataFromServer() {

    }

    @Override
    public void initData() {
        inputPayPwd = (TextView) findViewById(R.id.input_pay_pwd);
        payPwdOne = (EditText) findViewById(R.id.pay_pwd_01);
        payPwdTwo = (EditText) findViewById(R.id.pay_pwd_02);
        payPwdThree = (EditText) findViewById(R.id.pay_pwd_03);
        payPwdFour = (EditText) findViewById(R.id.pay_pwd_04);
        payPwdFive = (EditText) findViewById(R.id.pay_pwd_05);
        payPwdSix = (EditText) findViewById(R.id.pay_pwd_06);
        next = (Button) findViewById(R.id.next_pay_pwd);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag<1){
                    StringBuilder builder = new StringBuilder();
                    builder.append(payPwdOne.getText().toString().trim());
                    builder.append(payPwdTwo.getText().toString().trim());
                    builder.append(payPwdThree.getText().toString().trim());
                    builder.append(payPwdFour.getText().toString().trim());
                    builder.append(payPwdFive.getText().toString().trim());
                    builder.append(payPwdSix.getText().toString().trim());
                    payPwd = builder.toString();
                    inputPayPwd.setText("请确认支付密码");
                    next.setText("确认");
                    payPwdOne.setText("");
                    payPwdTwo.setText("");
                    payPwdThree.setText("");
                    payPwdFour.setText("");
                    payPwdFive.setText("");
                    payPwdSix.setText("");
                    tag++;
                }else{

                }
            }
        });
    }

    @Override
    public void initView() {

    }

    @Override
    public void createEvent() {

    }
}
