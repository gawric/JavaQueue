package org.example.Api.Interface;

import org.example.Api.Limiter.RateLimiter;
import org.example.Api.Model.RequestModel;

import java.util.concurrent.ArrayBlockingQueue;

public abstract class Queue {
    protected final ArrayBlockingQueue<RequestModel> queue;
    protected final RateLimiter rateLimiter;
    protected RequestModel POISON = new RequestModel(true);
    protected final int pauseTime = 100; //ms
    protected Queue(ArrayBlockingQueue<RequestModel> queue , RateLimiter rateLimiter) {
        this.queue = queue;
        this.rateLimiter = rateLimiter;
    }

    protected Queue(ArrayBlockingQueue<RequestModel> queue) {
        this.queue = queue;
        this.rateLimiter = null;
    }

    public void setStop(){
        queue.add(POISON);
    }
}
