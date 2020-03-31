package com.example.demo.multyThread.sleeptask;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * created by zhenzhong on 2020/4/1
 */
public class AfterSleepingTask implements Runnable
{
    private int sleepTime;

    public String getSleepTime()
    {
        return ("will sleep for " + sleepTime + " s");
    }

    @Override
    public void run()
    {
        sleepTime = new Random().nextInt(10);
        System.out.println(getSleepTime());
        try
        {
            TimeUnit.SECONDS.sleep(sleepTime);
        }
        catch (InterruptedException e)
        {
            System.out.println("InterruptedException");
        }
    }

    public static void main(String[] args)
    {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
        {
            executorService.execute(new AfterSleepingTask());
        }
        executorService.shutdown();
    }
}
