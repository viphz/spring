package com.springaop1.dao.impl;

import com.springaop1.dao.Dao;
import org.springframework.stereotype.Repository;

@Repository("daoImpl")
public class DaoImpl implements Dao {
    public void execute() {
        System.out.println("dao impl");
    }
}
