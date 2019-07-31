package com.example.wangd.weather.utils;

import com.example.wangd.weather.R;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import com.example.wangd.weather.model.WeatherData;
import com.example.wangd.weather.model.ForecastData.HeWeatherDataServiceBean.DailyForecastBean;
import com.example.wangd.weather.model.ItemWeatherData;
import com.example.wangd.weather.model.ItemWeatherForecast;
import com.example.wangd.weather.model.WeatherForecastData;
import com.example.wangd.weather.model.WeatherForecastData.ListBean;

/**
 * 数据的处理
 * Created by wangd on 2016/6/15.
 */
public class DataUtils {

    /**
     * utc时间转换成本地时间，本地时间根据手机默认设置
     *
     * @param dt utc 时间
     * @return 当地时间
     */
    public static String getTime(Long dt) {
//        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        DateFormat format = new SimpleDateFormat("HH:mm", Locale.getDefault());
        Long time = dt * 1000;
        return format.format(time);
    }

    /**
     * 从utf中获取月份日期
     *
     * @param dt
     * @return
     */
    public static String getMonth(Long dt) {
        DateFormat format = new SimpleDateFormat("MM-dd", Locale.getDefault());
        Long time = dt * 1000;
        return format.format(time);
    }

    public static String getDate(String dt) {
        SimpleDateFormat format = (SimpleDateFormat) SimpleDateFormat.getDateTimeInstance();
        format.applyPattern("yyyy-MM-dd");
        format.setTimeZone(TimeZone.getDefault());
        String str;
        try {
            Date date = format.parse(dt);
            Calendar calendar = format.getCalendar();
            calendar.setTime(date);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            str = month + "-" + day;
        } catch (ParseException e) {
            e.printStackTrace();
            str = "date error";
        }
        return str;
    }

    //    public static String getCurrTime() {
//        DateFormat format = new SimpleDateFormat("HH:mm:ss");
//        return format.format(System.currentTimeMillis());
//    }
    @Deprecated
    public static List<ItemWeatherForecast> getItemForecast(List<DailyForecastBean> data) {
        List<ItemWeatherForecast> list = new ArrayList<ItemWeatherForecast>();
        //选取未来4天的预报
        for (int i = 1; i < 5; i++) {
            DailyForecastBean bean = data.get(i);
            ItemWeatherForecast item = new ItemWeatherForecast();
            item.setMin_temp(bean.tmp.min);
            item.setMax_temp(bean.tmp.max + "°C");
            //选择白天的天气状况
            item.setWeather_description(bean.cond.txt_d);
            item.setDate(getDate(bean.date));
            item.setIcon(bean.cond.code_d);
            list.add(item);
        }
        return list;
    }

    /**
     * 从当前天气中获取需要显示的数据
     *
     * @param data 数据
     * @param lang zh_cn en语言
     * @return
     */
    public static ItemWeatherData getItemWeather(WeatherData data, String lang) {
        WeatherData.MainBean mainBean = data.getMain();
        WeatherData.WindBean windBean = data.getWind();
        WeatherData.CloudsBean cloudsBean = data.getClouds();
        WeatherData.SysBean sysBean = data.getSys();
        List<WeatherData.WeatherBean> weatherBean = data.getWeather();
        ItemWeatherData WeatherData = new ItemWeatherData();
        WeatherData.setPressure(String.valueOf(mainBean.getPressure()));
        WeatherData.setHumidity(String.valueOf(mainBean.getHumidity()));
        WeatherData.setTemp(DataUtils.getK2C(mainBean.getTemp()));
        WeatherData.setTemp_min(DataUtils.getK2C(mainBean.getTemp_min()));
        WeatherData.setTemp_max(DataUtils.getK2C(mainBean.getTemp_max()));
        WeatherData.setWind_speed(String.valueOf(windBean.getSpeed()));
        WeatherData.setClouds_all(String.valueOf(cloudsBean.getAll()));
        WeatherData.setCountry(data.getName() + "," + sysBean.getCountry());
        WeatherData.setSunrise(DataUtils.getTime(sysBean.getSunrise()));
        WeatherData.setSunset(DataUtils.getTime(sysBean.getSunset()));
        if (lang.contentEquals("zh_cn")) {
            WeatherData.setCurrent_day_week(DataUtils.getWeek(true));
            WeatherData.setWind_deg(DataUtils.getWindDeg(windBean.getDeg(), true));
        } else {
            WeatherData.setCurrent_day_week(DataUtils.getWeek(false));
            WeatherData.setWind_deg(DataUtils.getWindDeg(windBean.getDeg(), false));
        }
        if (weatherBean.size() != 0) {//返回天气信息列表
            WeatherData.setWeather_main(weatherBean.get(0).getDescription());
            WeatherData.setWeather_icon(weatherBean.get(0).getIcon());
        }
        return WeatherData;
    }


