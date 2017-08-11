package com.bwie.xiaodao.view.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
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
import com.youth.banner.Banner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

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
    @BindView(R.id.home_nearby_winport_imageView1)
    ImageView mHomeNearbyWinportImageView1;
    @BindView(R.id.home_nearby_winport_title1)
    TextView mHomeNearbyWinportTitle1;
    @BindView(R.id.home_nearby_winport_address1)
    TextView mHomeNearbyWinportAddress1;
    @BindView(R.id.home_nearby_winport_imageView2)
    ImageView mHomeNearbyWinportImageView2;
    @BindView(R.id.home_nearby_winport_title2)
    TextView mHomeNearbyWinportTitle2;
    @BindView(R.id.home_nearby_winport_address2)
    TextView mHomeNearbyWinportAddress2;
    @BindView(R.id.home_nearby_winport_imageView3)
    ImageView mHomeNearbyWinportImageView3;
    @BindView(R.id.home_nearby_winport_title3)
    TextView mHomeNearbyWinportTitle3;
    @BindView(R.id.home_nearby_winport_address3)
    TextView mHomeNearbyWinportAddress3;
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
    @BindView(R.id.home_rv)
    RecyclerView mHomeRv;
    Unbinder unbinder;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
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
}
