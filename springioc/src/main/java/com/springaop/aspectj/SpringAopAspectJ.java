package com.springaop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SpringAopAspectJ {
    /**
     * 用于匹配方法执行 join points连接点，最小粒度为方法
     * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
     *      ?：代表当前项可要可不要
     *      modifiers-pattern：方法的可见性，如public，protected；
     *      ret-type-pattern：方法的返回值类型，如int，void等；
     *      declaring-type-pattern：方法所在类的全路径名，如com.springaop.dao.*；
     *      name-pattern：方法名类型，如execute()；
     *      param-pattern：方法的参数类型，如java.lang.String；
     *      throws-pattern：方法抛出的异常类型，如java.lang.Exception；
     */
    @Pointcut("execution(* com.springaop.dao.*.*(..))")
    public void pointCutExecution(){
    }
    /**
     * 用于匹配方法执行 join points连接点，最小粒度为类
     * 粒度比execution更大，仅能实现到包和接口、类级别
     */
    @Pointcut("within(com.springaop.dao.*)")
    public void pointCutWithin(){
    }
    /**
     * args表达式的作用是匹配指定参数类型和指定参数数量的方法,与包名和类名无关
     */
    @Pointcut("args(java.lang.String, java.lang.Integer)")
    public void pointCutArgs(){
    }
    /**
     * 匹配带有com.springaop.anno.AopAnnotation注解的方法
     */
    @Pointcut("@annotation(com.springaop.anno.AopAnnotation)")
    public void pointCutAnnotation(){
    }
    /**
     * 匹配所有符合pointCutWithin的，但是不包括符合pointCutArgs
     */
    @Before("pointCutWithin() && !pointCutArgs()")
    public void beforeAdvice(){
        System.out.println("before");
    }
}
