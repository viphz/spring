package com.luban.customer;

import java.lang.reflect.Method;

public interface CoustomInvocationHandler {
    public Object invoke(Method method);
}
