package com.example.demo.multyThread.basic;

import org.junit.Test;

/**
 * created by zhenzhong on 2020/3/22
 */
public class BasicThread
{
    public static void main(String[] args)
    {
        final Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("waiting for liftoff");
    }

    protected int taskCount = 0;

    private final int id = taskCount++;

    public int getId()
    {
        return id;
    }

    @Test
    public void doTest()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println("id:" + id);// id 始终不会改变，都是10除非创建多个实例
        }
    }

    @Test
    public void doTest2()
    {
        for (int i = 0; i < 10; i++)
        {
            final BasicThread basicThread = new BasicThread();
            final int         id          = basicThread.getId();
            System.out.println("i: " + i + ", id :" + id);
        }
    }
}
