package com.example.demo.utils.guavautils;

import com.google.common.base.Preconditions;

/**
 * created by zhenzhong on 2020/1/9
 */
public class GuavaPreconditionTest
{
    public static void main(String[] args)
    {
        final GuavaPreconditionTest test = new GuavaPreconditionTest();
        try
        {
            System.out.println(test.qurt(-3.0));
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            System.out.println(test.sum(null, 3));
        }
        catch (NullPointerException  e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            System.out.println(test.getValue(6));
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println(e.getMessage());
        }


    }

    public double qurt(double input) throws IllegalArgumentException
    {
        Preconditions.checkArgument(input > 0.0, "Illegal Argument passed:nagative value %s", input);
        return Math.sqrt(input);
    }

    public int sum(Integer a, Integer b) throws IllegalArgumentException
    {
        a = Preconditions.checkNotNull(a, "Illegal Argument passed: First parameter is Null.");
        b = Preconditions.checkNotNull(b, "Illegal Argument passed: First parameter is Null.");
        return a + b;
    }

    public int getValue(int input)
    {
        int[] data = {1, 2, 3, 4, 5};
        Preconditions.checkElementIndex(input, data.length, "Illegal Argument passed: Invalid index.");
        return 0;
    }
}
