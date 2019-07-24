package utils;

import com.example.wangd.weather.BuildConfig;

import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * http请求工具
 */
public class HttpUtil {
    static OkHttpClient client; //okhttp

    //openweather天气的地址
    final static String Weatherhost = BuildConfig.Weatherhost;

    //和风天气地址
    public final static String hfWeatherhost = BuildConfig.HFWeatherhost;

    /**
     * 获取天气预报 和风天气
     * @param location 位置
     * 1. location=CN101010100
     * 2. location=116.40,39.9
     * 3. location=北京、 location=北京市、 location=beijing
     * 4. location=朝阳,北京、 location=chaoyang,beijing
     * 5. location=60.194.130.1
     * 6. location=auto_ip
     * @param callback 回调函数
     */
    public static void getForecastHF(String location,Callback callback){
        if(client==null){
            return;
        }
        HttpUrl.Builder urlBuilder = HttpUrl.parse(hfWeatherhost).newBuilder();
        urlBuilder.addPathSegment("forecast");
        urlBuilder.addQueryParameter("location",location);
        urlBuilder.addQueryParameter("key",BuildConfig.hfkey);
        Request request = new Request.Builder()
                .url(urlBuilder.build().toString())
                .build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * 获取当前天气 和风天气
     * @param cityname 城市名字
     * @param callback 回调函数
     */
    public static void getCurrweather(String cityname,Callback callback){
        if(client==null){
            return;
        }
        HttpUrl.Builder urlBuilder = HttpUrl.parse(hfWeatherhost).newBuilder();
        urlBuilder.addPathSegment("now");
        urlBuilder.addQueryParameter("location",cityname);
        urlBuilder.addQueryParameter("key",BuildConfig.hfkey);
        Request request = new Request.Builder()
                .url(urlBuilder.build().toString())
                .build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * 获取当前天气  openweather天气
     * @param lang 语言 zh_cn  en
     * @param cityname 城市名字
     * @param callback 回调函数
     */
    public static void getCurrweatherOW(String cityname,String lang,Callback callback){
        if(client==null){
            return;
        }
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Weatherhost).newBuilder();
        urlBuilder.addQueryParameter("q",cityname);
        urlBuilder.addQueryParameter("lang",lang);
        urlBuilder.addQueryParameter("appid",BuildConfig.owkey);
        Request request = new Request.Builder()
                .url(urlBuilder.build().toString())
                .build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * 获取当前天气  openweather天气
     * @param lat     纬度
     * @param lon     经度
     * @param lang 语言 zh_cn  en
     * @param callback 回调函数
     */
    public static void getCurrweatherOW(String lat, String lon,String lang,Callback callback){
        if(client==null){
            return;
        }
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Weatherhost).newBuilder();
        urlBuilder.addQueryParameter("lat",lat);
        urlBuilder.addQueryParameter("lon",lon);
        urlBuilder.addQueryParameter("lang",lang);
        urlBuilder.addQueryParameter("appid",BuildConfig.owkey);
        Request request = new Request.Builder()
                .url(urlBuilder.build().toString())
                .build();
        client.newCall(request).enqueue(callback);
    }


    public static OkHttpClient getClient() {
        return client;
    }

    public static void setClient(OkHttpClient client) {
        HttpUtil.client = client;
    }
}
