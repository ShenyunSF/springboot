package com.example.demo.multyThread.priority;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by zhenzhong on 2020/4/1
 */
public class SimplePriority implements Runnable
{
    private int countDown = 5;

    private volatile double d;

    private int priority;

    public SimplePriority(int priority)
    {
        this.priority = priority;
    }

    @Override
    public String toString()
    {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run()
    {
        Thread.currentThread().setPriority(priority);
        while (true)
        {
            // An expensive interruptable operation
            for (int i = 0; i < 100000; i++)
            {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0)
                {
                    Thread.yield();
                }
                System.out.println(this);
                if (--countDown == 0)
                {
                    return;
                }
            }
        }

    }

    public static void main(String[] args)
    {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
        {
            executorService.execute(new SimplePriority(Thread.MIN_PRIORITY));
        }
        executorService.execute(new SimplePriority(Thread.MAX_PRIORITY));// 最后一个线程的优先级设置为最高
        executorService.shutdown();
    }
}
