package com.example.wangd.weather.events;

import java.util.List;

import com.example.wangd.weather.model.CurrWeatherData;
import com.example.wangd.weather.model.ItemCurrWeatherData;
import com.example.wangd.weather.utils.DataUtils;

/**
 * Created by wangd on 2016/7/17.
 * 获取当前天气事件
 */
public class GetCurrWeatherMsgEvent {
    public GetCurrWeatherMsgEvent(CurrWeatherData data, int flag) {
        this.data = data;
        this.flag = flag;
        if (data == null) {
            return;
        }
        //设置列表所需要的数据
        itemCurrWeatherData = new ItemCurrWeatherData();
        CurrWeatherData.MainBean mainBean = this.data.getMain();
        CurrWeatherData.WindBean windBean = this.data.getWind();
        CurrWeatherData.CloudsBean cloudsBean = this.data.getClouds();
        CurrWeatherData.SysBean sysBean = this.data.getSys();
        List<CurrWeatherData.WeatherBean> weatherBean = this.data.getWeather();
        itemCurrWeatherData.pressure = mainBean.getPressure() + "hpa";
        itemCurrWeatherData.humidity = mainBean.getHumidity() + "%";
        itemCurrWeatherData.temp = DataUtils.getK2C(mainBean.getTemp());
        itemCurrWeatherData.temp_min = DataUtils.getK2C(mainBean.getTemp_min());
        itemCurrWeatherData.temp_max = DataUtils.getK2C(mainBean.getTemp_max());
        itemCurrWeatherData.wind_speed = windBean.getSpeed() + "m/s";
        itemCurrWeatherData.clouds_all = cloudsBean.getAll() + "%";
        itemCurrWeatherData.country = this.data.getName() + "," + sysBean.getCountry();
        itemCurrWeatherData.sunrise = DataUtils.getTime(sysBean.getSunrise());
        itemCurrWeatherData.sunset = DataUtils.getTime(sysBean.getSunset());
        itemCurrWeatherData.current_day_week = DataUtils.getWeek(true);
        itemCurrWeatherData.wind_deg = DataUtils.getWindDeg(windBean.getDeg());
        //返回天气信息列表
        if (weatherBean.size() != 0) {
            itemCurrWeatherData.weather_main = weatherBean.get(0).getDescription();
            itemCurrWeatherData.weather_icon = weatherBean.get(0).getIcon();
        }

    }

    public int flag; //0为成功，1 为失败
    public CurrWeatherData data; //服务器返回的json对象
    private ItemCurrWeatherData itemCurrWeatherData = null; //item使用的对象

    public ItemCurrWeatherData getItemCurrWeatherData() {
        return itemCurrWeatherData;
    }

    public void setItemCurrWeatherData(ItemCurrWeatherData itemCurrWeatherData) {
        this.itemCurrWeatherData = itemCurrWeatherData;
    }
}
