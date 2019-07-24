package model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/** 天气预报的数据
 * Created by wangd on 2016/6/12.
 */
public class WeatherForecastData implements Parcelable {
    /**
     * id : 524901
     * name : Moscow
     * coord : {"lon":37.615555,"lat":55.75222}
     * country : RU
     * population : 0
     * sys : {"population":0}
     */

    private CityBean city;
    /**
     * city : {"id":524901,"name":"Moscow","coord":{"lon":37.615555,"lat":55.75222},"country":"RU","population":0,"sys":{"population":0}}
     * cod : 200
     * message : 0.0095
     * cnt : 35
     * list : [{"dt":1465743600,"main":{"temp":285.84,"temp_min":285.486,"temp_max":285.84,"pressure":998.92,"sea_level":1018.36,"grnd_level":998.92,"humidity":81,"temp_kf":0.36},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":64},"wind":{"speed":6.36,"deg":236.5},"rain":{"3h":0.06},"sys":{"pod":"d"},"dt_txt":"2016-06-12 15:00:00"},{"dt":1465754400,"main":{"temp":285.23,"temp_min":284.99,"temp_max":285.23,"pressure":999.81,"sea_level":1019.27,"grnd_level":999.81,"humidity":76,"temp_kf":0.24},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":64},"wind":{"speed":5.7,"deg":241},"rain":{"3h":0.01},"sys":{"pod":"d"},"dt_txt":"2016-06-12 18:00:00"},{"dt":1465765200,"main":{"temp":284.67,"temp_min":284.551,"temp_max":284.67,"pressure":1000.49,"sea_level":1020.09,"grnd_level":1000.49,"humidity":76,"temp_kf":0.12},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04n"}],"clouds":{"all":56},"wind":{"speed":6.01,"deg":248},"rain":{},"sys":{"pod":"n"},"dt_txt":"2016-06-12 21:00:00"},{"dt":1465776000,"main":{"temp":283.815,"temp_min":283.815,"temp_max":283.815,"pressure":1001.52,"sea_level":1021.32,"grnd_level":1001.52,"humidity":79,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":48},"wind":{"speed":5.21,"deg":259.001},"rain":{"3h":0.01},"sys":{"pod":"n"},"dt_txt":"2016-06-13 00:00:00"},{"dt":1465786800,"main":{"temp":283.876,"temp_min":283.876,"temp_max":283.876,"pressure":1002.95,"sea_level":1022.64,"grnd_level":1002.95,"humidity":78,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"clouds":{"all":0},"wind":{"speed":4.57,"deg":261.506},"rain":{},"sys":{"pod":"d"},"dt_txt":"2016-06-13 03:00:00"},{"dt":1465797600,"main":{"temp":286.658,"temp_min":286.658,"temp_max":286.658,"pressure":1003.73,"sea_level":1023.2,"grnd_level":1003.73,"humidity":76,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"clouds":{"all":0},"wind":{"speed":4.81,"deg":251.002},"rain":{},"sys":{"pod":"d"},"dt_txt":"2016-06-13 06:00:00"},{"dt":1465808400,"main":{"temp":287.94,"temp_min":287.94,"temp_max":287.94,"pressure":1004.07,"sea_level":1023.49,"grnd_level":1004.07,"humidity":70,"temp_kf":0},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04d"}],"clouds":{"all":56},"wind":{"speed":5.71,"deg":248.5},"rain":{},"sys":{"pod":"d"},"dt_txt":"2016-06-13 09:00:00"},{"dt":1465819200,"main":{"temp":289.051,"temp_min":289.051,"temp_max":289.051,"pressure":1004.31,"sea_level":1023.76,"grnd_level":1004.31,"humidity":64,"temp_kf":0},"weather":[{"id":801,"main":"Clouds","description":"few clouds","icon":"02d"}],"clouds":{"all":24},"wind":{"speed":5.36,"deg":252.004},"rain":{},"sys":{"pod":"d"},"dt_txt":"2016-06-13 12:00:00"},{"dt":1465830000,"main":{"temp":289.527,"temp_min":289.527,"temp_max":289.527,"pressure":1004.67,"sea_level":1023.98,"grnd_level":1004.67,"humidity":60,"temp_kf":0},"weather":[{"id":801,"main":"Clouds","description":"few clouds","icon":"02d"}],"clouds":{"all":12},"wind":{"speed":4.12,"deg":254.503},"rain":{},"sys":{"pod":"d"},"dt_txt":"2016-06-13 15:00:00"},{"dt":1465840800,"main":{"temp":286.244,"temp_min":286.244,"temp_max":286.244,"pressure":1005.23,"sea_level":1024.71,"grnd_level":1005.23,"humidity":63,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"clouds":{"all":0},"wind":{"speed":2.06,"deg":234.001},"rain":{},"sys":{"pod":"d"},"dt_txt":"2016-06-13 18:00:00"},{"dt":1465851600,"main":{"temp":281.377,"temp_min":281.377,"temp_max":281.377,"pressure":1005.44,"sea_level":1025.08,"grnd_level":1005.44,"humidity":79,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01n"}],"clouds":{"all":0},"wind":{"speed":1.17,"deg":166.505},"rain":{},"sys":{"pod":"n"},"dt_txt":"2016-06-13 21:00:00"},{"dt":1465862400,"main":{"temp":279.55,"temp_min":279.55,"temp_max":279.55,"pressure":1005.37,"sea_level":1025.19,"grnd_level":1005.37,"humidity":82,"temp_kf":0},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"02n"}],"clouds":{"all":8},"wind":{"speed":1.16,"deg":112.5},"rain":{},"sys":{"pod":"n"},"dt_txt":"2016-06-14 00:00:00"},{"dt":1465873200,"main":{"temp":282.675,"temp_min":282.675,"temp_max":282.675,"pressure":1005.82,"sea_level":1025.46,"grnd_level":1005.82,"humidity":82,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04d"}],"clouds":{"all":92},"wind":{"speed":2.66,"deg":165.501},"rain":{},"sys":{"pod":"d"},"dt_txt":"2016-06-14 03:00:00"},{"dt":1465884000,"main":{"temp":285.553,"temp_min":285.553,"temp_max":285.553,"pressure":1005.75,"sea_level":1025.2,"grnd_level":1005.75,"humidity":93,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":2.9,"deg":139.003},"rain":{"3h":1.66},"sys":{"pod":"d"},"dt_txt":"2016-06-14 06:00:00"},{"dt":1465894800,"main":{"temp":284.889,"temp_min":284.889,"temp_max":284.889,"pressure":1005.2,"sea_level":1024.69,"grnd_level":1005.2,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":4.07,"deg":97.5026},"rain":{"3h":2.97},"sys":{"pod":"d"},"dt_txt":"2016-06-14 09:00:00"},{"dt":1465905600,"main":{"temp":285.349,"temp_min":285.349,"temp_max":285.349,"pressure":1004.1,"sea_level":1023.5,"grnd_level":1004.1,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":4.46,"deg":91.0008},"rain":{"3h":1.14},"sys":{"pod":"d"},"dt_txt":"2016-06-14 12:00:00"},{"dt":1465916400,"main":{"temp":286.158,"temp_min":286.158,"temp_max":286.158,"pressure":1002.13,"sea_level":1021.49,"grnd_level":1002.13,"humidity":100,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":4.32,"deg":73.5013},"rain":{"3h":0.97},"sys":{"pod":"d"},"dt_txt":"2016-06-14 15:00:00"},{"dt":1465927200,"main":{"temp":286.295,"temp_min":286.295,"temp_max":286.295,"pressure":1001.77,"sea_level":1021.11,"grnd_level":1001.77,"humidity":98,"temp_kf":0},"weather":[{"id":501,"main":"Rain","description":"moderate rain","icon":"10d"}],"clouds":{"all":100},"wind":{"speed":3.11,"deg":69.5016},"rain":{"3h":4.46},"sys":{"pod":"d"},"dt_txt":"2016-06-14 18:00:00"},{"dt":1465938000,"main":{"temp":286.296,"temp_min":286.296,"temp_max":286.296,"pressure":1001.38,"sea_level":1020.81,"grnd_level":1001.38,"humidity":98,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":76},"wind":{"speed":2.62,"deg":67.0024},"rain":{"3h":0.51},"sys":{"pod":"n"},"dt_txt":"2016-06-14 21:00:00"},{"dt":1465948800,"main":{"temp":285.178,"temp_min":285.178,"temp_max":285.178,"pressure":1001.37,"sea_level":1020.82,"grnd_level":1001.37,"humidity":96,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":68},"wind":{"speed":1.87,"deg":85.5004},"rain":{"3h":0.02},"sys":{"pod":"n"},"dt_txt":"2016-06-15 00:00:00"},{"dt":1465959600,"main":{"temp":287.196,"temp_min":287.196,"temp_max":287.196,"pressure":1001.59,"sea_level":1021,"grnd_level":1001.59,"humidity":98,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":76},"wind":{"speed":1.5,"deg":98.5002},"rain":{"3h":2.57},"sys":{"pod":"d"},"dt_txt":"2016-06-15 03:00:00"},{"dt":1465970400,"main":{"temp":291.939,"temp_min":291.939,"temp_max":291.939,"pressure":1001.68,"sea_level":1020.96,"grnd_level":1001.68,"humidity":98,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":44},"wind":{"speed":3.21,"deg":123.5},"rain":{"3h":0.24},"sys":{"pod":"d"},"dt_txt":"2016-06-15 06:00:00"},{"dt":1465981200,"main":{"temp":294.301,"temp_min":294.301,"temp_max":294.301,"pressure":1002.7,"sea_level":1021.98,"grnd_level":1002.7,"humidity":93,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":88},"wind":{"speed":3.06,"deg":225.502},"rain":{"3h":0.01},"sys":{"pod":"d"},"dt_txt":"2016-06-15 09:00:00"},{"dt":1465992000,"main":{"temp":293.575,"temp_min":293.575,"temp_max":293.575,"pressure":1003.18,"sea_level":1022.38,"grnd_level":1003.18,"humidity":93,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":100},"wind":{"speed":1.58,"deg":143.506},"rain":{"3h":0.03},"sys":{"pod":"d"},"dt_txt":"2016-06-15 12:00:00"},{"dt":1466002800,"main":{"temp":294.417,"temp_min":294.417,"temp_max":294.417,"pressure":1002.26,"sea_level":1021.48,"grnd_level":1002.26,"humidity":85,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04d"}],"clouds":{"all":92},"wind":{"speed":2.52,"deg":150.501},"rain":{},"sys":{"pod":"d"},"dt_txt":"2016-06-15 15:00:00"},{"dt":1466013600,"main":{"temp":292.03,"temp_min":292.03,"temp_max":292.03,"pressure":1001.84,"sea_level":1021.16,"grnd_level":1001.84,"humidity":83,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":76},"wind":{"speed":3.85,"deg":135.001},"rain":{"3h":0.04},"sys":{"pod":"d"},"dt_txt":"2016-06-15 18:00:00"},{"dt":1466024400,"main":{"temp":290.394,"temp_min":290.394,"temp_max":290.394,"pressure":1001.37,"sea_level":1020.77,"grnd_level":1001.37,"humidity":88,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10n"}],"clouds":{"all":88},"wind":{"speed":1.66,"deg":109},"rain":{"3h":0.15},"sys":{"pod":"n"},"dt_txt":"2016-06-15 21:00:00"},{"dt":1466035200,"main":{"temp":290.712,"temp_min":290.712,"temp_max":290.712,"pressure":1001.75,"sea_level":1021.11,"grnd_level":1001.75,"humidity":90,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],"clouds":{"all":88},"wind":{"speed":3.41,"deg":166.503},"rain":{},"sys":{"pod":"n"},"dt_txt":"2016-06-16 00:00:00"},{"dt":1466046000,"main":{"temp":291.362,"temp_min":291.362,"temp_max":291.362,"pressure":1002.36,"sea_level":1021.56,"grnd_level":1002.36,"humidity":91,"temp_kf":0},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04d"}],"clouds":{"all":92},"wind":{"speed":3.14,"deg":153.001},"rain":{},"sys":{"pod":"d"},"dt_txt":"2016-06-16 03:00:00"},{"dt":1466056800,"main":{"temp":294.465,"temp_min":294.465,"temp_max":294.465,"pressure":1003.12,"sea_level":1022.29,"grnd_level":1003.12,"humidity":91,"temp_kf":0},"weather":[{"id":802,"main":"Clouds","description":"scattered clouds","icon":"03d"}],"clouds":{"all":36},"wind":{"speed":2.72,"deg":179.508},"rain":{},"sys":{"pod":"d"},"dt_txt":"2016-06-16 06:00:00"},{"dt":1466067600,"main":{"temp":298.15,"temp_min":298.15,"temp_max":298.15,"pressure":1003.51,"sea_level":1022.66,"grnd_level":1003.51,"humidity":75,"temp_kf":0},"weather":[{"id":801,"main":"Clouds","description":"few clouds","icon":"02d"}],"clouds":{"all":24},"wind":{"speed":4.1,"deg":195.002},"rain":{},"sys":{"pod":"d"},"dt_txt":"2016-06-16 09:00:00"},{"dt":1466078400,"main":{"temp":298.262,"temp_min":298.262,"temp_max":298.262,"pressure":1003.91,"sea_level":1023.16,"grnd_level":1003.91,"humidity":66,"temp_kf":0},"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04d"}],"clouds":{"all":68},"wind":{"speed":4.66,"deg":194.003},"rain":{},"sys":{"pod":"d"},"dt_txt":"2016-06-16 12:00:00"},{"dt":1466089200,"main":{"temp":296.097,"temp_min":296.097,"temp_max":296.097,"pressure":1004.5,"sea_level":1023.83,"grnd_level":1004.5,"humidity":70,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":3.46,"deg":195.505},"rain":{"3h":0.01},"sys":{"pod":"d"},"dt_txt":"2016-06-16 15:00:00"},{"dt":1466100000,"main":{"temp":293.051,"temp_min":293.051,"temp_max":293.051,"pressure":1005.19,"sea_level":1024.53,"grnd_level":1005.19,"humidity":89,"temp_kf":0},"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"clouds":{"all":92},"wind":{"speed":3.01,"deg":188.507},"rain":{"3h":1.14},"sys":{"pod":"d"},"dt_txt":"2016-06-16 18:00:00"},{"dt":1466110800,"main":{"temp":289.65,"temp_min":289.65,"temp_max":289.65,"pressure":1005.76,"sea_level":1025.06,"grnd_level":1005.76,"humidity":98,"temp_kf":0},"weather":[{"id":502,"main":"Rain","description":"heavy intensity rain","icon":"10n"}],"clouds":{"all":92},"wind":{"speed":2.87,"deg":210.001},"rain":{"3h":13.41},"sys":{"pod":"n"},"dt_txt":"2016-06-16 21:00:00"}]
     */

