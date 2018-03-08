package com.liuxiaozhu.aidls.bean;


import com.google.gson.annotations.SerializedName;
import com.liuxiaozhu.aidl.Weather;
import com.liuxiaozhu.aidls.constons.ProtocolKey;

/**
 * Created by ChenHui on 2016/12/2.
 */

public class WeatherBase {
    @SerializedName(ProtocolKey.RETDATA)
    Weather weather;

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}
