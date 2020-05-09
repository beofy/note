package com.beofy.multithread.notify;

public class ThreadA extends  Thread{

    private final Object lock;

    public ThreadA (Object lock) {
        this.lock  = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("Start ThreadA");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("End ThreadA");
        }
    }
}
