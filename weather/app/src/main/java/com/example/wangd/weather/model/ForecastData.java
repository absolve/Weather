package com.example.wangd.weather.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/** 心知天气预报返回数据
 * Created by wangd on 2016/7/30.
 */
public class ForecastData implements Parcelable {

    /**
     * basic : {"city":"Roman","cnty":"Romania","id":"RO668732","lat":"46.916672","lon":"26.91667","update":{"loc":"2016-07-30 12:51","utc":"2016-07-30 09:51"}}
     * daily_forecast : [{"astro":{"sr":"05:50","ss":"20:47"},"cond":{"code_d":"305","code_n":"305","txt_d":"Light Rain","txt_n":"Light Rain"},"date":"2016-07-30","hum":"33","pcpn":"1.1","pop":"74","pres":"1014","tmp":{"max":"34","min":"17"},"vis":"9","wind":{"deg":"280","dir":"W","sc":"1-2","spd":"9"}},{"astro":{"sr":"05:51","ss":"20:45"},"cond":{"code_d":"100","code_n":"100","txt_d":"Sunny，Clear","txt_n":"Sunny，Clear"},"date":"2016-07-31","hum":"26","pcpn":"0.8","pop":"8","pres":"1015","tmp":{"max":"36","min":"18"},"vis":"10","wind":{"deg":"315","dir":"NW","sc":"1-2","spd":"9"}},{"astro":{"sr":"05:52","ss":"20:44"},"cond":{"code_d":"100","code_n":"305","txt_d":"Sunny，Clear","txt_n":"Light Rain"},"date":"2016-08-01","hum":"17","pcpn":"1.1","pop":"74","pres":"1013","tmp":{"max":"39","min":"18"},"vis":"10","wind":{"deg":"221","dir":"SW","sc":"1-2","spd":"9"}},{"astro":{"sr":"05:54","ss":"20:43"},"cond":{"code_d":"100","code_n":"307","txt_d":"Sunny，Clear","txt_n":"Heavy Rain"},"date":"2016-08-02","hum":"37","pcpn":"11.8","pop":"67","pres":"1014","tmp":{"max":"34","min":"19"},"vis":"10","wind":{"deg":"1","dir":"N","sc":"1-2","spd":"9"}},{"astro":{"sr":"05:55","ss":"20:41"},"cond":{"code_d":"301","code_n":"301","txt_d":"heavy shower rain","txt_n":"heavy shower rain"},"date":"2016-08-03","hum":"51","pcpn":"13.1","pop":"64","pres":"1012","tmp":{"max":"32","min":"19"},"vis":"7","wind":{"deg":"81","dir":"E","sc":"1-2","spd":"9"}},{"astro":{"sr":"05:56","ss":"20:40"},"cond":{"code_d":"103","code_n":"301","txt_d":"Partly Cloudy","txt_n":"heavy shower rain"},"date":"2016-08-04","hum":"52","pcpn":"9.1","pop":"56","pres":"1013","tmp":{"max":"30","min":"18"},"vis":"10","wind":{"deg":"349","dir":"NNW","sc":"1-2","spd":"9"}},{"astro":{"sr":"05:57","ss":"20:38"},"cond":{"code_d":"100","code_n":"305","txt_d":"Sunny，Clear","txt_n":"Light Rain"},"date":"2016-08-05","hum":"43","pcpn":"2.1","pop":"11","pres":"1014","tmp":{"max":"35","min":"19"},"vis":"10","wind":{"deg":"8","dir":"N","sc":"1-2","spd":"9"}}]
     * hourly_forecast : [{"date":"2016-07-30 13:00","hum":"34","pop":"34","pres":"1014","tmp":"34","wind":{"deg":"304","dir":"WNW","sc":"1-2","spd":"5"}},{"date":"2016-07-30 16:00","hum":"33","pop":"40","pres":"1014","tmp":"34","wind":{"deg":"257","dir":"WSW","sc":"1-2","spd":"5"}},{"date":"2016-07-30 19:00","hum":"47","pop":"42","pres":"1014","tmp":"32","wind":{"deg":"291","dir":"WNW","sc":"1-2","spd":"6"}},{"date":"2016-07-30 22:00","hum":"72","pop":"65","pres":"1015","tmp":"29","wind":{"deg":"309","dir":"NW","sc":"1-2","spd":"5"}}]
     * now : {"cond":{"code":"100","txt":"Sunny，Clear"},"fl":"29","hum":"70","pcpn":"0.0","pres":"1015","tmp":"27","vis":"10","wind":{"deg":"340","dir":"NNW","sc":"1-2","spd":"9"}}
     * status : ok
     */
    @SerializedName("HeWeather data service 3.0")
    public List<HeWeatherDataServiceBean> HeWeather_data_service;

