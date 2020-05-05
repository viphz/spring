package com.springfactorybean.dao;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;


/**
 * 如果你的类实现了FactoryBean，那么spring容器中会存在两个对象
 * 一个是getObject()返回的对象TempDaoFactoryBean
 * 另一个是当前对象DaoFactoryBean
 * bean的名字：
 *      getObject()的名字是当前类指定的名字，即daoFactoryBean
 *      当前对象的名字是"$"+当前类的名字，即&daoFactoryBean
 */
@Component("daoFactoryBean")
public class DaoFactoryBean implements FactoryBean {
    public void testBean(){
        System.out.println("testBean");
    }
    @Override
    public Object getObject() throws Exception {
        return new TempDaoFactoryBean();
    }
    @Override
    public Class<?> getObjectType() {
        return TempDaoFactoryBean.class;
    }
    @Override
    public boolean isSingleton() {
        return true;//true表示是单例
    }
}
