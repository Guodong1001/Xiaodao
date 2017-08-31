package com.bwie.xiaodao.view.view.activity.mine;

import android.widget.ListView;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.view.activity.BaseActivity;
import com.bwie.xiaodao.view.view.custom.MyListView;

public class MessagePageActivity extends BaseActivity {

    private TextView title;
    private MyListView rebateView,withdrawView,integralView;

    @Override
    public int setMyContentView() {
        return R.layout.message_page;
    }

    @Override
    public void initDataFromServer() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        title = (TextView) findViewById(R.id.titles);
        //跳转过来将标题改为目前页面名字
        title.setText(getIntent().getStringExtra("title"));
    }

    @Override
    public void createEvent() {

    }
}
