package org.example.Api.Queue;

import org.example.Api.Interface.IQueue;
import org.example.Api.Model.RequestModel;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Worker implements IQueue {
    private final ExecutorService executor;
    private BlockLoop _blockLoop;
    public Worker(ArrayBlockingQueue<RequestModel> queue) {
        this.executor = initExecutor();
        _blockLoop = new BlockLoop(queue);
        this.executor.submit(new BlockLoop(queue));
    }


    private ExecutorService  initExecutor(){
        return Executors.newSingleThreadExecutor(r -> new Thread(r, "consumer"));
    }

    public void addItem(RequestModel request){
        _blockLoop.addItem(request);
    }

    @Override
    public String getName() {
        return "PrimaryQueue";
    }

    public void stop(){
        _blockLoop.setStop();
    }
}
