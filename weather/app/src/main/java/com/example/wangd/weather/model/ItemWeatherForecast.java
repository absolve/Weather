package com.example.wangd.weather.model;

/**
 * 天气预报使用的数据 数据没有带单位
 */
public class ItemWeatherForecast {
    private String weather_description;  //天气描述
    private String icon;     //图标
    private String date;   //日期
    private String min_temp; //最小温度
    private String max_temp; //最大温度
    private String wind; //风速
    private String pressure; //气压
    private String humidity; //湿度

    public String getWeather_description() {
        return weather_description;
    }

    public void setWeather_description(String weather_description) {
        this.weather_description = weather_description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(String min_temp) {
        this.min_temp = min_temp;
    }

    public String getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(String max_temp) {
        this.max_temp = max_temp;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

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

    @Override
    public String toString() {
        return "ItemWeatherForecast{" +
                "weather_description='" + weather_description + '\'' +
                ", icon='" + icon + '\'' +
                ", date='" + date + '\'' +
                ", min_temp='" + min_temp + '\'' +
                ", max_temp='" + max_temp + '\'' +
                ", wind='" + wind + '\'' +
                ", pressure='" + pressure + '\'' +
                ", humidity='" + humidity + '\'' +
                '}';
    }
}
