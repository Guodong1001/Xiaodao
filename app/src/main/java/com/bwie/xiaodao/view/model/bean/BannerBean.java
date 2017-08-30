package com.bwie.xiaodao.view.model.bean;

import java.util.List;

/**
 * 类描述：
 * 创建人：guodongdong
 * 创建时间：2017/8/22
 */
public class BannerBean {


    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : {"pageNum":1,"totalSize":2,"totalPage":1,"list":[{"recommendId":2,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502686707256.jpg","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""},{"recommendId":4,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502686723134.jpg","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""}]}
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
         * pageNum : 1
         * totalSize : 2
         * totalPage : 1
         * list : [{"recommendId":2,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502686707256.jpg","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""},{"recommendId":4,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502686723134.jpg","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""}]
         */

        private int pageNum;
        private int totalSize;
        private int totalPage;
        private List<ListBean> list;

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

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

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * recommendId : 2
             * picture : http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502686707256.jpg
             * description :
             * type : -10
             * sequence : -10
             * status : -10
             * createTime :
             */

            private int recommendId;
            private String picture;
            private String description;
            private int type;
            private int sequence;
            private int status;
            private String createTime;

            public int getRecommendId() {
                return recommendId;
            }

            public void setRecommendId(int recommendId) {
                this.recommendId = recommendId;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getSequence() {
                return sequence;
            }

            public void setSequence(int sequence) {
                this.sequence = sequence;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }
    }
}
