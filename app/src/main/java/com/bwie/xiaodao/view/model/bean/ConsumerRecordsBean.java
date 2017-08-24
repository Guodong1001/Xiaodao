package com.bwie.xiaodao.view.model.bean;

import java.util.List;

/**
 * Created by 李冯壮 on 2017/8/15.
 */

public class ConsumerRecordsBean {

    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : {"totalSize":2,"totalPage":1,"list":[{"amount":25,"createTime":"2017-07-30 16:45:18.0","orderId":"G201707301645184","payMethod":1,"beginIndex":0,"pageSize":10,"shopName":"过桥米线","orderStatus":5,"sort":"","id":2,"order":"desc"}],"pageNum":1}
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
         * totalSize : 2
         * totalPage : 1
         * list : [{"amount":25,"createTime":"2017-07-30 16:45:18.0","orderId":"G201707301645184","payMethod":1,"beginIndex":0,"pageSize":10,"shopName":"过桥米线","orderStatus":5,"sort":"","id":2,"order":"desc"}]
         * pageNum : 1
         */

        private int totalSize;
        private int totalPage;
        private int pageNum;
        private List<ListBean> list;

        public int getTotalSize() {
            return totalSize;
        }

        public void setTotalSize(int totalSize) {
            this.totalSize = totalSize;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * amount : 25
             * createTime : 2017-07-30 16:45:18.0
             * orderId : G201707301645184
             * payMethod : 1
             * beginIndex : 0
             * pageSize : 10
             * shopName : 过桥米线
             * orderStatus : 5
             * sort :
             * id : 2
             * order : desc
             */

            private int amount;
            private String createTime;
            private String orderId;
            private int payMethod;
            private int beginIndex;
            private int pageSize;
            private String shopName;
            private int orderStatus;
            private String sort;
            private int id;
            private String order;

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public int getPayMethod() {
                return payMethod;
            }

            public void setPayMethod(int payMethod) {
                this.payMethod = payMethod;
            }

            public int getBeginIndex() {
                return beginIndex;
            }

            public void setBeginIndex(int beginIndex) {
                this.beginIndex = beginIndex;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public int getOrderStatus() {
                return orderStatus;
            }

            public void setOrderStatus(int orderStatus) {
                this.orderStatus = orderStatus;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }
        }
    }
}
