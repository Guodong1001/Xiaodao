package com.bwie.xiaodao.view.view.activity.rebate;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.view.activity.BaseActivity;
import com.bwie.xiaodao.view.view.fragment.QueryFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecordsQueryActivity extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    @BindView(R.id.query_rgb)
    RadioGroup mQueryRgb;
    @BindView(R.id.header_img_goback)
    ImageView mHeaderImgGoback;
    @BindView(R.id.header_txt_title)
    TextView mHeaderTxtTitle;
    @BindView(R.id.record_txt)
    TextView mRecordTxt;
    @BindView(R.id.query_pager)
    ViewPager mQueryPager;
    private FragmentManager fm;
    private static final int SIZE = 3;
    private int[] rbIDs = new int[]{R.id.query_rb_record, R.id.query_rb_rebated, R.id.query_rb_for_rebate};
    private RadioButton[] mRadioButton = new RadioButton[SIZE];
    private QueryFragment[] fragments = new QueryFragment[SIZE];

    @Override
    public int setMyContentView() {
        return R.layout.activity_records_query;
    }

    @Override
    public void initDataFromServer() {

    }

    @Override
    public void initData() {
        ButterKnife.bind(this);

    }

    @Override
    public void initView() {
        mHeaderTxtTitle.setText("记录查询");
        for (int i = 0; i < fragments.length; i++) {
            fragments[i] = new QueryFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("index", i);
            fragments[i].setArguments(bundle);
            mRadioButton[i] = (RadioButton) findViewById(rbIDs[i]);
            mRadioButton[i].setOnClickListener(this);
            if (i==0){
                mRadioButton[i].setChecked(true);
            }
        }
        fm = getSupportFragmentManager();
        MyAdapter adapter = new MyAdapter(fm);
        mQueryPager.setAdapter(adapter);
        mQueryPager.addOnPageChangeListener(this);
    }

    @Override
    public void createEvent() {

    }

    /**
     * 判断fragment是否添加过并且隐藏不需要显示的
     *
     * @param position
     */
    public void check(int position) {
        if (position == 0) {
            mRecordTxt.setVisibility(View.VISIBLE);
        } else {
            mRecordTxt.setVisibility(View.GONE);
        }
        for (RadioButton rb:mRadioButton){
            rb.setTextColor(Color.BLACK);
        }
        mRadioButton[position].setTextColor(Color.parseColor("#C20000"));
        mRadioButton[position].setChecked(true);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        check(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        int i = Integer.parseInt(v.getTag().toString());
        mQueryPager.setCurrentItem(i);
    }


    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }
    }


    @OnClick(R.id.header_img_goback)
    public void onViewClicked() {
        finish();
    }

}
