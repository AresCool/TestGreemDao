package com.ares.xq.testgreemdao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ares.xq.testgreemdao.dao.manager.GreenDaoManager;
import com.ares.xq.testgreemdao.dao.dao.StudentBeanDao;
import com.ares.xq.testgreemdao.dao.dao.TecherBeanDao;
import com.ares.xq.testgreemdao.dao.entity.StudentBean;

import com.ares.xq.testgreemdao.dao.entity.TecherBean;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        long time_1 = System.currentTimeMillis();
        init();
        techer();
        long time_2 = System.currentTimeMillis();
        Log.i("TAG","当前查询数据库使用时间："+(time_2-time_1)+"毫秒");
    }


    private void init() {
        StudentBeanDao sdao = GreenDaoManager.getInstance().getNewSession().getStudentBeanDao();
        insert(sdao);
        selectDao(sdao);
    }

    private void techer() {
        TecherBeanDao tdao = GreenDaoManager.getInstance().getNewSession().getTecherBeanDao();

        TecherBean bean = new TecherBean();
        bean.setClassName("二年级1班");
        bean.setName("刘老师");
        tdao.insert(bean);
        List<TecherBean> list = tdao.loadAll();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Log.i("TAG", list.get(i).toString());
            }
        }
    }

    /**
     * 插入数据
     *
     * @param
     */
    private void insert( StudentBeanDao sdao) {
        StudentBean bean = new StudentBean();
        bean.setAge(11);
        bean.setName("lily");
        sdao.insert(bean);
    }

    /**
     * 查询
     */
    private void selectDao(StudentBeanDao sdao) {
        List<StudentBean> list =sdao.loadAll();
        if (list != null && list.size() > 0) {
            for (StudentBean bean : list) {
                Log.i("TAG", bean.toString());
            }
        } else {
            Log.i("TAG", "LIST IS NULL");
        }
    }

    private void update() {

    }
}
