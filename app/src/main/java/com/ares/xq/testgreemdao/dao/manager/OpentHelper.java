package com.ares.xq.testgreemdao.dao.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.ares.xq.testgreemdao.dao.dao.DaoMaster;
import com.ares.xq.testgreemdao.dao.dao.StudentBeanDao;
import com.ares.xq.testgreemdao.dao.dao.TecherBeanDao;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Administrator on 2017/10/30.
 */

public class OpentHelper extends DaoMaster.OpenHelper {

    public OpentHelper(Context context, String name) {
        super(context, name);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("TAG", "当前数据库版本oldVersion: " + oldVersion);
        if (newVersion > oldVersion) {
            MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {
                @Override
                public void onCreateAllTables(Database db, boolean ifNotExists) {
                    DaoMaster.createAllTables(db, ifNotExists);
                }

                @Override
                public void onDropAllTables(Database db, boolean ifExists) {
                    DaoMaster.dropAllTables(db, ifExists);
                }
            }, StudentBeanDao.class, TecherBeanDao.class);
        }
    }
}