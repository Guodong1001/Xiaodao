package com.bwie.xiaodao.view.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.Application.BaseApplication;
import com.bwie.xiaodao.view.bean.RebateQuery;
import com.bwie.xiaodao.view.bean.RecordQuery;
import com.bwie.xiaodao.view.utlis.NetUtil;
import com.bwie.xiaodao.view.utlis.UrlUtil;
import com.bwie.xiaodao.view.utlis.inet.INet;
import com.bwie.xiaodao.view.view.adapter.QueryRvAdapterByRebate;
import com.bwie.xiaodao.view.view.adapter.QueryRvAdapterByRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class QueryFragment extends Fragment implements INet {
    private int tag;
    @BindView(R.id.query_txt)
    TextView mQueryTxt;
    @BindView(R.id.query_rv_content)
    RecyclerView mQueryRvContent;
    private List<RebateQuery.ObjectBean> mtoRebateQuerys = new ArrayList<>();
    private List<RebateQuery.ObjectBean> mRebatedQuerys = new ArrayList<>();
    private List<RecordQuery.ObjectBean.EntitysBean> mRecordQuerys = new ArrayList<>();
    Unbinder unbinder;
    private View mView;
    private QueryRvAdapterByRebate mByRebate;
    private HashMap<String, Object> mMap;
    private QueryRvAdapterByRecord mByRecord;

    public QueryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_query, container, false);
        unbinder = ButterKnife.bind(this, mView);
        tag = getArguments().getInt("index");
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMap = new HashMap<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mQueryRvContent.setLayoutManager(layoutManager);

        switch (tag) {
            case 0:
                mQueryTxt.setText("" + tag);
                mByRebate = new QueryRvAdapterByRebate();
                mByRecord = new QueryRvAdapterByRecord(getActivity(), mRecordQuerys, tag);
                mQueryRvContent.setAdapter(mByRecord);
                NetUtil.getInstance().postDataFromServer(UrlUtil.CREDITS_LOG_URL, mMap, this, RecordQuery.class, BaseApplication.getInstence().getToken(), 1);
                break;
            case 1:
                mQueryTxt.setText("" + tag);
                mByRebate = new QueryRvAdapterByRebate(getActivity(), mRebatedQuerys, tag);
                mQueryRvContent.setAdapter(mByRebate);
                break;
            case 2:
                mQueryTxt.setText("" + tag);
                mByRebate = new QueryRvAdapterByRebate(getActivity(), mtoRebateQuerys, tag);
                mQueryRvContent.setAdapter(mByRebate);
                break;
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onSuccess(Object o, int tag) {
        switch (tag) {
            case 1:
                final RecordQuery recordQuery = (RecordQuery) o;
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                mRecordQuerys.addAll(recordQuery.getObject().getEntitys());
                        mByRecord.notifyDataSetChanged();
                        NetUtil.getInstance().postDataFromServer(UrlUtil.REBATE_RECORD_QUERY_URL + "1", mMap, QueryFragment.this, RebateQuery.class, BaseApplication.getInstence().getToken(), 2);
                    }
                });
                break;
            case 2:
                final RebateQuery query = (RebateQuery) o;
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        mRebatedQuerys.addAll(query.getObject());
                        mByRebate.notifyDataSetChanged();
                        NetUtil.getInstance().postDataFromServer(UrlUtil.REBATE_RECORD_QUERY_URL + "0", mMap, QueryFragment.this, RebateQuery.class, BaseApplication.getInstence().getToken(), 3);
                    }
                });
                break;
            case 3:
                final RebateQuery rebateQuery = (RebateQuery) o;
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        mRebatedQuerys.addAll(rebateQuery.getObject());
                        mByRebate.notifyDataSetChanged();
                    }
                });

                break;

        }
    }

    @Override
    public void onError(String error) {

    }
}
