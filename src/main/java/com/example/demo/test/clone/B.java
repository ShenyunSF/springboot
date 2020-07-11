package com.example.demo.test.clone;

import java.util.Hashtable;

/**
 * created by zhenzhong on 2020/4/19
 */
public class B implements Cloneable
{
    private int a = 1;

    private boolean b = false;

    private Hashtable table = new Hashtable();

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    public static void main(String[] args)
    {
        float f=10.1f;
        final B b1 = new B();
        try
        {
            final Object clone = b1.clone();

        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

    }
}
