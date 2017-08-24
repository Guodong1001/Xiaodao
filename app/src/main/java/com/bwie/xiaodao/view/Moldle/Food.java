package com.bwie.xiaodao.view.Moldle;

import java.io.Serializable;

/**
 * 类描述：
 * 创建人：xiaoqian
 * 创建时间：2017/8/14 8:59
 */


public class Food implements Serializable{
    private int image;
    private String name;
    private int money;
    private String integralr;
    private String distance;
    private boolean discount=false;
    private String youhui;

    public Food(int image, String name, int money, String integralr, String distance, boolean discount, String youhui) {
        this.image = image;
        this.name = name;
        this.money = money;
        this.integralr = integralr;
        this.distance = distance;
        this.discount = discount;
        this.youhui = youhui;
    }

    public Food(int image, String name, int money, String integralr, boolean discount, String distance) {
        this.image = image;
        this.name = name;
        this.money = money;
        this.integralr = integralr;
        this.discount = discount;
        this.distance = distance;
    }

    public Food() {
    }
    public String getYouhui() {
        return youhui;
    }

    public void setYouhui(String youhui) {
        this.youhui = youhui;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getIntegralr() {
        return integralr;
    }

    public void setIntegralr(String integralr) {
        this.integralr = integralr;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}