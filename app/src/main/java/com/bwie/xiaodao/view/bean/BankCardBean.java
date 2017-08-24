package com.bwie.xiaodao.view.bean;

/**
 * Created by 李冯壮 on 2017/8/15.
 */

public class BankCardBean {
    private int bankCardLogo;
    private String bankCardName;
    private String bankCardAccount;

    public int getBankCardLogo() {
        return bankCardLogo;
    }

    public void setBankCardLogo(int bankCardLogo) {
        this.bankCardLogo = bankCardLogo;
    }

    public String getBankCardName() {
        return bankCardName;
    }

    public void setBankCardName(String bankCardName) {
        this.bankCardName = bankCardName;
    }

    public String getBankCardAccount() {
        return bankCardAccount;
    }

    public void setBankCardAccount(String bankCardAccount) {
        this.bankCardAccount = bankCardAccount;
    }

    public BankCardBean(int bankCardLogo, String bankCardName, String bankCardAccount) {

        this.bankCardLogo = bankCardLogo;
        this.bankCardName = bankCardName;
        this.bankCardAccount = bankCardAccount;
    }
}
