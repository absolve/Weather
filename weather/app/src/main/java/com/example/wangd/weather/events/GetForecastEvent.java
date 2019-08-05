package com.example.wangd.weather.events;

import java.util.List;

import com.example.wangd.weather.model.ItemWeatherForecast;

/** 获取天气预报的事件
 * Created by wangd on 2016/7/29.
 */
public class GetForecastEvent {
    public int flag; //0 为成功 1 为失败
    public List<ItemWeatherForecast> data;

    public GetForecastEvent( List<ItemWeatherForecast> data,int flag) {
        this.flag = flag;
        this.data = data;
    }
}
