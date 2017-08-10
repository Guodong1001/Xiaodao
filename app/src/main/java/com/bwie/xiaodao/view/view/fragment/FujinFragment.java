package com.bwie.xiaodao.view.view.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.xiaodao.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FujinFragment extends Fragment implements View.OnClickListener{
    private View view;
//    @ViewInject(R.id.hsv_title)
    private HorizontalScrollView hsvTitle;

    /**
     * 横向标题布局。盛放一个个的textview
     */
//    @ViewInject(R.id.ll_title)
    private LinearLayout llTitle;

    /**
     * 内容显示的控件
     */
//    @ViewInject(R.id.vp_content)
    private ViewPager vpContent;

    /**
     * 放所有textview的集合
     */
    private List<String> titles;

      private List<ContentFragment> fragments;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_fujin, null);


        llTitle= (LinearLayout) view.findViewById(R.id.ll_title);
        vpContent= (ViewPager) view.findViewById(R.id.vp_content);
        hsvTitle= (HorizontalScrollView) view.findViewById(R.id.hsv_title);
        initData();

        // 1. 向LinearLayout里面添加数据
        // 2. 向ViewPager里面添加Fragment
        addTitleAndFragment();

        // 给viewpager设置适配器
        vpContent.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                //    return ContentFragment.newInstance(titles.get(position));
           return fragments.get(position);
            }

            @Override
            public int getCount() {
                return titles.size();
            }
        });

        // 给viewpager设置切换事件监听
        vpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 选中切换变色
                changeTextColor(position);

                // 计算控件要滑动的距离
                // 共有多少margin
                int margins = 20 * position;
                // 定义一个textview宽度的综合
                int widthTotal = 0;
                // 遍历textview的宽度
                for (int j = 0; j < position; j++) {
                    TextView txtV = (TextView) llTitle.getChildAt(j);
                    widthTotal += txtV.getWidth();
                }

                // hsv计算滑动的位置
                hsvTitle.scrollTo((margins + widthTotal), 0);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }


             /**
              * 切换或者点击的时候改变文字颜色
              *
              * @param position
              */
             private void changeTextColor(int position) {
                 for (int i = 0; i < titles.size(); i++) {
                     // 拿到textview
                     TextView txtview = (TextView) llTitle.getChildAt(i);
                     // 如果被选中，就把文字变成红色
                     if (position == i) {
                         txtview.setTextColor(Color.RED);
                         txtview.setBackground(getResources().getDrawable(R.drawable.meishikuang));
                     } else {
                         txtview.setTextColor(Color.BLACK);
                         txtview.setBackground(null);
                     }
                 }
             }

             /**
              * 添加Textview和Fragment
              */
             private void addTitleAndFragment() {
                 for (int i = 0; i < titles.size(); i++) {
                     // 添加textview
                     TextView txt = new TextView(getActivity());
                     txt.setText(titles.get(i));
         //            txt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                     txt.setTextSize(14);
                     // 设置默认颜色，第一个是默认选中，红色，其他的是黑色，不选中
                     if (i == 0) {
                         txt.setTextColor(Color.RED);

                     } else {
                         txt.setTextColor(Color.BLACK);
                     }
                     // 给textview设置一个id
                     txt.setId(i + 1000);
                     // 给textview设置一个点击事件
                     txt.setOnClickListener(this);
                     // 设置textview要添加进的ViewGroup的宽高
                     LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                             ViewGroup.LayoutParams.WRAP_CONTENT);
//                     params.gravity = Gravity.CENTER;
                     params.setMargins(15, 5, 15, 5);
                     // 给textview设置一个相对父控件的参数
                     txt.setLayoutParams(params);
                     txt.setGravity(Gravity.CENTER);
                     txt.setBackgroundResource(R.drawable.meishikuang);
                     llTitle.addView(txt);
                     // 添加fragment
                     ContentFragment fragment = ContentFragment.newInstance(titles.get(i));
                     fragments.add(fragment);
                 }
             }

             /**
              * 初始化列表数据
              */
             private void initData() {
                 titles = new ArrayList<>();
                fragments = new ArrayList<>();
                 titles.add("美食");
                 titles.add("休闲娱乐");
                 titles.add("生活服务");
                 titles.add("酒店");
                 titles.add("全部");

             }

             //textview的监听事件
             @Override
             public void onClick(View v) {
                 int id = v.getId();
                 // 拿到textview的position
                 int position = id - 1000;
                 vpContent.setCurrentItem(position);

                 // 点击变色
                 changeTextColor(position);
             }
    }




