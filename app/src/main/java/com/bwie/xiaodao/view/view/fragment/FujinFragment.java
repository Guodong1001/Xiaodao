package com.bwie.xiaodao.view.view.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.bwie.xiaodao.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FujinFragment extends Fragment{
    private RadioGroup mRadioGroup;
    private FragmentManager fm;
    private Fragment[] fragments = new Fragment[5];
    //http://blog.csdn.net/ljfbest/article/details/38765641
    private View view;
    private MapView mMapView;
    private BaiduMap mBaiduMap;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SDKInitializer.initialize(getActivity().getApplicationContext());
        view = View.inflate(getActivity(), R.layout.fragment_fujin, null);
        //获取地图控件引用
        mMapView = (MapView)view. findViewById(R.id.bmapView);
        mRadioGroup = (RadioGroup) view.findViewById(R.id.fujin_rg);
        mBaiduMap = mMapView.getMap();
        //普通地图
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        mBaiduMap.setMyLocationEnabled(true);
// 当不需要定位图层时关闭定位图层
        mBaiduMap.setMyLocationEnabled(false);
        addFragment();
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                int i = Integer.parseInt(rb.getTag().toString());
                //判断如果点击的按钮下标为3时  再判断是否添加过当前fragment
                hideFragment(i);
            }
        });
        return view;
    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        mMapView.onDestroy();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
//        mMapView.onResume();
//    }
//    @Override
//    public void onPause() {
//        super.onPause();
//        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
//        mMapView.onPause();
//    }
    private void addFragment() {
        fragments[0] = new FoodFragment();
        fragments[1] = new XiuxianFragment();
        fragments[2] = new ShenghuoFragment();
        fragments[3] = new JiudianFragment();
        fragments[4] = new AllFragment();
        fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fujin_frame, fragments[0], "0");
        ft.commit();
    }
    private void hideFragment(int i) {
        FragmentTransaction ft = fm.beginTransaction();
        //如果fragment没有添加过就添加进去
        if (!fragments[i].isAdded()) {
            ft.add(R.id.fujin_frame, fragments[i], "" + i);
        }
        for (int j = 0; j < fragments.length; j++) {
            //找到radiogroup里的子控件
            RadioButton rb = (RadioButton) mRadioGroup.getChildAt(j);
            //给这个子控件的文字设置背景颜色    黑色  （没有选择的时候）
            rb.setTextColor(Color.BLACK);
            rb.setBackground(null);
            //通过循环隐藏所有的fragment
            ft.hide(fragments[j]);
            //如果当前radiobutton是选中状态就把文字颜色设置成红色的
            if (rb.isChecked()) {
                rb.setTextColor(Color.RED);
                rb.setBackground(getResources().getDrawable(R.drawable.meishikuang));
            }
            //如果点击的为用户，那么就传值到用户的fragment
        }
        //显示当前点击按钮相对应的fragment
        ft.show(fragments[i]);
        ft.commit();
    }
}





