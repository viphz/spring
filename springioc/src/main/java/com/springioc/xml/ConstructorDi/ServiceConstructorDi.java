package com.springioc.xml.ConstructorDi;

import com.springioc.Dao;

public class ServiceConstructorDi {
    private Dao dao;
    public ServiceConstructorDi(Dao dao){
        this.dao = dao;
    }
    public void service(){
        dao.test();
    }
}
