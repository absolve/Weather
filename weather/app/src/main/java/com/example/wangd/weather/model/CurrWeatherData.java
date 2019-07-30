package com.example.wangd.weather.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * openweather当前天气数据
 * Created by wangd on 2016/6/12.
 */
public class CurrWeatherData implements Parcelable {


    /**
     * coord : {"lon":119.3,"lat":26.08}
     * weather : [{"id":801,"main":"Clouds","description":"晴，少云","icon":"02d"}]
     * base : stations
     * main : {"temp":303.15,"pressure":1006,"humidity":74,"temp_min":303.15,"temp_max":303.15}
     * visibility : 8000
     * wind : {"speed":5,"deg":190}
     * clouds : {"all":20}
     * dt : 1564105734
     * sys : {"type":1,"id":9658,"message":0.0085,"country":"CN","sunrise":1564089906,"sunset":1564138395}
     * timezone : 28800
     * id : 1810821
     * name : Fuzhou
     * cod : 200
     */

    private CoordBean coord;
    private String base;
    private MainBean main;
    private int visibility;
    private WindBean wind;
    private CloudsBean clouds;
    private long dt;
    private SysBean sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;
    private List<WeatherBean> weather;

    public CoordBean getCoord() {
        return coord;
    }

    public void setCoord(CoordBean coord) {
        this.coord = coord;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public MainBean getMain() {
        return main;
    }

    public void setMain(MainBean main) {
        this.main = main;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public WindBean getWind() {
        return wind;
    }

    public void setWind(WindBean wind) {
        this.wind = wind;
    }

    public CloudsBean getClouds() {
        return clouds;
    }

    public void setClouds(CloudsBean clouds) {
        this.clouds = clouds;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public SysBean getSys() {
        return sys;
    }

    public void setSys(SysBean sys) {
        this.sys = sys;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public List<WeatherBean> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherBean> weather) {
        this.weather = weather;
    }

    public static class CoordBean implements Parcelable {
        /**
         * lon : 119.3
         * lat : 26.08
         */

        private double lon;
        private double lat;

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeDouble(this.lon);
            dest.writeDouble(this.lat);
        }

        public CoordBean() {
        }

        protected CoordBean(Parcel in) {
            this.lon = in.readDouble();
            this.lat = in.readDouble();
        }

        public static final Creator<CoordBean> CREATOR = new Creator<CoordBean>() {
            @Override
            public CoordBean createFromParcel(Parcel source) {
                return new CoordBean(source);
            }

            @Override
            public CoordBean[] newArray(int size) {
                return new CoordBean[size];
            }
        };

        @Override
        public String toString() {
            return "CoordBean{" +
                    "lon=" + lon +
                    ", lat=" + lat +
                    '}';
        }
    }

    public static class MainBean implements Parcelable {
        /**
         * temp : 303.15
         * pressure : 1006
         * humidity : 74
         * temp_min : 303.15
         * temp_max : 303.15
         */

        private double temp;
        private int pressure;
        private int humidity;
        private double temp_min;
        private double temp_max;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public int getPressure() {
            return pressure;
        }

        public void setPressure(int pressure) {
            this.pressure = pressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public double getTemp_min() {
            return temp_min;
        }

        public void setTemp_min(double temp_min) {
            this.temp_min = temp_min;
        }

        public double getTemp_max() {
            return temp_max;
        }

        public void setTemp_max(double temp_max) {
            this.temp_max = temp_max;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeDouble(this.temp);
            dest.writeInt(this.pressure);
            dest.writeInt(this.humidity);
            dest.writeDouble(this.temp_min);
            dest.writeDouble(this.temp_max);
        }

        public MainBean() {
        }

        protected MainBean(Parcel in) {
            this.temp = in.readDouble();
            this.pressure = in.readInt();
            this.humidity = in.readInt();
            this.temp_min = in.readDouble();
            this.temp_max = in.readDouble();
        }

        public static final Creator<MainBean> CREATOR = new Creator<MainBean>() {
            @Override
            public MainBean createFromParcel(Parcel source) {
                return new MainBean(source);
            }

            @Override
            public MainBean[] newArray(int size) {
                return new MainBean[size];
            }
        };

        @Override
        public String toString() {
            return "MainBean{" +
                    "temp=" + temp +
                    ", pressure=" + pressure +
                    ", humidity=" + humidity +
                    ", temp_min=" + temp_min +
                    ", temp_max=" + temp_max +
                    '}';
        }
    }

    public static class WindBean implements Parcelable {
        /**
         * speed : 5
         * deg : 190
         */

        private int speed;
        private int deg;

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public int getDeg() {
            return deg;
        }

        public void setDeg(int deg) {
            this.deg = deg;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.speed);
            dest.writeInt(this.deg);
        }

        public WindBean() {
        }

        protected WindBean(Parcel in) {
            this.speed = in.readInt();
            this.deg = in.readInt();
        }

        public static final Creator<WindBean> CREATOR = new Creator<WindBean>() {
            @Override
            public WindBean createFromParcel(Parcel source) {
                return new WindBean(source);
            }

            @Override
            public WindBean[] newArray(int size) {
                return new WindBean[size];
            }
        };

        @Override
        public String toString() {
            return "WindBean{" +
                    "speed=" + speed +
                    ", deg=" + deg +
                    '}';
        }
    }

    public static class CloudsBean implements Parcelable {
        /**
         * all : 20
         */

        private int all;

        public int getAll() {
            return all;
        }

        public void setAll(int all) {
            this.all = all;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.all);
        }

        public CloudsBean() {
        }

        protected CloudsBean(Parcel in) {
            this.all = in.readInt();
        }

        public static final Creator<CloudsBean> CREATOR = new Creator<CloudsBean>() {
            @Override
            public CloudsBean createFromParcel(Parcel source) {
                return new CloudsBean(source);
            }

            @Override
            public CloudsBean[] newArray(int size) {
                return new CloudsBean[size];
            }
        };

        @Override
        public String toString() {
            return "CloudsBean{" +
                    "all=" + all +
                    '}';
        }
    }

    public static class SysBean implements Parcelable {
        /**
         * type : 1
         * id : 9658
         * message : 0.0085
         * country : CN
         * sunrise : 1564089906
         * sunset : 1564138395
         */

        private int type;
        private int id;
        private double message;
        private String country;
        private long sunrise;
        private long sunset;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getMessage() {
            return message;
        }

        public void setMessage(double message) {
            this.message = message;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public long getSunrise() {
            return sunrise;
        }

        public void setSunrise(long sunrise) {
            this.sunrise = sunrise;
        }

        public long getSunset() {
            return sunset;
        }

        public void setSunset(long sunset) {
            this.sunset = sunset;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.type);
            dest.writeInt(this.id);
            dest.writeDouble(this.message);
            dest.writeString(this.country);
            dest.writeLong(this.sunrise);
            dest.writeLong(this.sunset);
        }

        public SysBean() {
        }

        protected SysBean(Parcel in) {
            this.type = in.readInt();
            this.id = in.readInt();
            this.message = in.readDouble();
            this.country = in.readString();
            this.sunrise = in.readLong();
            this.sunset = in.readLong();
        }

        public static final Creator<SysBean> CREATOR = new Creator<SysBean>() {
            @Override
            public SysBean createFromParcel(Parcel source) {
                return new SysBean(source);
            }

            @Override
            public SysBean[] newArray(int size) {
                return new SysBean[size];
            }
        };

        @Override
        public String toString() {
            return "SysBean{" +
                    "type=" + type +
                    ", id=" + id +
                    ", message=" + message +
                    ", country='" + country + '\'' +
                    ", sunrise=" + sunrise +
                    ", sunset=" + sunset +
                    '}';
        }
    }

    public static class WeatherBean {
        /**
         * id : 801
         * main : Clouds
         * description : 晴，少云
         * icon : 02d
         */

        private int id;
        private String main;
        private String description;
        private String icon;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        @Override
        public String toString() {
            return "WeatherBean{" +
                    "id=" + id +
                    ", main='" + main + '\'' +
                    ", description='" + description + '\'' +
                    ", icon='" + icon + '\'' +
                    '}';
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.coord, flags);
        dest.writeString(this.base);
        dest.writeParcelable(this.main, flags);
        dest.writeInt(this.visibility);
        dest.writeParcelable(this.wind, flags);
        dest.writeParcelable(this.clouds, flags);
        dest.writeLong(this.dt);
        dest.writeParcelable(this.sys, flags);
        dest.writeInt(this.timezone);
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.cod);
        dest.writeList(this.weather);
    }

