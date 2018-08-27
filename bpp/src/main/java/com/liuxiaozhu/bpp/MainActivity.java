package com.liuxiaozhu.bpp;

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

import com.liuxiaozhu.testaidl.MyApp;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * @author liuxiaozhu
     * @date 2018/8/27
     */
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction("com.liuxiaozhu.testaidl.MyService");
        intent.setPackage("com.liuxiaozhu.testaidl");
        //进程B 目的   binderServise  ----->  IBinder iBinder

        // c.conn.connected(r.name, service);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                //proxy   装煤炭  Proxy 对象  MyApp接口
                MyApp myApp = MyApp.Stub.asInterface(service);
                try {
                    myApp.setName("刘小猪");
                    Toast.makeText(MainActivity.this, "获取数据-----》" + myApp.getText(), Toast.LENGTH_SHORT).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, Context.BIND_AUTO_CREATE);
    }
}
