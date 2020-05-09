package com.beofy.multithread;

import java.util.concurrent.TimeUnit;

public class ThreadStatusDemo {

    public static void main(String[] args) {
        Thread timed_waiting_thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }, "Timed_waiting_Thread");
        timed_waiting_thread.start();


        Thread Waiting_Thread = new Thread(() -> {
            while (true) {
                synchronized (ThreadStatusDemo.class) {
                    try {
                        ThreadStatusDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.getStackTrace();
                    }
                }
            }

        }, "Waiting_Thread");
        Waiting_Thread.start();
        Waiting_Thread.getName();

        //BLOCKED
        new Thread(new BlockDemo(), "Blocked01_Thread").start();
        new Thread(new BlockDemo(), "Blocked02_Thread").start();
    }

    static class BlockDemo extends Thread {
        @Override
        public void run() {
            synchronized (BlockDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
