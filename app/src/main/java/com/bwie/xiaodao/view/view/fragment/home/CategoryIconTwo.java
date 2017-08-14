package com.bwie.xiaodao.view.view.fragment.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.model.bean.HomeIconsBean;
import com.bwie.xiaodao.view.utlis.ConstantUtil;
import com.bwie.xiaodao.view.utlis.NetUtil;
import com.bwie.xiaodao.view.utlis.inet.INet;
import com.bwie.xiaodao.view.view.adapter.HomeIconsAdapter;
import com.bwie.xiaodao.view.view.custom.ItemClickSupport;
import com.bwie.xiaodao.view.view.customs.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 类描述：分类图标之二
 * 创建人：xwh
 * 创建时间：17.8.12 11:18
 */
public class CategoryIconTwo extends Fragment implements INet<HomeIconsBean> {
    private static final String TAG = "CategoryIconTne";
    @BindView(R.id.icon_rv)
    RecyclerView mRecyclerView;
    Context mContext;
    Unbinder unbinder;
    private List<HomeIconsBean.ObjectBean.ListBean> mIconsList = new ArrayList<>();
    private HomeIconsAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_icon, container, false);
        unbinder = ButterKnife.bind(this, view);//绑定Fragment
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 5, GridLayoutManager.VERTICAL, false);
        //初始化配置
        initView(manager);
        //获取网络数据
        initData();
        initOtherAction();
    }

    private void initOtherAction() {
        //recyclerview条目点击及长按事件
        ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Snackbar.make(v, "click position of " + position, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void initData() {
        Map<String, Object> map = new HashMap<>();
        map.put("pageSize", 10);
        map.put("pageNum ", 2);
        NetUtil.getInstance().postDataFromServer(ConstantUtil.LINK_MOBILE_HOME_ICONS, map, this, HomeIconsBean.class);
    }

    private void initView(GridLayoutManager manager) {
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(5, getResources().getDimensionPixelSize(R.dimen.padding_middle), true));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setNestedScrollingEnabled(false);
        mAdapter = new HomeIconsAdapter(getActivity(), mIconsList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


    @Override
    public void onSuccess(final HomeIconsBean homeIconsBean,int tag) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mIconsList.clear();
                Log.i(TAG, "onSucces***************s: " + homeIconsBean.toString());
                mIconsList.addAll(homeIconsBean.getObject().getList());
                Log.e(TAG, "onSuccess**************: " + mIconsList.size());
                mAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void onError(String error) {
        Log.e(TAG, "onError: " + error);
    }
}
