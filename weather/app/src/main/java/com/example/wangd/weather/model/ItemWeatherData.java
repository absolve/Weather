package com.example.wangd.weather.model;

/**
 * 当前天气情况数据没有带单位
 */
public class ItemWeatherData {
    private String pressure; //气压
    private String humidity; //湿度
    private String temp; //温度
    private String temp_min; //最低气温
    private String temp_max; //最高气温
    private String visibility;
    private String wind_speed; //风速
    private String wind_deg; //风向
    private String clouds_all; //云朵
    private String country; //位置信息
    private String sunrise,sunset; //日出和日落时间
    private String weather_main; //天气的描述
    private String weather_icon; //所使用的天气图标
    private String weather_img; //需要显示的天气图片
    private String current_day_week; //当前星期

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(String temp_min) {
        this.temp_min = temp_min;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(String temp_max) {
        this.temp_max = temp_max;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(String wind_speed) {
        this.wind_speed = wind_speed;
    }

    public String getWind_deg() {
        return wind_deg;
    }

    public void setWind_deg(String wind_deg) {
        this.wind_deg = wind_deg;
    }

    public String getClouds_all() {
        return clouds_all;
    }

    public void setClouds_all(String clouds_all) {
        this.clouds_all = clouds_all;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getWeather_main() {
        return weather_main;
    }

    public void setWeather_main(String weather_main) {
        this.weather_main = weather_main;
    }

    public String getWeather_icon() {
        return weather_icon;
    }

    public void setWeather_icon(String weather_icon) {
        this.weather_icon = weather_icon;
    }

    public String getWeather_img() {
        return weather_img;
    }

    public void setWeather_img(String weather_img) {
        this.weather_img = weather_img;
    }

    public String getCurrent_day_week() {
        return current_day_week;
    }

    public void setCurrent_day_week(String current_day_week) {
        this.current_day_week = current_day_week;
    }

    @Override
    public String toString() {
        return "ItemWeatherData{" +
                "pressure='" + pressure + '\'' +
                ", humidity='" + humidity + '\'' +
                ", temp='" + temp + '\'' +
                ", temp_min='" + temp_min + '\'' +
                ", temp_max='" + temp_max + '\'' +
                ", visibility='" + visibility + '\'' +
                ", wind_speed='" + wind_speed + '\'' +
                ", wind_deg='" + wind_deg + '\'' +
                ", clouds_all='" + clouds_all + '\'' +
                ", country='" + country + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                ", weather_main='" + weather_main + '\'' +
                ", weather_icon='" + weather_icon + '\'' +
                ", weather_img='" + weather_img + '\'' +
                ", current_day_week='" + current_day_week + '\'' +
                '}';
    }
}
