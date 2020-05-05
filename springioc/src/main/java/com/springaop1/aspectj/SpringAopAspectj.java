package com.springaop1.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SpringAopAspectj {
    /**
     * 使用的JDK代理
     * 产生的新对象不继承原目标对象，所以before不会执行
     */
    @Pointcut("this(com.springaop1.dao.impl.DaoImpl)")
    public void pointCutThis(){
    }
    /**
     * 使用的CGLIB代理
     * 产生的新对象继承原目标对象，所以before会执行
     */
    @Pointcut("target(com.springaop1.dao.impl.DaoImpl)")
    public void pointCutTarget(){
    }
    @Before("pointCutTarget()")
    public void before(){
        System.out.println("before");
    }
}
