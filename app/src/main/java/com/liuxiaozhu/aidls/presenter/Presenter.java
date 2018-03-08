package com.liuxiaozhu.aidls.presenter;

import android.content.Context;

import com.liuxiaozhu.aidls.bean.WeatherBase;
import com.liuxiaozhu.aidls.model.IAction;
import com.liuxiaozhu.aidls.model.Mode;

/**
 * Author：Created by liuxiaozhu on 2018/3/8.
 * Email: chenhuixueba@163.com
 */

public class Presenter {
    private Mode mMode;
    private IView<WeatherBase> mIView;

    public Presenter(IView<WeatherBase> mIView) {
        this.mIView = mIView;
        mMode = new Mode(new MyAction());
    }
    public void  getData(Context context) {
        mMode.getData(context);
    }
    private class MyAction implements
            IAction<WeatherBase> {


        @Override
        public void success(WeatherBase data) {
            if (mIView != null) {
                mIView.onSuccess(data);
            }
        }


        @Override
        public void start(int textId) {
            if (mIView != null) {
                mIView.onStart(textId);
            }
        }

        @Override
        public void error(int msg) {
            if (mIView != null) {
                mIView.onStart(msg);
            }
        }


    }
}
