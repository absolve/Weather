package com.example.wangd.weather.events;

import java.util.List;

import com.example.wangd.weather.model.WeatherData;
import com.example.wangd.weather.model.ItemWeatherData;
import com.example.wangd.weather.utils.DataUtils;

/**
 * Created by wangd on 2016/7/17.
 * 获取当前天气事件
 */
public class GetWeatherMsgEvent {
    @Deprecated
    public GetWeatherMsgEvent(WeatherData data, int flag) {
        this.data = data;
        this.flag = flag;
        if (data == null) {
            return;
        }
        //设置列表所需要的数据
        weatherData = new ItemWeatherData();
        WeatherData.MainBean mainBean = this.data.getMain();
        WeatherData.WindBean windBean = this.data.getWind();
        WeatherData.CloudsBean cloudsBean = this.data.getClouds();
        WeatherData.SysBean sysBean = this.data.getSys();
        List<WeatherData.WeatherBean> weatherBean = this.data.getWeather();
        weatherData.setPressure(String.valueOf(mainBean.getPressure()));
        weatherData.setHumidity(String.valueOf(mainBean.getHumidity()));
        weatherData.setTemp(DataUtils.getK2C(mainBean.getTemp()));
        weatherData.setTemp_min(DataUtils.getK2C(mainBean.getTemp_min()));
        weatherData.setTemp_max(DataUtils.getK2C(mainBean.getTemp_max()));
        weatherData.setWind_speed(String.valueOf(windBean.getSpeed()));
        weatherData.setClouds_all(String.valueOf( cloudsBean.getAll() ));
        weatherData.setCountry(this.data.getName() + "," + sysBean.getCountry());
        weatherData.setSunrise(DataUtils.getTime(sysBean.getSunrise()));
        weatherData.setSunset(DataUtils.getTime(sysBean.getSunset()));
        weatherData.setCurrent_day_week(DataUtils.getWeek(true));
        weatherData.setWind_deg(DataUtils.getWindDeg(windBean.getDeg(),true));
        //返回天气信息列表
        if (weatherBean.size() != 0) {
            weatherData.setWeather_main(weatherBean.get(0).getDescription());
            weatherData.setWeather_icon(weatherBean.get(0).getIcon());
        }

    }

    public GetWeatherMsgEvent(ItemWeatherData data, int flag){
        weatherData = data;
        this.flag = flag;
    }
    public GetWeatherMsgEvent(int flag){
        this.flag = flag;
    }

    public int flag; //0为成功，1 为失败
    public WeatherData data; //服务器返回的json对象
    private ItemWeatherData weatherData = null; //item使用的对象

    public ItemWeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(ItemWeatherData weatherData) {
        this.weatherData = weatherData;
    }
}
