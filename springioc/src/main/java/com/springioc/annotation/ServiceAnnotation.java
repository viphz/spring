package com.springioc.annotation;

import com.springioc.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class ServiceAnnotation {
    @Autowired
    private Dao dao;
    public void setDao(Dao dao) {
        this.dao = dao;
    }
    public void service(){
        dao.test();
    }
}
