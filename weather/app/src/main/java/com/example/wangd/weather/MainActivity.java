package com.example.wangd.weather;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.loopj.android.http.TextHttpResponseHandler;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import adapter.WeatherAdapter;
import cz.msebera.android.httpclient.Header;
import events.GetCurrWeatherMsgEvent;
import events.GetForecastEvent;
import events.LocationEvent;
import model.CurrWeatherData;
import model.ForecastData;
import model.ItemWeatherForecast;
import model.WeatherForecastData;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import pub.devrel.easypermissions.EasyPermissions;
import utils.DataUtils;
import utils.HttpUtil;
import utils.Httpclient;

/**
 * Created by wangd on 2016/4/13.
 * 主界面
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        SwipeRefreshLayout.OnRefreshListener, EasyPermissions.PermissionCallbacks {
    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明mLocationOption对象
    public AMapLocationClientOption mLocationOption;
    //列表
    public RecyclerView recyclerView;
    //获取天气按钮
    private Button btn, wf;
    private WeatherResponse response;
    private WFResponse wfResponse;
    //    private MainView mainview;
//    private WeatherForecastData weatherForecastData;
    private ForecastData forecastData;
    //    private AdView adView;
    //定位后的位置
    private LocationEvent tempLocation = null;
    //列表适配器
    private WeatherAdapter adapter;
    //下拉刷新view
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        response = new WeatherResponse();
        wfResponse = new WFResponse();
        btn = findViewById(R.id.weather);
        btn.setBackgroundResource(R.drawable.yuanjiao_style_01);
        wf = findViewById(R.id.wf);
        btn.setOnClickListener(this);
        wf.setOnClickListener(this);
        //下拉刷新
        swipeRefreshLayout = findViewById(R.id.srLayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.blue);
        swipeRefreshLayout.setOnRefreshListener(this);
        //事件处理
        EventBus.getDefault().register(this);
        //列表
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        adapter = new WeatherAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        //设置刷新开启
//        swipeRefreshLayout.setRefreshing(true);
        //获取权限
        checkPermission();
        //初始化定位功能
        initLocationClient();
        //开始定位
        mLocationClient.startLocation();
//        HttpUtil.getCurrweather("beijing", new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                if (response.isSuccessful()) {
//                    Log.d("--", response.body().string());
//                }
//            }
//        });
    }

    /**
     * 检查权限
     */
    public void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions();
        }
    }

    /**
     * 请求相应的权限
     */
    public void requestPermissions() {
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        if (!EasyPermissions.hasPermissions(this, perms)) {
            EasyPermissions.requestPermissions(this,
                    "需要允许以下权限程序才能正常运行：\n存储数据权限，定位权限", 1, perms);
        }
    }

    /**
     * 初始化定位
     */
    public void initLocationClient() {
        //初始化定位
        mLocationClient = new AMapLocationClient(this);
        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(false);
        //设置是否强制刷新WIFI，默认为强制刷新
        mLocationOption.setWifiActiveScan(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(10000);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.weather) {
//            Httpclient.getCurrweather("fuzhou", response);
            HttpUtil.getForecastOW("fuzhou", "zh-cn", new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                }
            });
        } else if (v.getId() == R.id.wf) {
//            Httpclient.getXZForecast("fuzhou","en",wfResponse);
//            if (tempLocation == null) {
//                return;
//            }
//            Httpclient.getHFForecast(tempLocation.cityName, wfResponse);
            HttpUtil.getForecastOW("fuzhou", "zh_cn", new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    if (response.isSuccessful()) {
//                    Log.d("--", response.body().string());
                        Gson gson = new Gson();
                        try {
                            WeatherForecastData data = gson.fromJson(response.body().string(), WeatherForecastData.class);
                            Log.d("--",data.toString());
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                }
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mLocationClient != null) {
            mLocationClient.onDestroy();
        }
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    /**
     * 获取当前天气的回调
     *
     * @param event 事件
     */
    @Subscribe
    public void onEvent(GetCurrWeatherMsgEvent event) {
//        Log.d("----", event.data.getMain().getSea_level() + "");
        if (event.flag == 0 && event.data != null) {
            adapter.setCurrWeatherData(event.getItemCurrWeatherData());
        } else {
            Toast.makeText(this, "获取当前天气失败", Toast.LENGTH_SHORT).show();
        }
        //停止刷新
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    /**
     * 获取天气预报
     *
     * @param event 事件
     */
    @Subscribe
    public void onEvent(GetForecastEvent event) {
        if (event.flag == 0) {
            adapter.setForecastsList(event.data);
        } else {
            Toast.makeText(this, "获取预报失败", Toast.LENGTH_SHORT).show();
        }
        //停止刷新
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    /**
     * 定位消息
     *
     * @param event 事件
     */
    @Subscribe
    public void onEvent(LocationEvent event) {
        mLocationClient.stopLocation();
        if (event.flag == 0) {
            //定位成功,请求数据
            if (event.country.equals("中国")) {
                Httpclient.getCurrweather(event.Latitude + "",
                        event.Longitude + "", "zh_cn", response);
            } else {
                Httpclient.getCurrweather(event.Latitude + "",
                        event.Longitude + "", response);
            }
            //获取天气预报
            Httpclient.getHFForecast(event.cityName, wfResponse);
            //保存当前的位置
            tempLocation = event;
        } else {
            Toast.makeText(this, "定位失败", Toast.LENGTH_SHORT).show();
            //停止刷新
            if (swipeRefreshLayout.isRefreshing()) {
                swipeRefreshLayout.setRefreshing(false);
            }
        }
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        //如果已经定位过
        if (tempLocation == null) {
            if (!mLocationClient.isStarted()) {
                mLocationClient.startLocation();
            }
        } else {
            //获取当前天气
            if (tempLocation.country.equals("中国")) {
                Httpclient.getCurrweather(tempLocation.Latitude + "",
                        tempLocation.Longitude + "", "zh_cn", response);
            } else {
                Httpclient.getCurrweather(tempLocation.Latitude + "",
                        tempLocation.Longitude + "", response);
            }
            //获取天气预报
            Httpclient.getHFForecast(tempLocation.cityName, wfResponse);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }


    /**
     * 当前天气的回调
     */
    private class WeatherResponse extends TextHttpResponseHandler {
        @Override
        public void onSuccess(int statusCode, Header[] headers, String responseBody) {
            Log.i("------", responseBody);
            Gson gson = new Gson();
            CurrWeatherData currWeatherData = null;
            try {
                //转化成类
                currWeatherData = gson.fromJson(responseBody, CurrWeatherData.class);
            } catch (JsonSyntaxException e) {
                Log.d("---", e.toString());
            }
            EventBus.getDefault().post(new GetCurrWeatherMsgEvent(currWeatherData, 0));
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, String responseBody, Throwable error) {
            if (error != null) {
                Log.e("----", error.toString());
            }
            EventBus.getDefault().post(new GetCurrWeatherMsgEvent(null, 1));
        }
    }

    /**
     * 天气预报回调
     */
    private class WFResponse extends TextHttpResponseHandler {
        @Override
        public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
            if (throwable != null) {
                Log.e("----", throwable.toString());
            }
            EventBus.getDefault().post(new GetForecastEvent(null, 1));
        }

        @Override
        public void onSuccess(int statusCode, Header[] headers, String responseString) {
            Log.d("----", responseString);
            Gson gson = new Gson();
            List<ItemWeatherForecast> list = null;
            int flag = 0;
            try {
                forecastData = gson.fromJson(responseString, ForecastData.class);
                String status = forecastData.HeWeather_data_service.get(0).status;
                Log.d("----", status);
                if (!status.equals("ok")) {
                    flag = 1;
                }
                list = DataUtils.getItemForecast(forecastData.HeWeather_data_service.get(0).daily_forecast);
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                Log.d("error", e.getMessage());
            }
            EventBus.getDefault().post(new GetForecastEvent(list, flag));
        }
    }

    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation != null) {
                if (aMapLocation.getErrorCode() == 0) {
                    //定位成功回调信息，设置相关消息
                    Log.d("-----getLatitude------", aMapLocation.getLatitude() + "");
                    Log.d("------getLongitude-----", aMapLocation.getLongitude() + "");
                    Log.d("---getCountry-----", "getCountry" + aMapLocation.getCountry());
//                    Log.i("------------", aMapLocation.toString());
                    Log.i("----getCity----", aMapLocation.getCity());
                    String city = aMapLocation.getCity();
                    if (aMapLocation.getCountry().equals("中国")) {
                        city = city.substring(0, city.length() - 1);
                    }
//                    Log.i("----getCityCode-----", aMapLocation.getCityCode());
//                    Log.i("------getAdCode-------", aMapLocation.getAdCode());
                    EventBus.getDefault().post(new LocationEvent(aMapLocation.getLatitude(),
                            aMapLocation.getLongitude(), city, aMapLocation.getCountry(), 0));
                } else {
                    //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                    Log.e("AmapError", "location Error, ErrCode:"
                            + aMapLocation.getErrorCode() + ", errInfo:"
                            + aMapLocation.getErrorInfo());
                    EventBus.getDefault().post(new LocationEvent(-1, -1, "none", "none", 1));
                }
            }
        }
    };
}
