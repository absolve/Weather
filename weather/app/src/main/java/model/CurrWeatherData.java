package model;

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
     * lon : 145.77
     * lat : -16.92
     */

    private CoordBean coord;
    /**
     * coord : {"lon":145.77,"lat":-16.92}
     * weather : [{"id":500,"main":"Rain","description":"light rain","icon":"10n"}]
     * base : stations
     * main : {"temp":295,"pressure":1017,"humidity":10,"temp_min":291.48,"temp_max":297.04}
     * wind : {"speed":8.16,"deg":121.003}
     * rain : {"3h":0.22}
     * clouds : {"all":100}
     * dt : 1465733110
     * sys : {"type":3,"id":35642,"message":0.0153,"country":"AU","sunrise":1465677778,"sunset":1465717847}
     * id : 2172797
     * name : Cairns
     * cod : 200
     */

    private String base;
    /**
     * temp : 295
     * pressure : 1017
     * humidity : 10
     * temp_min : 291.48
     * temp_max : 297.04
     */

    private MainBean main;
    /**
     * speed : 8.16
     * deg : 121.003
     */

    private WindBean wind;
    /**
     * 3h : 0.22
     */

    private RainBean rain;
    /**
     * all : 100
     */

    private CloudsBean clouds;
    private int dt;
    /**
     * type : 3
     * id : 35642
     * message : 0.0153
     * country : AU
     * sunrise : 1465677778
     * sunset : 1465717847
     */

    private SysBean sys;
    private int id;
    private String name;
    private int cod;
    /**
     * id : 500
     * main : Rain
     * description : light rain
     * icon : 10n
     */

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

    public WindBean getWind() {
        return wind;
    }

    public void setWind(WindBean wind) {
        this.wind = wind;
    }

    public RainBean getRain() {
        return rain;
    }

    public void setRain(RainBean rain) {
        this.rain = rain;
    }

    public CloudsBean getClouds() {
        return clouds;
    }

    public void setClouds(CloudsBean clouds) {
        this.clouds = clouds;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public SysBean getSys() {
        return sys;
    }

    public void setSys(SysBean sys) {
        this.sys = sys;
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
    }

    public static class MainBean implements Parcelable {
        private double temp;
        private double pressure;
        private double humidity;
        private double temp_min;
        private double temp_max;
        private double sea_level;
        private double grnd_level;


        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public double getPressure() {
            return pressure;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }

        public double getHumidity() {
            return humidity;
        }

        public void setHumidity(double humidity) {
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

        public double getSea_level() {
            return sea_level;
        }

        public void setSea_level(double sea_level) {
            this.sea_level = sea_level;
        }

        public double getGrnd_level() {
            return grnd_level;
        }

        public void setGrnd_level(double grnd_level) {
            this.grnd_level = grnd_level;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeDouble(this.temp);
            dest.writeDouble(this.pressure);
            dest.writeDouble(this.humidity);
            dest.writeDouble(this.temp_min);
            dest.writeDouble(this.temp_max);
            dest.writeDouble(this.sea_level);
            dest.writeDouble(this.grnd_level);
        }

        public MainBean() {
        }

        protected MainBean(Parcel in) {
            this.temp = in.readDouble();
            this.pressure = in.readDouble();
            this.humidity = in.readDouble();
            this.temp_min = in.readDouble();
            this.temp_max = in.readDouble();
            this.sea_level = in.readDouble();
            this.grnd_level = in.readDouble();
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
    }

    public static class WindBean implements Parcelable {
        private double speed;
        private double deg;

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public double getDeg() {
            return deg;
        }

        public void setDeg(double deg) {
            this.deg = deg;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeDouble(this.speed);
            dest.writeDouble(this.deg);
        }

        public WindBean() {
        }

        protected WindBean(Parcel in) {
            this.speed = in.readDouble();
            this.deg = in.readDouble();
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
    }

    public static class RainBean implements Parcelable {

        private double value3h;

        public double getValue3h() {
            return value3h;
        }

        public void setValue3h(double value3h) {
            this.value3h = value3h;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeDouble(this.value3h);
        }

        public RainBean() {
        }

        protected RainBean(Parcel in) {
            this.value3h = in.readDouble();
        }

        public static final Creator<RainBean> CREATOR = new Creator<RainBean>() {
            @Override
            public RainBean createFromParcel(Parcel source) {
                return new RainBean(source);
            }

            @Override
            public RainBean[] newArray(int size) {
                return new RainBean[size];
            }
        };
    }

    public static class CloudsBean implements Parcelable {
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
    }

    public static class SysBean implements Parcelable {
        private int type;
        private int id;
        private double message;
        private String country;
        private Long sunrise;
        private Long sunset;

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

        public Long getSunrise() {
            return sunrise;
        }

        public void setSunrise(Long sunrise) {
            this.sunrise = sunrise;
        }

        public Long getSunset() {
            return sunset;
        }

        public void setSunset(Long sunset) {
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
    }

    public static class WeatherBean {
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
        dest.writeParcelable(this.wind, flags);
        dest.writeParcelable(this.rain, flags);
        dest.writeParcelable(this.clouds, flags);
        dest.writeInt(this.dt);
        dest.writeParcelable(this.sys, flags);
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
        this.wind = in.readParcelable(WindBean.class.getClassLoader());
        this.rain = in.readParcelable(RainBean.class.getClassLoader());
        this.clouds = in.readParcelable(CloudsBean.class.getClassLoader());
        this.dt = in.readInt();
        this.sys = in.readParcelable(SysBean.class.getClassLoader());
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
}
