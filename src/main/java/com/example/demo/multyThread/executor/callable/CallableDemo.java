package com.example.demo.multyThread.executor.callable;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * created by zhenzhong on 2020/3/22
 */
public class CallableDemo
{
    public static void main(String[] args)
    {
        final ExecutorService exec = Executors.newCachedThreadPool();
        final ArrayList<Future<String>> result = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            result.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : result)
        {
            try
            {
                if(fs.isDone())
                System.out.println(fs.get());
            }
            catch (InterruptedException e)
            {
                System.out.println(e);
                return;
            }
            catch (ExecutionException e)
            {
                System.out.println(e);
                return;
            }finally
            {
                exec.shutdown();
            }
        }
    }
}
