package com.beofy.multithread.unsafe;

import java.util.concurrent.locks.Lock;

public class SyncDemo {

    private static int count = 0;

    //两种代码表现形式
    //三种作用范围
    // 决定synchronized锁的范围和性能

    // demo 等价 demo1
    public synchronized void add1(){
        count ++ ;
        System.out.println("add1:"+count);
    }


    public  void add2(){
        // todo
        synchronized(this){
            //保护线程安全的变量
            count ++ ;
            System.out.println("add2:"+count);
        }
        // todo
    }


    // demo3 等价 demo4
    public synchronized static void add3(){
        count ++ ;

    }

    public static void add4(){
        synchronized(SyncDemo.class){
            count ++ ;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SyncDemo sd1 = new SyncDemo();

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> sd1.add1()).start();
            new Thread(() -> sd1.add2()).start();
        }

        Thread.sleep(3000);
        System.out.println("count:"+count);


        new Thread(() -> SyncDemo.add3()).start();
        new Thread(() -> SyncDemo.add4()).start();
    }
}