    /**
     * 从天气预报中获取适配器上显示的数据
     *
     * @param data
     * @param lang zh_cn en 语言
     * @return
     */
    public static List<ItemWeatherForecast> getItemForecast(WeatherForecastData data, String lang) {
        List<ItemWeatherForecast> list = new ArrayList<ItemWeatherForecast>();
        List<ListBean> temp = data.getList();
        for (ListBean bean : temp) {
            ItemWeatherForecast item = new ItemWeatherForecast();
            item.setDate(getMonth(bean.getDt()));
            item.setMax_temp(DataUtils.getK2C(bean.getTemp().getMax()));
            item.setMin_temp(DataUtils.getK2C(bean.getTemp().getMin()));
            if (bean.getWeather().size() > 0) {
                item.setIcon(bean.getWeather().get(0).getIcon());
                item.setWeather_description(bean.getWeather().get(0).getDescription());
            }
            item.setHumidity(String.valueOf(bean.getHumidity()));
            item.setWind(String.valueOf(bean.getSpeed()));
            item.setPressure(String.valueOf(bean.getPressure()));
            list.add(item);
        }
        return list;
    }

    //排序
//    public static List<ListBean> sort(List<ListBean> data) {
//        Collections.sort(data, new Comparator<ListBean>() {
//            @Override
//            public int compare(ListBean lhs, ListBean rhs) {
//                double left = lhs.getMain().getTemp();
//                double right = rhs.getMain().getTemp();
//                return (int) (left - right);
//            }
//        });
//        return data;
//    }

    /**
     * 获取风向
     *
     * @param wind_deg 角度
     * @param zh_cn    是否中文
     * @return 风向
     */
    public static String getWindDeg(int wind_deg, boolean zh_cn) {
        int degPos = wind_deg;
        if (wind_deg < 0) {
            degPos += (-wind_deg / 360 + 1) * 360;
        }
        int degNormalized = degPos % 360;
        int degRotated = degNormalized + (360 / 16 / 2);
        int flag = degRotated / (360 / 16);
        switch (flag) {
            case 0:
                return !zh_cn ? "North" : "北风";
            case 1:
                return !zh_cn ? "North-Northeast" : "东北偏北风";
            case 2:
                return !zh_cn ? "Northeast" : "东北风";
            case 3:
                return !zh_cn ? "East-Northeast" : "东北偏东风";
            case 4:
                return !zh_cn ? "East" : "东风";
            case 5:
                return !zh_cn ? "East-Southeast" : "东南偏东风";
            case 6:
                return !zh_cn ? "Southeast" : "东南风";
            case 7:
                return !zh_cn ? "South-Southeast" : "东南偏南风";
            case 8:
                return !zh_cn ? "South" : "南风";
            case 9:
                return !zh_cn ? "South-Southwest" : "西南偏南风";
            case 10:
                return !zh_cn ? "Southwest" : "西南方风";
            case 11:
                return !zh_cn ? "West-Southwest" : "西南偏西风";
            case 12:
                return !zh_cn ? "West" : "西风";
            case 13:
                return !zh_cn ? "West-Northwest" : "西南偏西风";
            case 14:
                return !zh_cn ? "Northwest" : "西北风";
            case 15:
                return !zh_cn ? "North-Northwest" : "西北偏西风";
            case 16:
                return !zh_cn ? "North" : "北风";
            default:
                return !zh_cn ? "North" : "北风";
        }
    }

