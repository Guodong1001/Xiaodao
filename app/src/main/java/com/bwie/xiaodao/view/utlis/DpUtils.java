package com.bwie.xiaodao.view.utlis;

import android.content.Context;

/**
 * 类描述：
 * 创建人：guodongdong
 * 创建时间：2017/8/15
 */
public class DpUtils {
    public static int dip2px(Context context, float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
