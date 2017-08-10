package com.bwie.xiaodao.view.utlis.inet;

/**
 * 类描述：
 * 创建人：guodongdong
 * 创建时间：2017/8/10
 */
public interface INet<T> {
    void onSuccess(T t);
    void onError(String error);
}
