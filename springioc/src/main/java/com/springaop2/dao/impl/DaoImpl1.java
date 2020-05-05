package com.springaop2.dao.impl;

import com.springaop2.dao.Dao;
import org.springframework.stereotype.Repository;

@Repository("daoImpl1")
public class DaoImpl1 implements Dao {
    public void execute() {
        System.out.println("dao2 impl1");
    }
    public void execute(String str) {
        System.out.println("dao2 impl1" + str);
    }
}
