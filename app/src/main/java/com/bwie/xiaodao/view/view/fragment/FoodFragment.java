package com.bwie.xiaodao.view.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.xiaodao.R;

/**
 * 类描述：
 * 创建人：xiaoqian
 * 创建时间：2017/8/10 16:06
 */


public class FoodFragment extends android.support.v4.app.Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view5 = View.inflate(getActivity(), R.layout.fujin_food, null);
        return view5;
    }
}
