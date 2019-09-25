package com.beofy.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DoSomeThingProxy implements InvocationHandler {

    private Object target;

    public DoSomeThingProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Do something before");

        Object result = method.invoke(target, args);
        System.out.println(result);

        System.out.println("Do something after");

        return result;
    }

}
