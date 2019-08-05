package com.example.wangd.weather;

import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
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
import com.example.wangd.weather.views.SimpleItemDecoration;
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
    public View toolbar; //工具栏
    public SwipeRefreshLayout srLayout; //下拉刷新
    public ImageView iv_weatherImg; //天气图片
    public TextView tv_temperature, tv_tempdec, tv_windspeed, tv_humidity,
            tv_wind_dt, tv_sunrise, tv_sunset; //温度 天气 风速 湿度 风向 日出 日落
    public RecyclerView rv_forecast;//天气预报
    private ItemAdapter adapter; //适配器
    private List<ItemWeatherForecast> data; //天气预报数据
    private String lang = "zh_cn"; //语言
    private int cOrk = 0; //0是显示摄氏度 1是显示开氏度 2显示华氏度
    public ImageView iv_more,iv_loc; //更多的按钮 定位
    private PopupWindow popupWindow;  //弹出框

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar = findViewById(R.id.toolbar);
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
        iv_more = findViewById(R.id.iv_more);
        iv_more.setOnClickListener(this);
        iv_loc = findViewById(R.id.iv_loc);
        iv_loc.setOnClickListener(this);
        rv_forecast = findViewById(R.id.rv_forecast);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_forecast.setLayoutManager(linearLayoutManager);
//        rv_forecast.addItemDecoration(new SimpleItemDecoration(this));
        data = new ArrayList<>();
        adapter = new ItemAdapter(this, data);
        rv_forecast.setAdapter(adapter);
    }

    /**
     * 显示弹出框
     */
    public void showPopupWindow(){
        if(popupWindow==null){
            LayoutInflater layoutInflater = LayoutInflater.from(this);
            View view = layoutInflater.inflate(R.layout.popup_window, null);
            view.findViewById(R.id.tv_about).setOnClickListener(this);//关于的按钮
            popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setFocusable(true);

            int offx = getResources().getDimensionPixelOffset(R.dimen.item_5dp);
            int offy=offx;
            int statusbar = getResources().getIdentifier("status_bar_height",
                    "dimen", "android"); //状态栏
            if(statusbar>0){
                offy+= getResources().getDimensionPixelSize(statusbar);
            }
            popupWindow.showAtLocation(toolbar,Gravity.TOP|Gravity.END,offx,offy);
        }else{
            int offx = getResources().getDimensionPixelOffset(R.dimen.item_5dp);
            int offy=offx;
            int statusbar = getResources().getIdentifier("status_bar_height",
                    "dimen", "android"); //状态栏
            if(statusbar>0){
                offy+= getResources().getDimensionPixelSize(statusbar);
            }
            popupWindow.showAtLocation(toolbar,Gravity.TOP|Gravity.END,offx,offy);
        }
    }

    /**
     * 显示提示信息
     * @param msg  信息
     * @param time 时间  0是短暂 1是较长
     */
    public void showToast(String msg,int time){
        if(time==0){
            Snackbar.make(toolbar, msg, Snackbar.LENGTH_SHORT).show();
        }else if(time==1){
            Snackbar.make(toolbar, msg, Snackbar.LENGTH_LONG).show();
        }
    }

    /**
     * 获取天气信息
     * @param cityname 城市名字
     */
    public void getWeatherData(String cityname){
        //当前天气
        HttpUtil.getCurrweatherOW(cityname, lang, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                EventBus.getDefault().post(new GetWeatherMsgEvent(1));
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    try {
                        String str = response.body().string();
                        Log.d("--", str);
                        Gson gson = new Gson();
                        WeatherData data = gson.fromJson(str, WeatherData.class);
                        ItemWeatherData temp = DataUtils.getItemWeather(data, lang);
                        EventBus.getDefault().post(new GetWeatherMsgEvent(temp, 0));
                    } catch (Exception e) {
                        e.printStackTrace();
                        EventBus.getDefault().post(new GetWeatherMsgEvent(1));
                    }
                }
            }
        });
    }

    /**
     * 获取天气预报
     * @param cityname 城市名字
     */
    public void getForecastData(String cityname){
        HttpUtil.getForecastOW(cityname, lang, new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    try {
                        Gson gson = new Gson();
                        String str = response.body().string();
                        Log.d("-onResponse-", str);
                        WeatherForecastData data = gson.fromJson(str, WeatherForecastData.class);
                        List<ItemWeatherForecast> list = DataUtils.getItemForecast(data, lang);
                        EventBus.getDefault().post(new GetForecastEvent(list, 0));
                    }catch (Exception e){
                        e.printStackTrace();
                        EventBus.getDefault().post(new GetForecastEvent(null, 1));
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                EventBus.getDefault().post(new GetForecastEvent(null, 1));
            }
        });
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
            showToast("获取成功",0);
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
                        weatherData.getWind_speed(),
                        DataUtils.getWindSpeed(weatherData.getWind_speed(),true));
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
                        weatherData.getWind_speed(),
                        DataUtils.getWindSpeed(weatherData.getWind_speed(),false));
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
        }else{
            showToast("获取当前天气失败",1);
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
        }else{
            showToast("获取天气预报失败",1);
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
        if(view.getId()==R.id.iv_more){ //更多
            showPopupWindow();
        }else if(view.getId()==R.id.tv_about){ //关于按钮
            if(popupWindow!=null&&popupWindow.isShowing()){
                popupWindow.dismiss();
            }
            new AlertDialog.Builder(this).setTitle("关于").
                    setMessage(getResources().getString(R.string.text_info)).show();
        }
//        Snackbar.make(view, "hello", Snackbar.LENGTH_SHORT).show();
    }

    /**
     * 刷新事件
     */
    @Override
    public void onRefresh() {
        //当前天气
        getWeatherData("fuzhou");

        //天气预报
        getForecastData("fuzhou");
    }
}
