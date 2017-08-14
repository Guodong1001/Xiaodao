package com.bwie.xiaodao.view.view.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.model.bean.HomeGoodsShowBean;
import com.bwie.xiaodao.view.view.activity.home.CityActivity;
import com.bwie.xiaodao.view.view.customs.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.youth.banner.BannerConfig.CIRCLE_INDICATOR;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.home_banner)
    Banner mHomeBanner;
    @BindView(R.id.home_city)
    Button mHomeCity;
    @BindView(R.id.home_sousuo)
    EditText mHomeSousuo;
    @BindView(R.id.home_message)
    ImageView mHomeMessage;
    @BindView(R.id.home_richscan)
    ImageView mHomeRichscan;
    @BindView(R.id.home_class_rb1)
    RadioButton mHomeClassRb1;
    @BindView(R.id.home_class_rb2)
    RadioButton mHomeClassRb2;
    @BindView(R.id.home_class_rg)
    RadioGroup mHomeClassRg;
    @BindView(R.id.home_class_viewpager)
    ViewPager mHomeClassViewpager;
    @BindView(R.id.home_class_framelayout)
    FrameLayout mHomeClassFramelayout;
    @BindView(R.id.home_recommend_img)
    ImageView mHomeRecommendImg;
    @BindView(R.id.home_recommend_title)
    TextView mHomeRecommendTitle;
    @BindView(R.id.home_recommend)
    FrameLayout mHomeRecommend;
    @BindView(R.id.home_function_title)
    TextView mHomeFunctionTitle;
    @BindView(R.id.home_function_connect)
    TextView mHomeFunctionConnect;
    @BindView(R.id.home_function_img)
    ImageView mHomeFunctionImg;
    @BindView(R.id.home_function)
    RelativeLayout mHomeFunction;
    @BindView(R.id.home_moment_title)
    TextView mHomeMomentTitle;
    @BindView(R.id.home_moment_connect)
    TextView mHomeMomentConnect;
    @BindView(R.id.home_moment_img)
    ImageView mHomeMomentImg;
    @BindView(R.id.home_moment)
    RelativeLayout mHomeMoment;
    @BindView(R.id.home_nearby_img)
    ImageView mHomeNearbyImg;
    @BindView(R.id.home_rb_cate)
    RadioButton mHomeRbCate;
    @BindView(R.id.home_rb_recreation)
    RadioButton mHomeRbRecreation;
    @BindView(R.id.home_rb_life)
    RadioButton mHomeRbLife;
    @BindView(R.id.home_rb_grogshop)
    RadioButton mHomeRbGrogshop;
    @BindView(R.id.home_rb_all)
    RadioButton mHomeRbAll;
    @BindView(R.id.home_rg)
    RadioGroup mHomeRg;
    Unbinder unbinder;
    private View view;
    //banner的list集合
    private List<String> mBannerList;

    private HomeClassShowFragments mShowFragments[] = new HomeClassShowFragments[5];
    private FragmentManager fm;
    private static final int REQUEST_CODE = 200;
    //分类展示的list
    private List<HomeGoodsShowBean> mShowBeanList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addShowBean();
        addShowFragment();
        initBannerImg();
        initview();
        event();
    }

    private void addShowBean() {
        //给展示分类的recyclerview设置假的数据
        mShowBeanList = new ArrayList<>();

    }

    private void addShowFragment() {
        fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        for (int i = 0; i < mShowFragments.length; i++) {
            mShowFragments[i] = new HomeClassShowFragments();
            ft.add(R.id.home_class_show_framelayout, mShowFragments[i]);
            if (i != 0) {
                ft.hide(mShowFragments[i]);
            }
        }
        ft.commit();
    }

    private void initBannerImg() {

        //首页banner图的假数据
        mBannerList = new ArrayList<>();
        mBannerList.add("http://img1.yulin520.com/news/BPKZUX0MNFR0OT0WLCOD.png#598_450");
        mBannerList.add("http://img1.yulin520.com/news/SPPW8T9QHFR0OM3HID0X.jpg#1280_960");
        mBannerList.add("http://img1.yulin520.com/news/RPZ58LLNXFR0OKFGFHGK.jpg#616_695");
        mBannerList.add("http://img1.yulin520.com/news/SO9EZSX0QC90ONZY8SVZ.jpg#619_650");
        mBannerList.add("http://img1.yulin520.com/news/VQA5D2ZGFFR0O5E1JWUK.jpg#488_597");
    }

    private void initview() {
        //设置banner的参数
        mHomeBanner.setBannerStyle(CIRCLE_INDICATOR);
        mHomeBanner.setImageLoader(new GlideImageLoader());
        mHomeBanner.setImages(mBannerList);
        mHomeBanner.isAutoPlay(true);
        mHomeBanner.setDelayTime(3000);
        mHomeBanner.setIndicatorGravity(BannerConfig.CENTER);
        mHomeBanner.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.home_city, R.id.home_sousuo, R.id.home_message, R.id.home_recommend, R.id.home_function, R.id.home_moment, R.id.home_nearby_img, R.id.home_rg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_city:
                switchCity();
                break;
            case R.id.home_sousuo:
                break;
            case R.id.home_message:
                break;
            case R.id.home_recommend:
                break;
            case R.id.home_function:
                break;
            case R.id.home_moment:
                break;
            case R.id.home_nearby_img:
                break;
            case R.id.home_rg:
                break;
        }
    }

    private void switchCity() {
        Intent intent = new Intent(getContext(), CityActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void event() {
        //分类展示的radiobutton点击切换效果
        mHomeRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                int i = Integer.parseInt(radioButton.getTag().toString());
//                RadioButton rb = (RadioButton) group.findViewById(checkedId);
//                int i = Integer.parseInt(rb.getTag().toString());
                for (int j = 0; j < group.getChildCount(); j++) {
                    //找到radiogroup里的子控件
                    RadioButton rb = (RadioButton) mHomeRg.getChildAt(j);
                    //给这个子控件的文字设置背景颜色    黑色  （没有选择的时候）
                    rb.setTextColor(Color.BLACK);
                    //如果当前radiobutton是选中状态就把文字颜色设置成红色的
                    if (rb.isChecked()) {
                        rb.setTextColor(Color.RED);
                    }
                }
                hideFragment(i);
            }
        });
    }

    /**
     * 判断fragment是否添加过并且隐藏不需要显示的
     *
     * @param i
     */
    public void hideFragment(int i) {
        FragmentTransaction ft = fm.beginTransaction();
        //如果fragment没有添加过就添加进去
        if (!mShowFragments[i].isAdded()) {
            ft.add(R.id.content_frame, mShowFragments[i], "" + i);
        }
        for (int j = 0; j < mShowFragments.length; j++) {
            //找到radiogroup里的子控件
            RadioButton rb = (RadioButton) mHomeRg.getChildAt(j);
            //给这个子控件的文字设置背景颜色    黑色  （没有选择的时候）
            rb.setTextColor(Color.BLACK);
            //通过循环隐藏所有的fragment
            ft.hide(mShowFragments[j]);
            //如果当前radiobutton是选中状态就把文字颜色设置成红色的
            if (rb.isChecked()) {
                rb.setTextColor(Color.RED);
            }
            //如果点击的为用户，那么就传值到用户的fragment
        }
        //显示当前点击按钮相对应的fragment
        ft.show(mShowFragments[i]);
        ft.commit();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && data != null) {
            if(resultCode == 100){
                String city = data.getStringExtra("city");
                mHomeCity.setText(city);
            }
        }
    }
}
