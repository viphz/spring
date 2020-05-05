package com.springioc.annotation;

import com.springioc.Dao;
import org.springframework.stereotype.Component;

//@Component("dao")
public class DaoAnnotationImpl implements Dao {
    public void test() {
        System.out.println("xxxx");
    }
}
