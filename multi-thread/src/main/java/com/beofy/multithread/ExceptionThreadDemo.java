package com.beofy.multithread;

import java.util.concurrent.TimeUnit;

public class ExceptionThreadDemo {
    //线程中断和复位
    //1.Thread.interrupt
    //2.InterruptedException

    private static int i;

//    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(() -> {
//            while (!Thread.currentThread().isInterrupted()) {
//                i++;
//            }
//            System.out.println("i:"+i);
//
//        }, "thread");
//        thread.start();
//
//        TimeUnit.SECONDS.sleep(1);
//        thread.interrupt(); //把isInterrupted设置成true
//        System.out.println(thread.isInterrupted());
//    }

        public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    // 中断一个处于阻塞状态的线程。 join() , wait() ,queue.take()...
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
//                    Thread.interrupted();// 复位
                    e.printStackTrace();
                }
                i++;
                System.out.println("i:"+i);
            }
            System.out.println("I:"+i);

        }, "thread");
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        thread.interrupt(); //把isInterrupted设置成true
        System.out.println(thread.isInterrupted());
    }
}
