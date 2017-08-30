package com.bwie.xiaodao.view.view.activity.mine;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.Application.BaseApplication;
import com.bwie.xiaodao.view.model.bean.SendCodeBean;
import com.bwie.xiaodao.view.presenter.MinePresenter;
import com.bwie.xiaodao.view.utlis.ConstantUtil;
import com.bwie.xiaodao.view.utlis.NetUtil;
import com.bwie.xiaodao.view.utlis.inet.INet;
import com.bwie.xiaodao.view.view.activity.BaseActivity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 李冯壮 on 2017/8/11.
 */

public class ForgotPwdPageActivity extends BaseActivity implements INet<SendCodeBean> {

    private TextView title, LoginPrompt;
    private EditText forgetPhone, forgetPassword, forgetCode, forgetPasswordangin;
    private Button newPassword, sendCode;
    private Map<String, Object> sendCodeMap;
    private Map<String, Object> newPasswordMap;

    @Override
    public int setMyContentView() {
        return R.layout.forgot_password_page;
    }

    @Override
    public void initDataFromServer() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        newPasswordMap = new HashMap<>();
        sendCodeMap = new HashMap<>();
        title = (TextView) findViewById(R.id.titles);
        LoginPrompt = (TextView) findViewById(R.id.forget_tishi);
        forgetPhone = (EditText) findViewById(R.id.forget_phone);
        forgetPassword = (EditText) findViewById(R.id.forget_password);
        forgetCode = (EditText) findViewById(R.id.forget_code);
        forgetPasswordangin = (EditText) findViewById(R.id.forget_password_angin);
        sendCode = (Button) findViewById(R.id.send_code);
        newPassword = (Button) findViewById(R.id.new_password);
        //跳转过来将标题改为目前页面名字
        title.setText(getIntent().getStringExtra("title"));

        //登录手机号判断
        forgetPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (start - 1 == 0) {
                    newPassword.setEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 11) {
                    LoginPrompt.setVisibility(View.VISIBLE);
                    newPassword.setEnabled(false);
                } else {
                    LoginPrompt.setVisibility(View.INVISIBLE);
                    newPassword.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!MinePresenter.isPhoneNumberValid(s.toString())) {
                    LoginPrompt.setVisibility(View.VISIBLE);
                } else {
                    LoginPrompt.setVisibility(View.INVISIBLE);
                    newPasswordMap.put("phone", forgetPhone.getText().toString().trim());
                    sendCodeMap.put("phone", forgetPhone.getText().toString().trim());
                }
            }
        });
        //登录密码是否正确
        forgetPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (start - 1 == 0) {
                    newPassword.setEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 6) {
                    LoginPrompt.setText("密码不能小于6位");
                    LoginPrompt.setVisibility(View.VISIBLE);
                    newPassword.setEnabled(false);
                } else {
                    LoginPrompt.setVisibility(View.INVISIBLE);
                    newPassword.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //登录密码是否正确
        forgetPasswordangin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (start - 1 == 0) {
                    newPassword.setEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 6) {
                    LoginPrompt.setText("密码不能小于6位");
                    LoginPrompt.setVisibility(View.VISIBLE);
                    newPassword.setEnabled(false);
                } else {
                    LoginPrompt.setVisibility(View.INVISIBLE);
                    newPassword.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String password = forgetPassword.getText().toString().trim();
                if (!password.equals(s.toString())) {
                    LoginPrompt.setText("两次密码不一致");
                    LoginPrompt.setVisibility(View.VISIBLE);
                    newPassword.setEnabled(false);
                } else {
                    newPassword.setEnabled(true);
                    newPasswordMap.put("password", forgetPassword.getText().toString().trim());
                }
            }
        });
        sendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCodeMap.put("merchant", "0");
                sendCodeMap.put("type", "2");
                NetUtil.getInstance().postDataFromServer(ConstantUtil.SEND_CODE, sendCodeMap, ForgotPwdPageActivity.this, SendCodeBean.class, "", 0);
                sendCode.setEnabled(false);
                CountDownTimer timer = new CountDownTimer(1000 * 60, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        sendCode.setEnabled(false);
                        sendCode.setText("重新获取验证码（" + millisUntilFinished / 1000 + "）");
                    }

                    @Override
                    public void onFinish() {
                        sendCode.setEnabled(true);
                        sendCode.setText("获取验证码");
                    }
                }.start();
            }
        });
        newPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newPasswordMap.put("code", forgetCode.getText().toString().trim());
                newPasswordMap.put("token", BaseApplication.getInstence().getToken());
                NetUtil.getInstance().postDataFromServer(ConstantUtil.NEW_PASSWORD, newPasswordMap, ForgotPwdPageActivity.this, SendCodeBean.class, "", 1);
            }
        });
    }

    @Override
    public void createEvent() {

    }

    @Override
    public void onSuccess(SendCodeBean sendCodeBean, int tag) {
        if (!sendCodeBean.getDescirption().toString().equals("系统处理成功")) {
            MinePresenter.getInstance().toastShow(ForgotPwdPageActivity.this, "系统处理失败");
        } else {
            if (tag == 1) {
                BaseApplication.getInstence().setLogin(false);
                AlertDialog dialog = new AlertDialog.Builder(ForgotPwdPageActivity.this).setIcon(R.mipmap.ic_launcher_round)
                        .setMessage("登录已过期，请重新登录")
                        .setTitle("提示")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                finish();
                                MinePresenter.getInstance().intentTo(ForgotPwdPageActivity.this, LoginPwdPageActivity.class, "登录");
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).create();
                dialog.show();
            }
        }
    }

    @Override
    public void onError(String error) {

    }
}
