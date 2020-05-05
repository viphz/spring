package com.springaop;

import com.springaop.configaop.AopConfig;
import com.springaop.dao.AopDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpringAop {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(AopConfig.class);
        AopDaoImpl aopDao = annotationConfigApplicationContext.getBean(AopDaoImpl.class);
        aopDao.execute();
    }
}
