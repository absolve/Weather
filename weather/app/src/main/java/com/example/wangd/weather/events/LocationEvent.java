package com.example.wangd.weather.events;

/** 定位事件
 * Created by wangd on 2016/7/26.
 */
public class LocationEvent {
    public  double Latitude; //纬度
    public  double Longitude; //经度
    public  String cityName; //城市名
    public String country; //国家
    public  int flag; //0 成功 1失败
    public LocationEvent(double latitude, double longitude,String cityName,
                         String country,int flag) {
        Latitude = latitude;
        Longitude = longitude;
        this.flag = flag;
        this.cityName = cityName;
        this.country =country;
    }
}
