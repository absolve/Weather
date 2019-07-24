package com.example.wangd.weather;

import android.app.Application;

import com.loopj.android.http.AsyncHttpClient;

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
    }
}
