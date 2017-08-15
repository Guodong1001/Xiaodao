package com.bwie.xiaodao.view.view.activity.mine;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.model.bean.RecordBean2;
import com.bwie.xiaodao.view.view.activity.BaseActivity;
import com.bwie.xiaodao.view.view.adapter.RecordConsumpAdapter;
import com.bwie.xiaodao.view.view.iview.RecordLink;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 李冯壮 on 2017/8/11.
 */

public class RecordConsumptionActivity extends BaseActivity{

    private TextView title;
    private RecyclerView recordRecycler;
    private List<RecordBean2> list;
    private ImageView imageView;

    @Override
    public int setMyContentView() {
        return R.layout.record_consumption_page;
    }

    @Override
    public void initDataFromServer() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        for (int i = 0; i <10; i++) {
                    list.add(new RecordBean2("肯德基(上地店)",false,"58.00元"));
                }
        initPopView();
        title = (TextView) findViewById(R.id.titles);
        recordRecycler = (RecyclerView) findViewById(R.id.record_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recordRecycler.setLayoutManager(manager);
        recordRecycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        RecordConsumpAdapter recordConsumpAdapter = new RecordConsumpAdapter(this,list);
        recordRecycler.setAdapter(recordConsumpAdapter);
        //跳转过来将标题改为目前页面名字
        title.setText(getIntent().getStringExtra("title"));
        recordConsumpAdapter.setRecordLink(new RecordLink() {
            @Override
            public void OnRecprdLink(View view, int por) {
                Toast.makeText(RecordConsumptionActivity.this,list.get(por).getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    //点击?号弹出提示框
    private void initPopView() {
        imageView = (ImageView)findViewById(R.id.details_tishi);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecordConsumptionActivity.this, "出来啊", Toast.LENGTH_SHORT).show();
                View view = View.inflate(RecordConsumptionActivity.this, R.layout.record_popview, null);
                PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                popupWindow.setTouchable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                popupWindow.setFocusable(true);
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                } else {
                    //Gravity.CENTER 中心 Gravity.BOTTOM 父控件底部
                    popupWindow.showAsDropDown(imageView);
                }
            }
        });
    }

    @Override
    public void createEvent() {

    }
}