    private String cod;
    private double message;
    private int cnt;
    /**
     * dt : 1465743600
     * main : {"temp":285.84,"temp_min":285.486,"temp_max":285.84,"pressure":998.92,"sea_level":1018.36,"grnd_level":998.92,"humidity":81,"temp_kf":0.36}
     * weather : [{"id":500,"main":"Rain","description":"light rain","icon":"10d"}]
     * clouds : {"all":64}
     * wind : {"speed":6.36,"deg":236.5}
     * rain : {"3h":0.06}
     * sys : {"pod":"d"}
     * dt_txt : 2016-06-12 15:00:00
     */

    private List<ListBean> list;

    public CityBean getCity() {
        return city;
    }

    public void setCity(CityBean city) {
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class CityBean implements Parcelable {
        private int id;
        private String name;
        /**
         * lon : 37.615555
         * lat : 55.75222
         */

        private CoordBean coord;
        private String country;
        private int population;
        /**
         * population : 0
         */

        private SysBean sys;

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

        public CoordBean getCoord() {
            return coord;
        }

        public void setCoord(CoordBean coord) {
            this.coord = coord;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public SysBean getSys() {
            return sys;
        }

        public void setSys(SysBean sys) {
            this.sys = sys;
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

        public static class SysBean implements Parcelable {
            private int population;

            public int getPopulation() {
                return population;
            }

            public void setPopulation(int population) {
                this.population = population;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.population);
            }

            public SysBean() {
            }

            protected SysBean(Parcel in) {
                this.population = in.readInt();
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeString(this.name);
            dest.writeParcelable(this.coord, flags);
            dest.writeString(this.country);
            dest.writeInt(this.population);
            dest.writeParcelable(this.sys, flags);
        }

        public CityBean() {
        }

        protected CityBean(Parcel in) {
            this.id = in.readInt();
            this.name = in.readString();
            this.coord = in.readParcelable(CoordBean.class.getClassLoader());
            this.country = in.readString();
            this.population = in.readInt();
            this.sys = in.readParcelable(SysBean.class.getClassLoader());
        }

        public static final Creator<CityBean> CREATOR = new Creator<CityBean>() {
            @Override
            public CityBean createFromParcel(Parcel source) {
                return new CityBean(source);
            }

            @Override
            public CityBean[] newArray(int size) {
                return new CityBean[size];
            }
        };
    }

    public static class ListBean implements Parcelable {
        private long dt;
        /**
         * temp : 285.84
         * temp_min : 285.486
         * temp_max : 285.84
         * pressure : 998.92
         * sea_level : 1018.36
         * grnd_level : 998.92
         * humidity : 81
         * temp_kf : 0.36
         */

        private MainBean main;
        /**
         * all : 64
         */

        private CloudsBean clouds;
        /**
         * speed : 6.36
         * deg : 236.5
         */

        private WindBean wind;
        /**
         * 3h : 0.06
         */

        private RainBean rain;
        /**
         * pod : d
         */

        private SysBean sys;
        private String dt_txt;
        /**
         * id : 500
         * main : Rain
         * description : light rain
         * icon : 10d
         */

        private List<WeatherBean> weather;

        public long getDt() {
            return dt;
        }

        public void setDt(long dt) {
            this.dt = dt;
        }

        public MainBean getMain() {
            return main;
        }

        public void setMain(MainBean main) {
            this.main = main;
        }

        public CloudsBean getClouds() {
            return clouds;
        }

        public void setClouds(CloudsBean clouds) {
            this.clouds = clouds;
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

        public SysBean getSys() {
            return sys;
        }

        public void setSys(SysBean sys) {
            this.sys = sys;
        }

        public String getDt_txt() {
            return dt_txt;
        }

        public void setDt_txt(String dt_txt) {
            this.dt_txt = dt_txt;
        }

        public List<WeatherBean> getWeather() {
            return weather;
        }

        public void setWeather(List<WeatherBean> weather) {
            this.weather = weather;
        }

        public static class MainBean implements Parcelable {
            private double temp;
            private double temp_min;
            private double temp_max;
            private double pressure;
            private double sea_level;
            private double grnd_level;
            private int humidity;
            private double temp_kf;

            public double getTemp() {
                return temp;
            }

            public void setTemp(double temp) {
                this.temp = temp;
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

            public double getPressure() {
                return pressure;
            }

            public void setPressure(double pressure) {
                this.pressure = pressure;
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

            public int getHumidity() {
                return humidity;
            }

            public void setHumidity(int humidity) {
                this.humidity = humidity;
            }

            public double getTemp_kf() {
                return temp_kf;
            }

            public void setTemp_kf(double temp_kf) {
                this.temp_kf = temp_kf;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeDouble(this.temp);
                dest.writeDouble(this.temp_min);
                dest.writeDouble(this.temp_max);
                dest.writeDouble(this.pressure);
                dest.writeDouble(this.sea_level);
                dest.writeDouble(this.grnd_level);
                dest.writeInt(this.humidity);
                dest.writeDouble(this.temp_kf);
            }

            public MainBean() {
            }

            protected MainBean(Parcel in) {
                this.temp = in.readDouble();
                this.temp_min = in.readDouble();
                this.temp_max = in.readDouble();
                this.pressure = in.readDouble();
                this.sea_level = in.readDouble();
                this.grnd_level = in.readDouble();
                this.humidity = in.readInt();
                this.temp_kf = in.readDouble();
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

        public static class SysBean implements Parcelable {
            private String pod;

            public String getPod() {
                return pod;
            }

            public void setPod(String pod) {
                this.pod = pod;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.pod);
            }

            public SysBean() {
            }

            protected SysBean(Parcel in) {
                this.pod = in.readString();
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

        public static class WeatherBean implements Parcelable {
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
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.id);
                dest.writeString(this.main);
                dest.writeString(this.description);
                dest.writeString(this.icon);
            }

            public WeatherBean() {
            }

            protected WeatherBean(Parcel in) {
                this.id = in.readInt();
                this.main = in.readString();
                this.description = in.readString();
                this.icon = in.readString();
            }

            public static final Creator<WeatherBean> CREATOR = new Creator<WeatherBean>() {
                @Override
                public WeatherBean createFromParcel(Parcel source) {
                    return new WeatherBean(source);
                }

                @Override
                public WeatherBean[] newArray(int size) {
                    return new WeatherBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeLong(this.dt);
            dest.writeParcelable(this.main, flags);
            dest.writeParcelable(this.clouds, flags);
            dest.writeParcelable(this.wind, flags);
            dest.writeParcelable(this.rain, flags);
            dest.writeParcelable(this.sys, flags);
            dest.writeString(this.dt_txt);
            dest.writeList(this.weather);
        }

        public ListBean() {
        }

        protected ListBean(Parcel in) {
            this.dt = in.readLong();
            this.main = in.readParcelable(MainBean.class.getClassLoader());
            this.clouds = in.readParcelable(CloudsBean.class.getClassLoader());
            this.wind = in.readParcelable(WindBean.class.getClassLoader());
            this.rain = in.readParcelable(RainBean.class.getClassLoader());
            this.sys = in.readParcelable(SysBean.class.getClassLoader());
            this.dt_txt = in.readString();
            this.weather = new ArrayList<WeatherBean>();
            in.readList(this.weather, WeatherBean.class.getClassLoader());
        }

        public static final Creator<ListBean> CREATOR = new Creator<ListBean>() {
            @Override
            public ListBean createFromParcel(Parcel source) {
                return new ListBean(source);
            }

            @Override
            public ListBean[] newArray(int size) {
                return new ListBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.city, flags);
        dest.writeString(this.cod);
        dest.writeDouble(this.message);
        dest.writeInt(this.cnt);
        dest.writeList(this.list);
    }

    public WeatherForecastData() {
    }

    protected WeatherForecastData(Parcel in) {
        this.city = in.readParcelable(CityBean.class.getClassLoader());
        this.cod = in.readString();
        this.message = in.readDouble();
        this.cnt = in.readInt();
        this.list = new ArrayList<ListBean>();
        in.readList(this.list, ListBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<WeatherForecastData> CREATOR = new Parcelable.Creator<WeatherForecastData>() {
        @Override
        public WeatherForecastData createFromParcel(Parcel source) {
            return new WeatherForecastData(source);
        }

        @Override
        public WeatherForecastData[] newArray(int size) {
            return new WeatherForecastData[size];
        }
    };
}
