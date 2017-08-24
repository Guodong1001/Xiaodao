package com.bwie.xiaodao.view.bean;

import java.util.List;

/**
 * Created by 雨夜 on 2017/8/15.
 */

public class RecordQuery {

    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : {"startIndex":0,"perPageSize":5,"currentPageNum":1,"totalPageNum":1,"totalCount":1,"entitys":[{"money":500,"createTime":1501589252000,"integral":50,"name":"兰州拉面","integralStyle":"/image/1.jpg","direction":"00"}]}
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
         * startIndex : 0
         * perPageSize : 5
         * currentPageNum : 1
         * totalPageNum : 1
         * totalCount : 1
         * entitys : [{"money":500,"createTime":1501589252000,"integral":50,"name":"兰州拉面","integralStyle":"/image/1.jpg","direction":"00"}]
         */

        private int startIndex;
        private int perPageSize;
        private int currentPageNum;
        private int totalPageNum;
        private int totalCount;
        private List<EntitysBean> entitys;

        public int getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public int getPerPageSize() {
            return perPageSize;
        }

        public void setPerPageSize(int perPageSize) {
            this.perPageSize = perPageSize;
        }

        public int getCurrentPageNum() {
            return currentPageNum;
        }

        public void setCurrentPageNum(int currentPageNum) {
            this.currentPageNum = currentPageNum;
        }

        public int getTotalPageNum() {
            return totalPageNum;
        }

        public void setTotalPageNum(int totalPageNum) {
            this.totalPageNum = totalPageNum;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public List<EntitysBean> getEntitys() {
            return entitys;
        }

        public void setEntitys(List<EntitysBean> entitys) {
            this.entitys = entitys;
        }

        public static class EntitysBean {
            /**
             * money : 500
             * createTime : 1501589252000
             * integral : 50
             * name : 兰州拉面
             * integralStyle : /image/1.jpg
             * direction : 00
             */

            private int money;
            private long createTime;
            private int integral;
            private String name;
            private String integralStyle;
            private String direction;

            public int getMoney() {
                return money;
            }

            public void setMoney(int money) {
                this.money = money;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public int getIntegral() {
                return integral;
            }

            public void setIntegral(int integral) {
                this.integral = integral;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIntegralStyle() {
                return integralStyle;
            }

            public void setIntegralStyle(String integralStyle) {
                this.integralStyle = integralStyle;
            }

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }
        }
    }
}
