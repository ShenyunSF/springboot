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
            //submit 会产生future对象，它用Callable返回结果的特定类型进行了参数化
            result.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : result)
        {
            try
            {
                // 当任务执行完成时，它具有一个结果。可以调用get()方法获取结果。也可以不用isDone（）判断就直接带哦用get（）
                //在这种情况下，get()会被阻塞直到结果准备就绪。
                //还可以在试图调用get（）来获取结果之前，先调用具有超时的get()。或者调用isDone（）来检查任务是否完成
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
