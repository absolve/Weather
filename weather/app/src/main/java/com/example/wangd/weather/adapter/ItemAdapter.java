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

import java.util.List;

/**
 * 天气预报列表适配器
 */
public class ItemAdapter  extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    private Context context;
    private String lang="zh_cn"; //语言 默认中文
    private List<ItemWeatherForecast> data;


    public ItemAdapter(Context context,List<ItemWeatherForecast> data) {
        this.context = context;
        this.data=data;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_main, viewGroup, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int position) {
        itemViewHolder.tv_mint.setText(data.get(position).min_temp);
        itemViewHolder.tv_maxt.setText(data.get(position).max_temp);
        itemViewHolder.iv_icon.setImageResource(DataUtils.getWeatherImg(data.get(position).icon));
        itemViewHolder.tv_date.setText(data.get(position).date);
        itemViewHolder.tv_weather.setText(data.get(position).weather_description);
        if(lang.equals("zh_cn")){
            String wind = String.format(context.getResources().getString(R.string.text_wind_zh),
                    data.get(position).wind);
            itemViewHolder.tv_wind.setText(wind);  //风速
            String pressure=String.format(context.getResources().getString(R.string.text_pressure_zh),
                    data.get(position).pressure);
            itemViewHolder.tv_pressure.setText(pressure); //气压
            String humidity = String.format(context.getResources().getString(R.string.text_humidity_zh),
                    data.get(position).humidity);
            itemViewHolder.tv_humidity.setText(humidity);//湿度
        }else{
            String wind = String.format(context.getResources().getString(R.string.text_wind),
                    data.get(position).wind);
            itemViewHolder.tv_wind.setText(wind);  //风速
            String pressure=String.format(context.getResources().getString(R.string.text_pressure),
                    data.get(position).pressure);
            itemViewHolder.tv_pressure.setText(pressure); //气压
            String humidity = String.format(context.getResources().getString(R.string.text_humidity),
                    data.get(position).humidity);
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

    /**
     * 数据内容
     */
    static class ItemViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_mint,tv_maxt,tv_unit,tv_date,tv_weather,
                tv_wind,tv_pressure,tv_humidity; //最低温度 最高温度 温度单位 日期 天气 风速 气压 湿度
        public ImageView iv_icon; //天气图标

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_mint =itemView.findViewById(R.id.tv_mint);
            tv_maxt=itemView.findViewById(R.id.tv_maxt);
            tv_unit=itemView.findViewById(R.id.tv_unit);
            tv_date=itemView.findViewById(R.id.tv_date);
            tv_weather=itemView.findViewById(R.id.tv_weather);
            tv_wind=itemView.findViewById(R.id.tv_wind);
            tv_pressure=itemView.findViewById(R.id.tv_pressure);
            tv_humidity=itemView.findViewById(R.id.tv_humidity);
            iv_icon=itemView.findViewById(R.id.iv_icon);
        }
    }
}
