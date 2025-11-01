package org.example.Api.Interface;

import org.example.Api.Creator.Builder;
import org.example.Api.Limiter.RateLimiter;
import org.example.Api.Model.GeneralModel;
import org.example.Api.Model.RequestModel;
import org.example.Api.Queue.RequestRetryHandler;
import org.example.Api.Queue.Worker;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class Api{
    protected RequestRetryHandler retryHandler;
    protected TimeUnit timeUnit;
    protected int requestLimit;
    protected ArrayBlockingQueue<RequestModel> queue = new ArrayBlockingQueue(10);
    protected Worker primaryQueue  = new Worker(queue);
    public void initRetryHandler(ArrayBlockingQueue<RequestModel> queue , RateLimiter rateLimiter){
        if(retryHandler == null){
            this.retryHandler = new RequestRetryHandler(queue, rateLimiter);
            Thread th = new Thread(retryHandler);
            th.start();
        }
    }

    protected String getQueueMessage(IQueue queue) {
        return queue == primaryQueue
                ? "Request added to queue successfully"
                : "Request skipped - rate limit exceeded. Added to retry queue.";
    }

    protected GeneralModel createDemoModel(){
        return new Builder()
                .Doc("participantInn" ,  "doc_id" ,  "doc_status",  "doc_type")
                .Owner("owner_inn" , "participant_inn" ,  "producer_inn")
                .Products("producer_inn" , "production_date" , "production_type" , null)
                .DataProduct("owner_inn" , "producer_inn" , "production_date" ,  "tnved_code")
                .build();
    }
}
