package com.bwie.xiaodao.view.model.bean;

import java.util.List;

/**
 * 类描述：消费记录网络请求Bean类
 * 创建人：丛云龙
 * 创建时间：2017/8/14 14:06
 */

public class RecordBean {

    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : {"pageNum":1,"totalSize":0,"totalPage":0,"list":[]}
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
         * totalSize : 0
         * totalPage : 0
         * list : []
         */

        private int pageNum;
        private int totalSize;
        private int totalPage;
        private List<?> list;

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

        public List<?> getList() {
            return list;
        }

        public void setList(List<?> list) {
            this.list = list;
        }
    }
}
