package com.liuxiaozhu.bpp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * @author liuxiaozhu
 * Creacted by Ender on 2018/8/27
 */
public class MyBService extends Service {
    private Binder binder = new MyBImp();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
