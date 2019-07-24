package utils;

import android.content.Context;
import android.util.Log;

import com.example.wangd.weather.BuildConfig;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.Locale;

/**
 * Created by wangd on 2016/4/17.
 * http工具
 */
public class Httpclient {
    //openweather天气的地址
    public final static String Weatherhost = BuildConfig.Weatherhost;
    //天气预报地址
    public final static String forecasthost = "http://api.openweathermap.org/data/2.5/forecast";
    //心知天气预报地址
//    public final static String xzforecasthost = "https://api.thinkpage.cn/v3/weather/daily.json";
    //和风天气预报地址
    public final static String hfforecasthost = BuildConfig.HFWeatherhost;

    //天气key
    public final static String appkey = BuildConfig.owkey;
    //地图key
//    public final static String mapkey = "34f2dff31b0dcf88acf39e0aa7a8dd86";
    //心知天气key
//    public final static String xzkey="ckwzx5kzynstl55w";
    //和风天气key
    public final static String hfkey = BuildConfig.hfkey;

    public static AsyncHttpClient client;

    public Httpclient() {

    }

    /**
     * 获取当前的天气
     *
     * @param cityname 城市名
     * @param handler  回调
     */
    public static void getCurrweather(String cityname, AsyncHttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.put("q", cityname);
        params.put("appid", appkey);
        Httpclient.get(Weatherhost, params, handler);
    }

    /**
     * 获取当前的天气
     *
     * @param lat     纬度
     * @param lon     经度
     * @param handler 回调
     */
    public static void getCurrweather(String lat, String lon, AsyncHttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.put("lat", lat);
        params.put("lon", lon);
        params.put("appid", appkey);
        Httpclient.get(Weatherhost, params, handler);
    }

    /**
     * 获取当前的天气
     * @param lat 纬度
     * @param lon   经度
     * @param lang  语言
     * @param handler 回调
     */
    public static void getCurrweather(String lat, String lon,String lang, AsyncHttpResponseHandler handler){
        RequestParams params = new RequestParams();
        params.put("lat", lat);
        params.put("lon", lon);
        params.put("lang",lang);
        params.put("appid", appkey);
        Httpclient.get(Weatherhost, params, handler);
    }

    /**
     * 获取天气预报
     *
     * @param cityname 城市名
     * @param handler  回调
     */
    public static void getForecast(String cityname, AsyncHttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.put("q", cityname);
        params.put("appid", appkey);
        Httpclient.get(forecasthost, params, handler);
    }

    /**
     *  获取天气预报
     * @param lat   纬度
     * @param lon   经度
     * @param handler 回调
     */
    public static void getForecast(String lat, String lon, AsyncHttpResponseHandler handler){
        RequestParams params = new RequestParams();
        params.put("lat", lat);
        params.put("lon", lon);
        params.put("appid", appkey);
        Httpclient.get(forecasthost, params, handler);
    }

    /**
     * 和风天气预报
     * @param cityname
     * @param handler
     */
    public static void getHFForecast(String cityname,AsyncHttpResponseHandler handler){
        RequestParams params = new RequestParams();
        params.put("city",cityname);
        params.put("key",hfkey);
        Httpclient.get(hfforecasthost, params, handler);
    }


    public static AsyncHttpClient getHttpClient() {
        return client;
    }

    public static void cancelAll(Context context) {
        client.cancelRequests(context, true);
    }

    public static void delete(String partUrl, AsyncHttpResponseHandler handler) {
        client.delete(partUrl, handler);
        log("DELETE " + partUrl);
    }

    public static void get(String partUrl, AsyncHttpResponseHandler handler) {
        client.get(partUrl, handler);
        log("GET " + partUrl);
    }

    public static void get(String partUrl, RequestParams params,
                           AsyncHttpResponseHandler handler) {
        client.get(partUrl, params, handler);
        log("GET " + partUrl + "&" +
                params);
    }

    public static void log(String log) {
        Log.d("Httpclient", log);
    }

    public static void post(String partUrl, AsyncHttpResponseHandler handler) {
        client.post(partUrl, handler);
        log("POST " + partUrl);
    }

    public static void post(String partUrl, RequestParams params,
                            AsyncHttpResponseHandler handler) {
        client.post(partUrl, params, handler);
        log("POST " + partUrl + "&" +
                params);
    }

    public static void postDirect(String url, RequestParams params,
                                  AsyncHttpResponseHandler handler) {
        client.post(url, params, handler);
        log("POST " + url + "&" + params);
    }

    public static void put(String partUrl, AsyncHttpResponseHandler handler) {
        client.put(partUrl, handler);
        log("PUT " + partUrl);
    }

    public static void put(String partUrl, RequestParams params,
                           AsyncHttpResponseHandler handler) {
        client.put(partUrl, params, handler);
        log("PUT " + partUrl + "&" +
                params);
    }

    public static void setHttpClient(AsyncHttpClient c) {
        client = c;
//        默认设置超时时间为15s
        client.setTimeout(15000);
//        client.addHeader("Accept-Language", Locale.getDefault().toString());
    }
}
