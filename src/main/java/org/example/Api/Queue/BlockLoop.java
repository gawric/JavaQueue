package org.example.Api.Queue;

import org.example.Api.Interface.IQueue;
import org.example.Api.Interface.Queue;
import org.example.Api.Model.RequestModel;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockLoop extends Queue implements Runnable, IQueue {
    public  BlockLoop(ArrayBlockingQueue<RequestModel> queue){
        super(queue , null);
    }

    public void run() {
        try {
            while (true) {
                RequestModel item = queue.take();
                if(item.isExit()) break;
                printData(item);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }



    public void printData(RequestModel item){
        System.out.println("Request item to delete Array and Send server data successfully " + item.getName());
    }


    @Override
    public void addItem(RequestModel request) {
        queue.add(request);
    }

    @Override
    public String getName() {
        return "PrimaryQueue";
    }
}