    public static class HeWeatherDataServiceBean implements Parcelable {
        /**
         * city : Roman
         * cnty : Romania
         * id : RO668732
         * lat : 46.916672
         * lon : 26.91667
         * update : {"loc":"2016-07-30 12:51","utc":"2016-07-30 09:51"}
         */

        public BasicBean basic;
        /**
         * cond : {"code":"100","txt":"Sunny，Clear"}
         * fl : 29
         * hum : 70
         * pcpn : 0.0
         * pres : 1015
         * tmp : 27
         * vis : 10
         * wind : {"deg":"340","dir":"NNW","sc":"1-2","spd":"9"}
         */

        public NowBean now;
        public String status;
        /**
         * astro : {"sr":"05:50","ss":"20:47"}
         * cond : {"code_d":"305","code_n":"305","txt_d":"Light Rain","txt_n":"Light Rain"}
         * date : 2016-07-30
         * hum : 33
         * pcpn : 1.1
         * pop : 74
         * pres : 1014
         * tmp : {"max":"34","min":"17"}
         * vis : 9
         * wind : {"deg":"280","dir":"W","sc":"1-2","spd":"9"}
         */

        public List<DailyForecastBean> daily_forecast;
        /**
         * date : 2016-07-30 13:00
         * hum : 34
         * pop : 34
         * pres : 1014
         * tmp : 34
         * wind : {"deg":"304","dir":"WNW","sc":"1-2","spd":"5"}
         */

        public List<HourlyForecastBean> hourly_forecast;

        public static class BasicBean implements Parcelable {
            public String city;
            public String cnty;
            public String id;
            public String lat;
            public String lon;
            /**
             * loc : 2016-07-30 12:51
             * utc : 2016-07-30 09:51
             */

            public UpdateBean update;

            public static class UpdateBean implements Parcelable {
                public String loc;
                public String utc;

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.loc);
                    dest.writeString(this.utc);
                }

                public UpdateBean() {
                }

                protected UpdateBean(Parcel in) {
                    this.loc = in.readString();
                    this.utc = in.readString();
                }

                public static final Creator<UpdateBean> CREATOR = new Creator<UpdateBean>() {
                    @Override
                    public UpdateBean createFromParcel(Parcel source) {
                        return new UpdateBean(source);
                    }

                    @Override
                    public UpdateBean[] newArray(int size) {
                        return new UpdateBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.city);
                dest.writeString(this.cnty);
                dest.writeString(this.id);
                dest.writeString(this.lat);
                dest.writeString(this.lon);
                dest.writeParcelable(this.update, flags);
            }

            public BasicBean() {
            }

            protected BasicBean(Parcel in) {
                this.city = in.readString();
                this.cnty = in.readString();
                this.id = in.readString();
                this.lat = in.readString();
                this.lon = in.readString();
                this.update = in.readParcelable(UpdateBean.class.getClassLoader());
            }

            public static final Creator<BasicBean> CREATOR = new Creator<BasicBean>() {
                @Override
                public BasicBean createFromParcel(Parcel source) {
                    return new BasicBean(source);
                }

                @Override
                public BasicBean[] newArray(int size) {
                    return new BasicBean[size];
                }
            };
        }

        public static class NowBean implements Parcelable {
            /**
             * code : 100
             * txt : Sunny，Clear
             */

            public CondBean cond;
            public String fl;
            public String hum;
            public String pcpn;
            public String pres;
            public String tmp;
            public String vis;
            /**
             * deg : 340
             * dir : NNW
             * sc : 1-2
             * spd : 9
             */

            public WindBean wind;

            public static class CondBean implements Parcelable {
                public String code;
                public String txt;

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.code);
                    dest.writeString(this.txt);
                }

                public CondBean() {
                }

                protected CondBean(Parcel in) {
                    this.code = in.readString();
                    this.txt = in.readString();
                }

