package com.bwie.xiaodao.view.view.activity.rebate;

import android.view.View;
import android.widget.TextView;

import com.bwie.xiaodao.R;
import com.bwie.xiaodao.view.view.activity.BaseActivity;
import com.othershe.calendarview.CalendarView;
import com.othershe.calendarview.DateBean;
import com.othershe.calendarview.WeekView;
import com.othershe.calendarview.listener.OnMonthItemClickListener;
import com.othershe.calendarview.listener.OnPagerChangeListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalendarActivity extends BaseActivity {


    @BindView(R.id.header_txt_title)
    TextView mHeaderTxtTitle;
    @BindView(R.id.week)
    WeekView mWeek;
    @BindView(R.id.calendar)
    CalendarView mCalendar;
    @BindView(R.id.calendar_txt_title)
    TextView mCalendarTxtTitle;

    @Override
    public int setMyContentView() {
        return R.layout.activity_calendar;
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
        mHeaderTxtTitle.setText("返利日历");
        mCalendar.init();
        DateBean d = mCalendar.getDateInit();

        mCalendarTxtTitle.setText(d.getSolar()[0] + "年" + d.getSolar()[1] + "月" + d.getSolar()[2] + "日");

        mCalendar.setOnPagerChangeListener(new OnPagerChangeListener() {
            @Override
            public void onPagerChanged(int[] date) {
                mCalendarTxtTitle.setText(date[0] + "年" + date[1] + "月" + date[2] + "日");
            }
        });

        mCalendar.setOnItemClickListener(new OnMonthItemClickListener() {
            @Override
            public void onMonthItemClick(View view, DateBean date) {
                mCalendarTxtTitle.setText(date.getSolar()[0] + "年" + date.getSolar()[1] + "月" + date.getSolar()[2] + "日");
            }
        });
    }

    @Override
    public void createEvent() {

    }



    @OnClick({R.id.calendar_img_last, R.id.calendar_img_next, R.id.header_img_goback})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.calendar_img_last:
                mCalendar.lastMonth();
                break;
            case R.id.calendar_img_next:
                mCalendar.nextMonth();
                break;
            case R.id.header_img_goback:
                finish();
                break;
        }
    }
}
