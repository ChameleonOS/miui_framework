// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package miui.provider;

import android.net.Uri;

public class Weather {
    public static final class Widget {

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/weather_widget";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/weather_widget";
        public static final Uri CONTENT_URI = Uri.parse("content://weather/widget");
        public static final String ID = "_id";
        public static final String PID = "posID";
        public static final String TYPE_ID = "type_id";
        public static final String WIDGET_ID = "widget_id";


        public Widget() {
        }
    }

    public static final class SelectedCity
        implements WeatherCityColumns {

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/weather_selected_city";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/weather_selected_city";
        public static final Uri CONTENT_URI = Uri.parse("content://weather/selected_city");
        public static final String FLAG = "flag";
        public static final int FLAG_GPS = 1;
        public static final String POSITION = "position";


        public SelectedCity() {
        }
    }

    public static final class HotCity
        implements WeatherCityColumns {

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/weather_hot_city";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/weather_hot_city";
        public static final Uri CONTENT_URI = Uri.parse("content://weather/hot_city");


        public HotCity() {
        }
    }

    public static final class City
        implements WeatherCityColumns {

        public static final String AREA_CODE = "area_code";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/weahter_city";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/weather_city";
        public static final Uri CONTENT_URI = Uri.parse("content://weather/city");
        public static final String PARENT = "parent";
        public static final String PHONE_CODE = "phone_code";
        public static final String PY = "pinyin";
        public static final String P_X = "x";
        public static final String P_Y = "y";
        public static final String ROOT = "root";
        public static final String URL = "url";


        public City() {
        }
    }

    static interface WeatherCityColumns {

        public static final String ID = "_id";
        public static final String NAME = "name";
        public static final String PID = "posID";
    }

    public static final class DailyWeather
        implements WeatherBaseColumns {

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/weather_daily_weather";
        public static final Uri CONTENT_URI = Uri.parse("content://weather/daily_weather");


        public DailyWeather() {
        }
    }

    public static final class LocalWeather
        implements WeatherBaseColumns {

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/weather_weather";
        public static final Uri CONTENT_URI = Uri.parse("content://weather/weather");


        public LocalWeather() {
        }
    }

    static interface WeatherBaseColumns {

        public static final String BEGINS = "begins";
        public static final String CITY_ID = "city_id";
        public static final String CITY_NAME = "city_name";
        public static final String DATA1 = "data1";
        public static final String DESCRIPTION = "description";
        public static final String ENDS = "ends";
        public static final String HUMIDITY = "humidity";
        public static final String ID = "_id";
        public static final String PUBLISH_TIME = "publish_time";
        public static final String SUNRISE = "sunrise";
        public static final String SUNSET = "sunset";
        public static final String TEMPERATURE = "temperature";
        public static final String TEMPERATURE_RANGE = "temperature_range";
        public static final String TIMESTAMP = "timestamp";
        public static final String WEATHER_TYPE = "weather_type";
        public static final String WIND = "wind";
    }


    public Weather() {
    }

    public static final String AUTHORITY = "weather";
    public static final int BLIZZARD = 13;
    public static final int BLOWING_SAND = 21;
    public static final int CLOUDY = 1;
    public static final int DUST = 20;
    public static final int DUSTSTORM = 19;
    public static final int FOG = 3;
    public static final int HAILSTONE = 22;
    public static final int HEAVY_RAIN = 9;
    public static final int HEAVY_RAINSTORM = 5;
    public static final int HEAVY_SNOW = 15;
    public static final int LIGHT_RAIN = 11;
    public static final int LIGHT_SNOW = 17;
    public static final int MODERATE_RAIN = 10;
    public static final int MODERATE_SNOW = 16;
    public static final int OVERCAST = 2;
    public static final int RAINSTORM = 6;
    public static final int RAIN_SHOWERS = 8;
    public static final int SLEET = 12;
    public static final int SNOW_SHOWERS = 14;
    public static final int STRONG_DUSTSTORM = 18;
    public static final int STRONG_RAINSTORM = 4;
    public static final int SUNNY = 0;
    public static final int T_STORMS = 7;
}
