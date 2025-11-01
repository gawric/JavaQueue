package org.example.Api.Queue;

import org.example.Api.Interface.IQueue;
import org.example.Api.Interface.Queue;
import org.example.Api.Limiter.RateLimiter;
import org.example.Api.Model.RequestModel;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class RequestRetryHandler extends Queue implements Runnable, IQueue {
    private final ArrayBlockingQueue<RequestModel> retryQueue;
    private volatile boolean running = true;

    public RequestRetryHandler(ArrayBlockingQueue<RequestModel> mainQueue, RateLimiter rateLimiter) {
        super(mainQueue, rateLimiter);
        this.retryQueue = new ArrayBlockingQueue<>(100);
    }

    @Override
    public void addItem(RequestModel request) {
        if (!retryQueue.offer(request)) {
            System.err.println("Retry queue is full. Request discarded.");
        }
    }

    @Override
    public String getName() {
        return "RequestRetryQueue";
    }

    public void shutdown() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            processRetryQueue();
            sleepQuietly();
        }
    }

    private void processRetryQueue() {
        try {
            if(retryQueue.isEmpty()){
                return;
            }

            if (rateLimiter.tryAcquire()) {
                RequestModel request = retryQueue.poll(100, TimeUnit.MILLISECONDS);

                if(request != null){
                    queue.add(request);
                    System.out.println("Retrying request - added to main queue. Queue size: " + retryQueue.size());
                }

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            shutdown();
        } catch (Exception e) {
            System.err.println("Error processing retry queue: " + e.getMessage());
        }
    }

    private void sleepQuietly() {
        try {
            Thread.sleep(pauseTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            shutdown();
        }
    }
}
