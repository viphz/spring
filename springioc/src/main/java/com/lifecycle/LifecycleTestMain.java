package com.lifecycle;

import com.lifecycle.dao.DaoAnnotation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifecycleTestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(LifecycleConfig.class);
        DaoAnnotation daoAnnotation = (DaoAnnotation)annotationConfigApplicationContext.getBean(DaoAnnotation.class);
    }
}
