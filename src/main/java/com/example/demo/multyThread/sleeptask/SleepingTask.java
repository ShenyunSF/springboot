package com.example.demo.multyThread.sleeptask;

import com.example.demo.multyThread.basic.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * created by zhenzhong on 2020/3/31
 */
public class SleepingTask extends LiftOff
{
    @Override
    public void run()
    {
        while(countDown-->0){
            System.out.println(status());
            try
            {
                TimeUnit.MICROSECONDS.sleep(100);
            }
            catch (InterruptedException e)
            {
                System.out.println("interrupt");
            }
        }
    }

    public static void main(String[] args)
    {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
        {
            executorService.execute(new SleepingTask());
        }
        executorService.shutdown();
    }
    //对sleep()的调用，会抛出InterruptedException 异常，并且可以看到，在run中被捕获，因为异常不能跨线程传播会=回main。所以必须在本地畜栏里所有在任务内部产生的异常。
    //这些任务是按照完美的顺序进行的。因为是在每个打印语句之后，每个任务都会将要睡眠（即阻塞），这使得线程调度器可以切换到另一个线程，进而驱动另一个任务。
/*    #0(9)
            #4(9)
            #3(9)
            #2(9)
            #1(9)
            #3(8)
            #0(8)
            #4(8)
            #1(8)
            #2(8)
            #0(7)
            #3(7)
            #2(7)
            #4(7)
            #1(7)
            #3(6)
            #0(6)
            #2(6)
            #4(6)
            #1(6)
            #1(5)
            #2(5)
            #3(5)
            #0(5)
            #4(5)
            #3(4)
            #1(4)
            #0(4)
            #4(4)
            #2(4)
            #2(3)
            #0(3)
            #1(3)
            #4(3)
            #3(3)
            #4(2)
            #2(2)
            #3(2)
            #1(2)
            #0(2)
            #3(1)
            #0(1)
            #4(1)
            #2(1)
            #1(1)
            #3(LiftOff!)
        #0(LiftOff!)
        #4(LiftOff!)
        #2(LiftOff!)
        #1(LiftOff!)*/
}
