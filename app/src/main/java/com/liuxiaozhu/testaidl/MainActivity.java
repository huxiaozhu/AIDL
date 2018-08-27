package com.liuxiaozhu.testaidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * @author 刘小猪
 */
public class MainActivity extends AppCompatActivity {

    private MyApp myApp;
    private int a = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        Intent intent = new Intent();
        intent.setAction("com.liuxiaozhu.bpp.MyBService");
        intent.setPackage("com.liuxiaozhu.bpp");
        //进程B 目的   binderServise  ----->  IBinder iBinder

        // c.conn.connected(r.name, service);
        if (myApp == null) {
            bindService(intent, new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    //Proxy 对象  MyApp接口
                    myApp = MyApp.Stub.asInterface(service);
                    setName();
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {

                }
            }, Context.BIND_AUTO_CREATE);
        } else {
            setName();
        }
    }

    private void setName() {
        try {
            myApp.setName("刘小猪宝宝" + a);
            Toast.makeText(MainActivity.this, "获取数据-----》" + myApp.getText(), Toast.LENGTH_SHORT).show();
            a++;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
