package com.timecat.extend.arms;

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2020/12/27
 * @description null
 * @usage null
 */
public class BaseApplication extends  com.jess.arms.base.BaseApplication {

    private static BaseApplication context;

    @Override
    public void onCreate() {
        context = this;
        super.onCreate();
    }

    public static BaseApplication getContext() {
        return context;
    }

    public static BaseApplication getInstance() {
        return context;
    }
}
