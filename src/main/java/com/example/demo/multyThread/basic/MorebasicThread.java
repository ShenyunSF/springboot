package com.example.demo.multyThread.basic;

/**
 * created by zhenzhong on 2020/3/22
 */
public class MorebasicThread
{
    public static void main(String[] args)
    {
        for (int i = 0; i < 5; i++)
        {
            new Thread(new LiftOff()).start();
        }
        System.out.println("waiting for listoff");
    }
}
