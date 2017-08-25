package com.bwie.xiaodao.view.model.bean;

/**
 * Created by 李冯壮 on 2017/8/23.
 */

public class BankCardMessageBean {
    private String bankCardNumber;
    private String openBankKind;
    private String openCity;
    private String openBank;

    public BankCardMessageBean(String bankCardNumber, String openBankKind, String openCity, String openBank) {
        this.bankCardNumber = bankCardNumber;
        this.openBankKind = openBankKind;
        this.openCity = openCity;
        this.openBank = openBank;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getOpenBankKind() {
        return openBankKind;
    }

    public void setOpenBankKind(String openBankKind) {
        this.openBankKind = openBankKind;
    }

    public String getOpenCity() {
        return openCity;
    }

    public void setOpenCity(String openCity) {
        this.openCity = openCity;
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank;
    }
}
