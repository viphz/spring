package com.springaop2.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Aspect
        ("pertarget(this(com.springaop2.dao.impl.DaoImpl))")//为所有代理对象等于DaoImpl的单独创建一个切面出来
@Scope("prototype")
public class SpringAopAspectj3 {
    @Around("within(com.springaop2.dao.impl.*)")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("around before");
        System.out.println(this.hashCode());
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around after");
    }
}