    public CurrWeatherData() {
    }

    protected CurrWeatherData(Parcel in) {
        this.coord = in.readParcelable(CoordBean.class.getClassLoader());
        this.base = in.readString();
        this.main = in.readParcelable(MainBean.class.getClassLoader());
        this.visibility = in.readInt();
        this.wind = in.readParcelable(WindBean.class.getClassLoader());
        this.clouds = in.readParcelable(CloudsBean.class.getClassLoader());
        this.dt = in.readLong();
        this.sys = in.readParcelable(SysBean.class.getClassLoader());
        this.timezone = in.readInt();
        this.id = in.readInt();
        this.name = in.readString();
        this.cod = in.readInt();
        this.weather = new ArrayList<WeatherBean>();
        in.readList(this.weather, WeatherBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<CurrWeatherData> CREATOR = new Parcelable.Creator<CurrWeatherData>() {
        @Override
        public CurrWeatherData createFromParcel(Parcel source) {
            return new CurrWeatherData(source);
        }

        @Override
        public CurrWeatherData[] newArray(int size) {
            return new CurrWeatherData[size];
        }
    };

    @Override
    public String toString() {
        return "CurrWeatherData{" +
                "coord=" + coord +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", visibility=" + visibility +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", dt=" + dt +
                ", sys=" + sys +
                ", timezone=" + timezone +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                ", weather=" + weather +
                '}';
    }
}
