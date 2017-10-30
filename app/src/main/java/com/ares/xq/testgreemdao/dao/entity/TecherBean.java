package com.ares.xq.testgreemdao.dao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/10/30.
 */

@Entity
public class TecherBean {

    @Id(autoincrement = true)
    private Long id;


    private String name;

    @Property(nameInDb = "CLASSNAME")
    private String className;

    @Generated(hash = 507619724)
    public TecherBean(Long id, String name, String className) {
        this.id = id;
        this.name = name;
        this.className = className;
    }

    @Generated(hash = 1291304909)
    public TecherBean() {
    }

    @Override
    public String toString() {
        return "TecherBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                '}';
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
