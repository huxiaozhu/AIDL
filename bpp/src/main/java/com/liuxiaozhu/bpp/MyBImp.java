package com.liuxiaozhu.bpp;

import android.os.RemoteException;
import android.util.Log;

import com.liuxiaozhu.testaidl.MyApp;

/**
 * @author liuxiaozhu
 * Creacted by Ender on 2018/8/27
 */
public class MyBImp extends MyApp.Stub {
    private String TAG = "MyBImp";
    private String name;

    @Override
    public String getText() throws RemoteException {
        Log.e(TAG, "获取name" + name);
        return name;
    }

    @Override
    public String setName(String name) throws RemoteException {
        Log.e(TAG, "设置name" + name);
        this.name = name;
        return "";
    }
}
