package model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * openweather天气预报的数据
 * Created by wangd on 2016/6/12.
 */
public class WeatherForecastData implements Parcelable {

    /**
     * city : {"id":2066756,"name":"Maylands","coord":{"lon":115.8833,"lat":-31.9334},"country":"AU","population":10447,"timezone":28800}
     * cod : 200
     * message : 0.0627178
     * cnt : 7
     * list : [{"dt":1563940800,"temp":{"day":18.1,"min":17.83,"max":18.26,"night":17.84,"eve":17.83,"morn":18.1},"pressure":1021.26,"humidity":73,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":6.52,"deg":331,"clouds":0,"rain":1.5},{"dt":1564027200,"temp":{"day":15.02,"min":15.02,"max":17.09,"night":16.07,"eve":16.25,"morn":17.09},"pressure":1024.92,"humidity":80,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":6.28,"deg":144,"clouds":100,"rain":1.31},{"dt":1564113600,"temp":{"day":14.45,"min":14.45,"max":16.31,"night":16.09,"eve":15.73,"morn":14.88},"pressure":1021.05,"humidity":71,"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04d"}],"speed":5.3,"deg":43,"clouds":100},{"dt":1564200000,"temp":{"day":13.95,"min":13.95,"max":15.85,"night":15.21,"eve":15.65,"morn":14.32},"pressure":1020.42,"humidity":82,"weather":[{"id":500,"main":"Rain","description":"light rain","icon":"10d"}],"speed":5.42,"deg":161,"clouds":76,"rain":1.63},{"dt":1564286400,"temp":{"day":14.03,"min":13.26,"max":15.83,"night":15.78,"eve":15.25,"morn":13.26},"pressure":1025.5,"humidity":76,"weather":[{"id":803,"main":"Clouds","description":"broken clouds","icon":"04d"}],"speed":6.76,"deg":140,"clouds":61},{"dt":1564372800,"temp":{"day":14.46,"min":13.64,"max":17.45,"night":16.37,"eve":17.45,"morn":14.61},"pressure":1027.83,"humidity":64,"weather":[{"id":800,"main":"Clear","description":"sky is clear","icon":"01d"}],"speed":5.77,"deg":90,"clouds":0},{"dt":1564459200,"temp":{"day":15.99,"min":14.92,"max":18.85,"night":17.48,"eve":18.85,"morn":15.52},"pressure":1026.99,"humidity":68,"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04d"}],"speed":7.29,"deg":40,"clouds":100}]
     */

    private CityBean city;
    private String cod;
    private double message;
    private int cnt;
    private List<ListBean> list; //天气预报的数据

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
        /**
         * id : 2066756
         * name : Maylands
         * coord : {"lon":115.8833,"lat":-31.9334}
         * country : AU
         * population : 10447
         * timezone : 28800
         */

        private int id;
        private String name;
        private CoordBean coord;
        private String country;
        private int population;
        private int timezone;

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

        public int getTimezone() {
            return timezone;
        }

        public void setTimezone(int timezone) {
            this.timezone = timezone;
        }

        public static class CoordBean implements Parcelable {
            /**
             * lon : 115.8833
             * lat : -31.9334
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
            dest.writeInt(this.timezone);
        }

        public CityBean() {
        }

        protected CityBean(Parcel in) {
            this.id = in.readInt();
            this.name = in.readString();
            this.coord = in.readParcelable(CoordBean.class.getClassLoader());
            this.country = in.readString();
            this.population = in.readInt();
            this.timezone = in.readInt();
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

    public static class ListBean {
        /**
         * dt : 1563940800
         * temp : {"day":18.1,"min":17.83,"max":18.26,"night":17.84,"eve":17.83,"morn":18.1}
         * pressure : 1021.26
         * humidity : 73
         * weather : [{"id":500,"main":"Rain","description":"light rain","icon":"10d"}]
         * speed : 6.52
         * deg : 331
         * clouds : 0
         * rain : 1.5
         */

        private int dt;
        private TempBean temp;
        private double pressure;
        private int humidity;
        private double speed;
        private int deg;
        private int clouds;
        private double rain;
        private List<WeatherBean> weather;

        public int getDt() {
            return dt;
        }

        public void setDt(int dt) {
            this.dt = dt;
        }

        public TempBean getTemp() {
            return temp;
        }

        public void setTemp(TempBean temp) {
            this.temp = temp;
        }

        public double getPressure() {
            return pressure;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public int getDeg() {
            return deg;
        }

        public void setDeg(int deg) {
            this.deg = deg;
        }

        public int getClouds() {
            return clouds;
        }

        public void setClouds(int clouds) {
            this.clouds = clouds;
        }

        public double getRain() {
            return rain;
        }

        public void setRain(double rain) {
            this.rain = rain;
        }

        public List<WeatherBean> getWeather() {
            return weather;
        }

        public void setWeather(List<WeatherBean> weather) {
            this.weather = weather;
        }

        public static class TempBean {
            /**
             * day : 18.1
             * min : 17.83
             * max : 18.26
             * night : 17.84
             * eve : 17.83
             * morn : 18.1
             */

            private double day;
            private double min;
            private double max;
            private double night;
            private double eve;
            private double morn;

            public double getDay() {
                return day;
            }

            public void setDay(double day) {
                this.day = day;
            }

            public double getMin() {
                return min;
            }

            public void setMin(double min) {
                this.min = min;
            }

            public double getMax() {
                return max;
            }

            public void setMax(double max) {
                this.max = max;
            }

            public double getNight() {
                return night;
            }

            public void setNight(double night) {
                this.night = night;
            }

            public double getEve() {
                return eve;
            }

            public void setEve(double eve) {
                this.eve = eve;
            }

            public double getMorn() {
                return morn;
            }

            public void setMorn(double morn) {
                this.morn = morn;
            }
        }

        public static class WeatherBean {
            /**
             * id : 500
             * main : Rain
             * description : light rain
             * icon : 10d
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
        }
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
