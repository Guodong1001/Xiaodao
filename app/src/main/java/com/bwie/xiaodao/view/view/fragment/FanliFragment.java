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
import com.bwie.xiaodao.view.Application.BaseApplication;
import com.bwie.xiaodao.view.bean.CashbackPlan;
import com.bwie.xiaodao.view.bean.CountCashBack;
import com.bwie.xiaodao.view.utlis.NetUtil;
import com.bwie.xiaodao.view.utlis.UrlUtil;
import com.bwie.xiaodao.view.utlis.inet.INet;
import com.bwie.xiaodao.view.view.activity.mine.CardPackagePageActivity;
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
public class FanliFragment extends Fragment implements INet {
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
    private static List<CashbackPlan.ObjectBean> mList;
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
        final Map<String, Object> map = new HashMap<>();
        NetUtil.getInstance().postDataFromServer(UrlUtil.STATISTICAL_INFORMATION_URL, map, this, CountCashBack.class, BaseApplication.getInstence().getToken(), 1);

    }

    private void initData() {
        mList = new ArrayList<>();
    }

    private void initView() {

        mFanliTxtPlanCount.setText("返利计划（共" + mList.size() + "档）");
        mAdapterLvFanli = new AdapterLvFanli(getContext(), mList);
        mFanliLvDetails.setAdapter(mAdapterLvFanli);
        mFanliLvDetails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), IllustrateActivity.class);
                intent.putExtra("index", position);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.fanli_txt_query, R.id.fanli_txt_show_more, R.id.fanli_layout_pay})
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
            case R.id.fanli_layout_pay:
                Intent intent = new Intent(getContext(), CardPackagePageActivity.class);
                intent.putExtra("title","卡包");
                startActivityForResult(intent,0);
                break;

        }
    }

    public static List<CashbackPlan.ObjectBean> getData() {
        return mList;
    }

    @OnClick(R.id.fanli_goto_calendar)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), CalendarActivity.class));
    }

    @Override
    public void onSuccess(Object o, int tag) {
        if (tag == 1) {
            final CountCashBack countCashBack = (CountCashBack) o;
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    NetUtil.getInstance().postDataFromServer(UrlUtil.REBATE_PROGRAM_URL, new HashMap<>(), FanliFragment.this, CashbackPlan.class, BaseApplication.getInstence().getToken(), 2);
                    float f = countCashBack.getObject().getCountReally();
                    mFanliTxtMoney.setText(String.format("%.2f", f));
                    mFanliTxtStrokeCount.setText(countCashBack.getObject().getWaitCashback() + "");
                }
            });
        } else if (tag == 2) {
            final CashbackPlan cashbackPlan = (CashbackPlan) o;
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mList.addAll(cashbackPlan.getObject());
                    mFanliTxtPlanCount.setText("返利计划（共" + mList.size() + "档）");
                    if (mList.size() <= 2) {
                        mFanliTxtShowMore.setClickable(false);
                    } else {
                        mFanliTxtShowMore.setClickable(true);
                    }
                    mAdapterLvFanli.notifyDataSetChanged();
                }
            });
        }

    }

    @Override
    public void onError(String error) {

    }

}
