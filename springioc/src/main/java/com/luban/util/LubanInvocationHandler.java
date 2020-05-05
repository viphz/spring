package com.luban.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LubanInvocationHandler implements InvocationHandler {
    Object target;
    public LubanInvocationHandler(Object target){
        this.target=target;
    }
    /**
     * 代理类的每一个方法执行时，都将调用一次invoke
     * @param proxy     代理对象
     * @param method    代理对象当前执行的方法的描述对象
     *                  method.invoke(代理对象，实际参数)，目标方法执行到目标对象上去
     * @param args      方法实际参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("LubanInvocationHandler jdk");
        return method.invoke(target,args);
    }
}
