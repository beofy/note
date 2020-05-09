package com.beofy.multithread.unsafe;

import java.util.concurrent.TimeUnit;

public class AtomicDemo {

    private static  int count=0;

    public static void add(){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        count ++;
    }

    public static void addSync(){
        count ++;
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000 ; i++) {
            new Thread(() -> {
                AtomicDemo.add();
            } ).start();
        }

        for (int i = 0; i < 1000 ; i++) {
            new Thread(() -> {
                synchronized(AtomicDemo.class) {
                    AtomicDemo.addSync();
                }
//                AtomicDemo.add();
            } ).start();
        }
        Thread.sleep(5000);
        System.out.println("运行结果："+ count);
    }
}
