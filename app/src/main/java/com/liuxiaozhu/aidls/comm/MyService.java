package com.liuxiaozhu.aidls.comm;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.liuxiaozhu.aidl.IMyAidlInterface;
import com.liuxiaozhu.aidl.Weather;
import com.liuxiaozhu.aidls.bean.WeatherBase;
import com.liuxiaozhu.aidls.presenter.IView;
import com.liuxiaozhu.aidls.presenter.Presenter;

/**
 * Author：Created by liuxiaozhu on 2018/3/8.
 * Email: chenhuixueba@163.com
 */

public class MyService extends Service  {

    private Weather weather = new Weather();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    /**
     * 获取数据之后将数据传递到aidl的IMyAidlInterface接口中
     */
    private class MyBinder extends IMyAidlInterface.Stub{
        @Override
        public Weather getWeather() throws RemoteException {
            Presenter presenter=new Presenter(iVew);
            presenter.getData(getApplicationContext());
            return weather;
        }
    }

    /**
     * 获取数据
     */
    private IView<WeatherBase> iVew=new IView<WeatherBase>() {
        @Override
        public void onStart(int textId) {

        }

        @Override
        public void onError(String msg) {

        }

        @Override
        public void onSuccess(WeatherBase data) {
            weather.setCity(data.getWeather().getCity());
            weather.setCityId(data.getWeather().getCityId());
            weather.setTemp(data.getWeather().getTemp());
            weather.setTime(data.getWeather().getTime());
            weather.setWD(data.getWeather().getWD());
            weather.setWS(data.getWeather().getWS());
        }
    };

}
