package com.springioc.scope;

import com.springioc.Dao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("service")
public abstract class ServiceScope{
    @Lookup
    public abstract Dao getDao();
    public void service(){
        System.out.println(getDao().hashCode());
    }
}
