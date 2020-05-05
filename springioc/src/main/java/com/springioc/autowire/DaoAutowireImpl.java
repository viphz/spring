package com.springioc.autowire;

import com.springioc.Dao;

public class DaoAutowireImpl implements Dao {
    public void test() {
        System.out.println("dao autowire impl");
    }
}
