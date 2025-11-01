package org.example;

import org.example.Api.CrptApi;


import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            CrptApi crptApi = new CrptApi(TimeUnit.MINUTES , 5);
            crptApi.AddQueue(null);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
