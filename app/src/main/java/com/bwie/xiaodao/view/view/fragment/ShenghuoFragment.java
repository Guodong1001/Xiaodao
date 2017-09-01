package com.bwie.xiaodao.view.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.Moldle.Food;
import com.bwie.xiaodao.view.Moldle.Foodbase;
import com.bwie.xiaodao.view.utlis.NetUtil;
import com.bwie.xiaodao.view.utlis.inet.INet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bwie.xiaodao.view.utlis.UrlUtil.FUJIN_SHENGHUO_URL;

/**
 * 类描述：
 * 创建人：xiaoqian
 * 创建时间：2017/8/10 16:06
 */


public class ShenghuoFragment extends android.support.v4.app.Fragment implements INet<Food> {
    private ListView listView;
    private View view3;
    private List<Food> arrlist;
    private Foodbase foodbase;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view3 = View.inflate(getActivity(), R.layout.fujin_shenghuo, null);
        return view3;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView) view3.findViewById(R.id.fujin_lv);
        arrlist=new ArrayList<>();
        foodbase = new Foodbase(getActivity(),arrlist);
        listView.setAdapter(foodbase);
        initDataFromServer();

    }

    private void initDataFromServer() {
        Map<String,Integer> map = new HashMap<>();
        map.put("shopId",8);
        NetUtil.getInstance().postDataFromServer(FUJIN_SHENGHUO_URL,map,this,Food.class,"",11);
    }

    @Override
    public void onSuccess(Food food, int tag) {
        arrlist.add(food);
        foodbase.notifyDataSetChanged();
    }

    @Override
    public void onError(String error) {
        Log.i("zzz","错误");
    }
}
