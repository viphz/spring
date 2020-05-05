package com.springaop2.aspectj;

import com.springaop2.dao.Dao;
import com.springaop2.dao.impl.DaoImpl;
import com.springaop2.dao.impl.DaoImpl1;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class SpringAopAspectj1 {
    @DeclareParents(value = "com.springaop2.dao.impl.*", defaultImpl = DaoImpl.class)
    public static Dao dao;
}
