package com.springaop2.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class SpringAopAspectj {
    @Pointcut("within(com.springaop2.dao.impl.*)")
    public void pointCutWithin(){
    }
    @Before("pointCutWithin()")
    public void before(JoinPoint joinPoint){
        System.out.println("before");
        System.out.println(joinPoint.getThis());//得到的jdk动态代理对象
        System.out.println(joinPoint.getTarget());//得到的目标对象
    }
    @After("pointCutWithin()")
    public void after(){
        System.out.println("after");
    }
    @Around("pointCutWithin()")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("around before");
        Object[] args = proceedingJoinPoint.getArgs();//拿到当前执行方法中的参数
        if(args != null && args.length>0){
            for (int i = 0; i < args.length; i++) {
                args[i] += " world";
            }
        }
        try {
            proceedingJoinPoint.proceed();//执行原方法
            proceedingJoinPoint.proceed(args);//执行修改了参数后的方法
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around after");
    }
}
