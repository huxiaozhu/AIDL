package com.liuxiaozhu.aidls.model;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.liuxiaozhu.aidls.R;
import com.liuxiaozhu.aidls.bean.WeatherBase;
import com.liuxiaozhu.aidls.constons.ProtocolKey;

import org.json.JSONObject;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author：Created by liuxiaozhu on 2018/3/8.
 * Email: chenhuixueba@163.com
 * 请求数据的模型
 */

public class Mode {
    private IAction mIAction;
    private ExecutorService service  = Executors.newCachedThreadPool();
    private Handler handler = new Handler(Looper.getMainLooper());

    public Mode(IAction mIAction) {
        this.mIAction = mIAction;
    }


    public void getData(final Context context) {
        mIAction.start(R.string.loading);
        final RequestQueue queue = Volley.newRequestQueue(context);
        service.submit(new Runnable() {
            @Override
            public void run() {
                JsonObjectRequest json = new JsonObjectRequest(ProtocolKey.Url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new Gson();
                        final WeatherBase weather = gson.fromJson(String.valueOf(response), WeatherBase.class);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                mIAction.success(weather);
                                Log.i("AAA", weather.getWeather().getCity());
                            }
                        });
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mIAction.error(R.string.error);
                    }
                });
                queue.add(json);
            }
        });

    }

}
