package com.beofy.multithread;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {

    private static int i;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("i:" + i);

        }, "thread");
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
            thread.interrupt(); //把isInterrupted设置成true
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
