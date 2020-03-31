package com.example.demo.multyThread.basic;

/**
 * created by zhenzhong on 2020/3/22
 */
public class MainThread
{
    public static void main(String[] args)
    {
        final LiftOff liftOff = new LiftOff();
        liftOff.run();
    }
}
