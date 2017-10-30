package com.ares.xq.testgreemdao.applocation;

import android.app.Application;

import com.ares.xq.testgreemdao.dao.manager.GreenDaoManager;

/**
 * Created by Administrator on 2017/10/30.
 */

public class MyApplication extends Application {

    private static MyApplication mMyApplication;


    @Override
    public void onCreate() {
        super.onCreate();
        mMyApplication = this;
        GreenDaoManager.getInstance();
    }

    public static MyApplication getInstince() {
        return mMyApplication;
    }
}
