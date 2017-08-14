package com.bwie.xiaodao.view.utlis;

import android.os.Handler;
import android.os.Message;

import com.bwie.xiaodao.view.utlis.inet.INet;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 类描述：
 * 创建人：guodongdong
 * 创建时间：2017/8/10
 */
public class NetUtil<T> {

    private INet mINet;
    private static volatile NetUtil instance = null;
    private int TAG;

    private Handler hanlder = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    mINet.onSuccess(msg.obj,TAG);
                    break;
            }
        }
    };


    private NetUtil() {

    }

    //单例
    public static NetUtil getInstance() {
        if (instance == null) {
            synchronized (NetUtil.class) {
                if (instance == null) {
                    instance = new NetUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 网络请求GET方法
     *
     * @param url
     * @param iNet
     */
    public <T>void getDataFromServer(String url, final INet iNet, final Class<T> tClass) {
        mINet = iNet;

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mINet.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();

                Gson gson = new Gson();
                T t = gson.fromJson(result, tClass);
                Message msg = hanlder.obtainMessage();
                msg.what = 0;
                msg.obj = t;
                hanlder.sendMessage(msg);
            }
        });
    }

    public <T> void postDataFromServer(String url, Map<String, Object> map, final INet iNet, final Class<T> tClass,String header,int tag) {
        mINet = iNet;
        TAG = tag;
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            builder.add(entry.getKey(), entry.getValue().toString());
        }
        RequestBody body = builder.build();
        final Request request = new Request.Builder()
                .addHeader("token",header)
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mINet.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String result = response.body().string();
                Gson gson = new Gson();
                T t = gson.fromJson(result, tClass);
                Message msg = hanlder.obtainMessage();
                msg.what = 0;
                msg.obj = t;
                hanlder.sendMessage(msg);
            }
        });
    }
}
