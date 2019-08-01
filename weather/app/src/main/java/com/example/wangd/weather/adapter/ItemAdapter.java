package com.example.wangd.weather.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wangd.weather.R;
import com.example.wangd.weather.model.ItemWeatherForecast;
import com.example.wangd.weather.utils.DataUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * 天气预报列表适配器
 * 数据后边增加单位
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private Context context;
    private String lang = "zh_cn"; //语言 默认中文
    private List<ItemWeatherForecast> data;
    private int tempUnit = 0; //0是显示摄氏度 1是显示开氏度 2是显示华氏度

    public ItemAdapter(Context context, List<ItemWeatherForecast> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_weather, viewGroup, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int position) {
        if (tempUnit == 0) {//摄氏度
            String mint = String.format(context.getResources().getString(R.string.text_celsius),
                    data.get(position).getMin_temp());
            itemViewHolder.tv_mint.setText(mint); //最低温度
            String maxt = String.format(context.getResources().getString(R.string.text_celsius),
                    data.get(position).getMax_temp());
            itemViewHolder.tv_maxt.setText(maxt); //最高温度
        } else {
            String mint = String.format(context.getResources().getString(R.string.text_kelvin),
                    data.get(position).getMin_temp());
            itemViewHolder.tv_mint.setText(mint); //最低温度
            String maxt = String.format(context.getResources().getString(R.string.text_kelvin),
                    data.get(position).getMax_temp());
            itemViewHolder.tv_maxt.setText(maxt); //最高温度
        }
        //天气图片
        Picasso.with(context).load(DataUtils.getWeatherImg(data.get(position).getIcon(),true)).fit().into(itemViewHolder.iv_icon);

        itemViewHolder.tv_date.setText(data.get(position).getDate());
        itemViewHolder.tv_weather.setText(data.get(position).getWeather_description());
        if (lang.equals("zh_cn")) {
            String wind = String.format(context.getResources().getString(R.string.text_wind_zh),
                    data.get(position).getWind(),
                    DataUtils.getWindSpeed(data.get(position).getWind(),true));
            itemViewHolder.tv_wind.setText(wind);  //风速
            String pressure = String.format(context.getResources().getString(R.string.text_pressure_zh),
                    data.get(position).getPressure());
            itemViewHolder.tv_pressure.setText(pressure); //气压
            String humidity = String.format(context.getResources().getString(R.string.text_humidity_zh),
                    data.get(position).getHumidity() + "%");
            itemViewHolder.tv_humidity.setText(humidity);//湿度
        } else {
            String wind = String.format(context.getResources().getString(R.string.text_wind),
                    data.get(position).getWind(),
                    DataUtils.getWindSpeed(data.get(position).getWind(),false));
            itemViewHolder.tv_wind.setText(wind);  //风速
            String pressure = String.format(context.getResources().getString(R.string.text_pressure),
                    data.get(position).getPressure());
            itemViewHolder.tv_pressure.setText(pressure); //气压
            String humidity = String.format(context.getResources().getString(R.string.text_humidity),
                    data.get(position).getHumidity() + "%");
            itemViewHolder.tv_humidity.setText(humidity);//湿度
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getTempUnit() {
        return tempUnit;
    }

    public void setTempUnit(int tempUnit) {
        this.tempUnit = tempUnit;
    }

    /**
     * 添加数据
     *
     * @param data
     */
    public void addData(List<ItemWeatherForecast> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    /**
     * 数据内容
     */
    static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_mint, tv_maxt, tv_date, tv_weather,
                tv_wind, tv_pressure, tv_humidity; //最低温度 最高温度  日期 天气 风速 气压 湿度
        public ImageView iv_icon; //天气图标

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_mint = itemView.findViewById(R.id.tv_mint);
            tv_maxt = itemView.findViewById(R.id.tv_maxt);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_weather = itemView.findViewById(R.id.tv_weather);
            tv_wind = itemView.findViewById(R.id.tv_wind);
            tv_pressure = itemView.findViewById(R.id.tv_pressure);
            tv_humidity = itemView.findViewById(R.id.tv_humidity);
            iv_icon = itemView.findViewById(R.id.iv_img);
        }

    }
}
