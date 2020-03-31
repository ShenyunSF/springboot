package com.example.demo.multyThread.executor;

import com.example.demo.multyThread.basic.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by zhenzhong on 2020/3/22
 */
public class CacheThreadPoolt
{
    public static void main(String[] args)
    {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
        {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
        System.out.println("waiting for liftoff");
    }
}
