package com.liuxiaozhu.aidl;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.liuxiaozhu.aidls.constons.ProtocolKey;


/**
 * Author：Created by liuxiaozhu on 2018/3/8.
 * Email: chenhuixueba@163.com
 */

public class Weather implements Parcelable{

    @SerializedName(ProtocolKey.CITY)
    private String City;
    @SerializedName(ProtocolKey.CITYID)
    private String CityId;
    @SerializedName(ProtocolKey.TEMP)
    private String Temp;
    @SerializedName(ProtocolKey.WD)
    private String WD;
    @SerializedName(ProtocolKey.WS)
    private String WS;
//    @SerializedName(ProtocolKey.CITY)
//    private String SD;
//    @SerializedName(ProtocolKey.CITY)
//    private String WSE;
    @SerializedName(ProtocolKey.TIME)
    private String Time;

    public Weather(String city, String cityId, String temp, String WD, String WS, String time) {
        City = city;
        CityId = cityId;
        Temp = temp;
        this.WD = WD;
        this.WS = WS;
        Time = time;
    }

    public Weather() {
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public String getCityId() {
        return CityId;
    }

    public void setCityId(String cityId) {
        this.CityId = cityId;
    }

    public String getTemp() {
        return Temp;
    }

    public void setTemp(String temp) {
        Temp = temp;
    }

    public String getWD() {
        return WD;
    }

    public void setWD(String WD) {
        this.WD = WD;
    }

    public String getWS() {
        return WS;
    }

    public void setWS(String WS) {
        this.WS = WS;
    }

//    public String getSD() {
//        return SD;
//    }
//
//    public void setSD(String SD) {
//        this.SD = SD;
//    }
//
//    public String getWSE() {
//        return WSE;
//    }
//
//    public void setWSE(String WSE) {
//        this.WSE = WSE;
//    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 将对象序列号
     * dest 就是对象即将写入的目的对象
     * flags 有关对象序列号的方式的标识
     * 这里要注意，写入的顺序要和在createFromParcel方法中读出的顺序完全相同。例如这里先写入的为name，
     * 那么在createFromParcel就要先读name
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(City);
        dest.writeString(CityId);
        dest.writeString(Temp);
        dest.writeString(WD);
        dest.writeString(WS);
        dest.writeString(Time);
    }

    /**
     * 在想要进行序列号传递的实体类内部一定要声明该常量。常量名只能是CREATOR,类型也必须是
     *Parcelable.Creator<Weather>
     */
    public static final Creator<Weather> CREATOR = new Creator<Weather>() {
        /***
         * 根据序列号的Parcel对象，反序列号为原本的实体对象
         * 读出顺序要和writeToParcel的写入顺序相同
         */
        @Override
        public Weather createFromParcel(Parcel in) {
            String City=in.readString();
            String CityId=in.readString();
            String Temp=in.readString();
            String WD=in.readString();
            String WS=in.readString();
            String Time=in.readString();

            Weather weather = new Weather();
            weather.setCity(City);
            weather.setCity(CityId);
            weather.setCity(Temp);
            weather.setCity(WD);
            weather.setCity(WS);
            weather.setCity(Time);
            return weather;
        }

        /**
         * 创建一个要序列号的实体类的数组，数组中存储的都设置为null
         */
        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };
}
