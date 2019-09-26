package com.beofy.cglib.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Object target;//需要代理的目标对象

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("before working...");

        Object invoke = method.invoke(target, objects);
        System.out.println(invoke);

        System.out.println("after working...");

        return invoke;
    }

    //定义获取代理对象方法
    private Object getCglibProxy(Object objectTarget){
        //为目标对象target赋值
        this.target = objectTarget;
        Enhancer enhancer = new Enhancer();
        //设置父类,因为Cglib是针对指定的类生成一个子类，所以需要指定父类
        enhancer.setSuperclass(objectTarget.getClass());
        enhancer.setCallback(this);// 设置回调
        return enhancer.create();//创建并返回代理对象;
    }


    public static void main(String[] args) {
        //way1();
        way2();
    }

    public static void way1(){
        CglibProxy cglib = new CglibProxy();//实例化CglibProxy对象
        Man man =  (Man) cglib.getCglibProxy(new Man());//获取代理对象
        man.working();//执行代理方法
    }

    public static void way2(){
        MethodInterceptor methodInterceptor = (o, method, objects, methodProxy) -> {
            System.out.println("before invoker ");
            Object invoke = method.invoke(new Man(), objects);
            System.out.println(invoke);
            System.out.println("before invoker ");
            return invoke;
        };
        Enhancer enhancer = new Enhancer();
        //设置父类,因为Cglib是针对指定的类生成一个子类，所以需要指定父类
        enhancer.setSuperclass(Man.class);
        enhancer.setCallback(methodInterceptor);// 设置回调
        Man man =(Man) enhancer.create();//创建并返回代理对象;
        man.working();

    }


}
