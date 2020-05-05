package com.springaop2;

import com.springaop2.config.SpringAopConfig;
import com.springaop2.dao.Dao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpringAop2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(SpringAopConfig.class);
        Dao dao1 = (Dao) annotationConfigApplicationContext.getBean("daoImpl");
        Dao dao2 = (Dao) annotationConfigApplicationContext.getBean("daoImpl");
        dao1.execute(" Hello1");
        System.out.println("--------------------------");
        dao2.execute(" Hello2");
        System.out.println("--------------------------");
        System.out.println(dao1.hashCode());
        System.out.println(dao2.hashCode());
    }
}
