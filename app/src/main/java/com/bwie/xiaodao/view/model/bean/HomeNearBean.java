package com.bwie.xiaodao.view.model.bean;

/**
 * 类描述：
 * 创建人：guodongdong
 * 创建时间：2017/8/15
 */
public class HomeNearBean {
    private String img;
    private String title;
    private String address;

    public HomeNearBean(String img, String title, String address) {
        this.img = img;
        this.title = title;
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
