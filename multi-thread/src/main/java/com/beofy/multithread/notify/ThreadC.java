package com.beofy.multithread.notify;

public class ThreadC extends Thread{
    private final Object lock;

    public ThreadC (Object lock) {
        this.lock  = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("Start ThreadC");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End ThreadC");
        }
    }
}
