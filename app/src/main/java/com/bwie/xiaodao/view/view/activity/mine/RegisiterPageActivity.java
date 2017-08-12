package com.bwie.xiaodao.view.view.activity.mine;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.view.activity.BaseActivity;

/**
 * Created by 李冯壮 on 2017/8/11.
 */

public class RegisiterPageActivity extends BaseActivity implements View.OnClickListener {

    private EditText inputPhone, inputCode, setPwd;
    private Button getCode, submit;
    private CheckBox isAgree;
    private TextView title;

    @Override
    public int setMyContentView() {
        return R.layout.register_page;
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
        inputPhone = (EditText) findViewById(R.id.register_input_phone);
        inputCode = (EditText) findViewById(R.id.register_input_verification_code);
        getCode = (Button) findViewById(R.id.get_verification_code);
        setPwd = (EditText) findViewById(R.id.register_set_password);
        submit = (Button) findViewById(R.id.button_submit);
        isAgree = (CheckBox) findViewById(R.id.is_agree);
        getCode.setOnClickListener(this);
        submit.setOnClickListener(this);

        //跳转过来将标题改为目前页面名字
        title.setText(getIntent().getStringExtra("title"));

        //判断CheckBox状态如果是选中状态可以点击提交按钮，如果不是就不能点击提交按钮
        isAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    submit.setEnabled(true);
                }else{
                    submit.setEnabled(false);
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
            case R.id.get_verification_code:
                //点击获取验证码
                getCode.setEnabled(false);
                CountDownTimer  timer = new CountDownTimer(1000*60,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        getCode.setEnabled(false);
                        getCode.setText("重新获取验证码（"+millisUntilFinished/1000+"）");
                    }

                    @Override
                    public void onFinish() {
                        getCode.setEnabled(true);
                    }
                }.start();
                break;
            case R.id.button_submit:
                //提交按钮
                break;
        }
    }
}
