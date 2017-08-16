package com.bwie.xiaodao.view.utlis;

/**
 * Created by 雨夜 on 2017/8/14.
 */

public class UrlUtil {

    public static final String BASE_URL = "http://123.57.33.185:8088";

    public static final String REBATE_RECORD_QUERY_URL = BASE_URL+"/cashback/list?status=1";//返利记录查询

    public static final String STATISTICAL_INFORMATION_URL = BASE_URL+"/cashback/countCashback?status=1";//统计信息

    public static final String REBATE_PROGRAM_URL = BASE_URL+"/user/cashback/plan";//返利计划

    public static final String CREDITS_LOG_URL = BASE_URL+"/user/intergral/records";//积分记录


    public static final String CITY_URL = BASE_URL+"/findAllCityList"; //城市切换


    public static final String GOODS_SHOW_URL = BASE_URL+"/findShopById"; //城市切换






}