    /**
     * 获取当前时间的星期
     *
     * @param zh_cn 是否中文
     * @return 星期
     */
    public static String getWeek(boolean zh_cn) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        int flag = cal.get(Calendar.DAY_OF_WEEK);
        switch (flag) {
            case Calendar.SUNDAY:
                return !zh_cn ? "SUNDAY" : "星期日";
            case Calendar.MONDAY:
                return !zh_cn ? "MONDAY" : "星期一";
            case Calendar.TUESDAY:
                return !zh_cn ? "TUESDAY" : "星期二";
            case Calendar.WEDNESDAY:
                return !zh_cn ? "WEDNESDAY" : "星期三";
            case Calendar.THURSDAY:
                return !zh_cn ? "THURSDAY" : "星期四";
            case Calendar.FRIDAY:
                return !zh_cn ? "FRIDAY" : "星期五";
            case Calendar.SATURDAY:
                return !zh_cn ? "SATURDAY" : "星期六";
            default:
                return !zh_cn ? "MONDAY" : "星期一";
        }
    }

    /**
     * Kelvin to Celsius
     *
     * @param K
     * @return
     */
    public static String getK2C(Double K) {
        Double C = K - 273.15;
        DecimalFormat df = new DecimalFormat("#");
        return df.format(C);
    }

    public static String getKM(Double km) {
        DecimalFormat df = new DecimalFormat("#");
        return df.format(km / 1000) + "km";
    }

    /**
     * 获取天气图标
     *
     * @param icon 天气图标的代码
     *             openweathermap的天气代码
     * @return 图片的id
     */
    public static int getWeatherImg(String icon) {
        //默认设置成太阳
        int img = R.drawable.img01d;
        switch (icon) {
            case "01d":
                img = R.drawable.img01d;
                break;
            case "01n":
                img = R.drawable.img01n;
                break;
            case "02d":
                img = R.drawable.img02d;
                break;
            case "02n":
                img = R.drawable.img02n;
                break;
            case "03d":
                img = R.drawable.img03d;
                break;
            case "03n":
                img = R.drawable.img03n;
                break;
            case "09d":
                img = R.drawable.img09d;
                break;
            case "09n":
                img = R.drawable.img09n;
                break;
            case "10d":
                img = R.drawable.img10d;
                break;
            case "10n":
                img = R.drawable.img10n;
                break;
            case "11d":
                img = R.drawable.img11d;
                break;
            case "11n":
                img = R.drawable.img11n;
                break;
            case "13d":
                img = R.drawable.img13d;
                break;
            case "13n":
                img = R.drawable.img13n;
                break;
            case "50d":
                img = R.drawable.img50d;
                break;
            case "50n":
                img = R.drawable.img50n;
                break;
        }
        return img;
    }

    /**
     * 获取和风天气的图标
     *
     * @param flag
     * @return
     */
    @Deprecated
    public static int getForecastImg(int flag) {
        if (flag == 100) {
            return R.drawable.img100;
        } else if (flag >= 101 && flag <= 104) {
            return R.drawable.img102;
        } else if (flag == 201) {
            return R.drawable.img201;
        } else if (flag == 200 || flag >= 202 && flag <= 207) {
            return R.drawable.img202;
        } else if (flag > 207 && flag <= 213) {
            return R.drawable.img213;
        } else if (flag == 300 || flag == 301) {
            return R.drawable.img300;
        } else if (flag > 301 && flag <= 304) {
            return R.drawable.img302;
        } else if (flag > 304 && flag <= 313) {
            return R.drawable.img307;
        } else if (flag >= 400 && flag < 407) {
            return R.drawable.img401;
        } else if (flag == 500 || flag == 501) {
            return R.drawable.img501;
        } else if (flag == 502) {
            return R.drawable.img502;
        } else if (flag == 503) {
            return R.drawable.img503;
        } else if (flag == 504) {
            return R.drawable.img504;
        } else if (flag >= 506 && flag <= 508) {
            return R.drawable.img508;
        } else if (flag == 900) {
            return R.drawable.img900;
        } else if (flag == 901) {
            return R.drawable.img901;
        } else {
            return R.drawable.img999;
        }
    }
}
