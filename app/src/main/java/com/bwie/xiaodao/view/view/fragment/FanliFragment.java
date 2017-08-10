package com.bwie.xiaodao.view.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.view.adapter.AdapterLvFanli;
import com.bwie.xiaodao.view.view.custom.MyListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FanliFragment extends Fragment {


    @BindView(R.id.fanli_img_title)
    ImageView mFanliImgTitle;
    @BindView(R.id.fanli_txt_money)
    TextView mFanliTxtMoney;
    @BindView(R.id.fanli_txt_stroke_count)
    TextView mFanliTxtStrokeCount;
    @BindView(R.id.fanli_txt_query)
    TextView mFanliTxtQuery;
    @BindView(R.id.fanli_txt_weixin_bind)
    TextView mFanliTxtWeixinBind;
    @BindView(R.id.fanli_txt_alipay_bind)
    TextView mFanliTxtAlipayBind;
    @BindView(R.id.fanli_img_pay_more)
    ImageView mFanliImgPayMore;
    @BindView(R.id.fanli_txt_plan_count)
    TextView mFanliTxtPlanCount;
    @BindView(R.id.fanli_lv_details)
    MyListView mFanliLvDetails;
    @BindView(R.id.fanli_img_calendar)
    ImageView mFanliImgCalendar;
    @BindView(R.id.fanli_txt_rebate_7)
    TextView mFanliTxtRebate7;
    @BindView(R.id.fanli_txt_date)
    TextView mFanliTxtDate;
    @BindView(R.id.fanli_txt_money_amounts)
    TextView mFanliTxtMoneyAmounts;
    @BindView(R.id.fanli_img_goto_calendar)
    ImageView mFanliImgGotoCalendar;
    Unbinder unbinder;
    private View view;
    private List<String> mList;
    private AdapterLvFanli mAdapterLvFanli;

    public FanliFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fanli, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initView();
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mList.add("item" + i);
        }
    }

    private void initView() {
        mFanliTxtPlanCount.setText("返利计划（共" + mList.size() + "档）");
        mAdapterLvFanli = new AdapterLvFanli(getContext(), mList);
        mFanliLvDetails.setAdapter(mAdapterLvFanli);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.fanli_txt_show_more)
    public void onViewClicked() {
        if (mAdapterLvFanli.getCount() == 2) {
            mAdapterLvFanli.addItemNum(mList.size());
            mAdapterLvFanli.notifyDataSetChanged();
        } else {
            mAdapterLvFanli.addItemNum(2);
            mAdapterLvFanli.notifyDataSetChanged();
        }
    }
}
