package org.example.Api.Limiter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class RateLimiter {
    private final int maxRequests;
    private final TimeUnit timeUnit;
    private final AtomicInteger requestCount = new AtomicInteger(0);
    private final Deque<Long> requestTimestamps = new ArrayDeque<>();
    private final ReentrantLock lock = new ReentrantLock();
    private long resetTime;


    public RateLimiter(int maxRequests, TimeUnit timeUnit) {
        this.maxRequests = maxRequests;
        this.timeUnit = timeUnit;
        this.resetTime = System.currentTimeMillis() + timeUnit.toMillis(1);
    }


    public boolean tryAcquire() {
        lock.lock();
        try {
            long currentTime = System.currentTimeMillis();

            if (currentTime > resetTime) {
                requestCount.set(0);
                requestTimestamps.clear();
                resetTime = currentTime + timeUnit.toMillis(1);
            }

            if (requestCount.get() < maxRequests) {
                requestCount.incrementAndGet();
                requestTimestamps.addLast(currentTime);
                return true;
            }

            return false;
        } finally {
            lock.unlock();
        }
    }
}