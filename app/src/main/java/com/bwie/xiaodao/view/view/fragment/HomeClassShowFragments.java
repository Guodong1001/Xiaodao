package com.bwie.xiaodao.view.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.Moldle.NearShops;
import com.bwie.xiaodao.view.model.bean.GoodsShowBean;
import com.bwie.xiaodao.view.presenter.MinePresenter;
import com.bwie.xiaodao.view.utlis.NetUtil;
import com.bwie.xiaodao.view.utlis.inet.INet;
import com.bwie.xiaodao.view.view.activity.home.GoodsDetailPage;
import com.bwie.xiaodao.view.view.adapter.HomeClassShowAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.bwie.xiaodao.view.utlis.UrlUtil.NEAR_SHOPS;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeClassShowFragments extends Fragment implements INet<NearShops> {

    @BindView(R.id.class_shou_rv)
    RecyclerView mClassShouRv;
    Unbinder unbinder;
    private HomeClassShowAdapter adapter;
    private List<NearShops.ObjectBean.ListBean> mList;
    private int tag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_home_class_show_fragments, container, false);


        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    public void setTag(int tag){
        this.tag = tag;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDataFromServer();
        initView();
    }

    private void initView() {
        mList = new ArrayList<>();
        adapter = new HomeClassShowAdapter(getContext(),mList);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        mClassShouRv.setLayoutManager(manager);
        if(tag == 5){
            GridLayoutManager manager = new GridLayoutManager(getContext(),GridLayoutManager.DEFAULT_SPAN_COUNT);
            mClassShouRv.setLayoutManager(manager);
        }else{
            LinearLayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
            mClassShouRv.setLayoutManager(manager);
        }
        //点击跳转到商品详情页面
        adapter.setOnItemClickListener(new HomeClassShowAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), GoodsDetailPage.class);
                intent.putExtra("title","商品详情");
//                intent.putExtra("","");
                getActivity().startActivity(intent);
            }
        });
        mClassShouRv.setAdapter(adapter);
    }

    private void initDataFromServer() {
        Map<String,String> map = new HashMap<>();
        map.put("longitude","116.4192930000");
        map.put("latitude","39.9768360000");
        map.put("categoryId","1");
        map.put("categoryType","1");
        NetUtil.getInstance().postDataFromServer(NEAR_SHOPS,map,this,NearShops.class,"",0);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onSuccess(NearShops nearShops, int tag) {
        if(tag == 0){
            mList.addAll(nearShops.getObject().getList());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }
}
