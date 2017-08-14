package com.bwie.xiaodao.view.model.bean;

/**
 * Created by 李冯壮 on 2017/8/14.
 */

public class LoginPasswordBean {

    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : {"phone":"15726643508","createTime":1502628820000,"nickname":"大道用户3508","userId":128,"picture":"","token":"f592498e4bbb37def59e2f60a4ec0884"}
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
         * phone : 15726643508
         * createTime : 1502628820000
         * nickname : 大道用户3508
         * userId : 128
         * picture :
         * token : f592498e4bbb37def59e2f60a4ec0884
         */

        private String phone;
        private long createTime;
        private String nickname;
        private int userId;
        private String picture;
        private String token;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
