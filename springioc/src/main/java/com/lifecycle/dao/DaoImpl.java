package com.lifecycle.dao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

//@Repository
public class DaoImpl implements InitializingBean, DisposableBean {
    public DaoImpl() {
        System.out.println("DaoImpl constructor");
    }
    public void afterPropertiesSet() throws Exception {
        System.out.println("DaoImpl init");
    }
    public void destroy() throws Exception {
        System.out.println("DaoImpl destroy");
    }
}
