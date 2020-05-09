package com.beofy.multithread.notify;

import java.util.concurrent.TimeUnit;

public class NotifyDemo {

    public static void main(String[] args) {
        Object lock = new Object();

        ThreadA threadA = new ThreadA(lock);
        threadA.start();

        ThreadC threadC = new ThreadC(lock);
        threadC.start();

        ThreadB threadB = new ThreadB(lock);
        threadB.start();



    }
}
