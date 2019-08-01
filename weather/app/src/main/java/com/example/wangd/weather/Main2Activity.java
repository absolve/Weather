package com.example.wangd.weather;

import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wangd.weather.adapter.ItemAdapter;
import com.example.wangd.weather.events.GetWeatherMsgEvent;
import com.example.wangd.weather.events.GetForecastEvent;
import com.example.wangd.weather.events.LocationEvent;
import com.example.wangd.weather.model.WeatherData;
import com.example.wangd.weather.model.ItemWeatherData;
import com.example.wangd.weather.model.ItemWeatherForecast;
import com.example.wangd.weather.model.WeatherForecastData;
import com.example.wangd.weather.utils.DataUtils;
import com.example.wangd.weather.utils.HttpUtil;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 主界面
 */
public class Main2Activity extends AppCompatActivity implements View.OnClickListener,
        SwipeRefreshLayout.OnRefreshListener {

    public Button btn_show;
    public SwipeRefreshLayout srLayout; //下拉刷新
    public ImageView iv_weatherImg; //天气图片
    public TextView tv_temperature, tv_tempdec, tv_windspeed, tv_humidity,
            tv_wind_dt, tv_sunrise, tv_sunset; //温度 天气 风速 湿度 风向 日出 日落
    public RecyclerView rv_forecast;//天气预报
    private ItemAdapter adapter; //适配器
    private List<ItemWeatherForecast> data; //天气预报数据
    private String lang = "zh_cn"; //语言
    private int cOrk = 0; //0是显示摄氏度 1是显示开氏度

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        srLayout = findViewById(R.id.srLayout);
        srLayout.setColorSchemeResources(R.color.blue);
        srLayout.setOnRefreshListener(this);
        iv_weatherImg = findViewById(R.id.iv_weatherImg);
        tv_temperature = findViewById(R.id.tv_temperature);
        tv_tempdec = findViewById(R.id.tv_tempdec);
        tv_windspeed = findViewById(R.id.tv_windspeed);
        tv_humidity = findViewById(R.id.tv_humidity);
        tv_wind_dt = findViewById(R.id.tv_wind_dt);
        tv_sunrise = findViewById(R.id.tv_sunrise);
        tv_sunset = findViewById(R.id.tv_sunset);
        rv_forecast = findViewById(R.id.rv_forecast);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_forecast.setLayoutManager(linearLayoutManager);

        data = new ArrayList<>();
        adapter = new ItemAdapter(this, data);
        rv_forecast.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //事件处理
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 获取当前天气的事件
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(GetWeatherMsgEvent event) {
        if (event.flag == 0) {
            ItemWeatherData weatherData = event.getWeatherData(); //天气数据
            iv_weatherImg.setImageResource(DataUtils.getWeatherImg(weatherData.getWeather_icon(),false));
            if (cOrk == 0) { //摄氏度
                String temp = String.format(getResources().getString(R.string.text_celsius),
                        weatherData.getTemp());
                tv_temperature.setText(temp);  //温度
            } else {
                String temp = String.format(getResources().getString(R.string.text_kelvin),
                        weatherData.getTemp());
                tv_temperature.setText(temp);  //温度
            }
            tv_tempdec.setText(weatherData.getWeather_main()); //天气情况
            if (lang.contentEquals("zh_cn")) {
                String winspeed = String.format(getResources().getString(R.string.text_wind_zh),
                        weatherData.getWind_speed());
                tv_windspeed.setText(winspeed); //风速
                String humidity = String.format(getResources().getString(R.string.text_humidity_zh),
                        weatherData.getHumidity() + "%");
                tv_humidity.setText(humidity); //湿度
                String wind_deg = String.format(getResources().getString(R.string.text_wind_direction_zh)
                        , weatherData.getWind_deg());
                tv_wind_dt.setText(wind_deg);  //风向
                String sunrise = String.format(getResources().getString(R.string.text_sunrise_zh),
                        weatherData.getSunrise());
                tv_sunrise.setText(sunrise); //日出
                String sunset = String.format(getResources().getString(R.string.text_sunset_zh),
                        weatherData.getSunset());
                tv_sunset.setText(sunset); //日落
            } else {
                String winspeed = String.format(getResources().getString(R.string.text_wind),
                        weatherData.getWind_speed());
                tv_windspeed.setText(winspeed); //风速
                String humidity = String.format(getResources().getString(R.string.text_humidity),
                        weatherData.getHumidity() + "%");
                tv_humidity.setText(humidity);//湿度
                String wind_deg = String.format(getResources().getString(R.string.text_wind_direction_zh)
                        , weatherData.getWind_deg());
                tv_wind_dt.setText(wind_deg);  //风向
                String sunrise = String.format(getResources().getString(R.string.text_sunrise),
                        weatherData.getSunrise());
                tv_sunrise.setText(sunrise);//日出
                String sunset = String.format(getResources().getString(R.string.text_sunset),
                        weatherData.getSunset());
                tv_sunset.setText(sunset);//日落
            }
        }
        //停止刷新
        if (srLayout.isRefreshing()) {
            srLayout.setRefreshing(false);
        }
    }

    /**
     * 获取天气预报
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(GetForecastEvent event) {
        if (event.flag == 0) {
            Log.d("---", event.data.toString());
            adapter.addData(event.data); //设置数据
        }
        //停止刷新
        if (srLayout.isRefreshing()) {
            srLayout.setRefreshing(false);
        }
    }

    /**
     * 定位消息
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(LocationEvent event) {

    }

    @Override
    public void onClick(View view) {
        Snackbar.make(view, "hello", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        //当前天气
        HttpUtil.getCurrweatherOW("fuzhou", lang, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                EventBus.getDefault().post(new GetWeatherMsgEvent(1));
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String str = response.body().string();
                    Log.d("--", str);
                    Gson gson = new Gson();
                    try {
                        WeatherData data = gson.fromJson(str, WeatherData.class);
                        ItemWeatherData temp = DataUtils.getItemWeather(data, lang);
                        EventBus.getDefault().post(new GetWeatherMsgEvent(temp, 0));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //天气预报
        HttpUtil.getForecastOW("fuzhou", lang, new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    Gson gson = new Gson();
                    String str = response.body().string();
                    Log.d("-onResponse-", str);
                    WeatherForecastData data = gson.fromJson(str, WeatherForecastData.class);
                    List<ItemWeatherForecast> list = DataUtils.getItemForecast(data, lang);
                    EventBus.getDefault().post(new GetForecastEvent(list, 0));
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                EventBus.getDefault().post(new GetForecastEvent(null, 1));
            }
        });

    }
}
