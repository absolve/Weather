package com.example.wangd.weather.adapter;

import android.content.Context;
import android.graphics.Color;
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
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * 天气预报列表适配器
 * 数据后边增加单位
 */
public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

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
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == typeView) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_weather, viewGroup, false);
            return new ItemViewHolder(v);
        } else {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_chart, viewGroup, false);
            return new ItemChartHolder(v).setUpChart();
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof ItemViewHolder) {
            ItemViewHolder vh = (ItemViewHolder) viewHolder;
            if (tempUnit == 0) {//摄氏度
                String mint = String.format(context.getResources().getString(R.string.text_celsius),
                        data.get(position).getMin_temp());
                vh.tv_mint.setText(mint); //最低温度
                String maxt = String.format(context.getResources().getString(R.string.text_celsius),
                        data.get(position).getMax_temp());
                vh.tv_maxt.setText(maxt); //最高温度
            } else {
                String mint = String.format(context.getResources().getString(R.string.text_kelvin),
                        data.get(position).getMin_temp());
                vh.tv_mint.setText(mint); //最低温度
                String maxt = String.format(context.getResources().getString(R.string.text_kelvin),
                        data.get(position).getMax_temp());
                vh.tv_maxt.setText(maxt); //最高温度
            }
            //天气图片
            Picasso.with(context).load(DataUtils.getWeatherImg(data.get(position).getIcon(), true)).fit().into(vh.iv_icon);

            vh.tv_date.setText(data.get(position).getDate());
            vh.tv_weather.setText(data.get(position).getWeather_description());
            if (lang.equals("zh_cn")) {
                String wind = String.format(context.getResources().getString(R.string.text_wind_zh),
                        data.get(position).getWind(),
                        DataUtils.getWindSpeed(data.get(position).getWind(), true));
                vh.tv_wind.setText(wind);  //风速
                String pressure = String.format(context.getResources().getString(R.string.text_pressure_zh),
                        data.get(position).getPressure());
                vh.tv_pressure.setText(pressure); //气压
                String humidity = String.format(context.getResources().getString(R.string.text_humidity_zh),
                        data.get(position).getHumidity() + "%");
                vh.tv_humidity.setText(humidity);//湿度
            } else {
                String wind = String.format(context.getResources().getString(R.string.text_wind),
                        data.get(position).getWind(),
                        DataUtils.getWindSpeed(data.get(position).getWind(), false));
                vh.tv_wind.setText(wind);  //风速
                String pressure = String.format(context.getResources().getString(R.string.text_pressure),
                        data.get(position).getPressure());
                vh.tv_pressure.setText(pressure); //气压
                String humidity = String.format(context.getResources().getString(R.string.text_humidity),
                        data.get(position).getHumidity() + "%");
                vh.tv_humidity.setText(humidity);//湿度
            }
        } else if (viewHolder instanceof ItemChartHolder) { //图表
            ItemChartHolder vh = (ItemChartHolder) viewHolder;
            final List<String> date = new ArrayList<>(); //日期数据
            for (ItemWeatherForecast item : data) {
                date.add(item.getDate());
            }
            ValueFormatter formatter = new ValueFormatter() {
                @Override
                public String getAxisLabel(float value, AxisBase axis) {
                    return date.get((int) value);
                }
            };
            XAxis xAxis = vh.chart.getXAxis();
            xAxis.setGranularity(1f);
            xAxis.setValueFormatter(formatter);
            ArrayList<Entry> minTemp = new ArrayList<>(); //最低温度
            for (int i = 0; i < data.size(); i++) {
                minTemp.add(new Entry(i, Float.valueOf(data.get(i).getMin_temp())));
            }

            LineDataSet set1 = new LineDataSet(minTemp, "最低温度");
            set1.setLineWidth(1.25f);
            set1.setCircleRadius(3f);
            set1.setCircleHoleRadius(2.5f);
            set1.setColor(Color.BLUE);
            set1.setCircleColor(Color.BLUE);
            set1.setHighLightColor(Color.RED);
            set1.setValueTextSize(12f); //设置文字的大小

            ArrayList<Entry> maxTemp = new ArrayList<>(); //最高温度
            for (int i = 0; i < data.size(); i++) {
                maxTemp.add(new Entry(i, Float.valueOf(data.get(i).getMax_temp())));
            }
            LineDataSet set2 = new LineDataSet(maxTemp, "最高温度");
            set2.setLineWidth(1.25f);
            set2.setCircleRadius(3f);
            set2.setCircleHoleRadius(2.5f);
            set2.setColor(Color.RED);
            set2.setCircleColor(Color.RED);
            set2.setHighLightColor(Color.BLUE);
            set2.setValueTextSize(12f); //设置文字的大小
            vh.chart.setData(new LineData(set1,set2));
            vh.chart.invalidate();
        }
    }

    //item的类型
    private int typeView = 0, typeChart = 1;

    @Override
    public int getItemViewType(int position) {
        if (position == data.size()) { //最后一个显示图表
            return typeChart;
        } else {
            return typeView;
        }
    }

    @Override
    public int getItemCount() {
        if(data.size()!=0) {
            return data.size() + 1; //用来最后一个显示
        }else{
            return data.size();
        }
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

    /**
     * 用来显示图表
     */
    static class ItemChartHolder extends RecyclerView.ViewHolder {
        public LineChart chart; //图表

        public ItemChartHolder(@NonNull View itemView) {
            super(itemView);
            chart = itemView.findViewById(R.id.chart1);
        }

        public ItemChartHolder setUpChart() {
            chart.getDescription().setEnabled(false);
            chart.setDrawGridBackground(false);
            chart.setTouchEnabled(true);
//            chart.setBackgroundColor(Color.WHITE);
            chart.setDrawBorders(false);
            chart.setDragEnabled(false);
            chart.setScaleEnabled(true);
            chart.setBackgroundResource(R.drawable.round_style_white1);
            chart.animateX(1000);
            //设置字体大小
            YAxis leftAxis = chart.getAxisLeft();
            leftAxis.setTextSize(12f);
            YAxis rightAxis = chart.getAxisRight();
            rightAxis.setTextSize(12f);

            XAxis xAxis1 = chart.getXAxis();
            xAxis1.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis1.setTextSize(12f);
            return this;
        }
    }
}
