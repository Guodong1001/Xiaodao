package com.bwie.xiaodao.view.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.xiaodao.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class QueryFragment extends Fragment {
    private int tag;


    @BindView(R.id.query_txt)
    TextView mQueryTxt;
    @BindView(R.id.query_rv_content)
    RecyclerView mQueryRvContent;
    Unbinder unbinder;
    private View mView;

    public QueryFragment() {
        // Required empty public constructor
    }

    public void setTag(int position){
        tag = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_query, container, false);
        unbinder = ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        switch (tag){
            case 0:
                mQueryTxt.setText(""+tag);
                break;
            case 1:
                mQueryTxt.setText(""+tag);
                break;
            case 2:
                mQueryTxt.setText(""+tag);
                break;
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
