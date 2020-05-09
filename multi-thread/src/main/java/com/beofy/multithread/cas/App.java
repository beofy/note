package com.beofy.multithread.cas;

import sun.misc.Unsafe;
import sun.misc.VM;
import sun.reflect.Reflection;

import java.lang.reflect.Field;

public class App {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Obj obj = new Obj();
        System.out.println(obj);

        //1.最简单的使用方式是基于反射获取Unsafe实例
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        long statusOffset = unsafe.objectFieldOffset(obj.getClass().getDeclaredField("status"));
        System.out.println("偏移量："+statusOffset);


        if (unsafe.compareAndSwapInt(obj,statusOffset,0,1)){
            System.out.println(obj);
        }
    }
}
