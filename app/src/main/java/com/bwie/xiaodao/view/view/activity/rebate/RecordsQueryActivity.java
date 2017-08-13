package com.bwie.xiaodao.view.view.activity.rebate;

import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

public class RecordsQueryActivity extends BaseActivity {
    @BindView(R.id.query_rgb)
    RadioGroup mQueryRgb;
    @BindView(R.id.header_img_goback)
    ImageView mHeaderImgGoback;
    @BindView(R.id.header_txt_title)
    TextView mHeaderTxtTitle;
    @BindView(R.id.record_txt)
    TextView mRecordTxt;
    private FragmentManager fm;
    private QueryFragment[] fragments = new QueryFragment[3];

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
        mQueryRgb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                int position = Integer.parseInt(rb.getTag().toString());
                //判断如果点击的按钮下标为3时  再判断是否添加过当前fragment
                hideFragment(position);
            }
        });
    }

    @Override
    public void createEvent() {

    }

    /**
     * 添加fragment
     */
    @Override
    public void addFragment() {
        for (int i = 0; i < fragments.length; i++) {
            fragments[i] = new QueryFragment();
        }
        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.query_frame, fragments[0], "0");
        ft.commit();
    }

    /**
     * 判断fragment是否添加过并且隐藏不需要显示的
     *
     * @param position
     */
    public void hideFragment(int position) {
        if (position == 0) {
            mRecordTxt.setVisibility(View.VISIBLE);
        } else {
            mRecordTxt.setVisibility(View.GONE);
        }
        FragmentTransaction ft = fm.beginTransaction();
//        如果fragment没有添加过就添加进去
        if (!fragments[position].isAdded()) {
            ft.add(R.id.query_frame, fragments[position], "" + position);
        }
        for (int i = 0; i < 3; i++) {
            //找到radiogroup里的子控件
            RadioButton rb = (RadioButton) mQueryRgb.getChildAt(i);
            if (rb.isChecked()) {
                //如果当前radiobutton是选中状态就把文字颜色设置成红色的
                rb.setTextColor(Color.parseColor("#C20000"));
                int tag = Integer.parseInt(rb.getTag().toString().trim());
                fragments[position].setTag(tag);
                //显示当前点击按钮相对应的fragment
                ft.show(fragments[position]);
            } else {
                //给这个子控件的文字设置背景颜色    黑色  （没有选择的时候）
                rb.setTextColor(Color.BLACK);
                //通过循环隐藏所有的fragment
                ft.hide(fragments[i]);
            }
        }

        ft.commit();
    }


    @OnClick(R.id.header_img_goback)
    public void onViewClicked() {
        finish();
    }

}
