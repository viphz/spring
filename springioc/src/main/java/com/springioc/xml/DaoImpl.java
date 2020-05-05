package com.springioc.xml;

import com.springioc.Dao;
import org.springframework.stereotype.Component;

public class DaoImpl implements Dao {
    public void test() {
        System.out.println("dao impl");
    }
}
