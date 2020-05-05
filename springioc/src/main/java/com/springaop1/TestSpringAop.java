package com.springaop1;

import com.springaop1.config.SpringAopConfig;
import com.springaop1.dao.Dao;
import com.springaop1.dao.impl.DaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpringAop {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(SpringAopConfig.class);
        Dao dao = (Dao) annotationConfigApplicationContext.getBean("daoImpl");
        dao.execute();
    }
}
