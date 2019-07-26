package utils;

import android.util.Log;

import com.example.wangd.weather.R;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import model.ForecastData.HeWeatherDataServiceBean.DailyForecastBean;
import model.ItemWeatherForecast;
import model.WeatherForecastData;
import model.WeatherForecastData.ListBean;

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
    public static List<ItemWeatherForecast> getItemForecast(List<DailyForecastBean> data) {
        List<ItemWeatherForecast> list = new ArrayList<ItemWeatherForecast>();
        //选取未来4天的预报
        for (int i = 1; i < 5; i++) {
            DailyForecastBean bean = data.get(i);
            ItemWeatherForecast item = new ItemWeatherForecast();
            item.min_temp = bean.tmp.min + "°C";
            item.max_temp = bean.tmp.max + "°C";
            //选择白天的天气状况
            item.weather_description = bean.cond.txt_d;
            item.date = getDate(bean.date);
            item.icon = bean.cond.code_d;
            list.add(item);
        }
        return list;
    }

    /**
     * 从天气预报中获取适配器上显示的数据
     *
     * @param data
     * @return
     */
    public static List<ItemWeatherForecast> getItemForecast(WeatherForecastData data) {
        List<ItemWeatherForecast> list = new ArrayList<ItemWeatherForecast>();
        List<ListBean> temp = data.getList();
        for (ListBean bean : temp) {
            ItemWeatherForecast item = new ItemWeatherForecast();
            item.date = getMonth(bean.getDt());
            item.max_temp = DataUtils.getK2C(bean.getTemp().getMax());
            item.min_temp = DataUtils.getK2C(bean.getTemp().getMin());
            if (bean.getWeather().size() > 0) {
                item.icon = bean.getWeather().get(0).getIcon();
                item.weather_description = bean.getWeather().get(0).getDescription();
            }
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
     * @return
     */
    public static String getWindDeg(int wind_deg) {
        int degPos = wind_deg;
        if (wind_deg < 0) {
            degPos += (-wind_deg / 360 + 1) * 360;
        }
        int degNormalized = degPos % 360;
        int degRotated = degNormalized + (360 / 16 / 2);
        int flag = degRotated / (360 / 16);
        switch (flag) {
            case 0:
                return "North";
            case 1:
                return "North-Northeast";
            case 2:
                return "Northeast";
            case 3:
                return "East-Northeast";
            case 4:
                return "East";
            case 5:
                return "East-Southeast";
            case 6:
                return "Southeast";
            case 7:
                return "South-Southeast";
            case 8:
                return "South";
            case 9:
                return "South-Southwest";
            case 10:
                return "Southwest";
            case 11:
                return "West-Southwest";
            case 12:
                return "West";
            case 13:
                return "West-Northwest";
            case 14:
                return "Northwest";
            case 15:
                return "North-Northwest";
            case 16:
                return "North";
            default:
                return "North";
        }
    }

    /**
     * 获取当前时间的星期
     *
     * @param zh_cn 是否中文
     * @return
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
        return df.format(C) + "°C";
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
        int img = R.mipmap.img01d;
        switch (icon) {
            case "01d":
                img = R.mipmap.img01d;
                break;
            case "01n":
                img = R.mipmap.img01n;
                break;
            case "02d":
                img = R.mipmap.img02d;
                break;
            case "02n":
                img = R.mipmap.img02n;
                break;
            case "03d":
                img = R.mipmap.img03d;
                break;
            case "03n":
                img = R.mipmap.img03n;
                break;
            case "09d":
                img = R.mipmap.img09d;
                break;
            case "09n":
                img = R.mipmap.img09n;
                break;
            case "10d":
                img = R.mipmap.img10d;
                break;
            case "10n":
                img = R.mipmap.img10n;
                break;
            case "11d":
                img = R.mipmap.img11d;
                break;
            case "11n":
                img = R.mipmap.img11n;
                break;
            case "13d":
                img = R.mipmap.img13d;
                break;
            case "13n":
                img = R.mipmap.img13n;
                break;
            case "50d":
                img = R.mipmap.img50d;
                break;
            case "50n":
                img = R.mipmap.img50n;
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
    public static int getForecastImg(int flag) {
        if (flag == 100) {
            return R.mipmap.img100;
        } else if (flag >= 101 && flag <= 104) {
            return R.mipmap.img102;
        } else if (flag == 201) {
            return R.mipmap.img201;
        } else if (flag == 200 || flag >= 202 && flag <= 207) {
            return R.mipmap.img202;
        } else if (flag > 207 && flag <= 213) {
            return R.mipmap.img213;
        } else if (flag == 300 || flag == 301) {
            return R.mipmap.img300;
        } else if (flag > 301 && flag <= 304) {
            return R.mipmap.img302;
        } else if (flag > 304 && flag <= 313) {
            return R.mipmap.img307;
        } else if (flag >= 400 && flag < 407) {
            return R.mipmap.img401;
        } else if (flag == 500 || flag == 501) {
            return R.mipmap.img501;
        } else if (flag == 502) {
            return R.mipmap.img502;
        } else if (flag == 503) {
            return R.mipmap.img503;
        } else if (flag == 504) {
            return R.mipmap.img504;
        } else if (flag >= 506 && flag <= 508) {
            return R.mipmap.img508;
        } else if (flag == 900) {
            return R.mipmap.img900;
        } else if (flag == 901) {
            return R.mipmap.img901;
        } else {
            return R.mipmap.img999;
        }
    }
}
