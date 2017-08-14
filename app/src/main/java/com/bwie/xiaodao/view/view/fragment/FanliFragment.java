package com.bwie.xiaodao.view.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.bean.CountCashBack;
import com.bwie.xiaodao.view.utlis.NetUtil;
import com.bwie.xiaodao.view.utlis.UrlUtil;
import com.bwie.xiaodao.view.utlis.inet.INet;
import com.bwie.xiaodao.view.view.activity.rebate.CalendarActivity;
import com.bwie.xiaodao.view.view.activity.rebate.IllustrateActivity;
import com.bwie.xiaodao.view.view.activity.rebate.RecordsQueryActivity;
import com.bwie.xiaodao.view.view.adapter.AdapterLvFanli;
import com.bwie.xiaodao.view.view.custom.MyListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FanliFragment extends Fragment implements INet<CountCashBack> {
    private static final String TAG = "FanliFragment";


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
    @BindView(R.id.fanli_txt_show_more)
    TextView mFanliTxtShowMore;
    private View view;
    private static List<String> mList;
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
        loadData();
        initView();
    }

    private void loadData() {
        Map<String,Object> map = new HashMap<>();
//        map.put("status",1);
//        map.put("token","2dbae1f3fda438301a33e1d0cfd97a34");
        NetUtil.getInstance().postDataFromServer(UrlUtil.baseURL,map,this, CountCashBack.class,"");
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
        mFanliLvDetails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), IllustrateActivity.class);
                intent.putExtra("index",position);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.fanli_txt_query, R.id.fanli_txt_show_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fanli_txt_query:
                startActivity(new Intent(getActivity(), RecordsQueryActivity.class));
                break;
            case R.id.fanli_txt_show_more:
                if (mAdapterLvFanli.getCount() == 2) {
                    mFanliTxtShowMore.setText("收起更多");
                    mAdapterLvFanli.addItemNum(mList.size());
                    mAdapterLvFanli.notifyDataSetChanged();
                } else {
                    mFanliTxtShowMore.setText("显示更多");
                    mAdapterLvFanli.addItemNum(2);
                    mAdapterLvFanli.notifyDataSetChanged();
                }
                break;
        }
    }
    public static List<String> getData(){
        return mList;
    }
    @OnClick(R.id.fanli_goto_calendar)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), CalendarActivity.class));
    }

    @Override
    public void onSuccess(final CountCashBack countCashBack) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mFanliTxtMoney.setText(countCashBack.getObject().getCountReally()+".00");
                mFanliTxtStrokeCount.setText(countCashBack.getObject().getWaitCashback()+"");
            }
        });
    }

    @Override
    public void onError(String error) {

    }
}
