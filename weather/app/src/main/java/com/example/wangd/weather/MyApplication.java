package com.example.wangd.weather;

import android.app.Application;

import com.loopj.android.http.AsyncHttpClient;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import utils.HttpUtil;
import utils.Httpclient;

/** Application
 * Created by wangd on 2016/4/17.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AsyncHttpClient client = new AsyncHttpClient();
        Httpclient.setHttpClient(client);
        OkHttpClient client1 = new OkHttpClient.Builder()
                .connectTimeout(35, TimeUnit.SECONDS)
                .writeTimeout(35, TimeUnit.SECONDS)
                .readTimeout(35, TimeUnit.SECONDS)
                .build();
        HttpUtil.setClient(client1);
    }
}
