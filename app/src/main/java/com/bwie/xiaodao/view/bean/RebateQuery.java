package com.bwie.xiaodao.view.bean;

import java.util.List;

/**
 * Created by 雨夜 on 2017/8/15.
 */

public class RebateQuery {

    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : [{"cashbackMoney":500,"recordCoding":"A20171001","cashbackSpecificDate":1499744912000,"taxPayment":10,"really":490}]
     */

    private String code;
    private String descirption;
    private List<ObjectBean> object;

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

    public List<ObjectBean> getObject() {
        return object;
    }

    public void setObject(List<ObjectBean> object) {
        this.object = object;
    }

    public static class ObjectBean {
        /**
         * cashbackMoney : 500
         * recordCoding : A20171001
         * cashbackSpecificDate : 1499744912000
         * taxPayment : 10
         * really : 490
         */

        private int cashbackMoney;
        private String recordCoding;
        private long cashbackSpecificDate;
        private int taxPayment;
        private int really;

        public int getCashbackMoney() {
            return cashbackMoney;
        }

        public void setCashbackMoney(int cashbackMoney) {
            this.cashbackMoney = cashbackMoney;
        }

        public String getRecordCoding() {
            return recordCoding;
        }

        public void setRecordCoding(String recordCoding) {
            this.recordCoding = recordCoding;
        }

        public long getCashbackSpecificDate() {
            return cashbackSpecificDate;
        }

        public void setCashbackSpecificDate(long cashbackSpecificDate) {
            this.cashbackSpecificDate = cashbackSpecificDate;
        }

        public int getTaxPayment() {
            return taxPayment;
        }

        public void setTaxPayment(int taxPayment) {
            this.taxPayment = taxPayment;
        }

        public int getReally() {
            return really;
        }

        public void setReally(int really) {
            this.really = really;
        }
    }
}
