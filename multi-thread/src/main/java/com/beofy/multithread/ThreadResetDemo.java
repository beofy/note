package com.beofy.multithread;

import java.util.concurrent.TimeUnit;

public class ThreadResetDemo {
    //线程中断和复位
    //1.Thread.interrupt
    //2.InterruptedException

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("before:"+Thread.currentThread().isInterrupted());
                    Thread.interrupted() ;//回到初始状态
                    System.out.println("after:"+Thread.currentThread().isInterrupted());
                }
            }

        }, "thread");
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        thread.interrupt(); //把isInterrupted设置成true
    }
}
