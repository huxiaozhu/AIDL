package com.liuxiaozhu.testaidl;

import android.os.RemoteException;
import android.util.Log;

/**
 * @author liuxiaozhu
 * Creacted by Ender on 2018/8/27
 *
 */
public class MyAppIml extends MyApp.Stub {
    private String name;
    private String TAG = "MyAppIml";

    @Override
    public String getText() throws RemoteException {
        Log.e(TAG, "获取数据name" + name);
        return name;
    }

    @Override
    public String setName(String name) throws RemoteException {
        this.name = name;
        Log.e(TAG, "设置数据name" + name);
        return "";
    }
}
