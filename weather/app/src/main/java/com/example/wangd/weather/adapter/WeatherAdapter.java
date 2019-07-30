package com.example.wangd.weather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wangd.weather.R;

import java.util.ArrayList;
import java.util.List;

import com.example.wangd.weather.model.ItemCurrWeatherData;
import com.example.wangd.weather.model.ItemWeatherForecast;
import com.example.wangd.weather.utils.DataUtils;

/**
 * RecyclerView适配器
 * Created by wangd on 2016/5/21.
 */
public class WeatherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater mInflater;
    private static final int HEAD_ITEMTYPE = 100;
    private static final int BODY_ITEMTYPE = 101;
    private static final int FOOT_ITEMTYPE = 102;
    private static final int ADS_ITEMTYPE = 103;

    //admob view
//    private AdView gadView;

    //数据当前天气的数据
    private ItemCurrWeatherData currWeatherData = null;
    //天气预报的数据
    private List<ItemWeatherForecast> forecastsList;

    public WeatherAdapter(Context c) {
        context = c;
        mInflater = LayoutInflater.from(c);
        forecastsList = new ArrayList<ItemWeatherForecast>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == HEAD_ITEMTYPE) {
            View v = mInflater.inflate(R.layout.item_main, parent, false);
            viewHolder = new ViewHolder1(v);
        } else if (viewType == BODY_ITEMTYPE) {
            View v = mInflater.inflate(R.layout.item_body, parent, false);
            viewHolder = new ViewHolder2(v);
        } else if (viewType == FOOT_ITEMTYPE) {
            View v = mInflater.inflate(R.layout.item_detail, parent, false);
            viewHolder = new ViewHolder3(v);
        } else if (viewType == ADS_ITEMTYPE) {
            View v = mInflater.inflate(R.layout.item_ad, parent, false);
            viewHolder = new ViewHolderAd(v);
        }
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            //头部
            if (currWeatherData != null) {
                ((ViewHolder1) holder).setTemp(currWeatherData.temp);
                ((ViewHolder1) holder).setDescription(currWeatherData.weather_main);
                ((ViewHolder1) holder).setLoc(currWeatherData.country);
                ((ViewHolder1) holder).setWeatherImg(DataUtils.getWeatherImg(currWeatherData.weather_icon));
                ((ViewHolder1) holder).setDate(currWeatherData.current_day_week);
            }
        } else if (holder instanceof ViewHolder2) {
            //天气预报信息
            ((ViewHolder2) holder).setStyle(position);
            if (forecastsList.size() != 0) {
                ((ViewHolder2) holder).setWeather(forecastsList.get(position - 1).weather_description);
                ((ViewHolder2) holder).setWeatherImg(DataUtils.getWeatherImg(forecastsList.get(position - 1).icon));
                ((ViewHolder2) holder).setMin_temp(forecastsList.get(position - 1).min_temp);
                ((ViewHolder2) holder).setMax_temp(forecastsList.get(position - 1).max_temp);
                ((ViewHolder2) holder).setData(forecastsList.get(position - 1).date);
            }
        } else if (holder instanceof ViewHolder3) {
            //天气详细信息
            if (currWeatherData != null) {
                ((ViewHolder3) holder).setHumidity(currWeatherData.humidity);
                ((ViewHolder3) holder).setPressure(currWeatherData.pressure);
                ((ViewHolder3) holder).setSunrise(currWeatherData.sunrise);
                ((ViewHolder3) holder).setSunset(currWeatherData.sunset);
                ((ViewHolder3) holder).setWindspeed(currWeatherData.wind_speed);
                ((ViewHolder3) holder).setWinddeg(currWeatherData.wind_deg);
            }
        }
    }

    @Override
    public int getItemCount() {
        return 9;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEAD_ITEMTYPE;
        } else if (position == 7) {
            return FOOT_ITEMTYPE;
        } else if (position == 8) {
            return ADS_ITEMTYPE;
        } else {
            return BODY_ITEMTYPE;
        }
    }

    /**
     * 列表中的头部
     */
    public static class ViewHolder1 extends RecyclerView.ViewHolder {
        private ImageView weatherImg;
        private TextView temp, description, loc, date;

        public ViewHolder1(View itemView) {
            super(itemView);
            weatherImg = (ImageView) itemView.findViewById(R.id.weatherImg);
            temp = (TextView) itemView.findViewById(R.id.temp);
            description = (TextView) itemView.findViewById(R.id.description);
            loc = (TextView) itemView.findViewById(R.id.loc);
            date = (TextView) itemView.findViewById(R.id.date);
        }

        public void setDate(String date) {
            this.date.setText(date);
        }

        public void setWeatherImg(int res) {
            this.weatherImg.setImageResource(res);
        }

        public void setTemp(String temp) {
            this.temp.setText(temp);
        }

        public void setDescription(String description) {
            this.description.setText(description);
        }

        public void setLoc(String loc) {
            this.loc.setText(loc);
        }
    }

    /**
     * 列表中天气预报的item
     */
    public static class ViewHolder2 extends RecyclerView.ViewHolder {
        private View root;
        private TextView data, weather, min_temp, max_temp;
        private ImageView weatherImg;

        public ViewHolder2(View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.root);
            data = (TextView) itemView.findViewById(R.id.item_date);
            weather = (TextView) itemView.findViewById(R.id.item_weather);
            weatherImg = (ImageView) itemView.findViewById(R.id.img);
            min_temp = (TextView) itemView.findViewById(R.id.item_mintemp);
            max_temp = (TextView) itemView.findViewById(R.id.item_maxtemp);

        }

        public void setData(String data) {
            this.data.setText(data);
        }

        public void setWeather(String weather) {
            this.weather.setText(weather);
        }

        public void setMin_temp(String min_temp) {
            this.min_temp.setText(min_temp);
        }

        public void setMax_temp(String max_temp) {
            this.max_temp.setText(max_temp);
        }

        public void setWeatherImg(int weatherImg) {
            this.weatherImg.setImageResource(weatherImg);
        }

        public void setStyle(int pos) {
            switch (pos) {
                case 1:
                    root.setBackgroundResource(styles[6]);
                    break;
                case 2:
                    root.setBackgroundResource(styles[7]);
                    break;
                case 3:
                    root.setBackgroundResource(styles[8]);
                    break;
                case 4:
                    root.setBackgroundResource(styles[9]);
                    break;
                default:
                    root.setBackgroundResource(styles[9]);
                    break;
            }
        }

    }

    /**
     * 列表的尾部
     */
    public static class ViewHolder3 extends RecyclerView.ViewHolder {
        private TextView pressure, humidity, sunrise, sunset, windspeed, winddeg;

        public ViewHolder3(View itemView) {
            super(itemView);
            pressure = (TextView) itemView.findViewById(R.id.pressure);
            humidity = (TextView) itemView.findViewById(R.id.humidity);
            sunrise = (TextView) itemView.findViewById(R.id.sunrise);
            sunset = (TextView) itemView.findViewById(R.id.sunset);
            windspeed = (TextView) itemView.findViewById(R.id.windspeed);
            winddeg = (TextView) itemView.findViewById(R.id.winddeg);
        }

        public void setWinddeg(String winddeg) {
            this.winddeg.setText(winddeg);
        }

        public void setPressure(String pressure) {
            this.pressure.setText(pressure);
        }

        public void setHumidity(String humidity) {
            this.humidity.setText(humidity);
        }

        public void setSunrise(String sunrise) {
            this.sunrise.setText(sunrise);
        }

        public void setSunset(String sunset) {
            this.sunset.setText(sunset);
        }

        public void setWindspeed(String windspeed) {
            this.windspeed.setText(windspeed);
        }
    }

    /**
     * 最后的说明
     */
    public static class ViewHolderAd extends RecyclerView.ViewHolder {
//        private AdView adView;

        public ViewHolderAd(View itemView) {
            super(itemView);
//            adView = (AdView) itemView.findViewById(R.id.adView);
//            AdRequest adRequest = new AdRequest.Builder().build();
//            adView.loadAd(adRequest);
        }
    }

    private static final int[] styles = {R.drawable.yuanjiao_style_01,
            R.drawable.yuanjiao_style_02, R.drawable.yuanjiao_style_03,
            R.drawable.yuanjiao_style_04,
            R.drawable.yuanjiao_style_05, R.drawable.yuanjiao_style_06,
            R.drawable.yuanjiao_style_07, R.drawable.yuanjiao_style_08,
            R.drawable.yuanjiao_style_09, R.drawable.yuanjiao_style_10};

    public ItemCurrWeatherData getCurrWeatherData() {
        return currWeatherData;
    }

    public void setCurrWeatherData(ItemCurrWeatherData currWeatherData) {
        this.currWeatherData = currWeatherData;
        if (currWeatherData != null) {
//            notifyItemChanged(0);
//            notifyItemChanged(8);
            notifyDataSetChanged();
        }
    }

    public void setForecastsList(List<ItemWeatherForecast> temp) {
        if (temp != null) {
            forecastsList.clear();
            forecastsList.addAll(temp);
            notifyDataSetChanged();
//            for (int i = 0; i < forecastsList.size(); i++) {
//                notifyItemChanged(i + 1);
//            }
        }
    }
}
