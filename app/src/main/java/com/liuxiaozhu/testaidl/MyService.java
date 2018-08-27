package com.liuxiaozhu.testaidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * @author huchenhui
 * 2018年08月27日10:31:08
 */
public class MyService extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyAppIml();
    }
}
