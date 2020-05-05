package com.lifecycle.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository
@Lazy(true)
public class DaoAnnotation {

    public DaoAnnotation() {
        System.out.println("DaoAnnotation constructor");
    }
}
