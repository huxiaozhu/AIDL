package com.liuxiaozhu.aidls.presenter;

/**
 * Author：Created by liuxiaozhu on 2018/3/8.
 * Email: chenhuixueba@163.com
 */

public interface IView<T> {
    void onStart(int textId);

    void onError(String msg);

    void onSuccess(T data);
}
