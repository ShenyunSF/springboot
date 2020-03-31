package com.example.demo.utils.guavautils;

import java.util.Optional;

/**
 * created by zhenzhong on 2020/1/9
 */
public class GuavaTest
{
    public static void main(String[] args)
    {
        final GuavaTest guavaTest = new GuavaTest();

        Integer                 invalidInput = null;
        final Optional<Integer> a            = Optional.of(invalidInput);
        final Optional<Integer> b            = Optional.of(new Integer(10));
        System.out.println(guavaTest.sum(a, b));

    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b)
    {
        //Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Secone parameter is present: " + b.isPresent());

        //Optional.or - returns the value if present otherwise returns
        //the default value passed.
        Integer v1 = a.orElse(0);
        //Optional.get - gets the value, value should be present
        Integer v2 = b.get();


        return v1 + v2;
    }
}
