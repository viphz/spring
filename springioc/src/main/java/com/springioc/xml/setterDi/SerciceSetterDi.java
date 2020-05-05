package com.springioc.xml.setterDi;

import com.springioc.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class SerciceSetterDi {
    private Dao dao;
    public void setDao(Dao dao) {
        this.dao = dao;
    }
    public void service(){
        dao.test();
    }
}
