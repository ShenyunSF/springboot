package com.example.demo.multyThread.executor.callable;

import java.util.concurrent.Callable;

/**
 * created by zhenzhong on 2020/3/22
 */
public class TaskWithResult implements Callable<String>
{
    private int id;

    public TaskWithResult(int id)
    {
        this.id = id;
    }

    @Override
    public String call() throws Exception
    {
        return "return of the TaskWithResult " + id;
    }
}
