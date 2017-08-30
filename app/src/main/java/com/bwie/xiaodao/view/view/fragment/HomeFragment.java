package com.bwie.xiaodao.view.view.fragment;


import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.model.bean.BannerBean;
import com.bwie.xiaodao.view.model.bean.HomeGoodsShowBean;
import com.bwie.xiaodao.view.model.bean.HomeNearBean;
import com.bwie.xiaodao.view.utlis.NetUtil;
import com.bwie.xiaodao.view.utlis.UrlUtil;
import com.bwie.xiaodao.view.utlis.inet.INet;
import com.bwie.xiaodao.view.view.activity.home.CityActivity;
import com.bwie.xiaodao.view.view.adapter.HomeFujinRvAdapter;
import com.bwie.xiaodao.view.view.customs.GlideImageLoader;
import com.bwie.xiaodao.view.view.fragment.home.CategoryIconOne;
import com.bwie.xiaodao.view.view.fragment.home.CategoryIconTwo;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    TextView mHomeSousuo;
    @BindView(R.id.home_message)
    ImageView mHomeMessage;
    @BindView(R.id.home_richscan)
    ImageView mHomeRichscan;
    @BindView(R.id.home_class_rb1)
    RadioButton mHomeIconRb1;
    @BindView(R.id.home_class_rb2)
    RadioButton mHomeIconRb2;
    @BindView(R.id.home_class_rg)
    RadioGroup mHomeIconRg;
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
    @BindView(R.id.home_fujin_rv)
    RecyclerView mHomeFujinRecyclerView;
    Unbinder unbinder;
    private View view;
    //banner的list集合
    private List<String> mBannerList;
    //设置附近旺铺的数据
    private List<HomeNearBean> mNearList;

    /**
     * 设置选项卡的总数
     */
    private final int[] array = new int[]{R.id.home_class_rb1, R.id.home_class_rb2};
    private List<Fragment> classList;

    private HomeClassShowFragments mShowFragments[] = new HomeClassShowFragments[5];
    private FragmentManager fm;
    private static final int REQUEST_CODE = 200;
    //分类展示的list
    private List<HomeGoodsShowBean> mShowBeanList;
    private HomeFujinRvAdapter mFujinRvAdapter;

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
        addFujinData();
//        addShowFragment();
        initBannerImg();
