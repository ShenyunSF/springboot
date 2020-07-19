package com.example.demo.test;

/**
 * created by zhenzhong on 2020/4/19
 */
public class TT
{
    private String str;
    private boolean b;
    private double d;
    public TT(){
        str+="asdas";
    }

    public static void main(String[] args)
    {
        final TT tt = new TT();
        System.out.println(tt.d+tt.str+tt.b);
    }
}
