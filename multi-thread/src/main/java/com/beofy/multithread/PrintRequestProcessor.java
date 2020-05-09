package com.beofy.multithread;

import java.util.concurrent.LinkedBlockingQueue;

public class PrintRequestProcessor extends Thread implements IRequestProcessor {
    // 阻塞队列
    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    private IRequestProcessor nextProcessor;
    private volatile boolean isFinish = false;

    public PrintRequestProcessor(IRequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public PrintRequestProcessor() {

    }

    public void shutdown(){
        isFinish = true;
    }

    @Override
    public void process(Request request) {
        // Todo 根据实际需求做一些处理
        //验证请求参数
        requests.add(request);
//        nextProcessor.process(request);
    }

    @Override
    public void run() {
        while (!isFinish){  //不建议这么写
            try {
                System.out.println("PrintRequestProcessor:requests.take()");
                Request request = requests.take();// 阻塞示获取数据
                // 真正的处理逻辑
                System.out.println("PrintRequestProcessor:"+request);
                // 交给下一个责任链
                if (nextProcessor != null){
                    nextProcessor.process(request);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
