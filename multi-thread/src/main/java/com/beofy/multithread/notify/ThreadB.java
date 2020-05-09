package com.beofy.multithread.notify;

import java.util.concurrent.TimeUnit;

public class ThreadB  extends Thread{

    private final Object lock;

    public ThreadB (Object lock) {
        this.lock  = lock;
    }


    @Override
    public void run() {
        synchronized (lock){
            System.out.println("Start ThreadB");

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("5秒后.....");
//            lock.notify();  // 唤醒被锁定的线程
            lock.notifyAll();  // 唤醒被锁定的线程
            System.out.println("End ThreadB");
        }

    }
}
