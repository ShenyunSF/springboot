package com.example.demo.test;

/**
 * created by zhenzhong on 2020/4/19
 */
public class Base
{
    public Base(){
        System.out.println("a");
    }
    public Base(int b){
        System.out.println("Base(int i）");
    }


}
 class Myover extends  Base{
    public Myover(int b){
    }

    public static void main(String[] args)
    {
        final Myover myover = new Myover(10);
    }
}
