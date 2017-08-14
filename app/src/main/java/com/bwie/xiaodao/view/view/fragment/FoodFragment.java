package com.bwie.xiaodao.view.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.Moldle.Food;
import com.bwie.xiaodao.view.Moldle.Foodbase;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 * 创建人：xiaoqian
 * 创建时间：2017/8/10 16:06
 */


public class FoodFragment extends android.support.v4.app.Fragment {
    private ListView listView;
    private List<Food> arrlist;
    private View view5;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view5 = View.inflate(getActivity(), R.layout.fujin_food, null);
        return view5;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView) view5.findViewById(R.id.fujin_lv);
        initfood();
        Foodbase bases = new Foodbase(getActivity(), arrlist);
        listView.setAdapter(bases);
        bases.notifyDataSetChanged();
    }
    private void initfood() {
        arrlist = new ArrayList<>();
        Food food1 = new Food(R.drawable.z, "798咖啡", 45, 15 + "%", false, "安贞距您<100>米");
        Food food2 = new Food(R.drawable.f, "小可爱西点（安贞门店）", 50, 25 + "%", "安贞距您<300>米", true, "每满100元减20元");
        Food food3 = new Food(R.drawable.d, "味多美（安贞华联店）", 31, 20 + "%", false, "安贞距您<200>米");
        Food food4 = new Food(R.drawable.e, "巴贝拉意式餐厅（天通苑）", 66, 15 + "%", "安贞距您<1000>米", true, "每满100元减8元");
        arrlist.add(food1);
        arrlist.add(food2);
        arrlist.add(food3);
        arrlist.add(food4);

    }

}
