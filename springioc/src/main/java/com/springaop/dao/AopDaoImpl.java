package com.springaop.dao;

import com.springaop.anno.AopAnnotation;
import org.springframework.stereotype.Repository;

@Repository
public class AopDaoImpl {
    @AopAnnotation
    public void execute(){
        System.out.println("springaop");
    }
}
