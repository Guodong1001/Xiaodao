package com.bwie.xiaodao.view.view.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.model.bean.CityBean;
import com.bwie.xiaodao.view.utlis.NetUtil;
import com.bwie.xiaodao.view.utlis.UrlUtil;
import com.bwie.xiaodao.view.utlis.inet.INet;
import com.bwie.xiaodao.view.view.adapter.SortAdapter;
import com.bwie.xiaodao.view.view.customs.CitySortModel;
import com.bwie.xiaodao.view.view.customs.EditTextWithDel;
import com.bwie.xiaodao.view.view.customs.PinyinComparator;
import com.bwie.xiaodao.view.view.customs.PinyinUtils;
import com.bwie.xiaodao.view.view.customs.SideBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CityActivity extends AppCompatActivity implements INet<CityBean> {
    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.titles)
    TextView mTitles;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private ListView sortListView;
    private SideBar sideBar;
    private TextView dialog;
    private SortAdapter adapter;
    private EditTextWithDel mEtCityName;
    private List<CitySortModel> mSourceDateList;
    private List<CityBean.ObjectBean> cityList;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_city);
        ButterKnife.bind(this);
        mTitles.setText("切换城市");
        initData();
        initDataFromServer();
        initViews();
    }

    private void initData() {
        intent = getIntent();
        String thisCity = intent.getStringExtra("thisCity");
        mTvTitle.setText("当前位置：" + thisCity);
    }

    private void initDataFromServer() {
        //获取到的城市
        NetUtil.getInstance().postDataFromServer(UrlUtil.CITY_URL, null, this, CityBean.class, "", 0);
    }





    private void initViews() {
        mEtCityName = (EditTextWithDel) findViewById(R.id.et_search);
        sideBar = (SideBar) findViewById(R.id.sidrbar);
        dialog = (TextView) findViewById(R.id.dialog);
        sortListView = (ListView) findViewById(R.id.country_lvcountry);
        initDatas();
        initEvents();

    }

    private void setAdapter() {
        Collections.sort(mSourceDateList, new PinyinComparator());
        adapter = new SortAdapter(this, mSourceDateList);
//        sortListView.addHeaderView(initHeadView());
        sortListView.setAdapter(adapter);
    }

    private void initEvents() {

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //设置右侧触摸监听
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    sortListView.setSelection(position);
                }
            }
        });

        //ListView的点击事件
        sortListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                intent = getIntent();
                intent.putExtra("city", ((CitySortModel) adapter.getItem(position)).getName());
                setResult(100, intent);
                mTvTitle.setText("当前位置：" + ((CitySortModel) adapter.getItem(position)).getName());
                Toast.makeText(getApplication(), ((CitySortModel) adapter.getItem(position)).getName(), Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        //根据输入框输入值的改变来过滤搜索
        mEtCityName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
                filterData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initDatas() {
        sideBar.setTextView(dialog);
    }

    /*private View initHeadView() {
        View headView = getLayoutInflater().inflate(R.layout.headview, null);
        GridView mGvCity = (GridView) headView.findViewById(R.id.gv_hot_city);
        String[] datas = getResources().getStringArray(R.array.city);
        ArrayList<String> cityList = new ArrayList<>();
        for (int i = 0; i < datas.length; i++) {
            cityList.add(datas[i]);
        }
        CityAdapter adapter = new CityAdapter(getApplicationContext(), R.layout.gridview_item, cityList);
        mGvCity.setAdapter(adapter);
        return headView;
    }*/

    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<CitySortModel> mSortList = new ArrayList<>();
        if (TextUtils.isEmpty(filterStr)) {
            mSortList = mSourceDateList;
        } else {
            mSortList.clear();
            for (CitySortModel sortModel : mSourceDateList) {
                String name = sortModel.getName();
                if (name.toUpperCase().indexOf(filterStr.toString().toUpperCase()) != -1 || PinyinUtils.getPingYin(name).toUpperCase().startsWith(filterStr.toString().toUpperCase())) {
                    mSortList.add(sortModel);
                }
            }
        }
        // 根据a-z进行排序
        Collections.sort(mSortList, new PinyinComparator());
        adapter.updateListView(mSortList);
    }

    private List<CitySortModel> filledData(List<CityBean.ObjectBean> date) {
        List<CitySortModel> mSortList = new ArrayList<>();
        ArrayList<String> indexString = new ArrayList<>();

        for (int i = 0; i < date.size(); i++) {
            CitySortModel sortModel = new CitySortModel();
            sortModel.setName(date.get(i).getAreaname());
            String pinyin = PinyinUtils.getPingYin(date.get(i).getAreaname());
            String sortString = pinyin.substring(0, 1).toUpperCase();
            if (sortString.matches("[A-Z]")) {
                sortModel.setSortLetters(sortString.toUpperCase());
                if (!indexString.contains(sortString)) {
                    indexString.add(sortString);
                }
            }
            mSortList.add(sortModel);
        }
        Collections.sort(indexString);
        sideBar.setIndexText(indexString);
        return mSortList;
    }


    @Override
    public void onSuccess(CityBean cityBean, int tag) {
        cityList = new ArrayList<>();
        mSourceDateList = new ArrayList<>();
        cityList.addAll(cityBean.getObject());
        mSourceDateList = filledData(cityList);
//        adapter.updateListView(mSourceDateList);
        setAdapter();
    }

    @Override
    public void onError(String error) {

    }
}
