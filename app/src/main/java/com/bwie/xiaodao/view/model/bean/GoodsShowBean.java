package com.bwie.xiaodao.view.model.bean;

/**
 * 类描述：
 * 创建人：guodongdong
 * 创建时间：2017/8/15
 */
public class GoodsShowBean {


    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : {"shopId":2,"shopName":"美颜化妆","shopDescription":"","phone":"17791312895","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"","markPicture":"","longitude":"800","latitude":"400","address":"北京市海淀区西三环中路10号","integralRate":12,"commissionRate":-2,"businessStartTime":"2017-07-30 00:00:00.0","businessEndTime":null,"tags":"wifi","createTime":1500261781000,"perCapitaConsumption":50,"categoryId":40,"distance":""}
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
         * shopId : 2
         * shopName : 美颜化妆
         * shopDescription :
         * phone : 17791312895
         * picture : http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg
         * verticalVersionPicture :
         * markPicture :
         * longitude : 800
         * latitude : 400
         * address : 北京市海淀区西三环中路10号
         * integralRate : 12
         * commissionRate : -2
         * businessStartTime : 2017-07-30 00:00:00.0
         * businessEndTime : null
         * tags : wifi
         * createTime : 1500261781000
         * perCapitaConsumption : 50
         * categoryId : 40
         * distance :
         */

        private int shopId;
        private String shopName;
        private String shopDescription;
        private String phone;
        private String picture;
        private String verticalVersionPicture;
        private String markPicture;
        private String longitude;
        private String latitude;
        private String address;
        private int integralRate;
        private int commissionRate;
        private String businessStartTime;
        private Object businessEndTime;
        private String tags;
        private long createTime;
        private int perCapitaConsumption;
        private int categoryId;
        private String distance;

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getShopDescription() {
            return shopDescription;
        }

        public void setShopDescription(String shopDescription) {
            this.shopDescription = shopDescription;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getVerticalVersionPicture() {
            return verticalVersionPicture;
        }

        public void setVerticalVersionPicture(String verticalVersionPicture) {
            this.verticalVersionPicture = verticalVersionPicture;
        }

        public String getMarkPicture() {
            return markPicture;
        }

        public void setMarkPicture(String markPicture) {
            this.markPicture = markPicture;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getIntegralRate() {
            return integralRate;
        }

        public void setIntegralRate(int integralRate) {
            this.integralRate = integralRate;
        }

        public int getCommissionRate() {
            return commissionRate;
        }

        public void setCommissionRate(int commissionRate) {
            this.commissionRate = commissionRate;
        }

        public String getBusinessStartTime() {
            return businessStartTime;
        }

        public void setBusinessStartTime(String businessStartTime) {
            this.businessStartTime = businessStartTime;
        }

        public Object getBusinessEndTime() {
            return businessEndTime;
        }

        public void setBusinessEndTime(Object businessEndTime) {
            this.businessEndTime = businessEndTime;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getPerCapitaConsumption() {
            return perCapitaConsumption;
        }

        public void setPerCapitaConsumption(int perCapitaConsumption) {
            this.perCapitaConsumption = perCapitaConsumption;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }
    }
}
