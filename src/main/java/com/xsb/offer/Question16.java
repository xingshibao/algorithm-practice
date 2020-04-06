package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-06 10:14
 *
 * 题目：数值的整数次方
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 */
public class Question16 {

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    /**
     * 比一次一次的乘机
     */
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1;
        }

        double half = fastPow(x, n / 2);
        if (n % 2 == 1) {
            return half * half * x;
        } else {
            return half * half;
        }
    }

    public static void main(String[] args) {
        Question16 question16 = new Question16();
        double v = question16.myPow(2, -2);
        System.out.println(v);
    }
}
