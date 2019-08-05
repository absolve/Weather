package com.example.wangd.weather.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wangd.weather.R;

import org.json.JSONObject;

import com.example.wangd.weather.model.WeatherData;
import com.example.wangd.weather.utils.DataUtils;

/**
 * Created by wangd on 2016/4/24.
 * 显示今天的天气
 */
@Deprecated
public class MainView extends LinearLayout {
    private LayoutInflater inflater;
    //温度
    private TextView temp,address;
    private ImageView weatherimg,changeAddr;

    public MainView(Context context) {
        super(context);
        inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.item_main, this, false);
//        temp = (TextView) v.findViewById(R.id.temp);
//        address = (TextView) v.findViewById(R.id.address);
        weatherimg = (ImageView) v.findViewById(R.id.weatherImg);
//        changeAddr= (ImageView) v.findViewById(R.id.changeAddr);
        //        改变地址的按钮
        changeAddr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
        this.addView(v);
    }

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.item_main, this, false);
//        temp = (TextView) v.findViewById(R.id.temp);
        weatherimg = (ImageView) v.findViewById(R.id.weatherImg);
//        changeAddr= (ImageView) v.findViewById(R.id.changeAddr);
//        改变地址的按钮
        changeAddr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
        this.addView(v);
    }

    public void setData(WeatherData.MainBean mainBean){
        String temp1 = DataUtils.getK2C(mainBean.getTemp());
        temp.setText(temp1);
    }

    public void setAddr(String addr){
        address.setText(addr);
    }

    /**
     * 初始化数据
     */
    public void initData(JSONObject object) {
//        try {
//            温度
//            String temp1 = DataUtils.getTemp(object).getString("temp");
//            float temp2 = Float.valueOf(temp1);
//            temp.setText(DataUtils.KtoC(temp2) + "°C");
//            风速
//            String windspeed = DataUtils.getWind(object).getString("speed");
//            wind.setText(windspeed + "m/s");
//湿度
//            String h = DataUtils.getTemp(object).getString("humidity");
//            humidity.setText(h + "%");
//气压
//            String p = DataUtils.getTemp(object).getString("pressure");
//            pressure.setText(p + "hPa");
//可见度
//            String v = DataUtils.getVisibility(object);
//            visibility.setText(v+"m");
//sunrise sunset
//            String sr = DataUtils.getSys(object).getString("sunrise");
//            sunrise.setText(DataUtils.getDefaultTime(sr));
//            String ss = DataUtils.getSys(object).getString("sunset");
//            sunset.setText(DataUtils.getDefaultTime(ss));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
    }

}
