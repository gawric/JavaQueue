package org.example.Api.Interface;

import org.example.Api.Model.RequestModel;

public interface IQueue {
    void addItem(RequestModel request);

    String getName();
}
