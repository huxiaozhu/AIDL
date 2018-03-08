// IMyAidlInterface.aidl
package com.liuxiaozhu.aidl;

import com.liuxiaozhu.aidl.Weather;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    //告诉我们aidl可以使用的类型
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//                double aDouble, String aString);
    //获取天气
    Weather getWeather();

}
