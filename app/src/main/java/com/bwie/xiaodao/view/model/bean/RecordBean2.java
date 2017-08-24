package com.bwie.xiaodao.view.model.bean;

/**
 * 类描述：消费记录网络请求无数据测试Bean类
 * 创建人：丛云龙
 * 创建时间：2017/8/14 14:06
 */

public class RecordBean2 {
    private String name;
    private boolean falg;
    private String cart;

    public RecordBean2(String name, boolean falg, String cart) {
        this.name = name;
        this.falg = falg;
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFalg() {
        return falg;
    }

    public void setFalg(boolean falg) {
        this.falg = falg;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "RecordBean2{" +
                "name='" + name + '\'' +
                ", falg=" + falg +
                ", cart='" + cart + '\'' +
                '}';
    }
}
