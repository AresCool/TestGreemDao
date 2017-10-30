package com.ares.xq.testgreemdao.dao.manager;

import android.util.Log;

import com.ares.xq.testgreemdao.applocation.MyApplication;
import com.ares.xq.testgreemdao.dao.dao.DaoMaster;
import com.ares.xq.testgreemdao.dao.dao.DaoSession;


/**
 * Created by Administrator on 2017/10/30.
 */

public class GreenDaoManager {
    private static final String TAG = "TAG";
    //多线程中要被共享的使用volatile关键字修饰
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private static volatile GreenDaoManager mInstance = null;

    private GreenDaoManager() {
        if (mInstance == null) {
            OpentHelper devOpenHelper = new OpentHelper(MyApplication.getInstince(), "yyc_user.db");
            mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
            mDaoSession = mDaoMaster.newSession();
            Log.i("TAG", "初始化数据库...");
        }
    }

    public static GreenDaoManager getInstance() {
        if (mInstance == null) {
            synchronized (GreenDaoManager.class) {
                if (mInstance == null) {
                    mInstance = new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    public DaoMaster getMaster() {
        return mDaoMaster;
    }

    public DaoSession getSession() {
        return mDaoSession;
    }

    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }
}