                public static final Creator<CondBean> CREATOR = new Creator<CondBean>() {
                    @Override
                    public CondBean createFromParcel(Parcel source) {
                        return new CondBean(source);
                    }

                    @Override
                    public CondBean[] newArray(int size) {
                        return new CondBean[size];
                    }
                };
            }

            public static class WindBean implements Parcelable {
                public String deg;
                public String dir;
                public String sc;
                public String spd;

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.deg);
                    dest.writeString(this.dir);
                    dest.writeString(this.sc);
                    dest.writeString(this.spd);
                }

                public WindBean() {
                }

                protected WindBean(Parcel in) {
                    this.deg = in.readString();
                    this.dir = in.readString();
                    this.sc = in.readString();
                    this.spd = in.readString();
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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeParcelable(this.cond, flags);
                dest.writeString(this.fl);
                dest.writeString(this.hum);
                dest.writeString(this.pcpn);
                dest.writeString(this.pres);
                dest.writeString(this.tmp);
                dest.writeString(this.vis);
                dest.writeParcelable(this.wind, flags);
            }

            public NowBean() {
            }

            protected NowBean(Parcel in) {
                this.cond = in.readParcelable(CondBean.class.getClassLoader());
                this.fl = in.readString();
                this.hum = in.readString();
                this.pcpn = in.readString();
                this.pres = in.readString();
                this.tmp = in.readString();
                this.vis = in.readString();
                this.wind = in.readParcelable(WindBean.class.getClassLoader());
            }

            public static final Creator<NowBean> CREATOR = new Creator<NowBean>() {
                @Override
                public NowBean createFromParcel(Parcel source) {
                    return new NowBean(source);
                }

                @Override
                public NowBean[] newArray(int size) {
                    return new NowBean[size];
                }
            };
        }

        public static class DailyForecastBean implements Parcelable {
            /**
             * sr : 05:50
             * ss : 20:47
             */

            public AstroBean astro;
            /**
             * code_d : 305
             * code_n : 305
             * txt_d : Light Rain
             * txt_n : Light Rain
             */

            public CondBean cond;
            public String date;
            public String hum;
            public String pcpn;
            public String pop;
            public String pres;
            /**
             * max : 34
             * min : 17
             */

            public TmpBean tmp;
            public String vis;
            /**
             * deg : 280
             * dir : W
             * sc : 1-2
             * spd : 9
             */

            public WindBean wind;

            public static class AstroBean implements Parcelable {
                public String sr;
                public String ss;

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.sr);
                    dest.writeString(this.ss);
                }

                public AstroBean() {
                }

                protected AstroBean(Parcel in) {
                    this.sr = in.readString();
                    this.ss = in.readString();
                }

                public static final Creator<AstroBean> CREATOR = new Creator<AstroBean>() {
                    @Override
                    public AstroBean createFromParcel(Parcel source) {
                        return new AstroBean(source);
                    }

                    @Override
                    public AstroBean[] newArray(int size) {
                        return new AstroBean[size];
                    }
                };
            }

            public static class CondBean implements Parcelable {
                public String code_d;
                public String code_n;
                public String txt_d;
                public String txt_n;

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.code_d);
                    dest.writeString(this.code_n);
                    dest.writeString(this.txt_d);
                    dest.writeString(this.txt_n);
                }

                public CondBean() {
                }

                protected CondBean(Parcel in) {
                    this.code_d = in.readString();
                    this.code_n = in.readString();
                    this.txt_d = in.readString();
                    this.txt_n = in.readString();
                }

                public static final Creator<CondBean> CREATOR = new Creator<CondBean>() {
                    @Override
                    public CondBean createFromParcel(Parcel source) {
                        return new CondBean(source);
                    }

                    @Override
                    public CondBean[] newArray(int size) {
                        return new CondBean[size];
                    }
                };
            }

            public static class TmpBean implements Parcelable {
                public String max;
                public String min;

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.max);
                    dest.writeString(this.min);
                }

                public TmpBean() {
                }

                protected TmpBean(Parcel in) {
                    this.max = in.readString();
                    this.min = in.readString();
                }

                public static final Creator<TmpBean> CREATOR = new Creator<TmpBean>() {
                    @Override
                    public TmpBean createFromParcel(Parcel source) {
                        return new TmpBean(source);
                    }

                    @Override
                    public TmpBean[] newArray(int size) {
                        return new TmpBean[size];
                    }
                };
            }

            public static class WindBean implements Parcelable {
                public String deg;
                public String dir;
                public String sc;
                public String spd;

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.deg);
                    dest.writeString(this.dir);
                    dest.writeString(this.sc);
                    dest.writeString(this.spd);
                }

                public WindBean() {
                }

                protected WindBean(Parcel in) {
                    this.deg = in.readString();
                    this.dir = in.readString();
                    this.sc = in.readString();
                    this.spd = in.readString();
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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeParcelable(this.astro, flags);
                dest.writeParcelable(this.cond, flags);
                dest.writeString(this.date);
                dest.writeString(this.hum);
                dest.writeString(this.pcpn);
                dest.writeString(this.pop);
                dest.writeString(this.pres);
                dest.writeParcelable(this.tmp, flags);
                dest.writeString(this.vis);
                dest.writeParcelable(this.wind, flags);
            }

            public DailyForecastBean() {
            }

            protected DailyForecastBean(Parcel in) {
                this.astro = in.readParcelable(AstroBean.class.getClassLoader());
                this.cond = in.readParcelable(CondBean.class.getClassLoader());
                this.date = in.readString();
                this.hum = in.readString();
                this.pcpn = in.readString();
                this.pop = in.readString();
                this.pres = in.readString();
                this.tmp = in.readParcelable(TmpBean.class.getClassLoader());
                this.vis = in.readString();
                this.wind = in.readParcelable(WindBean.class.getClassLoader());
            }

            public static final Creator<DailyForecastBean> CREATOR = new Creator<DailyForecastBean>() {
                @Override
                public DailyForecastBean createFromParcel(Parcel source) {
                    return new DailyForecastBean(source);
                }

                @Override
                public DailyForecastBean[] newArray(int size) {
                    return new DailyForecastBean[size];
                }
            };
        }

        public static class HourlyForecastBean implements Parcelable {
            public String date;
            public String hum;
            public String pop;
            public String pres;
            public String tmp;
            /**
             * deg : 304
             * dir : WNW
             * sc : 1-2
             * spd : 5
             */

            public WindBean wind;

            public static class WindBean implements Parcelable {
                public String deg;
                public String dir;
                public String sc;
                public String spd;

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.deg);
                    dest.writeString(this.dir);
                    dest.writeString(this.sc);
                    dest.writeString(this.spd);
                }

                public WindBean() {
                }

                protected WindBean(Parcel in) {
                    this.deg = in.readString();
                    this.dir = in.readString();
                    this.sc = in.readString();
                    this.spd = in.readString();
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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.date);
                dest.writeString(this.hum);
                dest.writeString(this.pop);
                dest.writeString(this.pres);
                dest.writeString(this.tmp);
                dest.writeParcelable(this.wind, flags);
            }

            public HourlyForecastBean() {
            }

            protected HourlyForecastBean(Parcel in) {
                this.date = in.readString();
                this.hum = in.readString();
                this.pop = in.readString();
                this.pres = in.readString();
                this.tmp = in.readString();
                this.wind = in.readParcelable(WindBean.class.getClassLoader());
            }

            public static final Creator<HourlyForecastBean> CREATOR = new Creator<HourlyForecastBean>() {
                @Override
                public HourlyForecastBean createFromParcel(Parcel source) {
                    return new HourlyForecastBean(source);
                }

                @Override
                public HourlyForecastBean[] newArray(int size) {
                    return new HourlyForecastBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this.basic, flags);
            dest.writeParcelable(this.now, flags);
            dest.writeString(this.status);
            dest.writeList(this.daily_forecast);
            dest.writeList(this.hourly_forecast);
        }

        public HeWeatherDataServiceBean() {
        }

        protected HeWeatherDataServiceBean(Parcel in) {
            this.basic = in.readParcelable(BasicBean.class.getClassLoader());
            this.now = in.readParcelable(NowBean.class.getClassLoader());
            this.status = in.readString();
            this.daily_forecast = new ArrayList<DailyForecastBean>();
            in.readList(this.daily_forecast, DailyForecastBean.class.getClassLoader());
            this.hourly_forecast = new ArrayList<HourlyForecastBean>();
            in.readList(this.hourly_forecast, HourlyForecastBean.class.getClassLoader());
        }

        public static final Creator<HeWeatherDataServiceBean> CREATOR = new Creator<HeWeatherDataServiceBean>() {
            @Override
            public HeWeatherDataServiceBean createFromParcel(Parcel source) {
                return new HeWeatherDataServiceBean(source);
            }

            @Override
            public HeWeatherDataServiceBean[] newArray(int size) {
                return new HeWeatherDataServiceBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.HeWeather_data_service);
    }

    public ForecastData() {
    }

    protected ForecastData(Parcel in) {
        this.HeWeather_data_service = new ArrayList<HeWeatherDataServiceBean>();
        in.readList(this.HeWeather_data_service, HeWeatherDataServiceBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<ForecastData> CREATOR = new Parcelable.Creator<ForecastData>() {
        @Override
        public ForecastData createFromParcel(Parcel source) {
            return new ForecastData(source);
        }

        @Override
        public ForecastData[] newArray(int size) {
            return new ForecastData[size];
        }
    };
}
