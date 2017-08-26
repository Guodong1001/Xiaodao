package com.bwie.xiaodao.view.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.Moldle.GridBase;
import com.bwie.xiaodao.view.bean.All_grid;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 * 创建人：xiaoqian
 * 创建时间：2017/8/10 16:07
 */


public class AllFragment extends android.support.v4.app.Fragment {
    private GridView gridView,gridview2;
    private ImageView imageView;
    private TextView title;
    private List<All_grid>arrlist;
    private List<All_grid>arrlist2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1=View.inflate(getActivity(), R.layout.fujin_all,null);
        gridView= (GridView) view1.findViewById(R.id.all_grid);
        gridview2= (GridView) view1.findViewById(R.id.all_grid2);
        imageView= (ImageView) view1.findViewById(R.id.tubiao);
        init();
        GridBase gridbase=new GridBase(getActivity(),arrlist);
        gridView.setAdapter(gridbase);
        GridBase gridbase2=new GridBase(getActivity(),arrlist2);
        gridview2.setAdapter(gridbase2);
        return view1;
    }

    private void init() {
        arrlist=new ArrayList<>();
        arrlist2=new ArrayList<>();
        arrlist.add(new All_grid("海鲜"));
        arrlist.add(new All_grid("西餐"));
        arrlist.add(new All_grid("粤菜"));
        arrlist.add(new All_grid("川菜"));
        arrlist.add(new All_grid("小吃"));
        arrlist.add(new All_grid("烧烤"));
        arrlist.add(new All_grid("蛋糕"));
        arrlist.add(new All_grid("咖啡"));
        arrlist.add(new All_grid("卤菜"));
        arrlist.add(new All_grid("炸鸡"));
        arrlist.add(new All_grid("韩式料理"));
        arrlist.add(new All_grid("火锅"));
        arrlist2.add(new All_grid("美发"));
        arrlist2.add(new All_grid("美甲"));
        arrlist2.add(new All_grid("瑜伽"));
        arrlist2.add(new All_grid("美妆"));
        arrlist2.add(new All_grid("SPA"));
        arrlist2.add(new All_grid("脱毛"));
        arrlist2.add(new All_grid("瘦身"));
        arrlist2.add(new All_grid("祛痘"));
        arrlist2.add(new All_grid("美睫"));
        arrlist2.add(new All_grid("美足"));
        arrlist2.add(new All_grid("美瞳"));
        arrlist2.add(new All_grid("舞蹈"));
    }
}
