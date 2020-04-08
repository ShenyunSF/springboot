package com.example.demo.java8.java8lambda;

import org.junit.Test;

/**
 * created by zhenzhong on 2020/4/4
 */
public class lambda1
{
    @Test
    public void doTestTraditionRunnale()
    {
        //传统的方法
        Runnable traditionRunnale = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("traditionalRunnable");
            }
        };
        traditionRunnale.run();
    }

    //lambda 新的做法
    @Test
    public void doTestLambdaRunnable()
    {
        Runnable lambdaRunnable = () -> System.out.println("lambdaRunnable");
        lambdaRunnable.run();
    }

    //lambdaRunnable 注释的接口中只能有一个抽象方法，作为函数式接口的标识

    @FunctionalInterface
    public interface CatInterface
    {
        void sayHello();
    }

    @FunctionalInterface
    public interface DogInterface
    {
        void sayWelcome();
    }

    @Test
    public void doTestFunctionalInterface()
    {
        CatInterface catInterface = () -> System.out.println("CatInterface");
        DogInterface dogInterface = () -> System.out.printf("DogInterface");
        catInterface.sayHello();
        dogInterface.sayWelcome();
    }

    // lambda表达式有各种简化版本
    @FunctionalInterface
    public interface TwoArgsInterface
    {
        void add(int a, int b);
    }

    @Test
    public void doTest()
    {
        TwoArgsInterface argsInterface = (a, b) -> System.out.println("nononon");
    }

    @FunctionalInterface
    public interface OneArgsInterface
    {
        void say(String a);
    }

    @Test
    public void doTest1()
    {
        OneArgsInterface argsInterface = a -> System.out.println(a + 10);
        argsInterface.say("sadada");
    }

    @FunctionalInterface
    public interface OneArgsInterface2
    {
        double say(double a);
    }

    @Test
    public void doTest2()
    {
        OneArgsInterface2 argsInterface = a -> {
            System.out.println(a);
            return a * 10;
        };
        final double say = argsInterface.say(10);
        System.out.println(say);
    }
}