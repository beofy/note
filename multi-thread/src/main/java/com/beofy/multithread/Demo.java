package com.beofy.multithread;

public class Demo {
//    Runnable

    public Demo() {



    }

    public static void main(String[] args) {
        PrintRequestProcessor printRequestProcessor = new PrintRequestProcessor();
        printRequestProcessor.start();
        SaveRequestProcessor saveRequestProcessor = new SaveRequestProcessor(printRequestProcessor);
        saveRequestProcessor.start();

        PrevRequestProcessor prevRequestProcessor = new PrevRequestProcessor(saveRequestProcessor);
        prevRequestProcessor.start();

        Request request = new Request();
        request.setName("beofy");

        prevRequestProcessor.process(request);

        Object o = new Object();

    }
}
