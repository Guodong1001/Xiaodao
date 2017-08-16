package com.bwie.xiaodao.view.model.bean;

/**
 * Created by 李冯壮 on 2017/8/15.
 */

public class BalanceBean {

    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : {"balance":0,"freezeMoney":0}
     */

    private String code;
    private String descirption;
    private ObjectBean object;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescirption() {
        return descirption;
    }

    public void setDescirption(String descirption) {
        this.descirption = descirption;
    }

    public ObjectBean getObject() {
        return object;
    }

    public void setObject(ObjectBean object) {
        this.object = object;
    }

    public static class ObjectBean {
        /**
         * balance : 0
         * freezeMoney : 0
         */

        private int balance;
        private int freezeMoney;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public int getFreezeMoney() {
            return freezeMoney;
        }

        public void setFreezeMoney(int freezeMoney) {
            this.freezeMoney = freezeMoney;
        }
    }
}