//        initview();
        event();
    }

    private void addFujinData() {
        mNearList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            HomeNearBean nearBean = new HomeNearBean("http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg", "海友良品酒店", "[安贞门]");
            mNearList.add(nearBean);
        }
        //给附近旺铺设置数据
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        mHomeFujinRecyclerView.setLayoutManager(manager);
        mFujinRvAdapter = new HomeFujinRvAdapter(getContext(), mNearList);
        mHomeFujinRecyclerView.setAdapter(mFujinRvAdapter);
    }

    private void addShowBean() {
        //给展示分类的recyclerview设置假的数据
        mShowBeanList = new ArrayList<>();

    }




    private void initBannerImg() {

        //首页banner图的数据
        mBannerList = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        map.put("Type",1);
        NetUtil.getInstance().postDataFromServer(UrlUtil.BANNER_URL, map, new INet<BannerBean>() {
            @Override
            public void onSuccess(BannerBean bannerBean, int tag) {
                if(tag == 1){
                    List<BannerBean.ObjectBean.ListBean> listBeen = bannerBean.getObject().getList();
                    for (BannerBean.ObjectBean.ListBean listBean : listBeen) {
                        mBannerList.add(listBean.getPicture());
                    }

                    //设置banner的参数
                    mHomeBanner.setBannerStyle(CIRCLE_INDICATOR);
                    mHomeBanner.setImageLoader(new GlideImageLoader());
                    mHomeBanner.setImages(mBannerList);
                    mHomeBanner.isAutoPlay(true);
                    mHomeBanner.setDelayTime(2000);
                    mHomeBanner.setIndicatorGravity(BannerConfig.CENTER);
                    mHomeBanner.start();
                    addShowFragment();
                    addClassFragment();
                }
            }

            @Override
            public void onError(String error) {

            }
        }, BannerBean.class, "", 1);



    }

    private void addClassFragment() {
        classList = new ArrayList<>();
        classList.add(new CategoryIconOne());
        classList.add(new CategoryIconTwo());
//        addShowFragment();
        initview();
    }

    private void initview() {

        //设置分类图标的viewpager的适配器
        mHomeClassViewpager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                //直接创建fragment对象并返回
                return classList.get(position);

            }

            @Override
            public int getCount() {
                return classList.size();
            }
        });

        //切换分类图标时RadioButton的点击效果
        mHomeClassViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //改变radioButton的状态
                change(array[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        //默认设置当前页是第一页
//        mHomeClassViewpager.setCurrentItem(0);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.home_city, R.id.home_sousuo, R.id.home_message, R.id.home_recommend, R.id.home_function, R.id.home_moment, R.id.home_nearby_img, R.id.home_rg,R.id.home_richscan})
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
            case R.id.home_richscan:
                //扫描二维码
                saoyisao();
                break;
        }
    }

    private void saoyisao() {
        View popupView = LayoutInflater.from(getContext()).inflate(R.layout.popupwindow_saoyisao, null);
        PopupWindow mPopupWindow = new PopupWindow(popupView, RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setContentView(popupView);
        //设置点击别的地方会消失popupwindow
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));

        TextView popupSaosao = (TextView) popupView.findViewById(R.id.popup_saoyisao);
        TextView popupFukuan = (TextView) popupView.findViewById(R.id.popup_fukuan);
        //popupWindow中扫一扫的点击事件
        popupSaosao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupSaoyisao();
            }
        });
        //popupWindow中付款码的点击事件
        popupFukuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fukuan();
            }
        });
        mPopupWindow.showAsDropDown(mHomeRichscan);
    }

    private void fukuan() {
        
    }

    private void popupSaoyisao() {
        //6.0动态权限
        AndPermission.with(getContext())
                .requestCode(100)
                .permission(Manifest.permission.CAMERA)
                .callback(new PermissionListener() {
                    @Override
                    public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {
                        if(requestCode == 100){
                            Intent intent = new Intent(getActivity(), CaptureActivity.class);
                            startActivityForResult(intent, REQUEST_CODE);
                        }else{
                            Toast.makeText(getContext(), "权限申请失败", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {

                    }
                })
                .start();
    }

    private void switchCity() {
        Intent intent = new Intent(getContext(), CityActivity.class);
        intent.putExtra("thisCity",mHomeCity.getText().toString());
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void event() {
        //设置radioGroup的状态改变监听
        mHomeIconRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                //设置了ViewPager的当前item就会触发ViewPager的SimpleOnPageChangeListener监听
                switch (checkedId) {
                    case R.id.home_class_rb1:
                        mHomeClassViewpager.setCurrentItem(0);
                        break;
                    case R.id.home_class_rb2:
                        mHomeClassViewpager.setCurrentItem(1);
                        break;
                }
            }
        });

        //分类展示的radiobutton点击切换效果
        mHomeRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                int i = Integer.parseInt(radioButton.getTag().toString());
                if(mShowFragments[i] == null){
                    mShowFragments[i] = new HomeClassShowFragments();
                    mShowFragments[i].setTag(i);
                }

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


    private void addShowFragment() {
        fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
//        for (int i = 0; i < mShowFragments.length; i++) {
//            mShowFragments[i] = new HomeClassShowFragments();
//            mShowFragments[i].setTag(i);
//        }
//        ft.add(R.id.home_class_show_framelayout, mShowFragments[0]);
//        ft.commit();
        for (int i = 0; i < mShowFragments.length; i++) {
            mShowFragments[i] = new HomeClassShowFragments();
            mShowFragments[i].setTag(i);
            if (i != 0) {
                ft.hide(mShowFragments[i]);
            }
        }
        ft.add(R.id.home_class_show_framelayout, mShowFragments[0]);
        ft.commit();
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
            ft.add(R.id.home_class_show_framelayout, mShowFragments[i], "" + i);
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
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getContext(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getContext(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    private void change(int checkedId) {
        //改变背景颜色
        mHomeIconRb1.setBackgroundResource(R.drawable.solid_circle_normal);
        mHomeIconRb2.setBackgroundResource(R.drawable.solid_circle_normal);
        switch (checkedId) {
            case R.id.home_class_rb1:
                mHomeIconRb1.setBackgroundResource(R.drawable.solid_circle_pressed);
                mHomeIconRb1.setChecked(true);
                break;
            case R.id.home_class_rb2:
                mHomeIconRb2.setBackgroundResource(R.drawable.solid_circle_pressed);
                mHomeIconRb2.setChecked(true);
                break;
        }

    }
}
