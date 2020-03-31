package com.example.demo.utils.algoritgms;

import org.junit.Test;

import java.util.Arrays;

/**
 * created by zhenzhong on 2020/1/2
 */
public class AlgoUtils
{
    //颠倒数组的顺寻
    public <T> T[] reverseArrays(T[] array)
    {
        int n = array.length;
        for (int i = 0; i < n / 2; i++)
        {
            T temp = array[i];
            array[i]         = array[n - 1 - i];
            array[n - 1 - i] = temp;
        }
        return array;
    }

    @Test
    public void doTest1()
    {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(Arrays.toString(reverseArrays(arr)));
    }

    //方阵相乘
    //a[][]*b[][]=c[][]
    public void squareMatrixMuiltiplication(int[][] a, int[][] b)
    {

        int        N = a.length;
        double[][] c = new double[N][N];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                for (int k = 0; k < N; k++)
                {
                    c[i][j] = a[i][k] * b[k][j];
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
    }

    //判断一个数是否是素数
    public boolean ifPrime(int n)
    {
        if (n < 2)
        {
            return false;
        }
        for (int i = 2; i * i <= n; i++)
        {
            if (n % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    // 二分查找的递归实现:找到key在数组a中的位置
    public static int rank(int key, int[] a)
    {
        return rank(key, a, 0, a.length - 1);
    }

    private static int rank(int key, int[] a, int lo, int hi)
    {
        if (lo > hi)
        { return -1; }
        int mid = lo + (hi - lo) / 2;
        if (key > a[mid]) { return rank(key, a, lo, mid - 1); }
        else if (key < a[mid]) { return rank(key, a, mid + 1, hi); }
        else { return mid; }
    }
}
