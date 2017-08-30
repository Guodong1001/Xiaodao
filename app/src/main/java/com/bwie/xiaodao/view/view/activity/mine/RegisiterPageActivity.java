package com.bwie.xiaodao.view.view.activity.mine;

import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.model.bean.LoginPasswordBean;
import com.bwie.xiaodao.view.presenter.MinePresenter;
import com.bwie.xiaodao.view.utlis.NetUtil;
import com.bwie.xiaodao.view.utlis.inet.INet;
import com.bwie.xiaodao.view.view.activity.BaseActivity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 李冯壮 on 2017/8/11.
 */

public class RegisiterPageActivity extends BaseActivity implements View.OnClickListener {

    private EditText inputPhone, inputCode, setPwd;
    private Button getCode, submit;
    private CheckBox isAgree, pwdVisility;
    private TextView title, registerPrompted;
    private Map<String, Object> map;

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
        map = new HashMap<>();
        title = (TextView) findViewById(R.id.titles);
        inputPhone = (EditText) findViewById(R.id.register_input_phone);
        inputCode = (EditText) findViewById(R.id.register_input_verification_code);
        getCode = (Button) findViewById(R.id.get_verification_code);
        setPwd = (EditText) findViewById(R.id.register_set_password);
        submit = (Button) findViewById(R.id.button_submit);
        isAgree = (CheckBox) findViewById(R.id.is_agree);
        pwdVisility = (CheckBox) findViewById(R.id.password_visibility);
        registerPrompted = (TextView) findViewById(R.id.register_prompted);
        getCode.setOnClickListener(this);
        submit.setOnClickListener(this);

        //跳转过来将标题改为目前页面名字
        title.setText(getIntent().getStringExtra("title"));


        //登录手机号判断
        inputPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 11) {
                    registerPrompted.setVisibility(View.VISIBLE);
                } else {
                    registerPrompted.setVisibility(View.INVISIBLE);
                    map.put("phone", inputPhone.getText().toString().trim());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!MinePresenter.isPhoneNumberValid(s.toString())) {
                    registerPrompted.setVisibility(View.VISIBLE);
                    map.put("phone", s.toString());
                } else {
                    registerPrompted.setVisibility(View.INVISIBLE);
                }
            }
        });

        //判断验证码是否正确
        inputCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 4) {
                    registerPrompted.setText("请输入正确验证码");
                    registerPrompted.setVisibility(View.VISIBLE);
                } else {
                    registerPrompted.setVisibility(View.INVISIBLE);
                    map.put("code", inputCode.getText().toString().trim());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //登录密码是否正确
        setPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 6) {
                    registerPrompted.setText("密码不能小于6位");
                    registerPrompted.setVisibility(View.VISIBLE);
                } else {
                    registerPrompted.setVisibility(View.INVISIBLE);
                    map.put("password", setPwd.getText().toString().trim());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //判断CheckBox状态如果是选中状态可以点击提交按钮，如果不是就不能点击提交按钮
        isAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    submit.setEnabled(true);
                } else {
                    submit.setEnabled(false);
                }
            }
        });
        pwdVisility.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setPwd.setTransformationMethod(null);
                    setPwd.setSelection(setPwd.length());
                } else {
                    setPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    setPwd.setSelection(setPwd.length());
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
//                NetUtil.getInstance().postDataFromServer("http://123.57.33.185:8088/sendCode",map,this,);
                getCode.setEnabled(false);
                CountDownTimer timer = new CountDownTimer(1000 * 60, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        getCode.setEnabled(false);
                        getCode.setText("重新获取验证码（" + millisUntilFinished / 1000 + "）");
                    }

                    @Override
                    public void onFinish() {
                        getCode.setEnabled(true);
                        getCode.setText("获取验证码");
                    }
                }.start();
                break;
            case R.id.button_submit:
                //提交按钮
                map.put("merchant","0");
//                NetUtil.getInstance().postDataFromServer("http://123.57.33.185:8088/user/register",map,this,LoginPasswordBean.class,"",1);
                break;
        }
    }
}
