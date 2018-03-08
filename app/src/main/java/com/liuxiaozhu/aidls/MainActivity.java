package com.liuxiaozhu.aidls;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.TextView;

import com.liuxiaozhu.aidl.IMyAidlInterface;
import com.liuxiaozhu.aidl.Weather;
import com.liuxiaozhu.aidls.comm.MyService;


/**
 * android 夸进程通讯
 * 在服务中请求数据
 * 请求过之后及时使用AIDL将数据传到MainActivity
 * 连接已失效..
 */
public class MainActivity extends Activity implements ServiceConnection {
    private TextView city, cityId, temp, time, wd, ws;
    private IMyAidlInterface mWea;
    private Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = findViewById(R.id.city);
        cityId = findViewById(R.id.cityid);
        temp = findViewById(R.id.temp);
        time = findViewById(R.id.time);
        wd = findViewById(R.id.wd);
        ws = findViewById(R.id.ws);
        //绑定服务
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, this, BIND_AUTO_CREATE);
    }

    public void click(View view) {
        if (weather != null) {
            city.setText("City:" + weather.getCity());
            cityId.setText("CityId:" + weather.getCityId());
            temp.setText("Temp:" + weather.getTemp());
            time.setText("Time:" + weather.getTime());
            wd.setText("WD:" + weather.getWD());
            ws.setText("WS:" + weather.getWS());
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(this);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        mWea = IMyAidlInterface.Stub.asInterface(service);
        try {
            /**
             * 通过aidl获取网络数据
             */
            weather = mWea.getWeather();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }

}
