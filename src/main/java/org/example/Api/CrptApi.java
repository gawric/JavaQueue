package org.example.Api;

import org.example.Api.Creator.Builder;
import org.example.Api.Interface.Api;
import org.example.Api.Interface.IApi;

import org.example.Api.Interface.IQueue;
import org.example.Api.Limiter.RateLimiter;
import org.example.Api.Model.GeneralModel;
import org.example.Api.Model.RequestModel;
import java.util.concurrent.*;


public class CrptApi extends Api implements IApi {
    private final RateLimiter rateLimiter;
    public CrptApi(TimeUnit timeUnit, int requestLimit) throws InterruptedException {
        this.rateLimiter = new RateLimiter(requestLimit, timeUnit);
        initRetryHandler( queue ,  rateLimiter);
    }

    public void AddQueue(GeneralModel data){


        GeneralModel modelToAdd = data == null ? createDemoModel() : data;
        RequestModel requestModel = new RequestModel(modelToAdd);

        try {
            IQueue targetQueue = rateLimiter.tryAcquire() ? primaryQueue  : retryHandler;
            targetQueue.addItem(requestModel);

            System.out.println(getQueueMessage(targetQueue));

        } catch (Exception e) {
            System.err.println("Error processing request: " + e.getMessage());
            retryHandler.addItem(requestModel);
            throw e;
        }
    }



}















