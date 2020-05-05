package com.springioc.autowire;

import com.springioc.Dao;

public class ServiceAutowire {
    private Dao dao;
    public void setDao(Dao dao) {
        this.dao = dao;
    }
    public void service(){
        dao.test();
    }
}
