package com.springfactorybean;

import com.springfactorybean.config.SpringFactoryBeanConfig;
import com.springfactorybean.dao.DaoFactoryBean;
import com.springfactorybean.dao.TempDaoFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(SpringFactoryBeanConfig.class);
        DaoFactoryBean daoFactoryBean = (DaoFactoryBean) annotationConfigApplicationContext.getBean("daoFactoryBean");
        daoFactoryBean.testBean();//ClassCastException，但spring中的就是DaoFactoryBean，为什么会报错？
//        TempDaoFactoryBean daoFactoryBean = (TempDaoFactoryBean) annotationConfigApplicationContext.getBean("daoFactoryBean");
//        daoFactoryBean.test();//此时会成功
        System.out.println("xxx");
    }
}
