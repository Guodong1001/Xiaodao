package com.bwie.xiaodao.view.view.fragment.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.model.bean.HomeIconsBean;
import com.bwie.xiaodao.view.view.adapter.HomeIconsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 类描述：分类图标之一
 * 创建人：xwh
 * 创建时间：17.8.12 11:18
 */
public class CategoryIconOne extends Fragment {
    @BindView(R.id.shouye_icon_rv)
    RecyclerView mRecyclerView;
    Context mContext;
    Unbinder unbinder;
    private List<HomeIconsBean.ObjectBean.ListBean> mIconsList = new ArrayList<>();
    private HomeIconsAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_icons, container, false);
        unbinder = ButterKnife.bind(this, view);//绑定Fragment
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 5, GridLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new HomeIconsAdapter(getContext(), mIconsList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
