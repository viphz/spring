package com.springaop2.dao.impl;

import com.springaop2.dao.Dao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("daoImpl")
@Scope("prototype")
public class DaoImpl implements Dao {
    public void execute() {
        System.out.println("dao2 impl");
    }
    public void execute(String str) {
        System.out.println("dao2 impl" + str);
    }
}
