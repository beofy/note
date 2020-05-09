package com.beofy.multithread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupport  {

//    public static void main(String[] args) throws InterruptedException {
//        Object lock = new Object();
//
//        Thread threadA = new Thread(() -> {
//            System.out.println("Thread.interrupted():"+Thread.interrupted());
//            java.util.concurrent.locks.LockSupport.park(lock);
//            System.out.println(Thread.interrupted());
//            System.out.println("释放锁");
//        });
//
//        threadA.start();
//
//
//        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
//        threadA.interrupt();
//    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread threadA = new Thread(() -> {
            System.out.println("Thread.interrupted():"+Thread.interrupted());
            java.util.concurrent.locks.LockSupport.park(lock);
            System.out.println(Thread.interrupted());
            System.out.println("释放锁");
        });

        threadA.start();


        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        java.util.concurrent.locks.LockSupport.unpark(threadA);
    }


//    public static void main(String[] args) throws InterruptedException {
//        Lock lock = new ReentrantLock();
//
//        Thread threadA = new Thread(() -> {
//            System.out.println("ThreadA.interrupted():"+Thread.interrupted());
//            lock.lock();
//            System.out.println(Thread.interrupted());
//            System.out.println("线程A：释放锁");
//        });
//
//        threadA.start();
//
//
//        Thread threadB = new Thread(() -> {
//            System.out.println("ThreadB.interrupted():"+Thread.interrupted());
//            lock.lock();
//            System.out.println(Thread.interrupted());
//            System.out.println("线程B：释放锁");
//        });
//
//        threadB.start();
//
//        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
//        threadB.interrupt();
//    }
}
