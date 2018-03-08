package com.liuxiaozhu.aidls.model;

/**
 * Author：Created by liuxiaozhu on 2018/3/8.
 * Email: chenhuixueba@163.com
 */

public interface IAction<T> {
    void start(int textId);

    void error(int msg);

    void success(T data);


}
