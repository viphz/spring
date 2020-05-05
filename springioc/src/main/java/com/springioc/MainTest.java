package com.springioc;

import com.springioc.annotation.ServiceAnnotation;
import com.springioc.autowire.ServiceAutowire;
import com.springioc.javaConfiguration.Spring;
import com.springioc.scope.ScopeConfig;
import com.springioc.scope.ServiceScope;
import com.springioc.xml.ConstructorDi.ServiceConstructorDi;
import com.springioc.xml.setterDi.SerciceSetterDi;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {
//        xmlTest();
//        annotationTest();
//        javaConfigurationTest();
//        autoTest();
        scopeTest();
    }

    private static void scopeTest() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(ScopeConfig.class);
        ServiceScope serviceScope1 = (ServiceScope) annotationConfigApplicationContext.getBean("service");
        serviceScope1.service();
        ServiceScope serviceScope2 = (ServiceScope) annotationConfigApplicationContext.getBean("service");
        serviceScope2.service();
    }

    private static void autoTest() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext
                = new ClassPathXmlApplicationContext("classpath:autowire.xml");
        ServiceAutowire serviceAutowire = (ServiceAutowire) classPathXmlApplicationContext.getBean("service");
        serviceAutowire.service();
    }

    private static void javaConfigurationTest() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(Spring.class);
        ServiceAnnotation serviceAnnotation = (ServiceAnnotation)annotationConfigApplicationContext.getBean("service");
        serviceAnnotation.service();
    }

    private static void annotationTest() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext
                = new ClassPathXmlApplicationContext("classpath:springAnnotation.xml");
        ServiceAnnotation serviceAnnotation = (ServiceAnnotation)classPathXmlApplicationContext.getBean("service");
        serviceAnnotation.service();
    }

    private static void xmlTest() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext
                = new ClassPathXmlApplicationContext("classpath:spring.xml");
        SerciceSetterDi serciceSetterDi = (SerciceSetterDi)classPathXmlApplicationContext.getBean("serviceSetterDi");
        serciceSetterDi.service();
        ServiceConstructorDi serviceConstructorDi = (ServiceConstructorDi)classPathXmlApplicationContext.getBean("serviceConstructorDi");
        serviceConstructorDi.service();
    }

}
